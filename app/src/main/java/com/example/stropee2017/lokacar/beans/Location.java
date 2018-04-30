package com.example.stropee2017.lokacar.beans;

import java.util.Date;
import java.util.List;

public class Location {

    private long idLocation;
    private Date debutLocation, finLocation;
    private float prixLocation;
    private Client client;
    private Voiture voiture;
    private List<String> etatDepart, etatRetour;

    public Location() {
    }

    public Location(Date debutLocation, Date finLocation, float prixLocation, Client client, Voiture voiture, List<String> etatDepart, List<String> etatRetour) {
        this.debutLocation = debutLocation;
        this.finLocation = finLocation;
        this.prixLocation = prixLocation;
        this.client = client;
        this.voiture = voiture;
        this.etatDepart = etatDepart;
        this.etatRetour = etatRetour;
    }

    public long getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(long idLocation) {
        this.idLocation = idLocation;
    }

    public Date getDebutLocation() {
        return debutLocation;
    }

    public void setDebutLocation(Date debutLocation) {
        this.debutLocation = debutLocation;
    }

    public Date getFinLocation() {
        return finLocation;
    }

    public void setFinLocation(Date finLocation) {
        this.finLocation = finLocation;
    }

    public float getPrixLocation() {
        return prixLocation;
    }

    public void setPrixLocation(float prixLocation) {
        this.prixLocation = prixLocation;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Voiture getVoiture() {
        return voiture;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }

    public List<String> getEtatDepart() {
        return etatDepart;
    }

    public void setEtatDepart(List<String> etatDepart) {
        this.etatDepart = etatDepart;
    }

    public List<String> getEtatRetour() {
        return etatRetour;
    }

    public void setEtatRetour(List<String> etatRetour) {
        this.etatRetour = etatRetour;
    }

    @Override
    public String toString() {
        return "Location{" +
                "idLocation=" + idLocation +
                ", debutLocation=" + debutLocation +
                ", finLocation=" + finLocation +
                ", prixLocation=" + prixLocation +
                ", client=" + client +
                ", voiture=" + voiture +
                ", etatDepart=" + etatDepart +
                ", etatRetour=" + etatRetour +
                '}';
    }
}
