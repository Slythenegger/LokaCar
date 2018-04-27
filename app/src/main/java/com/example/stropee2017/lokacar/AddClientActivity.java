package com.example.stropee2017.lokacar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stropee2017.lokacar.beans.Client;
import com.example.stropee2017.lokacar.dao.ClientDAO;

public class AddClientActivity extends AppCompatActivity {

    Client client;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_client);

    }

    @Override
    protected void onResume() {

        Intent intent = getIntent();

        if (intent != null) {

            client = intent.getParcelableExtra("client");

            if (client != null) {

                et = findViewById(R.id.editNom);
                et.setText(client.getNom());

                et = findViewById(R.id.editPrenom);
                et.setText(client.getPrenom());

                et = findViewById(R.id.editAdresse);
                et.setText(client.getAdresse());

                et = findViewById(R.id.editCodepostal);
                et.setText(client.getCodePostal());

                et = findViewById(R.id.editVille);
                et.setText(client.getVille());

                et = findViewById(R.id.editTelephone);
                et.setText(client.getTel());

                et = findViewById(R.id.editMail);
                et.setText(client.getMail());

                et = findViewById(R.id.editPermis);
                et.setText(client.getPermis());
            }

        }

        super.onResume();
    }

    public void saveClient(View view) {

        if (client == null) {

            client = new Client();
        }

        et = findViewById(R.id.editNom);
        client.setNom(et.getText().toString());

        et = findViewById(R.id.editPrenom);
        client.setPrenom(et.getText().toString());

        et = findViewById(R.id.editAdresse);
        client.setAdresse(et.getText().toString());

        et = findViewById(R.id.editCodepostal);
        client.setCodePostal(et.getText().toString());

        et = findViewById(R.id.editVille);
        client.setVille(et.getText().toString());

        et = findViewById(R.id.editTelephone);
        client.setTel(et.getText().toString());

        et = findViewById(R.id.editMail);
        client.setMail(et.getText().toString());

        et = findViewById(R.id.editPermis);
        client.setPermis(et.getText().toString());

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                ClientDAO dao = new ClientDAO(AddClientActivity.this);
                Log.i("TAG", client.toString());
                client.setIdClient(dao.insertOrUpdate(client));
                finish();
            }
        });

        thread.start();


    }
}
