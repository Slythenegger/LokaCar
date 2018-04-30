package com.example.stropee2017.lokacar.dao.contract;

public class AgenceContract {

    public static final String TABLE_NAME = "AGENCE";
    public static final String COL_ID_AGENCE = "ID_AGENCE";
    public static final String COL_NOM = "NOM";
    public static final String COL_PRENOM = "PRENOM";
    public static final String COL_ADRESSE = "ADRESSE";
    public static final String COL_CODEPOSTAL = "CODEPOSTAL";
    public static final String COL_VILLE = "VILLE";
    public static final String COL_TEL = "TEL";
    public static final String COL_PASSWORD = "PASSWORD";
    public static final String COL_CA = "CHIFFRE_D_AFFAIRE";



    public static final String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "
            + TABLE_NAME + " ("
            + COL_ID_AGENCE + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_NOM + " TEXT, "
            + COL_PRENOM + " TEXT,"
            + COL_ADRESSE + " TEXT,"
            + COL_CODEPOSTAL + " TEXT,"
            + COL_VILLE + " TEXT,"
            + COL_TEL + " TEXT,"
            + COL_PASSWORD + " TEXT,"
            + COL_CA + " TEXT)";

    public static final String SQL_DROP_TABLE  =" DROP TABLE IF EXISTS " + TABLE_NAME;


}
