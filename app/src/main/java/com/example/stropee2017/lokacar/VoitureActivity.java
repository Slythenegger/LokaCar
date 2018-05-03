package com.example.stropee2017.lokacar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.stropee2017.lokacar.adapter.VoitureAdapter;
import com.example.stropee2017.lokacar.beans.Client;
import com.example.stropee2017.lokacar.beans.Agence;
import com.example.stropee2017.lokacar.beans.Voiture;
import com.example.stropee2017.lokacar.dao.VoitureDAO;

import java.util.ArrayList;
import java.util.List;

public class VoitureActivity extends AppCompatActivity {

    List<Voiture> listeVoitures = new ArrayList<>();
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voiture);
        
        //la liste s'intégrera dans la layout identifié par listVoitures
        lv = (ListView) findViewById(R.id.listVoitures);
        ViewGroup headerView = (ViewGroup) getLayoutInflater().inflate(R.layout.activity_header_list_voitures, lv, false);
        lv.addHeaderView(headerView);
    }


    //aficher la liste des voitures
    @Override
    protected void onResume() {




        VoitureDAO voitureDAO = new VoitureDAO(VoitureActivity.this);
        //appel de la fonction getListe -> récupération des voitures dans ma BDD
        listeVoitures = voitureDAO.getListe(((Agence) this.getApplication()).getIdAgence());

        final VoitureAdapter adapter = new VoitureAdapter(VoitureActivity.this, R.layout.voiture_list, listeVoitures);

        lv.setAdapter(adapter);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position>0){
                    Voiture voiture = listeVoitures.get(position - 1);
                    Intent intent = new Intent(VoitureActivity.this, DetailVoitureActivity.class);
                    intent.putExtra("id", voiture.getId());
                    startActivity(intent);
                }


            }
        });


        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = getIntent();
                if (intent.getBooleanExtra("newLocation", false) == false) {

                    return false;

                } else {
                    Intent monIntent = new Intent();
                    Voiture voiture = listeVoitures.get(position - 1);
                    monIntent.putExtra("voiture", voiture);
                    setResult(RESULT_OK, monIntent);
                    finish();
                    return true;
                }


            }
        });
        super.onResume();

    }

    public void addVoiture(View view) {

        Intent intent = new Intent(VoitureActivity.this, AddVoitureActivity.class);
        startActivity(intent);

    }
}
