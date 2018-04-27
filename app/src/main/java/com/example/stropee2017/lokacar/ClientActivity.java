package com.example.stropee2017.lokacar;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.stropee2017.lokacar.beans.BddHelper;

public class ClientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        BddHelper helper = new BddHelper(this);

        SQLiteDatabase db = helper.getWritableDatabase();





    }
}
