package utils;

import classes.PersonaClient;
import classes.Comparadors.ComparadorClientDataAlta;
import classes.Comparadors.ComparadorClientEdat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;



public class LlistatClients implements Iterable<PersonaClient>{
    private static ArrayList<PersonaClient> llistatClients = new ArrayList<PersonaClient>();
    
    public void add(PersonaClient novaPersonaClient){
        llistatClients.add(novaPersonaClient);
    }

    public void remove(PersonaClient personaClient){
        llistatClients.remove(personaClient);
    }

    public void remove(int index){
        llistatClients.remove(index);
    }

    public Boolean contains(PersonaClient personaClient){
        return llistatClients.contains(personaClient);
    }

    public static int size(){
        return llistatClients.size();
    }

    //Per a obtindre una personaClient
    public PersonaClient get(int index){
        return llistatClients.get(index);
    }

    public PersonaClient getByCompteId(int id){
        for (PersonaClient client : llistatClients){
            if (client.getCompte().getId() == id){
                return client;
            }
        }
        return null;
    }

    public PersonaClient getByName(String name){
        for (PersonaClient client : llistatClients) {
            if (client.getNom() == name) {
                return client;
            }
        }
        return null;
    }


    //ITERATOR
    public Iterator<PersonaClient> iterator() {
        return llistatClients.iterator();
    } 

    //COMPARABLES
    public static void ordenarPerNom(){
        Collections.sort(llistatClients);
    }

    public static void ordenarPerDataAlta(){
        Collections.sort(llistatClients, new ComparadorClientDataAlta());
    }
    public static void ordenarPerEdat(){
        Collections.sort(llistatClients, new ComparadorClientEdat());
    }
}
