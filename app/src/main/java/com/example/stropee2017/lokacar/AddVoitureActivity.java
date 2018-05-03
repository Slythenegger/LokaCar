package com.example.stropee2017.lokacar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.stropee2017.lokacar.beans.Agence;
import com.example.stropee2017.lokacar.beans.Voiture;
import com.example.stropee2017.lokacar.dao.BddHelper;
import com.example.stropee2017.lokacar.dao.VoitureDAO;

import java.util.ArrayList;
import java.util.List;

public class AddVoitureActivity extends AppCompatActivity {

    private BddHelper helper;
    private int idVoiture;
    private Voiture nouvelleVoiture;
    private VoitureDAO voitureDAO;
    private Spinner editMarque;
    private EditText editModele, editImmat, editAnnee, editCouleur, editCarburant, editPuissance, editPorte, editStyle, editTarif, editAgence;
    private RadioGroup radioDispo;
    private RadioButton btnDispo, btnEtat;
    private RadioGroup radioEtat, editEtat;
    List<String> listMarques = new ArrayList();
    private String marque, etatVoiture;
    private int dispo;
    private boolean estDispo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_voiture);

        editMarque = (Spinner) findViewById(R.id.editMarque);
        editModele = (EditText) findViewById(R.id.idEditModele);
        editImmat = (EditText) findViewById(R.id.idEditImmat);
        editAnnee = (EditText) findViewById(R.id.idEditAnnee);
        editCouleur = (EditText) findViewById(R.id.idEditCouleur);
        editCarburant = (EditText) findViewById(R.id.idEditCarburant);
        editPuissance = (EditText) findViewById(R.id.idEditPuissance);
        editPorte = (EditText) findViewById(R.id.idEditPortes);
        editStyle = (EditText) findViewById(R.id.idEditStyle);

        editEtat = (RadioGroup) findViewById(R.id.radioGroupEtat);
        editTarif = (EditText) findViewById(R.id.idEditTarif);
        editAgence = (EditText) findViewById(R.id.txtAgence);
        //récupération de la ville de la classe Agence que j'associe à mon editText
        String agence = ((Agence) this.getApplication()).getVille();
        editAgence.setText(agence);


        //création d'un menu déroulant affichant des marques insérées en dur
        listMarques.add("Toyota");
        listMarques.add("Porsche");
        listMarques.add("Smart");

        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, listMarques);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        editMarque.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                marque = listMarques.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                marque = listMarques.get(0);
            }
        });

        editMarque.setAdapter(adapter);


    }


    public void onClickAjouterVoiture(View view) {

        radioDispo = (RadioGroup) findViewById(R.id.radioGroupDispo);
        radioEtat = (RadioGroup) findViewById(R.id.radioGroupEtat);

        int puissance = 0;
        int portes = 0;
        float tarif = 0;
        String modele = null;

        //estDispo
        dispo = radioDispo.getCheckedRadioButtonId();
        btnDispo = findViewById(dispo);
        String valeurRadioButton = btnDispo.getText().toString();
        estDispo = ("Oui".equals(valeurRadioButton));


        btnEtat = findViewById(radioEtat.getCheckedRadioButtonId());
        etatVoiture = btnEtat.getText().toString();

        if (editModele == null) {
            Toast.makeText(getApplicationContext(), "Indiquez le modèle svp", Toast.LENGTH_SHORT).show();
        } else {
            modele = editModele.getText().toString();
        }


        String immat = editImmat.getText().toString();
        String annee = editAnnee.getText().toString();
        String couleur = editCouleur.getText().toString();
        String carburant = editCarburant.getText().toString();
        //je récupère un texte que je veux transformer en int. Du coup j'utilise un parse pour transformer le string en interger

        if ("".equals(editPuissance)) {
            Toast.makeText(getApplicationContext(), "Ajoutez la puissance svp", Toast.LENGTH_SHORT).show();
        } else {
            puissance = Integer.parseInt(editPuissance.getText().toString());
        }

        if (editPorte == null) {
            Toast.makeText(getApplication(), "Indiquez le nombre de portes svp", Toast.LENGTH_SHORT).show();
        } else {
            portes = Integer.parseInt(editPorte.getText().toString());
        }

        if (editTarif == null) {
            Toast.makeText(getApplication(), "Indiquez le tarif svp", Toast.LENGTH_SHORT).show();
        } else {
            tarif = Float.parseFloat(editTarif.getText().toString());
        }
        String style = editStyle.getText().toString();


        //ce bloc sera la condition si la voiture a été correctement insérée
        nouvelleVoiture = new Voiture(tarif, puissance, portes, marque, modele, etatVoiture, immat, couleur, carburant, style, estDispo, annee);
        nouvelleVoiture.setIdAgence(((Agence) this.getApplication()).getIdAgence());
        Log.v("TAG", "voiture :" + nouvelleVoiture);
        voitureDAO = new VoitureDAO(AddVoitureActivity.this);
        long id = voitureDAO.insert(nouvelleVoiture);
        nouvelleVoiture.setId(id);

        if (nouvelleVoiture != null) {
            Toast.makeText(getApplication(), "Voiture ajoutée", Toast.LENGTH_SHORT).show();
        }

        finish();

    }
}
