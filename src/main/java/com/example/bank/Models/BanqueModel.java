package com.example.bank.Models;

public class BanqueModel {
    private int num_bq;
    private String nom_bq;

    public BanqueModel(int num_bq, String nom_bq) {
        this.num_bq = num_bq;
        this.nom_bq = nom_bq;
    }

    public int getNum_bq() {
        return num_bq;
    }

    public String getNom_bq() {
        return nom_bq;
    }
}
