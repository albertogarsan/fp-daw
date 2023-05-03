package classes;

public class Cuadrado implements Figura2d {
    //Atributos
    private double lado;

    //Constructors
    public Cuadrado() {
        this.lado = 1;
    }

    public Cuadrado(int lado) {
        this.lado = lado;
    }

    //Metodes
    //Getter
    public int getLado() {
        return this.lado;
    }

    //Setter
    public void setLado(int lado) {
        this.lado = lado;
    }

    //Metodes de la interface
    //Getters
    public double perimetro() {
        return this.lado * 4;
    }

    public double area() {
        return Math.pow(this.lado, 2);
    }

    //Setter
    public void escalar(double escala){
        if (escala > 0) {
            this.lado = this.lado * escala;
        }
    }

    @Override
    public String toString() {
        return "Cuadrado: " + this.lado + " de lado.";
    }
}
