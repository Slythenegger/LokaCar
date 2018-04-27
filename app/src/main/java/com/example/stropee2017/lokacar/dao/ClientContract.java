package com.example.stropee2017.lokacar.dao;

public abstract class ClientContract {

    private int idClient;
    private String nom, prenom, adresse, codePostal, tel, ville, permis, mail;


    public static final String TABLE_NAME = "CLIENT";
    public static final String COL_ID = "ID";
    public static final String COL_NOM = "NOM";
    public static final String COL_PRENOM = "PRENOM";
    public static final String COL_ADRESSE = "ADRESSE";
    public static final String COL_CODEPOSTAL = "CODEPOSTAL";
    public static final String COL_VILLE = "VILLE";
    public static final String COL_TEL = "TEL";
    public static final String COL_PERMIS = "PERMIS";
    public static final String COL_MAIL = "MAIL";



    public static final String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "
            + TABLE_NAME + " ("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_NOM + " TEXT, "
            + COL_PRENOM + " TEXT,"
            + COL_ADRESSE + " TEXT,"
            + COL_CODEPOSTAL + " TEXT,"
            + COL_VILLE + " TEXT,"
            + COL_TEL + " TEXT,"
            + COL_PERMIS + " TEXT,"
            + COL_MAIL + " TEXT)";

    public static final String SQL_DROP_TABLE  =" DROP TABLE IF EXISTS " + TABLE_NAME;







}
