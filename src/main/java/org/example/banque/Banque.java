package org.example.banque;

import org.example.client.Client;
import org.example.compte.Compte;

public class Banque {
    public String nomBanque;
    private Client[] listeClients = new Client[10];
    public Banque(String nomBanque) {
        this.nomBanque = nomBanque;
    }

    public Client[] getListeClients() {
        return this.listeClients;
    }

    public Client ajouterClient(Client client){
        for (int i = 0; i < this.listeClients.length; i++) {
            if(this.listeClients[i] == null){
                this.listeClients[i] = client;
                break;
            }
        }
        System.out.println("Le client "+client.getNom()+" a été crée !");
        return client;
    }

    public void afficherBilan(){
        for (Client client : this.listeClients){
            if(client != null){
                System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                System.out.println("\nLe client "+client.getNom()+" avec un id: "+ client.getIdClient());
                bilanClient(client);
            }else{
                break;
            }

        }
    }
    public void bilanClient(Client client){
        for (Compte compte : client.getListeComptes()){
            if (compte != null){
                System.out.println("=================================================");
                System.out.println("Numero de compte: "+compte.getNumeroCompte());
                System.out.println("Solde du compte: "+compte.getSoldeCompte());
                System.out.println("=================================================");
            }
        }
    }

    public void renflouerAll(){
        for(Client client : this.listeClients){
            if(client == null){
                break;
            }
            client.renflouer();
        }
    }
}
