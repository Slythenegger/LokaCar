package com.example.stropee2017.lokacar.beans;

import java.util.Date;
import java.util.List;

public class Location {

    private long idVoiture, idClient, idLocation;
    private Date debutLocation, finLocation;
    private float prixLocation;
    private List<String> etatDepart, etatRetour;

    public Location() {
    }

    public Location(long idVoiture, long idClient, Date debutLocation, Date finLocation, float prixLocation, List<String> etatDepart, List<String> etatRetour) {
        this.idVoiture = idVoiture;
        this.idClient = idClient;
        this.debutLocation = debutLocation;
        this.finLocation = finLocation;
        this.prixLocation = prixLocation;
        this.etatDepart = etatDepart;
        this.etatRetour = etatRetour;
    }

    public long getIdVoiture() {
        return idVoiture;
    }

    public void setIdVoiture(long idVoiture) {
        this.idVoiture = idVoiture;
    }

    public long getIdClient() {
        return idClient;
    }

    public void setIdClient(long idClient) {
        this.idClient = idClient;
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
}
