package classes;

import java.util.Date;

public abstract class Ave extends Animal{
    //Atributos
    private boolean pico;
    private boolean vuela;


    //Constructor
    public Ave(String codigo, int qpatas, int edad, Date fechaNacimiento, boolean pico, boolean vuela) {
        super(codigo, qpatas, edad, fechaNacimiento);
        this.pico = pico;
        this.vuela = vuela;
    }

    //Mètode abstracte
    public abstract void volar();

    //Metodes propis
    public boolean isPico() {
        return pico;
    }

    public boolean isVuela() {
        return vuela;
    }
}
