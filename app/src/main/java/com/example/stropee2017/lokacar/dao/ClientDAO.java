package com.example.stropee2017.lokacar.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.stropee2017.lokacar.beans.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientDAO {


    private Context context;
    private BddHelper helper;
    private List<Client> liste;


    public ClientDAO(Context context) {

        //instanciation du bddhelper avec le context de l'acrivité qui appelle la dao
        this.context = context;
        this.helper = new BddHelper(context);
    }


    public long insertOrUpdate(Client client) {

        long id;
        SQLiteDatabase db = helper.getWritableDatabase();


        //id client = 0 on fait un insert et on récupère l'id généré par la base
        if (client.getIdClient() <= 0) {

            // on appelle la méthode buildContent pour créer le container de valuer pour l'insert
            ContentValues c = buildContent(client);

            id = db.insert(ClientContract.TABLE_NAME, null, c);

            if (db != null)
                db.close();

        } else {
            // si l'id existe on fait un update
            id = client.getIdClient();

            ContentValues c = buildContent(client);

            db.update(ClientContract.TABLE_NAME, c, ClientContract.COL_ID_CLIENT + "=?", new String[]{String.valueOf(client.getIdClient())});

            if (db != null)
                db.close();

        }

        return id;
    }

    // fonction qui permet de créer un content values en fcontion d'un client, permet de ne pas répéter le code
    public ContentValues buildContent(Client client) {

        ContentValues c = new ContentValues();

        c.put(ClientContract.COL_NOM, client.getNom());
        c.put(ClientContract.COL_PRENOM, client.getPrenom());
        c.put(ClientContract.COL_ADRESSE, client.getAdresse());
        c.put(ClientContract.COL_CODEPOSTAL, client.getCodePostal());
        c.put(ClientContract.COL_TEL, client.getTel());
        c.put(ClientContract.COL_VILLE, client.getVille());
        c.put(ClientContract.COL_PERMIS, client.getPermis());
        c.put(ClientContract.COL_MAIL, client.getMail());


        return c;
    }

    // fonction qui pemet de récupérer un client en fonction de son id
    public Client findClientById(long id) {

        Client client = null;

        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor cursor = db.query(ClientContract.TABLE_NAME,
                null,
                ClientContract.COL_ID_CLIENT + "=?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null);

        if (cursor != null && cursor.moveToFirst()) {

            client = buildClient(cursor);
        }

        return client;
    }


    // permet de créer un objet client en fonction des données d'un curseur, permet la non redondace du code
    public Client buildClient(Cursor cursor) {

        Client client = new Client();

        client.setIdClient(cursor.getLong(cursor.getColumnIndex(ClientContract.COL_ID_CLIENT)));
        client.setAdresse(cursor.getString(cursor.getColumnIndex(ClientContract.COL_ADRESSE)));
        client.setCodePostal(cursor.getString(cursor.getColumnIndex(ClientContract.COL_CODEPOSTAL)));
        client.setMail(cursor.getString(cursor.getColumnIndex(ClientContract.COL_MAIL)));
        client.setNom(cursor.getString(cursor.getColumnIndex(ClientContract.COL_NOM)));
        client.setPermis(cursor.getString(cursor.getColumnIndex(ClientContract.COL_PERMIS)));
        client.setPrenom(cursor.getString(cursor.getColumnIndex(ClientContract.COL_PRENOM)));
        client.setTel(cursor.getString(cursor.getColumnIndex(ClientContract.COL_TEL)));
        client.setVille(cursor.getString(cursor.getColumnIndex(ClientContract.COL_VILLE)));

        return client;
    }

    // fonction qui renvoie la liste des clients présents dans la base
    public List<Client> getListe() {

        liste = new ArrayList<>();

        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor cursor = db.query(ClientContract.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null);


        if (cursor != null && cursor.moveToFirst()) {

            do {
                //on créé un obejet client avec la ligne en cours de lecture et l'ajout à la liste
                Client client = buildClient(cursor);
                liste.add(client);

            } while (cursor.moveToNext());
        }

        cursor.close();

        if (db != null)
            db.close();

        return liste;
    }
}
