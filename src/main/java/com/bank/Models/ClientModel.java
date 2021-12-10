package com.bank.Models;

import java.util.Date;

public class ClientModel {

    static long idit=1;
    private long id_clt;
    private String nomPrenom;
    private Date date_n;
    private String el;
    private String email;
    private String adr;

    public ClientModel( String nomPrenom, Date date_n, String el, String email, String adr) {
        this.id_clt = idit++;
        this.nomPrenom = nomPrenom;
        this.date_n = date_n;
        this.el = el;
        this.email = email;
        this.adr = adr;
    }

    public Long getId_clt() {
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