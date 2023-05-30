package classes;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Factura {
    int numFactura;
    Date data;
    double importe;

    //Constructor
    public Factura(int numFactura, String data, double importe){
        this.numFactura = numFactura;
        //La solució a l'error de parsing l'he buscat amb ChatGpt perquè no ho trobava per cap lloc!!!!
        try {
            this.data =  new SimpleDateFormat("dd/MM/yyyy").parse(data);
        } catch (ParseException e) {
            System.out.println("Error al parsear la fecha.");
            e.printStackTrace();
        }
        this.importe = importe;
    }


    //Metodos
    public int numFactura(){
        return this.numFactura;
    }
    public Date data(){
        return this.data;
    }
    public double importe(){
        return this.importe;
    }

    public String toString(){
        return "Factura: " + this.numFactura  + ". Importe: " + this.importe + ". Fecha: " + this.data;
    }
}
