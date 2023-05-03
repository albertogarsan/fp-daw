package classes;

import java.util.Date;

public class Perro extends Animal implements Mascota{
    private String nombre;
    private String raza;
    private boolean desparasitado;
    private int num_vacunas;

    // Construct
    public Perro(String codigo, int qpatas, int edad, Date fechaNacimiento, String nombre, String raza,
                 boolean desparasitado, int num_vacunas) {
        super(codigo, qpatas, edad, fechaNacimiento);
        this.nombre = nombre;
        this.raza = raza;
        this.desparasitado = desparasitado;
        this.num_vacunas = num_vacunas;
    }

    //Metodes
    public void aniversario(){
        this.setEdad(this.getEdad() + 1);
        System.out.println("La equivalencia humana en edad sería de " + (this.getEdad() * 7));
    }

    public void habla(){
        System.out.println("GUAU, GUAU");
    }

    public void vacunar(){
        this.num_vacunas += 1;
        this.desparasitado = true;
    }

    public String toString(){
        return "El perro es " + this.nombre + " con código " + this.getCodigo() + "de raza " + this.raza + " y tiene " +
                this.getQpatas() + " patas y su edad" +
                " es de " + getEdad() + " " +
                "nacido en " + getFechaNacimiento() + " y tiene " + this.num_vacunas + " entonces..." + this.desparasitado + " desparasitado.";
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void jugar(String nombre){
        System.out.println("Dame la pata");
        System.out.println("Coge el palo");
    }
}
