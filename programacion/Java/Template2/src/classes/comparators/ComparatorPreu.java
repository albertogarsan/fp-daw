package classes.comparators;
import classes.Instrument;
import java.util.Comparator;

public class ComparatorPreu implements Comparator<Instrument> {
    public int compare(Instrument instrument1, Instrument instrument2) {
        return Double.compare(instrument1.getPreu(), instrument2.getPreu());
    }
}
