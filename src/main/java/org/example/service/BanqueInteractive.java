package org.example.service;

import org.example.banque.Banque;
import org.example.client.Client;
import org.example.compte.Compte;

import java.util.Scanner;

public class BanqueInteractive {
    Banque banque;

    public BanqueInteractive(Banque banque) {
        this.banque = banque;
    }
    public int choixOperationBanque(Scanner scan){
        System.out.println("Quelle opération voulez-vous effectuer ?");
        System.out.println("1) Ajouter un client");
        System.out.println("2) Effectuer une opération sur un client");
        System.out.println("3) Afficher un bilan général");
        System.out.print("- ");
        int num = scan.nextInt();
        scan.nextLine();
        return num;
    }
    public String inputNomClient(Scanner scan){
        System.out.println("Entrez le nom du client :");
        System.out.print("- ");
        String nom = scan.nextLine();
        return nom;
    }
    public int choixOperationClient(Scanner scan){
        System.out.println("Quelle opération voulez-vous effectuer ?");
        System.out.println("1) Afficher un bilan");
        System.out.println("2) Faire un retrait");
        System.out.println("3) Faire un dépot");
        System.out.println("4) Faire un virement");
        System.out.print("- ");
        return scan.nextInt();
    }
    public void operationsClient(Client client, int choixOperation, Scanner scan){
        if(choixOperation == 1){
            this.banque.bilanClient(client);

        }else if(choixOperation == 2 ){
            //faire un retrait
            scan.nextLine();
            Compte compte  = recupererCompteChoisis(client, scan);
            double valeur = inputRetirer(scan);
            scan.nextLine();
            compte.retrait(valeur);

        }else if(choixOperation == 3){
            //faire un depot
            scan.nextLine();
            Compte compte = recupererCompteChoisis(client,scan); //chercher et récuperer un compte
            double valeur = inputDeposer(scan);
            scan.nextLine();
            compte.depot(valeur);

        }else if(choixOperation == 4){
            //faire un virement
            System.out.println("de quel montant est votre virement ?");
            int virement = scan.nextInt();
            scan.nextLine();
            // compte expediteur
            System.out.println("Choisissez le compte expéditeur: ");
            System.out.println();
            Compte compte1 = recupererCompteChoisis(client, scan);
            compte1.retrait(virement);
            //compte destinataire
            System.out.println("\nChoisissez le compte destinataire: ");
            Compte compte2 = recupererCompteChoisis(client,scan);
            while(compte2 == compte1){
                compte2 = recupererCompteChoisis(client,scan);
            }
            compte2.depot(virement);
        }
    }
    public double inputRetirer(Scanner scan){
        System.out.println("Combien souhaitez-vous retirer ? ");
        System.out.print("- ");
        return scan.nextInt();
    }
    public double inputDeposer(Scanner scan){
        System.out.println("Combien souhaitez-vous deposer ? ");
        System.out.print("- ");
        return scan.nextInt();
    }
    public void displayClientsNames(Client[] clients){
        for( int i = 0; i<clients.length; i++){
            if(clients[i] != null){
                System.out.println("-"+i+" "+ clients[i].getNom() +" || id: "+clients[i].getIdClient());
            }else{
                break;
            }
        }
    }
    public Client recupererClientChoisis(Client[] clients, Scanner scan){

        System.out.println("Choisissez un index pour séléctionner un client: ");
        System.out.print("-");
        int index = scan.nextInt();
        Client clientSelectionne = clients[index];
        System.out.println("client selectionné est : "+ clientSelectionne.getNom());
        return clientSelectionne;
    }
    public Compte recupererCompteChoisis(Client client,Scanner scan){
        this.banque.bilanClient(client); // afficher tout les comptes du client
        String numCompte = inputNumCompte(scan); // récupérer le num de compte
        Compte compte =client.chercherCompte(numCompte); // récupérer le compte
        return compte;
    }
    public String inputNumCompte(Scanner scan){
        System.out.println("Choissez un numero de compte: ");
        //System.out.print("- ");
        String numCompte = scan.nextLine();
        return numCompte; // récupérer le numero de compte souhaité
    }
}
