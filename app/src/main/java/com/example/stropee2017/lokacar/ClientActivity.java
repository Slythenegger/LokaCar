package com.example.stropee2017.lokacar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.stropee2017.lokacar.dao.VoitureDAO;

public class ClientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);


    }

    public void addClient(View view) {

        Intent intent = new Intent(this, AddClientActivity.class);
        startActivity(intent);
    }
}
