package com.example.stropee2017.lokacar.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.stropee2017.lokacar.beans.Client;
import com.example.stropee2017.lokacar.beans.Location;
import com.example.stropee2017.lokacar.beans.Voiture;
import com.example.stropee2017.lokacar.dao.contract.LocationContract;

import java.util.Date;
import java.util.List;

public class LocationDAO {

    private Context context;
    private BddHelper helper;
    private List<Location> liste;


    public LocationDAO(Context context) {
        this.context = context;
        this.helper = new BddHelper(context);
    }

    public long insert(Location location) {

        long id = 0;
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues c = new ContentValues();

        c.put(LocationContract.COL_ID_CLIENT, location.getClient().getIdClient());
        c.put(LocationContract.COL_ID_VOITURE, location.getVoiture().getId());
        c.put(LocationContract.COL_DATE_DEBUT_LOCATION, String.valueOf(location.getDebutLocation()));
        c.put(LocationContract.COL_DATE_FIN_LOCATION, String.valueOf(location.getFinLocation()));
        c.put(LocationContract.COL_PRIX_LOCATION, location.getPrixLocation());

        id = db.insert(LocationContract.TABLE_NAME, null, c);

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

    public Location locationBuilder(Cursor c) {

        Location location = new Location();

        location.setIdLocation(c.getLong(c.getColumnIndex(LocationContract.COL_ID_LOCATION)));
        location.setPrixLocation(c.getFloat(c.getColumnIndex(LocationContract.COL_PRIX_LOCATION)));
        location.setFinLocation(new Date(c.getString(c.getColumnIndex(LocationContract.COL_DATE_FIN_LOCATION))));
        location.setDebutLocation(new Date(c.getString(c.getColumnIndex(LocationContract.COL_DATE_DEBUT_LOCATION))));

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
