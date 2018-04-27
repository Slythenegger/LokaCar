package com.example.stropee2017.lokacar.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.stropee2017.lokacar.beans.Voiture;

public class VoitureDAO {

    private BddHelper helper;

    public VoitureDAO(Context context) {
        this.helper = new BddHelper(context);
    }

    public long insert(Voiture item) {

        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues c = new ContentValues();
        c.put(VoitureContract.COL_MARQUE, item.getMarque());
        c.put(VoitureContract.COL_MODELE, item.getModele());
        c.put(VoitureContract.COL_CARBURANT, item.getCarburant());
        c.put(VoitureContract.COL_COULEUR, item.getCouleur());
        c.put(VoitureContract.COL_IMMAT, item.getImmat());
        c.put(VoitureContract.COL_DISPO, item.getDispo());
        c.put(VoitureContract.COL_PORTES, item.getPortes());
        c.put(VoitureContract.COL_PUISSANCE, item.getPuissance());
        c.put(VoitureContract.COL_STYLE, item.getStyle());
        c.put(VoitureContract.COL_TARIF, item.getTarif());
        c.put(VoitureContract.COL_ETAT, item.getEtatVoiture());
        c.put(VoitureContract.COL_ANNEE, item.getAnnee());

        long id = db.insert(VoitureContract.TABLE_NAME, null, c);

        if (db != null) {
            db.close();
        }

        return id;

    }


}
