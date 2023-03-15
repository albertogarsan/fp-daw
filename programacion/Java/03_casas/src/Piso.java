public class Piso extends Casa {
    //Atributo
    int nBalcones;

    //Constructor
    public Piso(int qPuertas, int qVentanas, String color, int nBalcones) {
        super(qPuertas, qVentanas, color);
        this.nBalcones = nBalcones;
    }

    public Piso(int qPuertas, int qVentanas, String color) {
        super(qPuertas, qVentanas, color);
        this.nBalcones = 0;
    }

    //Métodos
    public void mostrarDatos(){
        System.out.println("El piso tiene " + this.qPuertas + " puertas, " + this.qVentanas + " ventanas y " + this.nBalcones + " balcones");
    }
}
