package classes.Comparadors;
import classes.Compte;
import java.util.Comparator;

public class ComparadorID implements Comparator<Compte> {
    public int compare(Compte compte1, Compte compte2) {
        return compte1.getId() - compte2.getId();
    }
}