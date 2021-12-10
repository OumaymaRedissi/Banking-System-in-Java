package com.bank.Models;

import java.util.ArrayList;

public class AgenceModel {

    static long codeit=100;
    private long code;
    private String nomChef;
    private String tel;
    private String adress;
    private Devise dev;
    private ArrayList<CompteModel> listeCompte;

    public AgenceModel( String nomChef, String tel, String email, String adress, Devise dev) {
        this.code = codeit++;
        this.nomChef = nomChef;
        this.tel = tel;
        this.adress = adress;
        this.dev = dev;
        this.listeCompte = new ArrayList<>();
    }

    public long getCode() {
        return code;
    }

    public String getNomChef() {
        return nomChef;
    }

    public String getTel() {
        return tel;
    }

    public String getAdress() {
        return adress;
    }

    public Devise getDev() {
        return dev;
    }

    public ArrayList<CompteModel> getListeCompte(){return listeCompte;}

    public int nbrCompte(){
        return listeCompte.size();
    }

    public void ajouterCompte(CompteModel compteModel){
        listeCompte.add(compteModel);
    }

    public void fermerCompte(CompteModel compteModel){
        listeCompte.remove(compteModel);
    }

    public boolean existant(CompteModel compteModel){
        return listeCompte.contains(compteModel);
    }

    public boolean agencevide(){
        return  listeCompte.isEmpty();
    }

    public String toString(){
        return listeCompte.toString();
    }


}
