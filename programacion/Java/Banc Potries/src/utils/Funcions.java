package utils;

import classes.*;
import classes.CompteInversio.Tipus;
import classes.Operacio.TipusOperacio;
import java.util.Date;


public class Funcions {
    //He hagut d'instanciar el llistat de comptes per a poder utilitzar-lo dins del for perquè no es podia fer estaticament la referència 
    public static LlistatComptes llistatComptes = new LlistatComptes();
    //Llistat d'operacions general
    public static LlistatOperacions llistatOperacions = new LlistatOperacions();

    public static LlistatClients llistatClients = new LlistatClients();
    
    ///////////////////////////////////////////////////
    /////// FUNCIONS REFERIDES ALS COMPTES ////////////
    ///////////////////////////////////////////////////
    public static void altaCompteCorrent(PersonaClient titular, Double qDiners){
        CompteCorrent compte = new CompteCorrent(titular, qDiners);
        llistatComptes.add(compte);

        titular.setCompte(compte);
        System.out.println("Benvingut/a! Compte donat d'alta correctament!");
    }

    public static void altaCompteEstalvis(PersonaClient titular, Double qDiners){
        CompteEstalvi compte = new CompteEstalvi(titular, qDiners);
        llistatComptes.add(compte);
        System.out.println("Benvingut/a! Compte donat d'alta correctament!");

        titular.setCompte(compte);
    }

    public static void altaCompteInversio(PersonaClient titular, Double qDiners, String tipusMoneda) {
        Tipus moneda = Tipus.valueOf(tipusMoneda.toUpperCase());
        CompteInversio compte = new CompteInversio(titular, qDiners, moneda);
        llistatComptes.add(compte);
        System.out.println("Benvingut/a! Compte donat d'alta correctament!");

        titular.setCompte(compte);
    }

    public static void altaCompteCripto(PersonaClient titular, Double qDiners, String email){
        CompteCripto compte = new CompteCripto(titular, qDiners, email);
        llistatComptes.add(compte);
        System.out.println("Benvingut/a! Compte donat d'alta correctament!");

        titular.setCompte(compte);
    }

    public static void mostrarComptes(){
        System.out.println("\nTotal de comptes: ");
        /* LlistatComptes.mostrarTots(); */
        int index = 1;
        for (Compte compte : llistatComptes) {
            System.out.println((index++) + ": " + compte);
        }
    }

    public static void baixaCompte(int opcio) {
        llistatComptes.remove(opcio-1);
        System.out.println("\nCompte eliminat amb éxit!");
    }

    public static void mostrarCompte(int opcio){
        Compte compte = llistatComptes.get(opcio-1);
        compte.mostrarInformacio();
    }

    public static void modificarInformacio(int opcio, String nouTitular){
        Compte compte = llistatComptes.get(opcio-1);
        compte.getTitular().setNom(nouTitular);
        System.out.println("El nom del compte ha sigut modificat correctament a: \t" + compte.getTitular());
    }

    public static void ingressar(Double qDiners, int id){
        //Ingressar diners a un compte que obtenim per id
        Compte compte = llistatComptes.getById(id);
        compte.ingressar(qDiners);

        //Registrales en la llista d'operacions generals
        TipusOperacio tipusOperacio = TipusOperacio.valueOf("INGRES");
        Operacio operacio = new Operacio(compte, qDiners, tipusOperacio);
        llistatOperacions.add(operacio);

        //Registrales en la llista d'operacions particulars (client)
        compte.getTitular().addOperacio(operacio);
    }

    public static void retirar(Double qDiners, int id){
        Compte compte = llistatComptes.getById(id);
        compte.retirar(qDiners);

        TipusOperacio tipusOperacio = TipusOperacio.valueOf("RETIRADA");
        Operacio operacio = new Operacio(compte, qDiners, tipusOperacio);
        llistatOperacions.add(operacio);

        compte.getTitular().addOperacio(operacio);
    }

    public static void transferir(Double qDiners, int id, int idDestinament){
        Compte compte = llistatComptes.getById(id);
        Compte destinatari = llistatComptes.getById(idDestinament);
        compte.transferir(destinatari, qDiners);

        Date dataStamp = new Date();

        Operacio operacioRetirada = new Operacio(compte, dataStamp, qDiners, TipusOperacio.valueOf("RETIRADA"), true);
        Operacio operacioIngres = new Operacio(destinatari, dataStamp, qDiners, TipusOperacio.valueOf("INGRES"), true);


        llistatOperacions.add(operacioIngres);
        llistatOperacions.add(operacioRetirada);

        destinatari.getTitular().addOperacio(operacioIngres);
        compte.getTitular().addOperacio(operacioRetirada);

    }

    public static void historial(){
        for (Operacio operacio : llistatOperacions){
            System.out.println(operacio);
        }
    }




    ///////////////////////////////////////////////////
    /////// FUNCIONS REFERIDES AL LES PERSONES ////////
    ///////////////////////////////////////////////////
    public static void altaPersonaClient(String nom, int edat, String direccio) {
        PersonaClient client = new PersonaClient(nom, edat, direccio);

        llistatClients.add(client);
        System.out.println();
    }

    public static void mostrarClients(){
        System.out.println("\nTota la clientela: ");
        /* LlistatComptes.mostrarTots(); */

        int index = 1;
        for (PersonaClient client : llistatClients) {
            System.out.println((index++) + ": " + client);
        }
    }

    public static void baixaClient(int index) {
        llistatClients.remove(index-1);
        System.out.println("\nClient eliminat amb éxit!");
    }

    public static void mostrarClient(int opcio){
        PersonaClient client = llistatClients.get(opcio-1);
        client.mostrarInformacio();
    }

    public static void modificarClientNom(int opcio, String nom){
        PersonaClient client = llistatClients.get(opcio -1);
        client.setNom(nom);
        System.out.println("\nClient nom modificat amb éxit!");
    }
    public static void modificarClientEdat(int opcio, int edat){
        PersonaClient client = llistatClients.get(opcio -1);
        client.setEdad(edat);
        System.out.println("\nClient edat modificat amb éxit!");
    }
    public static void modificarClientDireccio(int opcio, String direccio){
        PersonaClient client = llistatClients.get(opcio -1);
        client.setDireccion(direccio);
        System.out.println("\nClient direcció modificat amb éxit!");
    }

    public static PersonaClient getClient(int opcio) {
        return llistatClients.get(opcio-1);
    }
}
