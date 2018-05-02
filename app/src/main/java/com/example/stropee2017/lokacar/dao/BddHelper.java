package com.example.stropee2017.lokacar.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.stropee2017.lokacar.beans.Agence;
import com.example.stropee2017.lokacar.beans.Voiture;
import com.example.stropee2017.lokacar.dao.contract.AgenceContract;
import com.example.stropee2017.lokacar.dao.contract.ClientContract;
import com.example.stropee2017.lokacar.dao.contract.LocationContract;
import com.example.stropee2017.lokacar.dao.contract.LoginContract;
import com.example.stropee2017.lokacar.dao.contract.PhotoLocationContract;
import com.example.stropee2017.lokacar.dao.contract.PhotoProfilContract;
import com.example.stropee2017.lokacar.dao.contract.VoitureContract;

import java.util.ArrayList;
import java.util.List;

public class BddHelper extends SQLiteOpenHelper {
    private final static String DATABASE_NAME = "BDD_LOKACAR.db";
    private final static int DATABASE_VERSION = 1;
    private final Agence agence = new Agence("DUPONT", "Tintin", "avenue de paris", "44000", "Nantes", "027894566", "azerty", 2.01f);

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
        db.insert(AgenceContract.TABLE_NAME, null, c);

        for (Voiture voiture : getVoitures()) {
            ContentValues content = getContentVoiture(voiture);
            db.insert(VoitureContract.TABLE_NAME, null, content);

        }

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

    public List<Voiture> getVoitures() {

        Voiture voiture1 = new Voiture();
        Voiture voiture2 = new Voiture();
        Voiture voiture3 = new Voiture();

        List<Voiture> listeVoiture = new ArrayList<>();

        voiture1.setImmat("123AA45");
        voiture1.setMarque("PEUGEOT");
        voiture1.setModele("405");
        voiture1.setIdAgence(1);
        voiture1.setDispo(true);
        voiture1.setTarif(40);

        voiture2.setImmat("333AZ38");
        voiture2.setMarque("Smart");
        voiture2.setModele("Mini");
        voiture2.setIdAgence(1);
        voiture2.setDispo(true);
        voiture2.setTarif(150);

        voiture3.setImmat("444AA44");
        voiture3.setMarque("Citroen");
        voiture3.setModele("C4");
        voiture3.setDispo(false);
        voiture3.setIdAgence(1);
        voiture3.setTarif(80);

        listeVoiture.add(voiture1);
        listeVoiture.add(voiture2);
        listeVoiture.add(voiture3);

        return listeVoiture;
    }

    public ContentValues getContentVoiture(Voiture voiture) {

        ContentValues c = new ContentValues();

        c.put(VoitureContract.COL_IMMAT, voiture.getImmat());
        c.put(VoitureContract.COL_MARQUE, voiture.getMarque());
        c.put(VoitureContract.COL_MODELE, voiture.getModele());
        c.put(VoitureContract.COL_DISPO, voiture.getDispo());
        c.put(VoitureContract.COL_TARIF, voiture.getTarif());
        c.put(VoitureContract.COL_ID_AGENCE, voiture.getIdAgence());


        return c;
    }
}
