package com.bank.Models;

public enum TypeCompte {
    EPARGNE("E","Epargne") ,
    COURANT("C","Courant");


    private String code;
    private String text;

    private TypeCompte(String code, String text) {
        this.code = code;
        this.text = text;
    }

    public String getCode() {
        return code;
    }

    public String getText() {
        return text;
    }

    public static TypeCompte getByCode(String TypeCompteCode) {
        for (TypeCompte g : TypeCompte.values()) {
            if (g.code.equals(TypeCompteCode)) {
                return g;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.text;
    }
    }
