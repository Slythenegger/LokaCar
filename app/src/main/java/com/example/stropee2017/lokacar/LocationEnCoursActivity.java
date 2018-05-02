package com.example.stropee2017.lokacar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.stropee2017.lokacar.beans.Location;
import com.example.stropee2017.lokacar.dao.LocationDAO;

public class LocationEnCoursActivity extends AppCompatActivity {

    Location location;
    TextView tv;

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

            Location location = dao.findLocationById(idLocation);

           /* tv = findViewById(R.id.txtNbJourLocEnCours);
            float nbJours = (float)(location.getFinLocation().getTime() - location.getDebutLocation().getTime()) / (24 * 60 * 60 * 1000);
            int nb = (int) nbJours;
            tv.setText(String.valueOf(nb));*/

            tv = findViewById(R.id.txtTarifLocEnCours);
            tv.setText(String.valueOf(location.getPrixLocation()));




        }


    }
}
