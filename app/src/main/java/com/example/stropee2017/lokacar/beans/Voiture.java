package com.example.stropee2017.lokacar.beans;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Voiture implements Parcelable {

    private int id, idAgence, tarif, puissance, portes;
    private String etatVoiture, immat, couleur, carburant, style, dispo;
    private List<String> listPhotos;

    public Voiture() {
    }

    public Voiture(int idAgence, int tarif, int puissance, int portes, String etatVoiture, String immat, String couleur, String carburant, String style, String dispo, List<String> listPhotos) {
        this.idAgence = idAgence;
        this.tarif = tarif;
        this.puissance = puissance;
        this.portes = portes;
        this.etatVoiture = etatVoiture;
        this.immat = immat;
        this.couleur = couleur;
        this.carburant = carburant;
        this.style = style;
        this.dispo = dispo;
        this.listPhotos = listPhotos;
    }

    public Voiture(int id, int idAgence, int tarif, int puissance, int portes, String etatVoiture, String immat, String couleur, String carburant, String style, String dispo, List<String> listPhotos) {
        this.id = id;
        this.idAgence = idAgence;
        this.tarif = tarif;
        this.puissance = puissance;
        this.portes = portes;
        this.etatVoiture = etatVoiture;
        this.immat = immat;
        this.couleur = couleur;
        this.carburant = carburant;
        this.style = style;
        this.dispo = dispo;
        this.listPhotos = listPhotos;
    }

    protected Voiture(Parcel in) {
        id = in.readInt();
        idAgence = in.readInt();
        tarif = in.readInt();
        puissance = in.readInt();
        portes = in.readInt();
        etatVoiture = in.readString();
        immat = in.readString();
        couleur = in.readString();
        carburant = in.readString();
        style = in.readString();
        dispo = in.readString();
        listPhotos = in.createStringArrayList();
    }

    public static final Creator<Voiture> CREATOR = new Creator<Voiture>() {
        @Override
        public Voiture createFromParcel(Parcel in) {
            return new Voiture(in);
        }

        @Override
        public Voiture[] newArray(int size) {
            return new Voiture[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAgence() {
        return idAgence;
    }

    public void setIdAgence(int idAgence) {
        this.idAgence = idAgence;
    }

    public int getTarif() {
        return tarif;
    }

    public void setTarif(int tarif) {
        this.tarif = tarif;
    }

    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    public int getPortes() {
        return portes;
    }

    public void setPortes(int portes) {
        this.portes = portes;
    }

    public String getEtatVoiture() {
        return etatVoiture;
    }

    public void setEtatVoiture(String etatVoiture) {
        this.etatVoiture = etatVoiture;
    }

    public String getImmat() {
        return immat;
    }

    public void setImmat(String immat) {
        this.immat = immat;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getCarburant() {
        return carburant;
    }

    public void setCarburant(String carburant) {
        this.carburant = carburant;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getDispo() {
        return dispo;
    }

    public void setDispo(String dispo) {
        this.dispo = dispo;
    }

    public List<String> getListPhotos() {
        return listPhotos;
    }

    public void setListPhotos(List<String> listPhotos) {
        this.listPhotos = listPhotos;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(idAgence);
        dest.writeInt(tarif);
        dest.writeInt(puissance);
        dest.writeInt(portes);
        dest.writeString(etatVoiture);
        dest.writeString(immat);
        dest.writeString(couleur);
        dest.writeString(carburant);
        dest.writeString(style);
        dest.writeString(dispo);
        dest.writeStringList(listPhotos);
    }

    @Override
    public String toString() {
        return "Voiture{" +
                "id=" + id +
                ", idAgence=" + idAgence +
                ", tarif=" + tarif +
                ", puissance=" + puissance +
                ", portes=" + portes +
                ", etatVoiture='" + etatVoiture + '\'' +
                ", immat='" + immat + '\'' +
                ", couleur='" + couleur + '\'' +
                ", carburant='" + carburant + '\'' +
                ", style='" + style + '\'' +
                ", dispo='" + dispo + '\'' +
                ", listPhotos=" + listPhotos +
                '}';
    }
}
