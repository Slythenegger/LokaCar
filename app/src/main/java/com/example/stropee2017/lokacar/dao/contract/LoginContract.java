package com.example.stropee2017.lokacar.dao.contract;

public abstract class LoginContract {

    public static final String TABLE_NAME = "LOGIN";
    public static final String COL_ID_LOGIN = "ID_LOGIN";
    public static final String COL_USERNAME = "USERNAME";
    public static final String COL_PASSWORD = "PASSWORD";




    public static final String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "
            + TABLE_NAME + " ("
            + COL_ID_LOGIN + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_USERNAME + " TEXT, "
            + COL_PASSWORD + " TEXT)";


    public static final String SQL_DROP_TABLE  =" DROP TABLE IF EXISTS " + TABLE_NAME;


}


