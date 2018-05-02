package com.example.stropee2017.lokacar.beans;

import android.app.Application;

public class Agence extends Application {

    private long idAgence;
    private String nomGerant, prenomGerant, adresse, codePostal, ville, telephone, password;
    private float chiffreDAffaire;


    public Agence() {
    }

    public Agence( String nomGerant, String prenomGerant, String adresse, String codePostal, String ville, String telephone, String password, float chiffreDAffaire) {

        this.nomGerant = nomGerant;
        this.prenomGerant = prenomGerant;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.telephone = telephone;
        this.password = password;
        this.chiffreDAffaire = chiffreDAffaire;
    }

    public Agence(long idAgence, String nomGerant, String prenomGerant, String adresse, String codePostal, String ville, String telephone, String password, float chiffreDAffaire) {
        this.idAgence = idAgence;
        this.nomGerant = nomGerant;
        this.prenomGerant = prenomGerant;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.telephone = telephone;
        this.password = password;
        this.chiffreDAffaire = chiffreDAffaire;
    }

    public long getIdAgence() {
        return idAgence;
    }

    public void setIdAgence(long idAgence) {
        this.idAgence = idAgence;
    }

    public String getNomGerant() {
        return nomGerant;
    }

    public void setNomGerant(String nomGerant) {
        this.nomGerant = nomGerant;
    }

    public String getPrenomGerant() {
        return prenomGerant;
    }

    public void setPrenomGerant(String prenomGerant) {
        this.prenomGerant = prenomGerant;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public float getChiffreDAffaire() {
        return chiffreDAffaire;
    }

    public void setChiffreDAffaire(float chiffreDAffaire) {
        this.chiffreDAffaire = chiffreDAffaire;
    }
}
