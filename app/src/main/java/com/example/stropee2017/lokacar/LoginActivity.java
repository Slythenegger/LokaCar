package com.example.stropee2017.lokacar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stropee2017.lokacar.beans.Agence;
import com.example.stropee2017.lokacar.beans.Login;
import com.example.stropee2017.lokacar.dao.AgenceDAO;
import com.example.stropee2017.lokacar.dao.LoginDAO;
import com.example.stropee2017.lokacar.dao.contract.LoginContract;

public class LoginActivity extends AppCompatActivity {
    Agence luc;
    Button boutonLogin, boutonCancel;
    EditText username, password;

    TextView tx1;
    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        boutonLogin = (Button) findViewById(R.id.buttonLogin);
        username = (EditText) findViewById(R.id.textUsername);
        password = (EditText) findViewById(R.id.textPassword);

        boutonCancel = (Button) findViewById(R.id.buttonCancel);
        tx1 = (TextView) findViewById(R.id.nombreAttentat);


        boutonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AgenceDAO agenceDAO = new AgenceDAO(LoginActivity.this);
                luc = agenceDAO.findAgenceById(Integer.parseInt((username.getText().toString())));

                if (luc != null && password.getText().toString().equals(luc.getPassword())) {

                    Toast.makeText(getApplicationContext(),
                            "Bienvenue !", Toast.LENGTH_SHORT).show();
                    setAgence();


                    Intent intent = new Intent(LoginActivity.this,
                            AccueilActivity.class);
                    // intent.putExtra(EXTRA_LOGIN, loginTxt);
                    // intent.putExtra(EXTRA_PASSWORD, passTxt);

                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Erreur Authentification", Toast.LENGTH_SHORT).show();
                    tx1.setTextColor(Color.RED);
                    counter--;
                    tx1.setText(Integer.toString(counter));
                    username.setText("");
                    password.setText("");

                    if (counter == 0) {
                        boutonLogin.setEnabled(false);
                    }
                }
            }
        });

        boutonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username.setText("");
                password.setText("");


            }
        });


    }

    public void setAgence() {
        if (luc != null) {
            //on set avec les parametres récupérées dans la base de données
            ((Agence) this.getApplication()).setIdAgence(luc.getIdAgence());
            ((Agence) this.getApplication()).setNomGerant(luc.getNomGerant());
            ((Agence) this.getApplication()).setPrenomGerant(luc.getPrenomGerant());
            ((Agence) this.getApplication()).setAdresse(luc.getAdresse());
            ((Agence) this.getApplication()).setCodePostal(luc.getCodePostal());
            ((Agence) this.getApplication()).setVille(luc.getVille());
            ((Agence) this.getApplication()).setTelephone(luc.getTelephone());
            ((Agence) this.getApplication()).setPassword(luc.getPassword());
            ((Agence) this.getApplication()).setChiffreDAffaire(luc.getChiffreDAffaire());
        } else {
            Toast.makeText(getApplicationContext(), "récupération de l'agence échoué", Toast.LENGTH_SHORT).show();
        }
    }


}