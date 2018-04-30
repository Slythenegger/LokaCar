package com.example.stropee2017.lokacar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class AccueilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public void goClientActivity(MenuItem item) {

        Intent intent = new Intent(this, ClientActivity.class);
        startActivity(intent);
    }

    public void goVoitureActivity(MenuItem item) {

        Intent intent = new Intent(this, VoitureActivity.class);
        startActivity(intent);

    }

    public void goVueActivity(MenuItem item) {
    }

    public void newLocation(View view) {

        Intent intent = new Intent(this, LocationActivity.class);
        startActivity(intent);

    }
}
