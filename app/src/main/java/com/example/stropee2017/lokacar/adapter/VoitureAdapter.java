package com.example.stropee2017.lokacar.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.stropee2017.lokacar.R;
import com.example.stropee2017.lokacar.beans.Voiture;

import java.util.List;

public class VoitureAdapter extends ArrayAdapter<Voiture> {

    private int res;


    public VoitureAdapter(@NonNull Context context, int resource, @NonNull List<Voiture> objects) {
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
            holder.marque = convertView.findViewById(R.id.txtListMarque);
            holder.modele = convertView.findViewById(R.id.txtListModele);
            holder.immat = convertView.findViewById(R.id.txtListImmat);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Voiture voiture = getItem(position);
        holder.marque.setText(voiture.getMarque());
        holder.modele.setText(voiture.getModele());
        holder.immat.setText(voiture.getImmat());

        return convertView;

    }

    private class ViewHolder {
        TextView marque, modele, immat;
    }
}
