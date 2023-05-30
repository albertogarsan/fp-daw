package classes;

import java.util.Date;

public abstract class Animal implements Comparable <Animal> {
    public static final String Objects = null;
    //Atributos
    private String codigo;
    private int qpatas;
    private int edad;
    private Date fechaNacimiento;

    //Constructor
    public Animal(String codigo, int qpatas, int edad, Date fechaNacimiento) {
        this.codigo = codigo;
        this.qpatas = qpatas;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
    }

    //Mètode abstracte
    public abstract void aniversario();

    public abstract void habla();

    public abstract String toString();

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getQpatas() {
        return qpatas;
    }

    public void setQpatas(int qpatas) {
        this.qpatas = qpatas;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int compareTo(Animal animal1){
        return this.codigo.compareTo(animal1.codigo);
    }
}
