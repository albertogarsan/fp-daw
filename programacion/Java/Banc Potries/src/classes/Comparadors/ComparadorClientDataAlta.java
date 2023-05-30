package classes.Comparadors;
import classes.PersonaClient;
import java.util.Comparator;

public class ComparadorClientDataAlta implements Comparator<PersonaClient> {
    public int compare(PersonaClient persona1, PersonaClient persona2) {
        return persona1.getDataAlta().compareTo(persona2.getDataAlta());
    }
}
