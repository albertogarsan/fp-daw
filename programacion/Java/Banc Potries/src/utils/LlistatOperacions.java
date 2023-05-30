package utils;
import classes.Operacio;
import java.util.ArrayList;
import java.util.Iterator;
import java.lang.Iterable;

public class LlistatOperacions implements Iterable<Operacio> {
    private static ArrayList<Operacio> llistatOperacions = new ArrayList<Operacio>();

    public void add(Operacio novaOperacio){
        llistatOperacions.add(novaOperacio);
    }

    public void remove(Operacio operacio){
        llistatOperacions.remove(operacio);
    }

    public void remove(int index){
        llistatOperacions.remove(index);
    }

    public Boolean contains(Operacio operacio){
        return llistatOperacions.contains(operacio);
    }

    public static int size(){
        return llistatOperacions.size();
    }

    @Override
    public Iterator<Operacio> iterator() {
        return llistatOperacions.iterator();
    }

    
}
