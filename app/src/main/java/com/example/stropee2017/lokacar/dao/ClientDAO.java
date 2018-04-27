package com.example.stropee2017.lokacar.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.stropee2017.lokacar.beans.BddHelper;
import com.example.stropee2017.lokacar.beans.Client;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {


    private Context context;
    private BddHelper helper;
    private List<Client> liste;


    public ClientDAO(Context context) {

        this.context = context;
        this.helper = new BddHelper(context);
    }

    public long insert(Client client) {

        long id;

        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues c = new ContentValues();
        c.put(ClientContract.COL_NOM, client.getNom());
        c.put(ClientContract.COL_PRENOM, client.getPrenom());
        c.put(ClientContract.COL_ADRESSE, client.getAdresse());
        c.put(ClientContract.COL_CODEPOSTAL, client.getCodePostal());
        c.put(ClientContract.COL_TEL, client.getTel());
        c.put(ClientContract.COL_VILLE, client.getVille());
        c.put(ClientContract.COL_PERMIS, client.getPermis());
        c.put(ClientContract.COL_MAIL, client.getMail());

        id = db.insert(ClientContract.TABLE_NAME, null, c);

        if (db != null)
            db.close();

        return id;
    }

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

                liste.add(client);

            } while (cursor.moveToNext());
        }

        cursor.close();

        if (db != null)
            db.close();

        return liste;
    }
}
