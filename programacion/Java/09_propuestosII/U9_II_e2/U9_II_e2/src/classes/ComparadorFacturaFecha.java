package classes;
import java.util.Comparator;

public class ComparadorFacturaFecha implements Comparator<Factura>{
    public int compare(Factura fact1, Factura fact2){
        return fact1.data().compareTo(fact2.data());
    }   
}
