package com.example.stropee2017.lokacar;

import android.graphics.Color;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.example.stropee2017.lokacar.adapter.DetailBusinessAdapter;
import com.example.stropee2017.lokacar.beans.Agence;
import com.example.stropee2017.lokacar.beans.Voiture;
import com.example.stropee2017.lokacar.dao.VoitureDAO;

import java.util.ArrayList;
import java.util.List;

class EtatBusinessActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etat_business);

        ListView lst = findViewById(R.id.listeVoitures);

        VoitureDAO daoVoiture = new VoitureDAO(this);

        List<Voiture> maListe = new ArrayList<>();
        maListe = daoVoiture.getListe(1);

        DetailBusinessAdapter adapter = new DetailBusinessAdapter(this,R.layout.etat_business_details,maListe);

      /*  for(Voiture voiture:maListe) {
            if (voiture.getDispo() == true) {

                Log.i("changement couleur", "changé en vert");
            } else {
                adapter.setBackgroundColor(Color.red(Color.RED));
                Log.i("changement couleur", "changé en rouge");
            }
        }
        */
        lst.setAdapter(adapter);

    }
}
