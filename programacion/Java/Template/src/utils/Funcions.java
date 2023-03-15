package utils;

import java.util.ArrayList;
//Aci s'importarà totes les classes que dins tinga creades.
import classes.*;
//import java.util.Scanner;


public class Funcions {
    //Totes les cases que anem donant de alta les anem guardant en l'arraylist (que té dimensió variable que pots
    // anar clavant-li i llevant-li).
    //Li fiquem static per a no instanciar la classe en la que esta continguda eixa peça de dades, per tal de poder
    // gastar-ho globalment dins de l'scope que estiguem.
    static ArrayList<Casa> listadoInmuebles = new ArrayList<>();

    //static Scanner sc = new Scanner(System.in);
    static Leer lector = new Leer();

    public static void menu() {

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
/*

    public static void altaInmueble() {

        System.out.println("¿Qué tipo de inmueble quieres agregar? Teclea 1 para Casa, 2 para Inmueble: ");
        int tipoInmueble = sc.nextInt();

        switch (tipoInmueble) {
            case 1:
                //Aixina seria amb BufferedReader en lloc de per Scanner
                int respuestaId = lector.demanarInt("¿Qué identificador quieres agregar? ");

                //Aixina seria amb Scanner
                System.out.println("¿Cuántas puertas quieres agregar? ");
                int respuestaPuertas = sc.nextInt();


                System.out.println("¿Cuántas ventanas quieres agregar? ");
                int respuestaVentanas = sc.nextInt();
                System.out.println("¿Qué color quieres agregar? ");
                String respuestaColor = sc.next();

                Casa casa = new Casa(respuestaId, respuestaPuertas, respuestaVentanas, respuestaColor);
                listadoInmuebles.add(casa);
                break;
            case 2:
                System.out.println("¿Qué identificador quieres agregar? ");
                int respuestaId2 = sc.nextInt();
                System.out.println("¿Cuántas puertas quieres agregar? ");
                int respuestaPuertas2 = sc.nextInt();
                System.out.println("¿Cuántas ventanas quieres agregar? ");
                int respuestaVentanas2 = sc.nextInt();
                System.out.println("¿Qué color quieres agregar? ");
                String respuestaColor2 = sc.next();
                System.out.println("¿Cuántos metros de jardin quieres agregar? ");
                int respuestaMetroJardin = sc.nextInt();
                System.out.println("¿Cuánto es el precio de mantenimiento que quieres agregar? ");
                double respuestaMantenimiento = sc.nextDouble();
                System.out.println("¿Qué color de valla quieres agregar? ");
                String respuestaColorValla = sc.next();

                //Creem un chalet i ho podem fer perque tenim importades totes les classes.
                Chalet chalet = new Chalet(respuestaId2, respuestaPuertas2, respuestaVentanas2, respuestaColor2,
                        respuestaMetroJardin,
                        respuestaMantenimiento, respuestaColorValla);
                listadoInmuebles.add(chalet);
                break;
            default:
                System.out.println("Valor no válido. Inténtalo de nuevo.");
                break;
        }


    }
    public static void bajaInmueble() {
        System.out.println("¿Qué inmueble quieres eliminar? Introduce su ID: ");
        int idInmueble = sc.nextInt();
        for (Casa inmueble: listadoInmuebles) {
            if (inmueble.id == idInmueble) {
                listadoInmuebles.remove(inmueble);
                System.out.println("Inmueble eliminado correctamente.");
            }
        }
    }
    public static void mostrarInformacion() {
        System.out.println("¿Qué inmueble quieres consultar? Introduce su ID:");
        int idInmueble = sc.nextInt();
        for (Casa inmueble: listadoInmuebles) {
            if (inmueble.id == idInmueble) {
                inmueble.mostrarDatos();
            }
        }
    }
    public static void imprimirInmuebles() {
        for (Casa inmueble : listadoInmuebles) {
            inmueble.mostrarDatos();
            System.out.println("-".repeat(20));
        }
    }
    public static void borradoTotal() {
        int qListadoInmuebles = listadoInmuebles.size();
        listadoInmuebles.clear();
        System.out.println("Se han borrado " + qListadoInmuebles + " inmuebles.");
    }
}
*/
