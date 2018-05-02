package com.example.stropee2017.lokacar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stropee2017.lokacar.beans.Client;
import com.example.stropee2017.lokacar.beans.Location;
import com.example.stropee2017.lokacar.beans.Voiture;
import com.example.stropee2017.lokacar.dao.LocationDAO;

import java.util.Date;

public class LocationActivity extends AppCompatActivity {

    TextView tv;
    Client client;
    Voiture voiture;
    EditText etDepart, etRetour;

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

        etDepart = (EditText) findViewById(R.id.dateDepart);
        etRetour = (EditText) findViewById(R.id.dateRetour);

        if (client == null || voiture == null || etDepart.getText().toString().equals("") || etRetour.getText().toString().equals("")) {

            Toast.makeText(this, "Veuillez remplir correctement tous les champs demandés", Toast.LENGTH_LONG).show();

        } else {

            location.setVoiture(voiture);
            location.setClient(client);

            String debutLoc = etDepart.getText().toString();
            String[] tabDateDebut = debutLoc.split("/");
            String newDateDebut = tabDateDebut[1] + "/" + tabDateDebut[0] + "/" + tabDateDebut[2];
            location.setDebutLocation(new Date(newDateDebut));


            String retourLoc = etRetour.getText().toString();
            String[] tabDateRetour = retourLoc.split("/");
            String newDateRetour = tabDateRetour[1] + "/" + tabDateRetour[0] + "/" + tabDateRetour[2];
            location.setFinLocation(new Date(newDateRetour));

            location.setEnCours(true);

            float nbJours = (location.getFinLocation().getTime() - location.getDebutLocation().getTime()) / (24 * 60 * 60 * 1000);
            int nb = (int) nbJours;
            location.setPrixLocation(nb * location.getVoiture().getTarif());

            location.setIdLocation(dao.insertOrUpdate(location));

            Intent intent = new Intent(this, LocationEnCoursActivity.class);
            intent.putExtra("idLocation", location.getIdLocation());
            startActivity(intent);
        }


    }
}
