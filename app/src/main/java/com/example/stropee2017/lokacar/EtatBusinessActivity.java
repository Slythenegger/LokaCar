package com.example.stropee2017.lokacar;

import android.graphics.Color;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.example.stropee2017.lokacar.adapter.DetailBusinessAdapter;
import com.example.stropee2017.lokacar.beans.Agence;
import com.example.stropee2017.lokacar.beans.Location;
import com.example.stropee2017.lokacar.beans.Voiture;
import com.example.stropee2017.lokacar.dao.LocationDAO;
import com.example.stropee2017.lokacar.dao.VoitureDAO;

import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EtatBusinessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etat_business);

        //declarations variables
        LocationDAO daoLocation;
        VoitureDAO daoVoiture;

        List<Voiture> maListe;
        List<Location> listeLocationEnCours;
        List<Location> listeLocationPasCours;
        List<Location> listeLocation;
        ListView lst;
        TextView bilan;

        float prix=0.0f;

        lst = findViewById(R.id.listeVoitures);
        bilan = findViewById(R.id.chiffre);

        //methode calcule chiffre d'affaire
        daoLocation = new LocationDAO(this);
        listeLocationEnCours = daoLocation.getListeLocation();
        listeLocationPasCours = daoLocation.getListeLocationPasEnCours();

        listeLocation = new ArrayList<>();
        listeLocation.addAll(listeLocationEnCours);
        listeLocation.addAll(listeLocationPasCours);

        //TODO a finir comparaison date
        //SimpleDateFormat sdf = new SimpleDateFormat("MM-yy");

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/yyyy");
        Date date1 = null;
        Date date2 = null;
        Date date = new Date();

        for (Location location : listeLocation){
           if((dateFormat.format(location.getFinLocation())).compareTo(dateFormat.format(date))==0){
                prix+=location.getPrixLocation();
           }
        }

        bilan.setText("Chiffre d'affaire du mois: "+prix+" Euros");



        // methode affichage liste voiture dispo coloré en vert et non dispo coloré en rouge
        daoVoiture = new VoitureDAO(this);
        maListe = daoVoiture.getListe(1);

        DetailBusinessAdapter adapter = new DetailBusinessAdapter(this, R.layout.etat_business_details, maListe);

        lst.setAdapter(adapter);

    }
}
