package com.example.stropee2017.lokacar.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.stropee2017.lokacar.beans.Location;
import com.example.stropee2017.lokacar.dao.contract.LocationContract;

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

        db.insert(LocationContract.TABLE_NAME, null, c);

        return id;
    }

    public List<Location> getListe() {

        return null;
    }

}
