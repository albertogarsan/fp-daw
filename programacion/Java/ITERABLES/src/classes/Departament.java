package classes;

import java.util.ArrayList;
import java.util.Iterator;

public class Departament implements Iterable<Empleat> {

    //ATRIBUTS
    String nom;
    ArrayList<Empleat> empleats = new ArrayList<Empleat>();
    


    //CONSTRUCTORS
    public Departament(String nom, ArrayList<Empleat> empleats) {
        this.nom = nom;
        this.empleats = empleats;
    }

    public Departament(String nom) {
        this.nom = nom;
    }


    //MÈTODES
    public String getNom() {
        return nom;
    }
    public ArrayList<Empleat> getEmpleats() {
        return empleats;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEmpleats(ArrayList<Empleat> empleats) {
        this.empleats = empleats;
    }

    public void addEmpleat(Empleat empleat){
        this.empleats.add(empleat);
    }

    @Override
    public String toString() {
        return "Departament [nom=" + this.nom + ", empleats=" + this.empleats + "]";
    }

    /* @Override
    public Iterator<Empleat> iterator() {
        return this.empleats.iterator();
    } */

    @Override
    public Iterator<Empleat> iterator() {
        return new DepartamentIterador();
    }

    protected class DepartamentIterador implements Iterator<Empleat> {
        int posicio = 0; 

        @Override
        public boolean hasNext() {
            return posicio < empleats.size();
        }

        @Override
        public Empleat next() {
            return empleats.get(posicio++);
        }

    }

}
