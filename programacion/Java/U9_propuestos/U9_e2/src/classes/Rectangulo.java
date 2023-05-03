package classes;

public class Rectangulo implements Figura2d {
    //Atributos
    private double lado1;
    private double lado2;

    //Constructors
    public Rectangulo() {
        this.lado1 = 1;
        this.lado2 = 2;
    }

    public Rectangulo(double lado1, double lado2) {
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    //Metodes
    //Getter
    public double getLado1() {
        return lado1;
    }

    public double getLado2() {
        return lado2;
    }

    //Setter
    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }

    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }

    //Metodes de la interface
    //Getters
    public double perimetro() {
        return (this.lado1 * 2) + (this.lado2 * 2);
    }

    public double area() {
        return this.lado1 * this.lado2;
    }

    //Setter
    public void escalar(double escala){
        if (escala > 0) {
            this.lado1 = this.lado1 * escala;
            this.lado2 = this.lado2 * escala;
        }
    }

    @Override
    public String toString() {
        return "Rectangulo: " + this.lado1 + " de un lado y del otro lado: " + this.lado2;
    }

}
