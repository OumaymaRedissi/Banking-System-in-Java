package com.bank.Models;

import java.util.Date;

public class ClientModel {

    static long idit=11;
    private long id_clt;
    private String nomPrenom;
    private Date date_n;
    private String tel;
    private String email;
    private String adr;

    public ClientModel() {}

    public ClientModel(long id_clt, String nomPrenom, Date date_n, String tel, String email, String adr) {
        this.id_clt = id_clt;
        this.nomPrenom = nomPrenom;
        this.date_n = date_n;
        this.tel = tel;
        this.email = email;
        this.adr = adr;
    }

    public ClientModel(String tel, String email, String adr) {
        this.tel = tel;
        this.email = email;
        this.adr = adr;
    }
    public ClientModel(String nomPrenom, Date date_n, String tel, String email, String adr) {
        this.id_clt = idit++;
        this.nomPrenom = nomPrenom;
        this.date_n = date_n;
        this.tel = tel;
        this.email = email;
        this.adr = adr;
    }

    public ClientModel(long id_clt, Date date_n, String tel, String email, String adr) {
    }

    public Long getId_clt() {
        return id_clt;
    }

    public String getNomPrenom() {
        return nomPrenom;
    }

    public Date getDate_n() {return  date_n;}

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    public String getAdr() {
        return adr;
    }



    public void setId_clt(long id_clt) {
        this.id_clt = id_clt;
    }

    public void setNomPrenom(String nomPrenom) {
        this.nomPrenom = nomPrenom;
    }

    public void setDate_n(Date date_n) {
        this.date_n = date_n;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }
}