package org.example.compte;

import java.util.UUID;

public class Compte {
    private String numeroCompte;
    private double soldeCompte;
    public Compte() {
        this.numeroCompte = UUID.randomUUID().toString();
        this.soldeCompte = 5000;
    }
    public String getNumeroCompte() {
        return numeroCompte;
    }
    public double getSoldeCompte() {
        return soldeCompte;
    }
    public void depot(double valeur){
        soldeCompte+=valeur;
    }
    public void retrait(double valeur){
        soldeCompte-= valeur;
    }
}


