import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static ArrayList<Coche> listaCoches = new ArrayList<>(); // Lista creada

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("-".repeat(25));
            System.out.println("| CONCESIONARIO MOD |");
            System.out.println("-".repeat(25));
            System.out.println();
            System.out.println("-".repeat(18));
            System.out.println("| Menú principal |");
            System.out.println("-".repeat(18));
            System.out.println("1. Propuesto ");
            System.out.println("2. Información vehículo");
            System.out.println("3. Alta vehículo");
            System.out.println("4. Baja vehículo");
            System.out.println("5. Imprimir todos los vehículos");
            System.out.println("6. Borrado total");
            System.out.println("7. Salir");
            System.out.println();
            System.out.print("Opción (1, 2 o 3...): ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    propuesto();
                    break;
                case 2:
                    //Mostrar vehículos disponibles
                    mostrarVehiculosDisponibles();

                    if (listaCoches.size() > 0) {
                        //Input del usuario
                        String matricula = sc.next();
                        //Mostrar información del vehículo
                        mostrarInfoVehiculo(matricula);
                    }
                    break;

                case 3:
                    //Preguntar tipo de vehiculo: primera o segunda mano
                    //Solicitar al usuario la información de un vehículo nuevo
                    altaVehiculo();
                    break;

                case 4:
                    //Pedir la baja de un vehículo
                    bajaVehiculo();
                    break;

                case 5:
                    //Mostrar todos los vehículos del arraylist
                    mostrarTodosLosVehiculos();
                    break;

                case 6:
                    //Borrar total de vehículos del arraylist
                    borradoTotal();


                case 7:
                    System.out.println("Finalizando programa...");
                    System.out.println();
                    System.out.println("¡¡¡ADIÓS!!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        } while (opcion != 7);
    }

    public static void propuesto() {
        Coche cocheNou1 = new Coche(74, "6083LZV", "BMW", "Ibiza", "Fucsia", 1 );

        cocheNou1.aumentarPrecioPorcentaje(3);
        cocheNou1.mostrarInfo();

        Coche2mano cocheAntic1 = new Coche2mano(30, "9012HVD", "Mersedes", "Leon", "Lapislatzuli", 500, 1000000, 60);

        cocheAntic1.mostrarInfo();

        Coche cocheNou2 = new Coche(19, "4023WWP", "SKODA", "Toledo", "Negre", 40 );
        Coche2mano cocheAntic2 = new Coche2mano(55, "9222LSD", "Mersedes", "Cordoba", "Blanc", 500, 990000, 120);

        Coche[] arrayCoche = {cocheNou1, cocheNou2, cocheAntic1, cocheAntic2};

        cocheNou1.revisar(); // true false false false false
        cocheNou1.revisar(); // true true false false false
        cocheNou1.revisar(); // true true true false false

        for (Coche coche : arrayCoche) {
            coche.mostrarInfo();
            System.out.println("-".repeat(20));
        }

        for (int i = 0; i < arrayCoche.length; i++) {
            System.out.println(arrayCoche[i]);
        }

        mostrarKm(cocheNou1);
        mostrarKm(cocheAntic1);
    }

    public static void mostrarVehiculosDisponibles() {

        if (listaCoches.size() == 0) {
            System.out.println("No hay coches disponibles por el momento.");
        } else {
            for (Coche coche : listaCoches) {
                System.out.println(coche);
            }
            System.out.println("Introduce la matricula del coche a mostrar: ");


        }
    }

    public static void mostrarInfoVehiculo(String matricula) {
        for (Coche coche : listaCoches) {
            if (coche.getMatricula().equals(matricula)) {
                coche.mostrarInfo();
                break;
            }
        }
    }

    public static void mostrarTodosLosVehiculos() {
        if (listaCoches.size() == 0) {
            System.out.println("No hay coches disponibles por el momento.");
        } else {
            for (Coche coche : listaCoches) {
                coche.mostrarInfo();
                System.out.println();
            }
        }
    }

    public static void altaVehiculo() {
        //Introduce separado por comas(,) ...
        System.out.println("Introduce separado por comas (,) el número de bastidor, matrícula, marca," +
                " modelo, color, precio y si es de segunda mano, introduce también los Km y los años que tiene el " +
                "vehículo: ");
        String respuestaUsuario = sc.next();

        String[] arrayRespuestas = respuestaUsuario.split(",");

        //Fem com un "casting" del array a numero
        int bastidor = Integer.parseInt(arrayRespuestas[0]);
        String matricula = arrayRespuestas[1].trim();
        String marca = arrayRespuestas[2].trim();
        String modelo = arrayRespuestas[3].trim();
        String color = arrayRespuestas[4].trim();
        int precio = Integer.parseInt(arrayRespuestas[5]);

        if (arrayRespuestas.length == 6) {
            Coche nuevoCoche = new Coche(bastidor, matricula, marca, modelo, color, precio);
            listaCoches.add(nuevoCoche);
            System.out.println("Se ha añadido un nuevo vehículo de primera mano.");

        } else if (arrayRespuestas.length == 8) {
            int km = Integer.parseInt(arrayRespuestas[6]);
            int anys = Integer.parseInt(arrayRespuestas[7]);

            Coche2mano nuevoCoche = new Coche2mano(bastidor, matricula, marca, modelo, color, precio, km, anys);
            listaCoches.add(nuevoCoche);
            System.out.println("Se ha añadido un nuevo vehículo de segunda mano.");
        } else {
            System.out.println("Opción no válida. Inténtalo de nuevo.");
            altaVehiculo();
        }
    }

    public static void bajaVehiculo() {
        if (listaCoches.size() == 0) {
            System.out.println("No hay coches disponibles por el momento.");
        } else {
            for (Coche coche : listaCoches) {
                System.out.println(coche);
            }
            System.out.println("Introduce la matricula del coche a eliminar: ");
            String matricula = sc.next();
            int posicion = 0;

            for (int i = 0; i < listaCoches.size(); i++) {
                if (listaCoches.get(i).getMatricula().equals(matricula)) {
                    posicion = i;
                }
            }

            listaCoches.remove(posicion);
            System.out.println("Se ha eliminado el vehículo correctamente.");
        }
    }

    public static void borradoTotal() {

        if (listaCoches.size() == 0) {
            System.out.println("No hay coches disponibles por el momento.");
        } else {
            for (Coche coche : listaCoches) {
                System.out.println(coche);
            }
            System.out.println("¿Estás segur@ de borrar todo? (si/no): ");
            String respuesta = sc.next();

            if (respuesta.equals("si")) {
                listaCoches.clear();
                System.out.println("Se han eliminado todos los vehículos.");
            } else {
                System.out.println("Has elegido: no");
            }
        }
    }

    public static void mostrarKm(Coche coche){
        if (coche instanceof Coche2mano){
            System.out.println("Km recorridos: " + ((Coche2mano) coche).getKm()); //casteem
        } else {
            System.out.println("Coche nuevo con 0 km.");
        }
    }
}