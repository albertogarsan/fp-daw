import java.util.ArrayList;
import java.util.Collections;
import classes.*;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList <Departamento> departamentos = new ArrayList<Departamento>();

        Departamento dept1 = new Departamento("Alberto", 1);
        Departamento dept2 = new Departamento("Blai", 3);
        Departamento dept3 = new Departamento("Sebastià", 4);
        Departamento dept4 = new Departamento("Ferran", 2);
        Departamento dept5 = new Departamento("Abdo", 3);

        departamentos.add(dept1);
        departamentos.add(dept2);
        departamentos.add(dept3);
        departamentos.add(dept4);
        departamentos.add(dept5);

        System.out.println("Departamentos sin ordenar");
        for (Departamento departamento : departamentos) {
            System.out.println(departamento);
        }

        Collections.sort(departamentos);
        
        System.out.println("Departamentos ordenados: ");
        for (Departamento departamento : departamentos) {
            System.out.println(departamento);
        }
        
        System.out.println("Departamento 1 es mayor a Departamento 2: " + dept1.esMayor(dept2));
        System.out.println("Departamento 1 es menor a Departamento 2: " + dept1.esMenor(dept2));
        System.out.println("Departamento 1 es igual a Departamento 4: " + dept1.esIgual(dept4));

    }
}
