package com.example.bank.Models;

import java.util.Date;

public class CompteModel {
    private enum TypeCompte{Epargne, Courant}
    private String num_c;
    private TypeCompte type_c;
    private Date date_c;
    private float solde_c;
    private float frais;
    private boolean etat;

    public CompteModel(String num_c, TypeCompte type_c, Date date_c, float solde_c, float frais, boolean etat) {
        this.num_c = num_c;
        this.type_c = type_c;
        this.date_c = date_c;
        this.solde_c = solde_c;
        this.frais = frais;
        this.etat = etat;
    }

    public String getNum_c() {
        return num_c;
    }

    public TypeCompte getType_c() {
        return type_c;
    }

    public Date getDate_c() {
        return date_c;
    }

    public float getSolde_c() {
        return solde_c;
    }

    public float getFrais() {
        return frais;
    }

    public boolean isEtat() {
        return etat;
    }
}
