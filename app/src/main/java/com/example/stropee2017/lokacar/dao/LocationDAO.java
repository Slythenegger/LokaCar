package com.example.stropee2017.lokacar.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.stropee2017.lokacar.beans.Client;
import com.example.stropee2017.lokacar.beans.Location;
import com.example.stropee2017.lokacar.beans.Voiture;
import com.example.stropee2017.lokacar.dao.contract.LocationContract;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LocationDAO {

    private Context context;
    private BddHelper helper;
    private List<Location> listeLocation;


    public LocationDAO(Context context) {
        this.context = context;
        this.helper = new BddHelper(context);
    }

    public long insertOrUpdate(Location location) {

        long id;
        SQLiteDatabase db = helper.getWritableDatabase();
        if (location.getIdLocation() <= 0) {

            ContentValues c = new ContentValues();

            c.put(LocationContract.COL_ID_CLIENT, location.getClient().getIdClient());
            c.put(LocationContract.COL_ID_VOITURE, location.getVoiture().getId());
            c.put(LocationContract.COL_DATE_DEBUT_LOCATION, String.valueOf(location.getDebutLocation()));
            c.put(LocationContract.COL_DATE_FIN_LOCATION, String.valueOf(location.getFinLocation()));
            c.put(LocationContract.COL_PRIX_LOCATION, location.getPrixLocation());
            c.put(LocationContract.COL_ETAT_LOCATION, location.isEnCours());

            id = db.insert(LocationContract.TABLE_NAME, null, c);
            VoitureDAO dao = new VoitureDAO(context);
            dao.insert(location.getVoiture());

        } else {

            id = location.getIdLocation();

            ContentValues c = new ContentValues();

            c.put(LocationContract.COL_ID_CLIENT, location.getClient().getIdClient());
            c.put(LocationContract.COL_ID_VOITURE, location.getVoiture().getId());
            c.put(LocationContract.COL_DATE_DEBUT_LOCATION, String.valueOf(location.getDebutLocation()));
            c.put(LocationContract.COL_DATE_FIN_LOCATION, String.valueOf(location.getFinLocation()));
            c.put(LocationContract.COL_PRIX_LOCATION, location.getPrixLocation());
            c.put(LocationContract.COL_ETAT_LOCATION, location.isEnCours());

            db.update(LocationContract.TABLE_NAME, c, LocationContract.COL_ID_LOCATION + "=?", new String[]{String.valueOf(id)});
            VoitureDAO dao = new VoitureDAO(context);
            dao.insert(location.getVoiture());

        }

        return id;
    }


    public Location findLocationById(long id) {

        SQLiteDatabase db = helper.getReadableDatabase();
        Location location = null;

        Cursor c = db.query(LocationContract.TABLE_NAME, null, LocationContract.COL_ID_LOCATION + "=?", new String[]{String.valueOf(id)}, null, null, null);

        if (c != null && c.moveToFirst()) {

            location = locationBuilder(c);
        }


        return location;
    }

    public List<Location> getListeLocation() {

        listeLocation = new ArrayList<>();
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor c = db.query(LocationContract.TABLE_NAME, null, LocationContract.COL_ETAT_LOCATION + "=?", new String[]{"1"}, null, null, LocationContract.COL_DATE_FIN_LOCATION + " ASC");

        if (c != null && c.moveToFirst()) {

            do {
                Location location = locationBuilder(c);
                listeLocation.add(location);

            } while (c.moveToNext());
        }
        return listeLocation;
    }

    public List<Location> getListeLocationPasEnCours() {

        listeLocation = new ArrayList<>();
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor c = db.query(LocationContract.TABLE_NAME, null, LocationContract.COL_ETAT_LOCATION + "=?", new String[]{"0"}, null, null, LocationContract.COL_DATE_FIN_LOCATION + " ASC");

        if (c != null && c.moveToFirst()) {

            do {
                Location location = locationBuilder(c);
                listeLocation.add(location);

            } while (c.moveToNext());
        }
        return listeLocation;
    }

    public Location locationBuilder(Cursor c) {

        Location location = new Location();

        location.setIdLocation(c.getLong(c.getColumnIndex(LocationContract.COL_ID_LOCATION)));
        location.setPrixLocation(c.getFloat(c.getColumnIndex(LocationContract.COL_PRIX_LOCATION)));
        location.setFinLocation(new Date(c.getString(c.getColumnIndex(LocationContract.COL_DATE_FIN_LOCATION))));
        location.setDebutLocation(new Date(c.getString(c.getColumnIndex(LocationContract.COL_DATE_DEBUT_LOCATION))));
        int locEnCours = c.getInt(c.getColumnIndex(LocationContract.COL_ETAT_LOCATION));
        boolean enCours = (locEnCours == 1);
        location.setEnCours(enCours);

        long idVoiture = c.getLong(c.getColumnIndex(LocationContract.COL_ID_VOITURE));
        long idClient = c.getLong(c.getColumnIndex(LocationContract.COL_ID_CLIENT));

        ClientDAO daoClient = new ClientDAO(context);
        Client client = daoClient.findClientById(idClient);

        VoitureDAO daoVoiture = new VoitureDAO(context);
        Voiture voiture = daoVoiture.findVoitureById(idVoiture);

        location.setClient(client);
        location.setVoiture(voiture);

        return location;
    }

}
