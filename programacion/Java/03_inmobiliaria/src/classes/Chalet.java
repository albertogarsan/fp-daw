package classes;

// Final vol dir que de Chalet ja no pots fer subclasses. És com posar un tope a l'herència.
//public final class Chalet

// extends el que fa és referenciar la classe mare.

public class Chalet extends Casa{
    //ATRIBUTOS
    private int metrosJardin;
    private double mantenimiento;
    private String colorValla;

    //CONSTRUTORES
    public Chalet(int id, int qPuertas, int qVentanas, String color, int metrosJardin, double mantenimiento,
                  String colorValla){
        //Super inicializa el atributs de la classe mare que cal passar-lo com a arguments en el constructor com
        // referenciarlos en el cos.
        super(id, qPuertas, qVentanas, color);
        this.metrosJardin = metrosJardin;
        this.mantenimiento = mantenimiento;
        this.colorValla = colorValla;
    }

    public Chalet(){
        //Ací super no du arguments perquè ja els té en el constructor buit mare. Per a que s'inicialitze com
        // l'objecte Casa.
        super();
        this.metrosJardin = 10;
        this.mantenimiento = 0;
        this.colorValla = "fuchsia";
    }

    //METODOS

    //Setter porque estamos cambiando el valor del mantenimiento.
    public void aumentaMantenimiento(){
        this.mantenimiento = this.mantenimiento * 1.02;
    }

    //Ací estem agafant un metode de la classe mare i el que estem fent és sobreescrivint-lo (override).
    @Override
    public void pintar(String nuevoColor) {
        this.colorValla = nuevoColor;
    }

    @Override
    public void mostrarDatos(){
        System.out.println("El chalet tiene " + this.qPuertas + " puertas, " + this.qVentanas + " ventanas y " + this.metrosJardin + " jardin.");
    }
}
