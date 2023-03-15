package classes;

public class Casa {
    //ATRIBUTOS
    public int id;
    protected int qPuertas;
    protected int qVentanas;
    protected String color;


    // CONSTRUCTORES
    //Podemos construir tantos constuctores sin repetir el número y o tipos de argumentos.

    //Construtores sin argumentos: es aquel que tiene por defecto valores. Es construir un objeto sin argumentos.
    // Ejemplo: Casa casa = new Casa(); esto por defecto nos diría que tiene 3 puertas, 2 ventanas y el color es blanco.
    public Casa() {
        this.id = 0;
        this.qPuertas = 3;
        this.qVentanas = 2;
        this.color = "Blanca";
    }

    //Construtores general
    public Casa(int id, int qPuertas, int qVentanas, String color) {
        this.id = id;
        this.qPuertas = qPuertas;
        this.qVentanas = qVentanas;
        this.color = color;
    }

    //MÉTODOS

    //Setter: *establint* un nou color. Per això necessita un argument però no sempre és necessari.
    public void pintar(String nuevoColor) {
        this.color = nuevoColor;
    }

    //Setter
    public void construirVentanas(int nuevasVentanas) {
        this.qVentanas += nuevasVentanas;
    }

    //Setter
    public void quitarVentanas(int quitarVentanas) {

        // Comprovar que no puguem llevar més finestres de les que hi ha
        if (this.qVentanas - quitarVentanas >= 0) {
            this.qVentanas -= quitarVentanas;
        } else{
            System.out.println("¡ERROR FATAL! La casa solo tiene " + this.qVentanas + ", añade un número válido.");
        }

        /*if (quitarVentanas <= this.qVentanas) {
            this.qVentanas -= quitarVentanas;
        }*/
    }

    //*Getter(dar)* pero per pantalla
    public void mostrarDatos(){
        System.out.println("La casa tiene " + this.qPuertas + " puertas y " + this.qVentanas + " ventanas.");
    }

}
