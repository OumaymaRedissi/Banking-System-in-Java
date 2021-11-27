package com.example.bank.Models;

import java.util.Date;

public class ClientModel {
    private String id_clt;
    private String nomPrenom;
    private Date date_n;
    private String el;
    private String email;
    private String adr;

    public ClientModel(String id_clt, String nomPrenom, Date date_n, String el, String email, String adr) {
        this.id_clt = id_clt;
        this.nomPrenom = nomPrenom;
        this.date_n = date_n;
        this.el = el;
        this.email = email;
        this.adr = adr;
    }

    public String getId_clt() {
        return id_clt;
    }

    public String getNomPrenom() {
        return nomPrenom;
    }

    public Date getDate_n() {
        return date_n;
    }

    public String getEl() {
        return el;
    }

    public String getEmail() {
        return email;
    }

    public String getAdr() {
        return adr;
    }
}