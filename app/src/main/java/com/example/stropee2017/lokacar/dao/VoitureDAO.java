package com.example.stropee2017.lokacar.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.stropee2017.lokacar.beans.Agence;
import com.example.stropee2017.lokacar.beans.Voiture;
import com.example.stropee2017.lokacar.dao.contract.VoitureContract;

import java.util.ArrayList;
import java.util.List;

public class VoitureDAO {

    private BddHelper helper;
    private List<Voiture> listVoitures;

    public VoitureDAO(Context context) {
        this.helper = new BddHelper(context);
    }

    public long insert(Voiture item) {

        long id;
        //connexion à la BDD pour écrire dedans
        SQLiteDatabase db = helper.getWritableDatabase();

        if (item.getId() <= 0) {

            ContentValues c = buildContent(item);
            id = db.insert(VoitureContract.TABLE_NAME, null, c);

        } else {

            id = item.getId();
            ContentValues c = buildContent(item);
            db.update(VoitureContract.TABLE_NAME, c, VoitureContract.COL_ID_VOITURE + "=?", new String[]{String.valueOf(id)});
        }

        if (db != null) {
            db.close();
        }

        return id;

    }

    public ContentValues buildContent(Voiture item) {

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
        c.put(VoitureContract.COL_ID_AGENCE, item.getIdAgence());

        return c;
    }


    public List<Voiture> getListe(long id) {

        listVoitures = new ArrayList<>();

        //connexion à la BDD pour la lire
        SQLiteDatabase db = helper.getReadableDatabase();

        //select * from
        Cursor c = db.query(VoitureContract.TABLE_NAME, null, VoitureContract.COL_ID_AGENCE + "=?",
                new String[]{String.valueOf(id)}, null, null, null);

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


    //trouver la voiture par son id
    public Voiture findVoitureById(long id) {

        Voiture voiture = null;

        SQLiteDatabase db = helper.getReadableDatabase();

        //création d'un curseur qui va se mettre sur la ligne sélectionnée
        Cursor c = db.query(VoitureContract.TABLE_NAME, null, VoitureContract.COL_ID_VOITURE + "=?",
                new String[]{String.valueOf(id)}, null, null, null);

        //curseur qui part [toujours] de -1. Si le curseur existe et qu'il peut aller à la première ligne (donc il y a bien une table qui existe)
        if (c != null && c.moveToFirst()) {
            //je construis mon objet voiture avec la fonction créee avec en paramètre mon curseur qui est positionné sur la ligne sélectionnée
            voiture = buildVoiture(c);
        }


        return voiture;
    }

    //récupération d'une ligne de voiture
    public Voiture buildVoiture(Cursor c) {

        Voiture voiture = new Voiture();

        //affecte un id à l'objet dans la colonne idVoiture de la table Voiture
        voiture.setId(c.getLong(c.getColumnIndex(VoitureContract.COL_ID_VOITURE)));
        voiture.setIdAgence(c.getLong(c.getColumnIndex(VoitureContract.COL_ID_AGENCE)));
        voiture.setTarif(c.getFloat(c.getColumnIndex(VoitureContract.COL_TARIF)));
        voiture.setPuissance(c.getInt(c.getColumnIndex(VoitureContract.COL_PUISSANCE)));
        voiture.setPortes(c.getInt(c.getColumnIndex(VoitureContract.COL_PORTES)));
        voiture.setMarque(c.getString(c.getColumnIndex(VoitureContract.COL_MARQUE)));
        voiture.setModele(c.getString(c.getColumnIndex(VoitureContract.COL_MODELE)));
        voiture.setEtatVoiture(c.getString(c.getColumnIndex(VoitureContract.COL_ETAT)));
        voiture.setImmat(c.getString(c.getColumnIndex(VoitureContract.COL_IMMAT)));
        voiture.setCouleur(c.getString(c.getColumnIndex(VoitureContract.COL_COULEUR)));
        voiture.setStyle(c.getString(c.getColumnIndex(VoitureContract.COL_STYLE)));
        voiture.setCarburant(c.getString(c.getColumnIndex(VoitureContract.COL_CARBURANT)));
        boolean estDispo = (c.getInt(c.getColumnIndex(VoitureContract.COL_DISPO)) == 1);
        voiture.setDispo(estDispo);
        voiture.setAnnee(c.getString(c.getColumnIndex(VoitureContract.COL_ANNEE)));
        voiture.setIdAgence(c.getColumnIndex(VoitureContract.COL_ID_AGENCE));

        return voiture;
    }


}
