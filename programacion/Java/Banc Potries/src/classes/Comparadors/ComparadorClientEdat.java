package classes.Comparadors;
import classes.Persona;

import java.util.Comparator;

public class ComparadorClientEdat implements Comparator<Persona>{
    public int compare(Persona persona1, Persona persona2) {
        return persona1.getEdad() - persona2.getEdad();
    }
}