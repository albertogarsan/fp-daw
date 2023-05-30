package classes.comparadores;
import classes.Animal;
import java.util.Comparator;

public class ComparadorAnimalesTipo implements Comparator<Animal> {
    public int compare(Animal animal1, Animal animal2){
        int resultado = animal1.getClass().getSimpleName().compareTo(animal2.getClass().getSimpleName());
        if (resultado == 0) {
            return animal1.getCodigo().compareTo(animal2.getCodigo());
        }
        return resultado;
    }
}