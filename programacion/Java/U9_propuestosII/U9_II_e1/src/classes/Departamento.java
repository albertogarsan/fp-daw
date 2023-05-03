package classes;
import java.lang.Comparable;

public class Departamento implements Comparable <Departamento> {
    //atributos
    private String nombre;
    private int numEmpleados;

    //constructor
    public Departamento(String nombre, int num){
        this.nombre = nombre;
        this.numEmpleados = num;
    }

    //metodos
    public int compareTo(Departamento dept) {
        int resultado = this.numEmpleados - dept.numEmpleados;
        if (resultado == 0) {
            return this.nombre.compareTo(dept.nombre);
        } else {
            return resultado;
        }
    }

    public String toString(){
        return this.nombre + " (" + this.numEmpleados + ")";
    }

    public boolean esMayor(Departamento dept){
        return this.numEmpleados > dept.numEmpleados;
        /* if (this.numEmpleados.compareTo(dept.numEmpleados) > 0){
            return true;
        } else {
            return false;
        }*/
    }

    public boolean esMenor(Departamento dept){
        return this.numEmpleados < dept.numEmpleados;
    }

    public boolean esIgual(Departamento dept){
        return this.numEmpleados == dept.numEmpleados;
    }
}
