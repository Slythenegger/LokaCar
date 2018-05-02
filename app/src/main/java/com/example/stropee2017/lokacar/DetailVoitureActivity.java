package com.example.stropee2017.lokacar;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.stropee2017.lokacar.beans.Agence;
import com.example.stropee2017.lokacar.beans.Voiture;
import com.example.stropee2017.lokacar.dao.VoitureDAO;

public class DetailVoitureActivity extends AppCompatActivity {

    private TextView textMarque;
    private TextView textModele;
    private TextView textImmat;
    private TextView textAnnee;
    private TextView textPuissance;
    private TextView textPortes;
    private TextView textCarburant;
    private TextView textCouleur;
    private TextView textStyle;
    private TextView textDispo;
    private TextView textTarif;
    private TextView textEtat;
    private TextView textAgence;

    Voiture voiture;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_voiture);
    }

    @Override
    protected void onResume() {

        TextView tv;
        Intent intent = getIntent();
        VoitureDAO dao = new VoitureDAO(this);

        if (intent != null) {

            long id = intent.getLongExtra("id", 0);
            voiture = dao.findVoitureById(id);

            textMarque = (TextView) findViewById(R.id.recupMarque);
            textModele = (TextView) findViewById(R.id.recupModele);
            textImmat = (TextView) findViewById(R.id.recupImmat);
            textAnnee = (TextView) findViewById(R.id.recupAnnee);
            textPuissance = (TextView) findViewById(R.id.recupPuissance);
            textPortes = (TextView) findViewById(R.id.recupPortes);
            textCarburant = (TextView) findViewById(R.id.recupCarburant);
            textCouleur = (TextView) findViewById(R.id.recupCouleur);
            textStyle = (TextView) findViewById(R.id.recupStyle);
            textDispo = (TextView) findViewById(R.id.recupDispo);
            textTarif = (TextView) findViewById(R.id.recupTarif);
            textEtat = (TextView) findViewById(R.id.recupEtat);
            textAgence = (TextView) findViewById(R.id.recupAgence);


            textMarque.setText(voiture.getMarque());
            textModele.setText(voiture.getModele());
            textImmat.setText(voiture.getImmat());
            textAnnee.setText(voiture.getAnnee());
            textPuissance.setText(String.valueOf((voiture.getPuissance())));
            textPortes.setText(String.valueOf(voiture.getPortes()));
            textCarburant.setText(voiture.getCarburant());
            textCouleur.setText(voiture.getCouleur());
            textStyle.setText(voiture.getStyle());
            textDispo.setText(voiture.getDispo());
            textTarif.setText(String.valueOf(voiture.getTarif()));
            textEtat.setText(voiture.getEtatVoiture());
            //récupérer le nom de l'agence lié à son id ;
            textAgence.setText(((Agence) this.getApplication()).getVille());


        }


        super.onResume();
    }
}
