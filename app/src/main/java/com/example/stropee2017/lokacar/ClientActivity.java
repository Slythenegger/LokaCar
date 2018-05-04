package com.example.stropee2017.lokacar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.stropee2017.lokacar.adapter.ClientAdapter;
import com.example.stropee2017.lokacar.beans.Agence;
import com.example.stropee2017.lokacar.beans.Client;
import com.example.stropee2017.lokacar.dao.ClientDAO;
import com.example.stropee2017.lokacar.dao.VoitureDAO;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

public class ClientActivity extends AppCompatActivity {

    List<Client> listeClient = new ArrayList<>();
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        lv = findViewById(R.id.lstClient);

        ViewGroup headerView = (ViewGroup) getLayoutInflater().inflate(R.layout.activity_header_list_clients, lv, false);
        lv.addHeaderView(headerView);


    }

    @Override
    protected void onResume() {


        ClientDAO dao = new ClientDAO(ClientActivity.this);
        listeClient = dao.getListe();

        final ClientAdapter adapter = new ClientAdapter(ClientActivity.this,
                R.layout.client_list,
                listeClient);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) {
                    Client client = listeClient.get(position - 1);
                    Intent intent = new Intent(ClientActivity.this, DetailClientActivity.class);
                    intent.putExtra("id", client.getIdClient());
                    startActivity(intent);
                }

            }
        });


        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {


                Intent intent = getIntent();
                if (intent.getBooleanExtra("newLocation", false) == false) {

                    Intent newIntentLocation = new Intent(ClientActivity.this, LocationActivity.class);
                    Client client = listeClient.get(position - 1);
                    newIntentLocation.putExtra("clientLoc", client);
                    startActivity(newIntentLocation);

                    return true;

                } else {
                    Intent monIntent = new Intent();
                    Client client = listeClient.get(position - 1);
                    monIntent.putExtra("client", client);
                    setResult(RESULT_OK, monIntent);
                    finish();
                    return true;
                }


            }
        });


        super.onResume();
    }

    public void addClient(View view) {

        Intent intent = new Intent(this, AddClientActivity.class);
        startActivity(intent);
    }
}
