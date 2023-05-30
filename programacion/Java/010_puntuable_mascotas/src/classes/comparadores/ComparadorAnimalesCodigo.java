package classes.comparadores;

import classes.Animal;

import java.util.Comparator;

public class ComparadorAnimalesCodigo implements Comparator<Animal> {
    public int compare(Animal animal1, Animal animal2){
        return animal1.getCodigo().compareTo(animal2.getCodigo());
    }
}