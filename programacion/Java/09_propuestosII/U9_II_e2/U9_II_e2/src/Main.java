import classes.*;
import java.util.ArrayList;
import java.util.Collections;


public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList <Factura> facturas = new ArrayList<Factura>();

        //Crear facturas
        Factura fact1 = new Factura(1, "23/03/2023", 10.0);
        Factura fact2 = new Factura(3, "10/03/2023", 13.5);
        Factura fact3 = new Factura(2, "19/03/2023", 7.2);

        facturas.add(fact1);
        facturas.add(fact2);
        facturas.add(fact3);

        if ((new ComparadorFacturaImporte()).compare(fact1, fact2) < 0) {
            System.out.println("La factura mayor es: " + fact2); 
        } else {
            System.out.println("La factura mayor es: " + fact1);
        }

        System.out.println("Las facturas sin ordenar son: ");
        for (Factura factura : facturas) {
            System.out.println(factura);
        }

        System.out.println("Las facturas ordenadas por importe son: ");
        Collections.sort(facturas, new ComparadorFacturaImporte());
        for (Factura factura : facturas) {
            System.out.println(factura);
        }

        System.out.println("Las facturas ordenadas por fecha son: ");
        Collections.sort(facturas, new ComparadorFacturaFecha());
        for (Factura factura : facturas) {
            System.out.println(factura);
        }

        System.out.println("Las facturas ordenadas por numero son: ");
        Collections.sort(facturas, new ComparadorFacturaNumero());
        for (Factura factura : facturas) {
            System.out.println(factura);
        }
    }
}
