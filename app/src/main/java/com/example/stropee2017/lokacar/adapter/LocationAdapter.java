package com.example.stropee2017.lokacar.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.stropee2017.lokacar.R;
import com.example.stropee2017.lokacar.beans.Client;
import com.example.stropee2017.lokacar.beans.Location;

import java.util.List;

public class LocationAdapter extends ArrayAdapter<Location> {

    private int res;


    public LocationAdapter(@NonNull Context context, int resource, @NonNull List<Location> objects) {
        super(context, resource, objects);

        res = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(res, parent, false);
            holder = new ViewHolder();
            holder.nomClient = convertView.findViewById(R.id.txtNomListLocEnCours);
            holder.prenomClient = convertView.findViewById(R.id.txtPrenomListLocEnCours);
            holder.marque = convertView.findViewById(R.id.txtMarqueListLocEnCours);
            holder.modele = convertView.findViewById(R.id.txtModeleListLocEnCours);
            holder.immatriculation = convertView.findViewById(R.id.txtImmatListLocEnCours);
            holder.dateRetour = convertView.findViewById(R.id.txtRetourPrevuListLocEnCours);

            convertView.setTag(holder);

        } else {

            holder = (ViewHolder) convertView.getTag();
        }

        Location location = getItem(position);
        holder.nomClient.setText(location.getClient().getNom());
        holder.prenomClient.setText(location.getClient().getPrenom());
        holder.marque.setText(location.getVoiture().getMarque());
        holder.modele.setText(location.getVoiture().getModele());
        holder.immatriculation.setText(location.getVoiture().getImmat());

        android.text.format.DateFormat df = new android.text.format.DateFormat();
        String date = (String) df.format("dd-MM-yyyy", location.getFinLocation());
        holder.dateRetour.setText(date);


        return convertView;


    }

    private class ViewHolder {

        TextView nomClient, prenomClient, marque, modele, immatriculation, dateRetour;


    }

}
