package classes;
import java.util.Comparator;

public class ComparadorFacturaNumero implements Comparator<Factura>{
    public int compare(Factura fact1, Factura fact2){
        return fact1.numFactura() - fact2.numFactura();
    }
}