package com.example.stropee2017.lokacar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.stropee2017.lokacar.adapter.ClientAdapter;
import com.example.stropee2017.lokacar.beans.Client;
import com.example.stropee2017.lokacar.dao.ClientDAO;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

public class ClientActivity extends AppCompatActivity {

    List<Client> listeClient = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);


    }

    @Override
    protected void onResume() {

        ListView lv = findViewById(R.id.lstClient);

        ClientDAO dao = new ClientDAO(ClientActivity.this);
        listeClient = dao.getListe();

        final ClientAdapter adapter = new ClientAdapter(ClientActivity.this,
                R.layout.client_list,
                listeClient);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Client client = listeClient.get(position);
                Intent intent = new Intent(ClientActivity.this, DetailClientActivity.class);
                intent.putExtra("id", client.getIdClient());
                startActivity(intent);
            }
        });

        super.onResume();
    }

    public void addClient(View view) {

        Intent intent = new Intent(this, AddClientActivity.class);
        startActivity(intent);
    }
}
