package com.example.stropee2017.lokacar.dao.contract;

public abstract class VoitureContract {

    public static final String TABLE_NAME = "VOITURE";
    public static final String COL_ID_VOITURE = "ID_VOITURE";
    public static final String COL_ID_AGENCE = "ID_AGENCE";
    public static final String COL_MARQUE = "MARQUE";
    public static final String COL_MODELE = "MODELE";
    public static final String COL_TARIF = "TARIF";
    public static final String COL_PUISSANCE = "PUISSANCE";
    public static final String COL_PORTES = "PORTES";
    public static final String COL_ETAT = "ETAT";
    public static final String COL_IMMAT = "IMMATRICULATION";
    public static final String COL_COULEUR = "COULEUR";
    public static final String COL_CARBURANT = "CARBURANT";
    public static final String COL_STYLE = "STYLE";
    public static final String COL_DISPO = "DISPONIBILITE";
    public static final String COL_ANNEE = "ANNEE";
    public static final String COL_AGENCE = "AGENCE";

    public static final String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " +
            TABLE_NAME + "( "
            + COL_ID_VOITURE + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COL_ID_AGENCE + " INTEGER,"
            + COL_MARQUE + " TEXT,"
            + COL_MODELE + " TEXT,"
            + COL_TARIF + " REAL,"
            + COL_PUISSANCE + " INTEGER,"
            + COL_PORTES + " INTEGER,"
            + COL_ETAT + " TEXT,"
            + COL_IMMAT + " TEXT,"
            + COL_COULEUR + " TEXT,"
            + COL_CARBURANT + " TEXT,"
            + COL_STYLE + " TEXT,"
            + COL_DISPO + " TEXT,"
            + COL_ANNEE + " TEXT,"
            + COL_AGENCE+ "TEXT)"
            + "FOREIGN KEY (" + COL_ID_AGENCE + ") REFERENCES " + AgenceContract.TABLE_NAME + "(" + AgenceContract.COL_ID_AGENCE + "))";

    public static final String SQL_DROP_TABLE = " DROP TABLE IF EXISTS " + TABLE_NAME;
}
