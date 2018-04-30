package com.example.stropee2017.lokacar.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.stropee2017.lokacar.beans.Voiture;

import java.util.ArrayList;
import java.util.List;

public class VoitureDAO {

    private BddHelper helper;
    private List<Voiture> listVoitures;

    public VoitureDAO(Context context) {
        this.helper = new BddHelper(context);
    }

    public long insert(Voiture item) {

        //connexion à la BDD pour écrire dedans
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

    public List<Voiture> getListe() {

        listVoitures = new ArrayList<>();

        //connexion à la BDD pour la lire
        SQLiteDatabase db = helper.getReadableDatabase();

        //select * from
        Cursor c = db.query(VoitureContract.TABLE_NAME, null, null, null, null, null, null);

        if (c != null && c.moveToFirst()) {
            do {
                Voiture voiture = buildVoiture(c);
                listVoitures.add(voiture);
            } while (c.moveToNext());
        }

        c.close();

        if (db != null) {
            db.close();
        }
        return listVoitures;
    }

    public Voiture buildVoiture (Cursor c){

        //création d'un nouvel objet
        Voiture voiture = new Voiture();

        //affecte un id à l'objet dans la colonne idVoiture de la table Voiture
        voiture.setId(c.getLong(c.getColumnIndex(VoitureContract.COL_ID_VOITURE)));
        voiture.setIdAgence(c.getLong(c.getColumnIndex(VoitureContract.COL_ID_AGENCE)));
        voiture.setTarif(c.getInt(c.getColumnIndex(VoitureContract.COL_TARIF)));
        voiture.setPuissance(c.getInt(c.getColumnIndex(VoitureContract.COL_PUISSANCE)));
        voiture.setPortes(c.getInt(c.getColumnIndex(VoitureContract.COL_PORTES)));
        voiture.setMarque(c.getString(c.getColumnIndex(VoitureContract.COL_MARQUE)));
        voiture.setModele(c.getString(c.getColumnIndex(VoitureContract.COL_MODELE)));
        voiture.setEtatVoiture(c.getString(c.getColumnIndex(VoitureContract.COL_ETAT)));
        voiture.setImmat(c.getString(c.getColumnIndex(VoitureContract.COL_IMMAT)));
        voiture.setCouleur(c.getString(c.getColumnIndex(VoitureContract.COL_COULEUR)));
        voiture.setStyle(c.getString(c.getColumnIndex(VoitureContract.COL_STYLE)));
        voiture.setDispo(c.getString(c.getColumnIndex(VoitureContract.COL_DISPO)));
        voiture.setAnnee(c.getString(c.getColumnIndex(VoitureContract.COL_ANNEE)));

        return voiture;
    }


}
