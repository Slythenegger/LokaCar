package com.example.stropee2017.lokacar.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.stropee2017.lokacar.beans.Agence;
import com.example.stropee2017.lokacar.beans.Login;
import com.example.stropee2017.lokacar.dao.contract.AgenceContract;
import com.example.stropee2017.lokacar.dao.contract.ClientContract;
import com.example.stropee2017.lokacar.dao.contract.LoginContract;

import java.util.ArrayList;
import java.util.List;

public class LoginDAO {

    private Context context;
    private BddHelper helper;
    private List<Login> listeLogin;


    public LoginDAO(Context context) {

        //instanciation du bddhelper avec le context de l'acrivité qui appelle la dao
        this.context = context;
        this.helper = new BddHelper(context);
    }


    public long insertOrUpdate(Login login) {

        long id;
        SQLiteDatabase db = helper.getWritableDatabase();


        //id login = 0 on fait un insert et on récupère l'id généré par la base
        if (login.getId_login() <= 0) {

            // on appelle la méthode buildContent pour créer le container de valuer pour l'insert
            ContentValues c = buildContent(login);

            id = db.insert(LoginContract.TABLE_NAME, null, c);

            if (db != null)
                db.close();

        } else {
            // si l'id existe on fait un update
            id = login.getId_login();

            ContentValues c = buildContent(login);

            db.update(LoginContract.TABLE_NAME, c, LoginContract.COL_ID_LOGIN + "=?", new String[]{String.valueOf(login.getId_login())});

            if (db != null)
                db.close();

        }

        return id;
    }

    // fonction qui permet de créer un content values en fcontion d'un client, permet de ne pas répéter le code
    public ContentValues buildContent(Login login) {

        ContentValues c = new ContentValues();

        c.put(LoginContract.COL_USERNAME, login.getUsername());
        c.put(LoginContract.COL_PASSWORD, login.getPassword());



        return c;
    }

    // fonction qui pemet de récupérer un login en fonction de son id
    public Login findLoginByUsername(String username) {

        Login login = null;

        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor cursor = db.query(LoginContract.TABLE_NAME,
                null,
                LoginContract.COL_USERNAME + "=?",
                new String[]{String.valueOf(username)},
                null,
                null,
                null);

        if (cursor != null && cursor.moveToFirst()) {

            login = buildLogin(cursor);
        }

        return login;
    }


    // permet de créer un objet client en fonction des données d'un curseur, permet la non redondace du code
    public Login buildLogin(Cursor cursor) {

        Login login= new Login();

        login.setId_login(cursor.getInt(cursor.getColumnIndex(LoginContract.COL_ID_LOGIN)));
        login.setUsername(cursor.getString(cursor.getColumnIndex(LoginContract.COL_USERNAME)));
        login.setPassword(cursor.getString(cursor.getColumnIndex(LoginContract.COL_PASSWORD)));


        return login;
    }

    // fonction qui pemet de récupérer une agence en fonction de son id
    public Agence findAgenceById(long id) {

        Agence agence = null;

        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor cursor = db.query(ClientContract.TABLE_NAME,
                null,
                AgenceContract.COL_ID_AGENCE + "=?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null);

        if (cursor != null && cursor.moveToFirst()) {

            agence = buildAgence(cursor);
        }

        return agence;
    }


    // permet de créer un objet client en fonction des données d'un curseur, permet la non redondace du code
    public Agence buildAgence(Cursor cursor) {

        Agence agence= new Agence();

        agence.setIdAgence(cursor.getInt(cursor.getColumnIndex(AgenceContract.COL_ID_AGENCE)));
        agence.setNomGerant(cursor.getString(cursor.getColumnIndex(AgenceContract.COL_NOM)));
        agence.setPrenomGerant(cursor.getString(cursor.getColumnIndex(AgenceContract.COL_PRENOM)));
        agence.setAdresse(cursor.getString(cursor.getColumnIndex(AgenceContract.COL_ADRESSE)));
        agence.setCodePostal(cursor.getString(cursor.getColumnIndex(AgenceContract.COL_CODEPOSTAL)));
        agence.setVille(cursor.getString(cursor.getColumnIndex(AgenceContract.COL_VILLE)));
        agence.setTelephone(cursor.getString(cursor.getColumnIndex(AgenceContract.COL_TEL)));
        agence.setPassword(cursor.getString(cursor.getColumnIndex(AgenceContract.COL_PASSWORD)));
        agence.setChiffreDAffaire(cursor.getFloat(cursor.getColumnIndex((AgenceContract.COL_CA))));



        return agence;
    }
}
