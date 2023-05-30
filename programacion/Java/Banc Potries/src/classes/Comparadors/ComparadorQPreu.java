package classes.Comparadors;
import classes.Compte;
import java.util.Comparator;

public class ComparadorQPreu implements Comparator<Compte> {
    public int compare(Compte compte1, Compte compte2) {
        return Double.compare(compte1.getqDiners(), compte2.getqDiners());
    }
}