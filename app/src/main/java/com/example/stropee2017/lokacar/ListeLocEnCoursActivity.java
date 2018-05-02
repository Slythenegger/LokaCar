package com.example.stropee2017.lokacar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.stropee2017.lokacar.adapter.ClientAdapter;
import com.example.stropee2017.lokacar.adapter.LocationAdapter;
import com.example.stropee2017.lokacar.beans.Client;
import com.example.stropee2017.lokacar.beans.Location;
import com.example.stropee2017.lokacar.dao.ClientDAO;
import com.example.stropee2017.lokacar.dao.LocationDAO;

import java.util.ArrayList;
import java.util.List;

public class ListeLocEnCoursActivity extends AppCompatActivity {

    List<Location> listeLocation = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_location_en_cours);

    }


    @Override
    protected void onResume() {
        super.onResume();

        ListView lv = findViewById(R.id.lstLocEnCours);

        LocationDAO dao = new LocationDAO(this);
        listeLocation = dao.getListeLocation();

        final LocationAdapter adapter = new LocationAdapter(this,
                R.layout.location_list,
                listeLocation);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Location location = listeLocation.get(position);
                Intent intent = new Intent(ListeLocEnCoursActivity.this, LocationEnCoursActivity.class);
                intent.putExtra("idLocation", location.getIdLocation());
                startActivity(intent);
            }
        });
    }
}
