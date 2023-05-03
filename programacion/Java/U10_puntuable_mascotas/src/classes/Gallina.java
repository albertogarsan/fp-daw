package classes;

import java.util.Date;

public class Gallina extends Ave{
    //Atributs
    private boolean ponedora;

    //Construct
    public Gallina(String codigo, int qpatas, int edad, Date fechaNacimiento, boolean pico, boolean vuela,
                   boolean ponedora) {
        super(codigo, qpatas, edad, fechaNacimiento, pico, vuela);
        this.ponedora = ponedora;
    }

    //Metodes abstractes
    public void habla(){
        System.out.println("Coc, Coc");
    }

    public void volar(){
        System.out.println("La gallina salta un metro y medio");
    }

    public void aniversario(){
        this.setEdad(this.getEdad()+1);
        System.out.println("La equivalencia humana en edad sería de " + (this.getEdad() * 8));
    }

    public String toString(){
        return "La gallina con código " + this.getCodigo() + " tiene " + this.getQpatas() + " patas y su edad es de " + getEdad() + " " +
                "nacido en " + getFechaNacimiento() + " y " + this.ponedora + " ponedora.";
    }

}
