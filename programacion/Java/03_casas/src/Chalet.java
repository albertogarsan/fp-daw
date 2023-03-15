import java.util.Scanner;
public class Chalet extends Casa{

    Scanner sc = new Scanner(System.in);
    //Tots els mètodes i atributs de Casa, el Chalet ja els té amb extends.

    //Atributos
    private int mjardin;
    private double mantener = 0;
    private String colorValla;

    //Constructor
    public Chalet(int qPuertas, int qVentanas, String color, int mjardin) {
        //Super és com una funció que fa referència a la classe que heretem amb extend i rebrà els paràmetres propis
        // d'eixa classe
        super(qPuertas, qVentanas, color);
        // Atribut propi de la classe Chalet
        this.mjardin = mjardin;

        System.out.println("Chalet inicializado");
    }

    public Chalet(int qPuertas, int qVentanas, String color, int mjardin, double mantener) {
        //Super és com una funció que fa referència a la classe que heretem amb extend i rebrà els paràmetres propis
        // d'eixa classe
        super(qPuertas, qVentanas, color);
        // Atribut propi de la classe Chalet
        this.mjardin = mjardin;
        this.mantener = mantener;

        System.out.println("Chalet inicializado");
    }

    //Métodos
    public void aumentaMantener(){
        this.mantener = this.mantener * 1.02;
    }

    public void pedirCosteMantenimiento(){
        System.out.print("Introduce el coste de mantenimiento: ");
        this.mantener = sc.nextDouble();
    }

    public void pedirCosteMantenimiento(double mantenimiento){
        this.mantener = mantenimiento;
    }

    @Override
    //Es opcional, és per a ser conscient de que estem sobreescrivint.
    // Cal anar en cura perquè ara no podrem pintar el chalet perquè hem utilitzat el mateix mètode per a pintar la valla.
    public void pintar(String nouColor){
        this.colorValla = nouColor;
    }

    @Override
    public void mostrarDatos(){
        System.out.println("El chalet tiene " + this.qPuertas + " puertas, " + this.qVentanas + " ventanas y " + this.mjardin + " m2 de jardín");
    }

}
