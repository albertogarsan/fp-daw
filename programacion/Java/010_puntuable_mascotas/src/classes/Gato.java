package classes;

import java.util.Date;

public class Gato extends Animal implements Mascota{
    //Atributs
    private String nombre;
    private String raza;
    private boolean pelo_largo;

    //Construct
    public Gato(String codigo, int qpatas, int edad, Date fechaNacimiento, String nombre, String raza,
                boolean pelo_largo) {
        super(codigo, qpatas, edad, fechaNacimiento);
        this.nombre = nombre;
        this.raza = raza;
        this.pelo_largo = pelo_largo;
    }

    //Metodes propi
    public void cortarPelo(){
        System.out.println("El pelo se ha cortado");
        this.pelo_largo = false;
    }

    public String toString(){
        return "El gato es " + this.nombre + " con código " + this.getCodigo() + "de raza " + this.raza + " y tiene " +
                this.getQpatas() + " patas y su edad" +
                " es de " + getEdad() + " " +
                "nacido en " + getFechaNacimiento() + " y tiene " + this.pelo_largo + " el pelo largo.";
    }

    //Metodes abstracte
    public void aniversario(){
        this.setEdad(this.getEdad() + 1);
        System.out.println("La equivalencia humana en edad sería de " + (this.getEdad() * 5));
    }

    public void habla(){
        System.out.println("MIAU, MIAU");
    }

    //Metodes interface
    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void jugar(String nombre){
        System.out.println("Rasca la cuerda");
    }
}
