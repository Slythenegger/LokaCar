package com.example.stropee2017.lokacar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.stropee2017.lokacar.beans.Client;
import com.example.stropee2017.lokacar.beans.Location;
import com.example.stropee2017.lokacar.beans.Voiture;
import com.example.stropee2017.lokacar.dao.LocationDAO;

import java.util.Date;

public class LocationActivity extends AppCompatActivity {

    TextView tv;
    Client client;
    Voiture voiture;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
    }

    public void addVoiture(View view) {
        Intent intent = new Intent(this, VoitureActivity.class);
        intent.putExtra("newLocation", true);
        startActivityForResult(intent, 200);

    }

    public void addClient(View view) {
        Intent intent = new Intent(this, ClientActivity.class);
        intent.putExtra("newLocation", true);
        startActivityForResult(intent, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100 && resultCode == RESULT_OK) {
            this.client = data.getParcelableExtra("client");
            tv = findViewById(R.id.txtIdNomClient);
            tv.setText(client.getNom() + " " + client.getPrenom());
        }
        if (requestCode == 200 && resultCode == RESULT_OK) {
            this.voiture = data.getParcelableExtra("voiture");
            tv = findViewById(R.id.txtIdVoiture);
            tv.setText(voiture.getMarque() + " " + " " + voiture.getModele() + " " + voiture.getImmat());
        }
    }

    public void addPhotos(View view) {

    }

    public void addNewLocation(View view) {

        LocationDAO dao = new LocationDAO(this);

        Location location = new Location();

        location.setVoiture(voiture);
        location.setClient(client);

        et = (EditText) findViewById(R.id.dateDepart);
        location.setDebutLocation(new Date(et.getText().toString()));
        
        et = (EditText) findViewById(R.id.dateRetour);
        location.setFinLocation(new Date(et.getText().toString()));

    }
}
