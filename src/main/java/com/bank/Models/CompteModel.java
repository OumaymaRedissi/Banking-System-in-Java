package com.bank.Models;

import java.util.ArrayList;
import java.util.Date;

public class CompteModel {

    static long numit = 1000000000;
    private long num_c;
    private TypeCompte type_c;
    private float solde_c;
    private float frais;
    private boolean etat;
    private ClientModel prop;
    private ArrayList<TransactionModel> listeTransactions;



    public CompteModel( TypeCompte type_c, Date date_c) {
        this.etat = true;
        this.num_c = numit++;
        this.type_c = type_c;
        this.solde_c = 0;
        this.listeTransactions = new ArrayList<>();
        if(type_c == TypeCompte.EPARGNE)
            this.frais = (float) 0.15;
        else if(type_c == TypeCompte.COURANT)
            this.frais = (float) 0.30;
    }
    public CompteModel( TypeCompte type_c,  float x) {
        this.etat = true;
        this.num_c = numit++;
        this.type_c = type_c;
        this.solde_c = x;
        this.listeTransactions = new ArrayList<>();
        if(type_c == TypeCompte.EPARGNE)
            this.frais = (float) 0.15;
        else if(type_c == TypeCompte.COURANT)
            this.frais = (float) 0.30;
    }

    public long getNum_c() {
        return num_c;
    }

    public TypeCompte getType_c() {
        return type_c;
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

    public void Depot(double x){
        solde_c+=x;
    }
    public void Retrait(double x){
        solde_c-=x;
    }
    public void virerVers(CompteModel cb, double x){
        cb.Depot(x);
        Retrait(x);
    }
}
