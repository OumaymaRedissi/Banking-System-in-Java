package com.example.bank.Models;

public class AgenceModel {
    private enum Devises{ Dt, Eu , Dol}

    private int code;
    private String nomChef;
    private String tel;
    private String email;
    private String adress;
    private Devises dev;

    public AgenceModel(int code, String nomChef, String tel, String email, String adress, Devises dev) {
        this.code = code;
        this.nomChef = nomChef;
        this.tel = tel;
        this.email = email;
        this.adress = adress;
        this.dev = dev;
    }

    public int getCode() {
        return code;
    }

    public String getNomChef() {
        return nomChef;
    }

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    public String getAdress() {
        return adress;
    }

    public Devises getDev() {
        return dev;
    }
}
