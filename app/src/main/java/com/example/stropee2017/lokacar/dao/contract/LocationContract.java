package com.example.stropee2017.lokacar.dao.contract;


public abstract class LocationContract {


    public static final String TABLE_NAME = "LOCATION";
    public static final String COL_ID_LOCATION = "ID_LOCATION";
    public static final String COL_ID_VOITURE = "ID_VOITURE";
    public static final String COL_ID_CLIENT = "ID_CLIENT";
    public static final String COL_DATE_DEBUT_LOCATION = "DATE_DEBUT_LOCATION";
    public static final String COL_DATE_FIN_LOCATION = "DATE_FIN_LOCATION";
    public static final String COL_PRIX_LOCATION = "PRIX_LOCATION";


    public static final String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "
            + TABLE_NAME + " ("
            + COL_ID_LOCATION + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_ID_VOITURE + " INTEGER, "
            + COL_ID_CLIENT + " INTEGER,"
            + COL_DATE_DEBUT_LOCATION + " TEXT,"
            + COL_DATE_FIN_LOCATION + " TEXT,"
            + COL_PRIX_LOCATION + " REAL,"
            + "FOREIGN KEY (" + COL_ID_VOITURE + ") REFERENCES " + VoitureContract.TABLE_NAME + "(" + VoitureContract.COL_ID_VOITURE+"),"
            + "FOREIGN KEY (" + COL_ID_CLIENT + ") REFERENCES " + ClientContract.TABLE_NAME + "(" + ClientContract.COL_ID_CLIENT + "))";

    public static final String SQL_DROP_TABLE = " DROP TABLE IF EXISTS " + TABLE_NAME;


}
