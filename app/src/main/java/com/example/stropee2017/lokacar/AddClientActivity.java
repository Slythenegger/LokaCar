package com.example.stropee2017.lokacar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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

    public void saveClient(View view) {

        client = new Client();

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
                dao.insert(client);
                finish();
            }
        });

        thread.start();


    }
}
