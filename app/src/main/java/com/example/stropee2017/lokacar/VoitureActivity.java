package com.example.stropee2017.lokacar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.stropee2017.lokacar.adapter.VoitureAdapter;
import com.example.stropee2017.lokacar.beans.Voiture;
import com.example.stropee2017.lokacar.dao.VoitureDAO;

import java.util.ArrayList;
import java.util.List;

public class VoitureActivity extends AppCompatActivity {

    List<Voiture> listeVoitures = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.voiture_list);
    }


    //aficher la liste des voitures
    @Override
    protected void onResume() {

        //la liste s'intégrera dans la layout identifié par listVoitures
        ListView lv = findViewById(R.id.listVoitures);

        VoitureDAO voitureDAO = new VoitureDAO(VoitureActivity.this);
        //appel de la fonction getListe -> récupération des voitures dans ma BDD
        listeVoitures = voitureDAO.getListe();

        final VoitureAdapter adapter = new VoitureAdapter(VoitureActivity.this, R.layout.voiture_list, listeVoitures);

        lv.setAdapter(adapter);

        /*
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Voiture voiture = listeVoitures.get(position);
                Intent intent = new Intent(VoitureActivity.this, DetailVoitureActivity.class);
                intent.putExtra("id", voiture.getId());
                startActivity(intent);
            }
        });
        */

        super.onResume();

    }
}
