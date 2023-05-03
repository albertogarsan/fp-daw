package classes;

import java.util.Date;

public class Loro extends Ave implements Mascota{
    //Atributs
    private String nombre;
    private String tipo;
    private boolean habla;

    //Construct

    public Loro(String codigo, int qpatas, int edad, Date fechaNacimiento, boolean pico, boolean vuela, String nombre
            , String tipo, boolean habla) {
        super(codigo, qpatas, edad, fechaNacimiento, pico, vuela);
        this.nombre = nombre;
        this.tipo = tipo;
        this.habla = habla;
    }

    //Metodes propis
    public void saluda(){
        System.out.println("HOLA, HOLA");
    }

    //Metodes abstractes
    public void volar(){
        System.out.println("El loro se ha desplazado 3 metros.");
    }

    public void aniversario(){
        this.setEdad(this.getEdad() + 1);
        System.out.println("La equivalencia humana en edad sería de " + (this.getEdad() * 10));
    }

    public void habla(){
        System.out.println("Siuuuu");
    }

    public String toString(){
        return "El loro es " + this.nombre + " con código " + this.getCodigo() + "de tipo " + this.tipo + " y tiene " +
                this.getQpatas() + " patas y su edad" +
                " es de " + getEdad() + " " +
                "nacido en " + getFechaNacimiento() + " y " + this.habla + " habla, " + this.isPico() + " pico y " + this.isVuela() + " vuela";
    }

    //Medotes interficies
    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void jugar(String nombre) {
        System.out.println("Saluda a quien pase");
    }
}
