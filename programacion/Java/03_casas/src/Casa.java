public class Casa {
    //Atributos
    //Privated: solo puede acceder casa.java
    //Protected: pueden acceder todas las clases que están construidas a partir de ella.
    protected int qPuertas;
    protected int qVentanas;
    private String color;

    //Constructor
    public Casa(int qPuertas, int qVentanas, String color){
        this.qPuertas = qPuertas;
        this.qVentanas = qVentanas;
        this.color = color;

        System.out.println("Casa inicializada");
    }


    //Metodos - setters
    public void pintar(String nouColor){
        this.color = nouColor;
    }

    public void abrirVentanas(int qVentanasNuevas){
        this.qVentanas += qVentanasNuevas;
    }

    public void cerrarVentanas(int qVentanasCerradas){
        this.qVentanas -= qVentanasCerradas;
        if (this.qVentanas < 0) {
            this.qVentanas = 0;
        }
    }

    public void mostrarDatos(){
        System.out.println("La casa tiene " + this.qPuertas + " puertas y " + this.qVentanas + " ventanas");
    }

    @Override
    public String toString() {
        return getClass().getName() + "-" + this.color;
    }

    //Metodos - getters (son creados para poder acceder a ellos desde adosados. Pero no hace falta recurrir a ellos.
    // Por eso, en adosados lleva qpuertas() con los parentesis para poder acceder. Pero el kit no es el metodo sino
    // que es public. La manera de no recurrir al metodo es ir a los atributos de casa, en vez de que sean privados
    // hay que ponerlos protected.
    /*public int qPuertas(){
        return this.qPuertas;
    }

    public int qVentanas(){
        return this.qVentanas;
    }*/
}

