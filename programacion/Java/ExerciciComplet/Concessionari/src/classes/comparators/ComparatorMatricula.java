package classes.comparators;
import classes.Vehicle;
import java.util.Comparator;


// compare() = Comparator y Comparable = compareTo()
// Comparator se utiliza para definir un orden personalizado de los objetos de una clase que no tienen un orden natural o para ordenar objetos de una clase en múltiples formas.
public class ComparatorMatricula implements Comparator<Vehicle> {

    //Comparator tiene un único método que es compare que compara dos objetos pasados como parámetros y devuelve un valor entero que indica si el primer objeto es menor, igual o mayor que el segundo objeto según el criterio de comparación definido en el método.
    public int compare(Vehicle vehicle1, Vehicle vehicle2) {
        return vehicle1.getMatricula().compareTo(vehicle2.getMatricula());
    }
}


// compareTo() es un método definido en la interfaz Comparable, que se utiliza para comparar objetos de una clase que SI tienen un ORDEN natural DEFINIDO.

// compare() es un método definido en la interfaz Comparator, que se utiliza para comparar objetos de una clase que NO tienen un ORDEN natural DEFINIDO o para ordenar objetos en múltiples formas.

