package org.example.client;

import org.example.compte.Compte;

import java.util.UUID;

public class Client {
    private String nom;
    private Compte[] listeComptes = new Compte[5];
    private String idClient;

    public Client(String nom) {
        this.nom = nom;
        this.idClient = UUID.randomUUID().toString();
        for (int i = 0; i < listeComptes.length; i++) {
            listeComptes[i] = new Compte();
        }
    }
    public String getNom() {
        return this.nom;
    }
    public Compte[] getListeComptes() {
        return this.listeComptes;
    }
    public int getSoldes() {
        int sum = 0;
        for (Compte compte : this.listeComptes) {
            sum += compte.getSoldeCompte();
        }
        return sum;
    }
    public String getIdClient() {
        return this.idClient;
    }
    public void ajouterCompte(Compte compte) {
        for (int i = 0; i < this.listeComptes.length; i++) {
            if (this.listeComptes[i] == null) {
                this.listeComptes[i] = compte;
                break;
            }
        }
    }
    public void renflouer(){
        for(Compte compte : listeComptes){
            if(compte.getSoldeCompte()<0){
                for(Compte comptee : listeComptes){
                    if(comptee.getSoldeCompte()> compte.getSoldeCompte() * (-1)){
                        comptee.depot(compte.getSoldeCompte());
                        compte.depot(compte.getSoldeCompte() * (-1));
                        System.out.println("Compte avec id:"+compte.getNumeroCompte()+" n'est plus en découvert!");
                        break;
                    }
                }
            }
        }
    }
    public Compte chercherCompte(String id) {
        for (Compte compte : this.listeComptes) {
            if (compte != null) {
                if (compte.getNumeroCompte().equals(id)){
                    return compte;
                }
            }else{
                break;
            }
        }
        return null;
    }
}