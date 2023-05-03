package classes;

public class Circulo implements Figura2d {
    //Atributos
    private double radio;

    //Constructors
    public Circulo() {
        this.radio = 1;
    }

    public Circulo(double radio) {
        this.radio = radio;
    }

    //Metodes
    //Getter
    public double getRadio() {
        return radio;
    }

    //Setter
    public void setRadio(double radio) {
        this.radio = radio;
    }

    //Metodes de la interface
    //Getters
    public double perimetro() {
        return 2 * Math.PI * this.radio;
    }

    public double area() {
        return Math.PI * Math.pow(this.radio, 2);
    }

    //Setter
    public void escalar(double escala){
        if (escala > 0) {
            this.radio = this.radio * escala;
        }
    }

    @Override
    public String toString() {
        return "Circulo: " + this.radio + " de radio.";
    }
}
