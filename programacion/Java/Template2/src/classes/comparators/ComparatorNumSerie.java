package classes.comparators;
import classes.Instrument;
import java.util.Comparator;

public class ComparatorNumSerie implements Comparator<Instrument> {
    public int compare(Instrument instrument1, Instrument instrument2) {
        return instrument1.getNumSerie().compareTo(instrument2.getNumSerie());
    }
}
