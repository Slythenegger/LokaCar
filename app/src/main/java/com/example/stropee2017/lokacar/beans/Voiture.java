package com.example.stropee2017.lokacar.beans;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Voiture implements Parcelable {

    private long id, idAgence;
    private int tarif, puissance, portes;
    private String marque, modele, etatVoiture, immat, couleur, carburant, style, dispo, annee;
    private List<String> listPhotos;

    public Voiture() {
    }

    public Voiture(int tarif, int puissance, int portes, String marque, String modele, String etatVoiture, String immat, String couleur, String carburant, String style, String dispo, String annee) {
        this.tarif = tarif;
        this.puissance = puissance;
        this.portes = portes;
        this.marque = marque;
        this.modele = modele;
        this.etatVoiture = etatVoiture;
        this.immat = immat;
        this.couleur = couleur;
        this.carburant = carburant;
        this.style = style;
        this.dispo = dispo;
        this.annee = annee;
    }

    public Voiture(int tarif, int puissance, int portes, String marque, String modele, String etatVoiture, String immat, String couleur, String carburant, String style, String dispo, String annee, List<String> listPhotos) {
        this.tarif = tarif;
        this.puissance = puissance;
        this.portes = portes;
        this.marque = marque;
        this.modele = modele;
        this.etatVoiture = etatVoiture;
        this.immat = immat;
        this.couleur = couleur;
        this.carburant = carburant;
        this.style = style;
        this.dispo = dispo;
        this.annee = annee;
        this.listPhotos = listPhotos;
    }

    public Voiture(long idAgence, int tarif, int puissance, int portes, String marque, String modele, String etatVoiture, String immat, String couleur, String carburant, String style, String dispo, String annee, List<String> listPhotos) {
        this.idAgence = idAgence;
        this.tarif = tarif;
        this.puissance = puissance;
        this.portes = portes;
        this.marque = marque;
        this.modele = modele;
        this.etatVoiture = etatVoiture;
        this.immat = immat;
        this.couleur = couleur;
        this.carburant = carburant;
        this.style = style;
        this.dispo = dispo;
        this.annee = annee;
        this.listPhotos = listPhotos;
    }

    protected Voiture(Parcel in) {
        id = in.readLong();
        idAgence = in.readLong();
        tarif = in.readInt();
        puissance = in.readInt();
        portes = in.readInt();
        marque = in.readString();
        modele = in.readString();
        etatVoiture = in.readString();
        immat = in.readString();
        couleur = in.readString();
        carburant = in.readString();
        style = in.readString();
        dispo = in.readString();
        annee = in.readString();
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdAgence() {
        return idAgence;
    }

    public void setIdAgence(long idAgence) {
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

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
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

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public List<String> getListPhotos() {
        return listPhotos;
    }

    public void setListPhotos(List<String> listPhotos) {
        this.listPhotos = listPhotos;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Voiture{");
        sb.append("id=").append(id);
        sb.append(", idAgence=").append(idAgence);
        sb.append(", tarif=").append(tarif);
        sb.append(", puissance=").append(puissance);
        sb.append(", portes=").append(portes);
        sb.append(", marque='").append(marque).append('\'');
        sb.append(", modele='").append(modele).append('\'');
        sb.append(", etatVoiture='").append(etatVoiture).append('\'');
        sb.append(", immat='").append(immat).append('\'');
        sb.append(", couleur='").append(couleur).append('\'');
        sb.append(", carburant='").append(carburant).append('\'');
        sb.append(", style='").append(style).append('\'');
        sb.append(", dispo='").append(dispo).append('\'');
        sb.append(", annee='").append(annee).append('\'');
        sb.append(", listPhotos=").append(listPhotos);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeLong(idAgence);
        dest.writeInt(tarif);
        dest.writeInt(puissance);
        dest.writeInt(portes);
        dest.writeString(marque);
        dest.writeString(modele);
        dest.writeString(etatVoiture);
        dest.writeString(immat);
        dest.writeString(couleur);
        dest.writeString(carburant);
        dest.writeString(style);
        dest.writeString(dispo);
        dest.writeString(annee);
        dest.writeStringList(listPhotos);
    }
}


