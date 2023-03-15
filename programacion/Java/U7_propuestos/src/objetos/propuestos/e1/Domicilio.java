package objetos.propuestos.e1;

public class Domicilio {

    //Un domicilio: calle, número, piso, puerta, código postal, población y provincia

    //Atributos
    String calle;
    int numero;
    int piso;
    int puerta;
    int codigoPostal;
    String poblacion;
    String provincia;

    //Constructor
    public Domicilio(String calle, int numero, int piso, int puerta, int codigoPostal, String poblacion, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.piso = piso;
        this.puerta = puerta;
        this.codigoPostal = codigoPostal;
        this.poblacion = poblacion;
        this.provincia = provincia;
    }

    //Métodos

}
