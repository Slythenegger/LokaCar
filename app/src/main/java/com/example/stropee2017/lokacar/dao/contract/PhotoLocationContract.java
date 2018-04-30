package com.example.stropee2017.lokacar.dao.contract;

public abstract class PhotoLocationContract {

    public static final String TABLE_NAME = "PHOTOLOCATION";
    public static final String COL_ID_PHOTO_LOCATION = "ID_PHOTO_LOCATION";
    public static final String COL_PATH = "PATH";
    public static final String COL_ID_LOCATION = "ID_LOCATION";
    public static final String COL_ETAT_DES_LIEUX = "ETAT_DES_LIEUX";


    public static final String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "
            + TABLE_NAME + " ("
            + COL_ID_PHOTO_LOCATION + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_PATH + " TEXT, "
            + COL_ID_LOCATION + " INTEGER,"
            + COL_ETAT_DES_LIEUX + " INTEGER,"
            + "FOREIGN KEY (" + COL_ID_LOCATION + ") REFERENCES " + LocationContract.TABLE_NAME + "(" + LocationContract.COL_ID_LOCATION + "))";

    public static final String SQL_DROP_TABLE = " DROP TABLE IF EXISTS " + TABLE_NAME;


}
