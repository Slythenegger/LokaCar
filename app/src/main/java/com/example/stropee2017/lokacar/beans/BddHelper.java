package com.example.stropee2017.lokacar.beans;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.stropee2017.lokacar.dao.ClientContract;
import com.example.stropee2017.lokacar.dao.PhotoProfilContract;
import com.example.stropee2017.lokacar.dao.VoitureContract;

public class BddHelper extends SQLiteOpenHelper {

    private final static String DATABASE_NAME = "BDD_LOKACAR.db";
    private final static int DATABASE_VERSION = 1;


    public BddHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(ClientContract.SQL_CREATE_TABLE);
        db.execSQL(VoitureContract.SQL_CREATE_TABLE);
        db.execSQL(PhotoProfilContract.SQL_CREATE_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(PhotoProfilContract.SQL_DROP_TABLE);
        db.execSQL(VoitureContract.SQL_DROP_TABLE);
        db.execSQL(ClientContract.SQL_DROP_TABLE);


    }
}
