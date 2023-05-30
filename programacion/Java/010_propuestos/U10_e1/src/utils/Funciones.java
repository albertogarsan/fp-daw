package utils;
import classes.*;
import java.util.Iterator;

public class Funciones {
    static Alumno alumno;
    static Leer lector = new Leer();

    static Iterator<Integer> it;

    public static void menu() throws CustomException {

        int opcion;
        do {
            System.out.println("-".repeat(25));
            System.out.println("| EJERCICIO PROPUESTO U10 e1 |");
            System.out.println("-".repeat(25));
            System.out.println();
            System.out.println("-".repeat(18));
            System.out.println("| Menú principal |");
            System.out.println("-".repeat(18));
            System.out.println("1. Alta alumno ");
            System.out.println("2. Poner nota individual");
            System.out.println("3. Poner notas aleatoriamente");
            System.out.println("4. Mostrar lista de notas de un alumno");
            System.out.println("5. Salir");
            System.out.println();
            opcion = lector.demanarIntOpcio(1, 5);

            switch (opcion) {
                case 1:
                    altaAlumno();
                    break;
                case 2:
                    ponerNotaInd();
                    break;
                case 3:
                    ponerNotasAle();
                    break;
                case 4:
                    mostrarListaNotasAlumno();
                    break;
                case 5:
                    System.out.println("Finalizando programa...");
                    System.out.println();
                    System.out.println("¡¡¡ADIÓS!!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        } while (opcion != 6);
    }

    public static void altaAlumno() {
        alumno = new Alumno();
        System.out.println("Alumne donat d'alta correctament.");
    }

    public static void ponerNotaInd() throws CustomException {

        int nota = lector.demanarInt("Introdueix nota: ");
        int ava = lector.demanarInt("Introdueix l'avalució: ");
        int exerc = lector.demanarInt("Introdueix l'exercici: ");
        try {
            alumno.ponerNota(nota, ava, exerc);
        } catch (CustomException e) {
            System.out.println(e);
        }
    }

    public static void ponerNotasAle() {
        alumno = new Alumno(true);
        System.out.println("Nota afegida correctament.");
    }

    public static void mostrarListaNotasAlumno() {
        /*it = alumno.iterador();
        while (it.hasNext()) {
            int nota = it.next();
            System.out.println(nota);
        }*/

        for (Object n : alumno) {
            System.out.println(n);
        }
    }
}
