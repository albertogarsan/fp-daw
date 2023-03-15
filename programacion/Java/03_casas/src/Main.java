import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("-".repeat(25));
            System.out.println("| PRÀCTICA CASA OBJECTES |");
            System.out.println("-".repeat(25));
            System.out.println();
            System.out.println("-".repeat(18));
            System.out.println("| Menú principal |");
            System.out.println("-".repeat(18));
            System.out.println("1. Parte 1 ");
            System.out.println("2. Parte 2");
            System.out.println("3. Eixir");
            System.out.println();
            System.out.print("Opció (1, 2 o 3): ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    parte1();
                    break;
                case 2:
                    parte2();
                    break;
                case 3:
                    System.out.println("Finalizando programa...");
                    System.out.println();
                    System.out.println("¡¡¡ADIÓS!!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        } while (opcion != 3);

    }

    //Funcions
    public static void parte1() {
        // Instanciar/Crear 8 objetos
        Casa casa1 = new Casa(5, 4, "blanco");
        Casa casa2 = new Casa(6, 6, "negro");
        Chalet chalet1 = new Chalet(4, 39, "negro", 10, 67.5);
        Chalet chalet2 = new Chalet(9, 43, "negro", 7);
        Adosado adosado1 = new Adosado(312, 1029, "negro", 2, true);
        Adosado adosado2 = new Adosado(2, 11, "negro", 0, false);
        Piso piso1 = new Piso(1, 1, "negro", 1);
        Piso piso2 = new Piso(9, 3, "negro");

        //Utilizar todos los métodos
        chalet2.pedirCosteMantenimiento(199.5);
        chalet2.aumentaMantener();
        adosado1.mostrarDatos();
        casa1.pintar("Fucsia");
        piso1.abrirVentanas(1);
        chalet1.cerrarVentanas(39);
        piso2.abrirVentanas(5);
        casa2.pintar("Verde");
        adosado2.mostrarDatos();
    }

    public static void parte2() {
        Scanner sc = new Scanner(System.in);
        int propiedades;

        System.out.println("Quantes propietats tens?");
        propiedades = sc.nextInt();
        Casa[] casas = new Casa[propiedades];

        for (int i = 0; i < propiedades; i++) {
            System.out.println(casas[i]);
            if (casas[i] == null) {
                System.out.println("El elemento está vacío");
            } else {
                casas[i].mostrarDatos();
            }
        }
    }
}