package utils;

import java.util.Scanner;

public class Menu {

    public static void menu() {

        Leer lector = new Leer();

        int opcion;
        do {
            System.out.println("-".repeat(25));
            System.out.println("| LA CAZA DEL SUBMARINO |");
            System.out.println("-".repeat(25));
            System.out.println();
            System.out.println("-".repeat(18));
            System.out.println("| Menú principal |");
            System.out.println("-".repeat(18));
            System.out.println("1. Jugar partida ");
            System.out.println("2. Ayuda");
            System.out.println("3. Salir");
            System.out.println();
            opcion = lector.demanarIntOpcio(1, 3);

            switch (opcion) {
                case 1:
                    System.out.println("Opcion 1");
                    break;
                case 2:
                    System.out.println("Opcion 2");
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
}
