public class Coche {
    //Atributos
    private int numBastidor;
    private String matricula;
    private String marca;
    private String modelo;
    private String color;
    private double precio;
    protected boolean[] revisiones = {false, false, false, false, false};


    //Constructor
    public Coche(int numBastidor, String matricula, String marca, String modelo, String color, double precio) {
        this.numBastidor = numBastidor;
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.precio = precio;
    }

    //Method
    public void aumentarPrecioPorcentaje(int porcentaje) {
        precio = precio * (1 + (porcentaje / 100));
        //precio = precio + precio * porcentaje / 100;
    }

    public void mostrarInfo(){
        System.out.println("Num. bastidor: " + this.numBastidor);
        System.out.println("Num. bastidor: " + this.matricula);
        System.out.println("Marca del coche: " + this.marca);
        System.out.println("Nombre del modelo: " + this.modelo);
        System.out.println("Color del coche: " + this.color);
        System.out.println("Precio del coche: " + this.precio);
    }

    public void revisar(){
        for (int i = 0; i < this.revisiones.length; i++) {
            if (this.revisiones[i] == false) {
                this.revisiones[i] = true;
                break;
            }
        }
    }

    public String getMatricula(){
        return this.matricula;
    }

    @Override //toString mostra l'interior de l'objecte, i no l'espai en memoria al sobreescriure'l
    public String toString() {
        return this.matricula + " - " + this.marca + " " + this.modelo;
    }

}
