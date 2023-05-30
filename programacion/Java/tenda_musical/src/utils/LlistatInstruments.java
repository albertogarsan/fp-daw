package utils;

import classes.Instrument;
import classes.comparators.ComparatorNumSerie;
import classes.comparators.ComparatorPreu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class LlistatInstruments implements Iterable<Instrument> {
    // En lloc de tindre = new ArrayList... buit cada vegada que executem el programa, carregarem les dades dels instruments mitjançant una funció que connectarà amb la base de dades 
    //private static ArrayList<Instrument> llistatInstruments = new ArrayList<Instrument>();
    private static ArrayList<Instrument> llistatInstruments = GestorBD.carregarInstruments();
    /* LlistatInstruments.add(new Fusta("Clarinet", "1", 3000.00, null)); */
    

    public void add(Instrument nouInstrument){
        llistatInstruments.add(nouInstrument);
    }

    public void remove(Instrument nouInstrument){
        llistatInstruments.remove(nouInstrument);
    }

    public void remove(int index){
        llistatInstruments.remove(index);
    }

    public static int size(){
        return llistatInstruments.size();
    }

    public Instrument get(int index){
        return llistatInstruments.get(index);
    }

    public Instrument getByName(String nom){
        for (Instrument instrument : llistatInstruments) {
            if (instrument.getNom() == nom) {
                return instrument;
            }
        }
        return null;
    }

    //ITERATOR
    public Iterator<Instrument> iterator() {
        return llistatInstruments.iterator();
    } 

    //COMPARABLES
    public static void ordenarPerNom(){
        Collections.sort(llistatInstruments);
    }

    public static void ordenarPreu(){
        Collections.sort(llistatInstruments, new ComparatorPreu());
    }
    public static void ordenarNumSerie(){
        Collections.sort(llistatInstruments, new ComparatorNumSerie());
    }
    public void clear() {
        llistatInstruments.clear();
    }

}
