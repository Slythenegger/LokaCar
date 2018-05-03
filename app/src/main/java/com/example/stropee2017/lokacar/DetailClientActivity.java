package com.example.stropee2017.lokacar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.stropee2017.lokacar.beans.Client;
import com.example.stropee2017.lokacar.dao.ClientDAO;

public class DetailClientActivity extends AppCompatActivity {

    Client client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_client);
    }

    @Override
    protected void onResume() {



        TextView tv;
        Intent intent = getIntent();
        ClientDAO dao = new ClientDAO(this);

        if (intent != null) {

            long id = intent.getLongExtra("id", 0);
            client = dao.findClientById(id);

            tv = findViewById(R.id.txtDetailNom);
            tv.setText(client.getNom());

            tv = findViewById(R.id.txtDetailPrenom);
            tv.setText(client.getPrenom());

            tv = findViewById(R.id.txtDetailAdresse);
            tv.setText(client.getAdresse());

            tv = findViewById(R.id.txtDetailCodepostal);
            tv.setText(client.getCodePostal());

            tv = findViewById(R.id.txtDetailVille);
            tv.setText(client.getVille());

            tv = findViewById(R.id.txtDetailTelephone);
            tv.setText(client.getTel());

            tv = findViewById(R.id.txtDetailMail);
            tv.setText(client.getMail());

            tv = findViewById(R.id.txtDetailPermis);
            tv.setText(client.getPermis());



        }

        super.onResume();
    }

    public void editClient(View view) {

        Intent intent = new Intent(this, AddClientActivity.class);
        intent.putExtra("client", client);
        startActivity(intent);
    }
}
