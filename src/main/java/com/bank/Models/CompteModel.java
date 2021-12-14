package com.bank.Models;

import java.util.ArrayList;
import java.util.Date;

public class CompteModel {

    static long numit = 1000000000;
    private long num_c;
    private TypeCompte type_c;
    private float solde_c;
    private long id_c;
    private boolean etat;

    private ClientModel prop;
    private ArrayList<TransactionModel> listeTransactions;
    private float frais;

    public CompteModel(long num_c, TypeCompte type_c, float solde_c, long id_c, boolean etat) {
        this.num_c = num_c;
        this.type_c = type_c;
        this.solde_c = solde_c;
        this.id_c = id_c;
        this.etat = etat;
    }

    public CompteModel(long num_c, TypeCompte type_c, float solde_c, long id_c) {
        this.num_c = num_c;
        this.type_c = type_c;
        this.solde_c = solde_c;
        this.id_c = id_c;

    }

    public CompteModel(){}


    public CompteModel( TypeCompte type_c) {
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





    public static void setNumit(long numit) {
        CompteModel.numit = numit;
    }

    public void setNum_c(long num_c) {
        this.num_c = num_c;
    }

    public void setType_c(TypeCompte type_c) {
        this.type_c = type_c;
    }

    public void setSolde_c(float solde_c) {
        this.solde_c = solde_c;
    }

    public void setFrais(float frais) {
        this.frais = frais;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public void setProp(ClientModel prop) {
        this.prop = prop;
    }

    public void setListeTransactions(ArrayList<TransactionModel> listeTransactions) {
        this.listeTransactions = listeTransactions;
    }

    public long getId_c() {
        return id_c;
    }

    public void setId_c(long id_c) {
        this.id_c = id_c;
    }
}
