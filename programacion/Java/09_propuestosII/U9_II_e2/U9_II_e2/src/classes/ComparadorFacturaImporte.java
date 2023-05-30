package classes;
import java.util.Comparator;

public class ComparadorFacturaImporte implements Comparator<Factura>{
    public int compare(Factura fact1, Factura fact2){
        return Double.compare(fact1.importe(), fact2.importe());
    } 
}
