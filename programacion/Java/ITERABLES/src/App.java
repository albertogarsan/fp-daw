import classes.*;

public class App {
    public static void main(String[] args) throws Exception {
        Departament dept1 = new Departament("Ciencies");
        Empleat professor1 = new Empleat("Josep");
        Empleat professor2 = new Empleat("Abdó");
        Empleat professor3 = new Empleat("Adrià");

        dept1.addEmpleat(professor1);
        dept1.addEmpleat(professor2);
        dept1.addEmpleat(professor3);

        //Iterar sobre un objecte
        for (Empleat empleat : dept1) {
            System.out.println(empleat);
        }

        
    }
}
