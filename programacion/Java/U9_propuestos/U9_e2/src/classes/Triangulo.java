package classes;

public class Triangulo implements Figura2d {
    //Atributos
    private double base;
    private double altura;

    //Constructors
    public Triangulo() {
        this.base = 1;
        this.altura = 2;
    }

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    //Metodes
    //Getter
    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }

    //Setter
    public void setBase(double base) {
        this.base = base;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    //Metodes de la interface
    //Getters
    public double perimetro() {
        double ladoInclinado = Math.sqrt(Math.pow(this.altura, 2) + Math.pow(this.base / 2, 2)); //teorema de pitagores

        return ladoInclinado + ladoInclinado + this.base;
    }

    public double area() {
        return this.altura * this.base / 2;
    }

    //Setter
    public void escalar(double escala){
        if (escala > 0) {
            this.base = this.base * escala;
            this.altura = this.altura * escala;
        }
    }

    @Override
    public String toString() {
        return "Triangulo: " + this.base + " de base. Y " + this.altura + " de altura.";
    }

}
