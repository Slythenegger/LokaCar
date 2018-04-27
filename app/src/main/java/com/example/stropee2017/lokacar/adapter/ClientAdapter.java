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

import java.util.List;

public class ClientAdapter extends ArrayAdapter<Client> {

    private int res;

    public ClientAdapter(@NonNull Context context, int resource, @NonNull List<Client> objects) {
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
            holder.nom = convertView.findViewById(R.id.txtListClientNom);
            holder.prenom = convertView.findViewById(R.id.txtListClientPrenom);

            convertView.setTag(holder);

        } else {

            holder = (ViewHolder) convertView.getTag();
        }

        Client client = getItem(position);
        holder.nom.setText(client.getNom());
        holder.prenom.setText(client.getPrenom());

        return convertView;


    }

    private class ViewHolder {

        TextView nom, prenom;


    }

}
