package funcions;

import java.util.ArrayList;
import java.util.Scanner;
import classes.*;
import static utils.Leer.*;

public class Funcions {
    //Totes les cases que anem donant de alta les anem guardant en l'arraylist (que té dimensió variable que pots 
    // anar clavant-li i llevant-li).
    //Li fiquem static per a no instanciar la classe en la que esta continguda eixa peça de dades, per tal de poder
    // gastar-ho globalment dins de l'scope que estiguem.
    static ArrayList<Casa> listadoInmuebles = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    
    public static void menu() {
        Scanner sc = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("-".repeat(25));
            System.out.println("| INMOBILIARIA |");
            System.out.println("-".repeat(25));
            System.out.println();
            System.out.println("-".repeat(18));
            System.out.println("| Menú principal |");
            System.out.println("-".repeat(18));
            System.out.println("1. Alta inmueble ");
            System.out.println("2. Baja inmueble");
            System.out.println("3. Mostrar información");
            System.out.println("4. Imprimir todos los inmuebles");
            System.out.println("5. Borrado total");
            System.out.println("6. Salir");
            System.out.println();
            System.out.print("Opción (1, 2 o 3...): ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    altaInmueble();
                    break;
                case 2:
                    bajaInmueble();

                    /*if (listaCoches.size() > 0) {
                        //Input del usuario
                        String matricula = sc.next();
                        //Mostrar información del vehículo
                        mostrarInfoVehiculo(matricula);
                    }*/
                    break;

                case 3:
                    //Preguntar tipo de vehiculo: primera o segunda mano
                    //Solicitar al usuario la información de un vehículo nuevo
                    mostrarInformacion();
                    break;

                case 4:
                    //Pedir la baja de un vehículo
                    imprimirInmuebles();
                    break;

                case 5:
                    //Mostrar todos los vehículos del arraylist
                    //Borrar total de vehículos del arraylist
                    borradoTotal();
                    break;

                case 6:
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
    public static void altaInmueble() {
        
        System.out.println("¿Qué tipo de inmueble quieres agregar? Teclea 1 para Casa, 2 para Inmueble: ");
        int tipoInmueble = sc.nextInt();

        switch (tipoInmueble) {
            case 1:
                System.out.println("¿Qué identificador quieres agregar? ");
                int respuestaId = sc.nextInt();
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
