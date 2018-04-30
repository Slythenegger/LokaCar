package com.example.stropee2017.lokacar.dao.contract;

public abstract class PhotoProfilContract {

    public static final String TABLE_NAME = "PHOTOPROFIL";
    public static final String COL_ID_PHOTO_PROFIL = "ID";
    public static final String COL_PATH = "PATH";
    public static final String COL_ID_VOITURE = "ID_VOITURE";



    public static final String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "
            + TABLE_NAME + " ("
            + COL_ID_PHOTO_PROFIL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_PATH + " TEXT, "
            + COL_ID_VOITURE + " INTEGER,"
            + "FOREIGN KEY ("+COL_ID_VOITURE+") REFERENCES "+ VoitureContract.TABLE_NAME+"("+VoitureContract.COL_ID_VOITURE+"))";

    public static final String SQL_DROP_TABLE  =" DROP TABLE IF EXISTS " + TABLE_NAME;






}
