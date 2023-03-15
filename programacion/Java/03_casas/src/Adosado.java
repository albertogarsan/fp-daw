public class Adosado extends Casa {
    //Atributs
    int plazasCochera;
    boolean patio;

    //Constructor
    public Adosado(int qPuertas, int qVentanas, String color, int plazasCochera, boolean patio) {
        super(qPuertas, qVentanas, color);
        this.plazasCochera = plazasCochera;
        this.patio = patio;
    }

    public Adosado(int qPuertas, int qVentanas, String color) {
        super(qPuertas, qVentanas, color);
        this.plazasCochera = 0;
        this.patio = false;
    }

    //Métodos
    @Override
    public void mostrarDatos() {
        String comprobarPatio = "no tiene patio";

        //Si no és True mai s'executarà
        if (patio){
            comprobarPatio = "tiene patio";
        }

        System.out.println("El adosado tiene " + this.qPuertas + " puertas, " + this.qVentanas + " ventanas, " + this.plazasCochera + " plazas de cochera y " + comprobarPatio);
    }
}
