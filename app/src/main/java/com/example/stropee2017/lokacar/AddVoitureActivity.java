package com.example.stropee2017.lokacar;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
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
    private EditText editModele;
    private EditText editImmat;
    private EditText editAnnee;
    private EditText editCouleur;
    private EditText editCarburant;
    private EditText editPuissance;
    private EditText editPorte;
    private EditText editStyle;
    private RadioGroup radioDispo;
    private RadioButton btnDispo;
    private RadioGroup radioEtat;
    private RadioButton btnEtat;
    private RadioGroup editEtat;
    private EditText editTarif;
    private EditText editAgence;
    List<String> listMarques = new ArrayList();
    private String marque;
    private int dispo;
    private boolean estDispo;
    private String etatVoiture;

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
        /*
        editMarque.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                marque = listMarques.get(position);
            }
        });
        */
        editMarque.setAdapter(adapter);


    }


    public void onClickAjouterVoiture(View view) {

        radioDispo = (RadioGroup) findViewById(R.id.radioGroupDispo);
        radioEtat = (RadioGroup) findViewById(R.id.radioGroupEtat);

        //estDispo
        dispo = radioDispo.getCheckedRadioButtonId();
        btnDispo = findViewById(dispo);
        String valeurRadioButton = btnDispo.getText().toString();
        estDispo = ("Oui".equals(valeurRadioButton));


        btnEtat = findViewById(radioEtat.getCheckedRadioButtonId());
        etatVoiture = btnEtat.getText().toString();


        String modele = editModele.getText().toString();
        String immat = editImmat.getText().toString();
        String annee = editAnnee.getText().toString();
        String couleur = editCouleur.getText().toString();
        String carburant = editCarburant.getText().toString();
        //je récupère un texte que je veux transformer en int. Du coup j'utilise un parse pour transformer le string en interger
        int puissance = Integer.parseInt(editPuissance.getText().toString());
        int portes = Integer.parseInt(editPorte.getText().toString());
        String style = editStyle.getText().toString();

        int tarif = Integer.parseInt(editTarif.getText().toString());

        if (marque == null) {
            marque = listMarques.get(0);
        }

        nouvelleVoiture = new Voiture(tarif, puissance, portes, marque, modele, etatVoiture, immat, couleur, carburant, style, estDispo, annee);
        nouvelleVoiture.setIdAgence(((Agence) this.getApplication()).getIdAgence());
        Log.v("TAG", "voiture :" + nouvelleVoiture);
        voitureDAO = new VoitureDAO(AddVoitureActivity.this);
        long id = voitureDAO.insert(nouvelleVoiture);
        nouvelleVoiture.setId(id);

        finish();

    }


}
