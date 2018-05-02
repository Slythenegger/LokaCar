package com.example.stropee2017.lokacar.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.stropee2017.lokacar.beans.Agence;
import com.example.stropee2017.lokacar.dao.contract.AgenceContract;
import com.example.stropee2017.lokacar.dao.contract.ClientContract;
import com.example.stropee2017.lokacar.dao.contract.LocationContract;
import com.example.stropee2017.lokacar.dao.contract.LoginContract;
import com.example.stropee2017.lokacar.dao.contract.PhotoLocationContract;
import com.example.stropee2017.lokacar.dao.contract.PhotoProfilContract;
import com.example.stropee2017.lokacar.dao.contract.VoitureContract;

public class BddHelper extends SQLiteOpenHelper {
    private final static String DATABASE_NAME = "BDD_LOKACAR.db";
    private final static int DATABASE_VERSION = 1;
    private final Agence agence = new Agence("DUPONT","Tintin","avenue de paris","44000","Nantes","027894566","azerty", 2.01f);

    public BddHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(ClientContract.SQL_CREATE_TABLE);
        db.execSQL(AgenceContract.SQL_CREATE_TABLE);
        db.execSQL(VoitureContract.SQL_CREATE_TABLE);
        db.execSQL(PhotoProfilContract.SQL_CREATE_TABLE);
        db.execSQL(LocationContract.SQL_CREATE_TABLE);
        db.execSQL(PhotoLocationContract.SQL_CREATE_TABLE);
        db.execSQL(LoginContract.SQL_CREATE_TABLE);

        ContentValues c = buildContent(agence);
        db.insert(AgenceContract.TABLE_NAME , null, c );


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(PhotoProfilContract.SQL_DROP_TABLE);
        db.execSQL(AgenceContract.SQL_DROP_TABLE);
        db.execSQL(VoitureContract.SQL_DROP_TABLE);
        db.execSQL(ClientContract.SQL_DROP_TABLE);
        db.execSQL(LocationContract.SQL_DROP_TABLE);
        db.execSQL(PhotoLocationContract.SQL_DROP_TABLE);
        db.execSQL(LoginContract.SQL_DROP_TABLE);


    }

    public ContentValues buildContent(Agence agence) {

        ContentValues c = new ContentValues();

        c.put(AgenceContract.COL_NOM, agence.getNomGerant());
        c.put(AgenceContract.COL_PRENOM, agence.getPrenomGerant());
        c.put(AgenceContract.COL_ADRESSE, agence.getAdresse());
        c.put(AgenceContract.COL_CODEPOSTAL, agence.getCodePostal());
        c.put(AgenceContract.COL_VILLE, agence.getVille());
        c.put(AgenceContract.COL_TEL, agence.getTelephone());
        c.put(AgenceContract.COL_PASSWORD, agence.getPassword());
        c.put(AgenceContract.COL_CA, agence.getChiffreDAffaire());

        return c;
    }
}
