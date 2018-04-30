package com.example.stropee2017.lokacar.beans;

import android.os.Parcel;
import android.os.Parcelable;

public class Client implements Parcelable {

    private long idClient;
    private String nom, prenom, adresse, codePostal, tel, ville, permis, mail;

    public Client() {

    }

    public Client(String tel, String nom, String prenom, String adresse, String codePostal, String ville, String permis, String mail) {
        this.tel = tel;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.permis = permis;
        this.mail = mail;
    }


    protected Client(Parcel in) {
        idClient = in.readLong();
        nom = in.readString();
        prenom = in.readString();
        adresse = in.readString();
        codePostal = in.readString();
        tel = in.readString();
        ville = in.readString();
        permis = in.readString();
        mail = in.readString();
    }

    public static final Creator<Client> CREATOR = new Creator<Client>() {
        @Override
        public Client createFromParcel(Parcel in) {
            return new Client(in);
        }

        @Override
        public Client[] newArray(int size) {
            return new Client[size];
        }
    };

    public long getIdClient() {
        return idClient;
    }

    public void setIdClient(long idClient) {

        this.idClient = idClient;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPermis() {
        return permis;
    }

    public void setPermis(String permis) {
        this.permis = permis;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", codePostal='" + codePostal + '\'' +
                ", tel='" + tel + '\'' +
                ", ville='" + ville + '\'' +
                ", permis='" + permis + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(idClient);
        dest.writeString(nom);
        dest.writeString(prenom);
        dest.writeString(adresse);
        dest.writeString(codePostal);
        dest.writeString(tel);
        dest.writeString(ville);
        dest.writeString(permis);
        dest.writeString(mail);
    }
}


