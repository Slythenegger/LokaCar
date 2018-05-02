package com.example.stropee2017.lokacar.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stropee2017.lokacar.R;
import com.example.stropee2017.lokacar.beans.Voiture;

import java.util.List;

public class DetailBusinessAdapter extends ArrayAdapter<Voiture>{
    private int res;

    public DetailBusinessAdapter(@NonNull Context context, int resource, @NonNull List<Voiture> objects) {
        super(context, resource, objects);
        res = resource;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        ViewHolder holder;

        if(convertView == null ){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(res,parent,false);

            holder = new ViewHolder();

            holder.image = convertView.findViewById(R.id.avatar);
            holder.marque = convertView.findViewById(R.id.pseudo);
            holder.modele = convertView.findViewById(R.id.text);

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        Voiture voiture = getItem(position);
       // holder.image.setImageDrawable();
        holder.marque.setText(voiture.getMarque());
        holder.modele.setText((voiture.getModele()));




        return convertView;
    }



    static class ViewHolder{
        ImageView image;
        TextView marque;
        TextView modele;

    }
}
