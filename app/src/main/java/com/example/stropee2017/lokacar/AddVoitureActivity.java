package com.example.stropee2017.lokacar;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

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
    private EditText editMarque;
    private EditText editModele;
    private EditText editImmat;
    private EditText editAnnee;
    private EditText editCouleur;
    private EditText editCarburant;
    private EditText editPuissance;
    private EditText editPorte;
    private EditText editStyle;
    private RadioGroup editDispo;
    private RadioGroup editEtat;
    private EditText editTarif;
    private EditText editAgence;

    Spinner spinner ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_voiture);

        editMarque = (EditText) findViewById(R.id.idEditMarque);
        editModele = (EditText) findViewById(R.id.idEditModele);
        editImmat = (EditText) findViewById(R.id.idEditImmat);
        editAnnee = (EditText) findViewById(R.id.idEditAnnee);
        editCouleur = (EditText) findViewById(R.id.idEditCouleur);
        editCarburant = (EditText) findViewById(R.id.idEditCarburant);
        editPuissance = (EditText) findViewById(R.id.idEditPuissance);
        editPorte = (EditText) findViewById(R.id.idEditPortes);
        editStyle = (EditText) findViewById(R.id.idEditStyle);
        editDispo = (RadioGroup) findViewById(R.id.radioGroupDispo);
        editEtat = (RadioGroup) findViewById(R.id.radioGroupEtat);
        editTarif = (EditText) findViewById(R.id.idEditTarif);
        editAgence = (EditText) findViewById(R.id.txtAgence);
        //récupération de la ville de la classe Agence que j'associe à mon editText
        String agence = ((Agence) this.getApplication()).getVille();
        editAgence.setText(agence);

        spinner = (Spinner) findViewById(R.id.spinner);
        List list = new ArrayList();
        list.add("Toyota");
        list.add("Porsche");

        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.activity_add_voiture, list);

        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

    }

    /*
    public void onClickAjouterVoiture(View view) {

        String marque = editMarque.getText().toString();
        String modele = editModele.getText().toString();
        String immat = editImmat.getText().toString();
        String annee = editAnnee.getText().toString();
        String couleur = editCouleur.getText().toString();
        String carburant = editCarburant.getText().toString();
        //je récupère un texte que je veux transformer en int. Du coup j'utilise un parse pour transformer le string en interger
        int puissance = Integer.parseInt(editPuissance.getText().toString());
        int portes = Integer.parseInt(editPorte.getText().toString());
        String style = editStyle.getText().toString();
        //boolean dispo = editDispo.getCheckedRadioButtonId();
        String etatVoiture = editEtat.getCheckedRadioButtonId().toString();
        int tarif = Integer.parseInt(editTarif.getText().toString());

        nouvelleVoiture = new Voiture(tarif, puissance, portes, marque, modele, etatVoiture, immat, couleur, carburant, style, dispo, annee);
        nouvelleVoiture.setIdAgence(((Agence) this.getApplication()).getIdAgence());
        Log.v("TAG", "voiture :"+nouvelleVoiture);
        voitureDAO = new VoitureDAO(AddVoitureActivity.this);
        long id = voitureDAO.insert(nouvelleVoiture);
        nouvelleVoiture.setId(id);

        finish();

    }
    */

    private class insert {

    }
}
