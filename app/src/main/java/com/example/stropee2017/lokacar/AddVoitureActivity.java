package com.example.stropee2017.lokacar;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.stropee2017.lokacar.beans.Agence;
import com.example.stropee2017.lokacar.beans.Voiture;
import com.example.stropee2017.lokacar.dao.BddHelper;
import com.example.stropee2017.lokacar.dao.VoitureDAO;

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
    private EditText editDispo;
    private EditText editEtat;
    private EditText editTarif;
    private EditText editAgence;


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
        editDispo = (EditText) findViewById(R.id.idEditDispo);
        editEtat = (EditText) findViewById(R.id.idEditEtat);
        editTarif = (EditText) findViewById(R.id.idEditTarif);
        editAgence = (EditText) findViewById(R.id.txtAgence);
        //récupération de la ville de la classe Agence que j'associe à mon editText
        String agence = ((Agence) this.getApplication()).getVille();
        Log.v("TAG", agence);
        editAgence.setText(agence);


    }

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
        String dispo = editDispo.getText().toString();
        String etatVoiture = editEtat.getText().toString();
        int tarif = Integer.parseInt(editTarif.getText().toString());

        nouvelleVoiture = new Voiture(tarif, puissance, portes, marque, modele, etatVoiture, immat, couleur, carburant, style, dispo, annee);
        voitureDAO = new VoitureDAO(AddVoitureActivity.this);
        long id = voitureDAO.insert(nouvelleVoiture);
        nouvelleVoiture.setId(id);

        finish();

    }

    private class insert {

    }
}
