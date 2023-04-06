package org.example;

import org.example.banque.Banque;
import org.example.client.Client;
import org.example.compte.Compte;
import org.example.service.BanqueInteractive;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//-------------------------variables setup----------------------------

        Banque banque = new Banque("MybanK");
        Scanner scan = new Scanner(System.in);
        BanqueInteractive banqueService = new BanqueInteractive(banque);
        Client[] clients = banque.getListeClients();

        Boolean onWork = true;

//-------------------------------------------------------------------------------------------

        while(onWork = true){

            int choix = banqueService.choixOperationBanque(scan);

            if(choix==1){
                String nomClient = banqueService.inputNomClient(scan);
                banque.ajouterClient(new Client(nomClient));
            }else if(choix==2){
                // choix du client
                banqueService.displayClientsNames(clients);
                Client clientChoisis = banqueService.recupererClientChoisis(clients, scan);
                // choix d'opérations
                int num = banqueService.choixOperationClient(scan);
                banqueService.operationsClient(clientChoisis,num,scan);
                checkOnWork(scan);

            }else if(choix==3){
                // afficher un bilan général
                banque.afficherBilan();
                checkOnWork(scan);
            }
            banque.renflouerAll();
        }
    }
    public static boolean checkOnWork(Scanner scan){
        System.out.println("\n souhaites-tu quitter le programme ?  y or n");
        String response = scan.next();

        if(response.equals('y')){
            return false;
        }else if(response.equals('n')){
            return true;
        }
        return true;
    }
}