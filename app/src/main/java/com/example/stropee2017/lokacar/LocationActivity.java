package com.example.stropee2017.lokacar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.stropee2017.lokacar.beans.Client;

public class LocationActivity extends AppCompatActivity {

    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
    }

    public void addVoiture(View view) {
    }

    public void addClient(View view) {
        Intent intent = new Intent(this, ClientActivity.class);
        intent.putExtra("newLocation", true);
        startActivityForResult(intent, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100 && resultCode == RESULT_OK) {
            Client client = data.getParcelableExtra("client");

            tv = findViewById(R.id.txtIdNomClient);
            tv.setText(client.getNom() + " " + client.getPrenom());


        }


    }
}
