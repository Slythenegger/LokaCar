package com.example.stropee2017.lokacar;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.stropee2017.lokacar.beans.Location;
import com.example.stropee2017.lokacar.dao.LocationDAO;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Date;

public class LocationEnCoursActivity extends AppCompatActivity {

    Location location;
    TextView tv;
    String dateRetour, dateDebut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_en_cours);
    }


    @Override
    protected void onResume() {
        super.onResume();

        Intent intent = getIntent();
        LocationDAO dao = new LocationDAO(this);

        if (intent != null) {

            long idLocation = intent.getLongExtra("idLocation", 0);

            Log.i("TAG_ID_LOC_EN_COURS", String.valueOf(idLocation));

            location = dao.findLocationById(idLocation);

            tv = findViewById(R.id.txtNbJourLocEnCours);
            float nbJours = (float) (location.getFinLocation().getTime() - location.getDebutLocation().getTime()) / (24 * 60 * 60 * 1000);
            int nb = (int) nbJours;
            tv.setText(String.valueOf(nb));

            tv = findViewById(R.id.txtTarifLocEnCours);
            tv.setText(String.valueOf(location.getPrixLocation()));

            tv = findViewById(R.id.txtRetourPrevuLocEnCours);
            android.text.format.DateFormat df = new android.text.format.DateFormat();
            dateRetour = (String) df.format("dd-MM-yyyy", location.getFinLocation());
            dateDebut = (String) df.format("dd-MM-yyyy", location.getDebutLocation());
            tv.setText(dateRetour);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sms, menu);
        return true;
    }

    public void backAccueil(View view) {

        Intent intent = new Intent(this, AccueilActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }

    public void finishLocation(View view) {

        location.setEnCours(false);
        LocationDAO dao = new LocationDAO(this);
        dao.insertOrUpdate(location);
        backAccueil(view);

    }


    public void sendSms(MenuItem item) {

        Uri uri = Uri.parse("smsto:" + location.getClient().getTel());
        Intent it = new Intent(Intent.ACTION_SENDTO, uri);
        it.putExtra("sms_body", "LokaCar : Bonjour Mme/M " + location.getClient().getNom() +
                ". Votre location d'une " + location.getVoiture().getMarque() + " " + location.getVoiture().getModele()
                + " à partir du " + dateDebut + " jusqu'au " + dateRetour
                + " est bien enregistrée. Merci d'utiliser nos services. Bon voyage !");
        startActivity(it);


    }


}
