package com.bank.Models;

import java.util.ArrayList;

public class BanqueModel {

    static long numit=1;
    private long num_bq;
    private String nom_bq;
    private ArrayList<AgenceModel> listeAgence;


    public BanqueModel( String nom_bq) {
        this.num_bq = numit++;
        this.nom_bq = nom_bq;
        this.listeAgence = new ArrayList<>();
    }


    public long getNum_bq() {
        return num_bq;
    }

    public String getNom_bq() {
        return nom_bq;
    }
}
