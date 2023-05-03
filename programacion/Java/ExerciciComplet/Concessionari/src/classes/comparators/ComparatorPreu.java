package classes.comparators;
import classes.Vehicle;
import java.util.Comparator;

public class ComparatorPreu implements Comparator<Vehicle> {
    public int compare(Vehicle vehicle1, Vehicle vehicle2) {
        return Double.compare(vehicle1.getPreu(), vehicle2.getPreu());
    }
}
