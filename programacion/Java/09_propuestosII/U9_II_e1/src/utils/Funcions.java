/* package utils;

import java.util.ArrayList;

import classes.*;

public class Funcions {

    // inicialitzem arraylist per guardar astres
    static ArrayList<Astro> astros = new ArrayList<Astro>();

    // inicialitzem el lector per demanar inputs a l'usuari
    static Leer lector = new Leer();

    // declarem metodes del programa: menu + 6 metodes
    public static void menu() {

        int opcion;

        do {
            System.out.println();

            System.out.println("-".repeat(18));
            System.out.println("| MI SISTEMA SOLAR |");
            System.out.println("-".repeat(18));
            System.out.println("1. Inicializar sistema");
            System.out.println("2. Registrar planetas y satélites");
            System.out.println("3. Mostrar información de un astro");
            System.out.println("4. Mostrar satélites de un planeta");
            System.out.println("5. Eliminar un planeta");
            System.out.println("6. Vaciar el ArrayList");
            System.out.println("7. Salir");
            System.out.println("-".repeat(18));

            opcion = lector.demanarIntOpcio(1, 7, "Opción (1 - 7): ");

            switch (opcion) {
                case 1:
                    inicializarArrayList();
                    break;
                case 2:
                    registrarAstro();
                    break;
                case 3:
                    mostrarInformacion();
                    break;
                case 4:
                    mostrarSatelites();
                    break;
                case 5:
                    eliminarPlaneta();
                    break;
                case 6:
                    vaciarArrayList();
                    break;
                case 7:
                    System.out.println("Finalizando programa...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        } while (opcion != 7);
    }

    public static void inicializarArrayList() {

        // inicialitzem planetes i satellits
        Planeta jupiter = new Planeta("Jupiter", 71492000, 1.899e27, 7.78412e11);
        Planeta mart = new Planeta("Marte", 3389500, 1.899e27, 2.2793664e11);
        Planeta venus = new Planeta("Venus", 6051800, 1.899e27, 1.0820893e11);

        Satelite ganimedes = new Satelite("Ganimedes", 2634100.00, 14819000e16, 1.0704e9, jupiter);
        Satelite calixto = new Satelite("Calixto", 2410300, 10759000e16, 1.8827e9, jupiter);
        Satelite io = new Satelite("Io", 1821600, 8931900e16, 4.218e8, jupiter);
        Satelite europa = new Satelite("Europa", 1560800, 4799800e16, 6.711e8, jupiter);

        Satelite fobos = new Satelite("Fobos", 22200, 1.08e16, 9377000, mart);
        Satelite deimos = new Satelite("Deimos", 6300, 2.0e15, 23460000, mart);

        // afegim els seus satelits a cada planeta
        jupiter.addSatelite(ganimedes);
        jupiter.addSatelite(calixto);
        jupiter.addSatelite(io);
        jupiter.addSatelite(europa);

        mart.addSatelite(fobos);
        mart.addSatelite(deimos);

        // omplim l'arraylist
        astros.add(venus);
        astros.add(mart);
        astros.add(fobos);
        astros.add(deimos);
        astros.add(jupiter);
        astros.add(ganimedes);
        astros.add(calixto);
        astros.add(io);

        System.out.println();
        System.out.println("ArrayList con planetas y satelites inicializado! (3 planetas, 6 satelites)");

    }

    public static void registrarAstro() {
        // demanar si es planeta o satelit
        int opcio = lector.demanarIntOpcio(1, 2, "Que quieres registrar? 1) Planeta, 2) Satelite: ");
        String opcions[] = { "", "planeta", "satelite" };
        String tipo = opcions[opcio];
        String nom = lector.demanarString("Nombre del " + tipo + ": ");
        double radi = lector.demanarDouble("Radio del " + tipo + " (en metros): ");
        double massa = lector.demanarDouble("Masa del " + tipo + " (en kg): ");
        // double distancia_sol;
        // double distancia_planeta;

        switch (opcio) {
            case 1:
                double distancia_sol = lector.demanarDouble("Distancia del planeta al Sol (en metros): ");

                Planeta nuevoPlaneta = new Planeta(nom, radi, massa, distancia_sol);
                astros.add(nuevoPlaneta);

                break;
            case 2:
                double distancia_planeta = lector.demanarDouble("Distancia del satelite al planeta (en metros): ");
                Satelite nuevoSatelite = new Satelite(nom, radi, massa, distancia_planeta);
                astros.add(nuevoSatelite);
                break;

            default:
                System.out.println("Opcion no valida!");
                break;
        }
        System.out.println();
        System.out.println("El " + tipo + " se ha registrado correctamente.");
    }

    public static void mostrarInformacion() {
        System.out.println();
        if (astros.size() == 0) {
            System.out.println("Actualmente no existen astros registrados en el sistema");
        } else {

            System.out.println("De que astro deseas consultar la informacion?");
            int ind = 1;
            for (Astro astro : astros) {
                System.out.println(ind + " - " + astro.getNombre());
                ind++;
            }
            int maximo = astros.size() - 1;
            String texto = "Elige opcion (0 - " + maximo + "): ";
            int opcion = lector.demanarIntOpcio(0, maximo, texto);
            Astro astroSeleccionado = astros.get(opcion -1);
            System.out.println();
            astroSeleccionado.muestraDatos();
        }

    }

    public static void mostrarSatelites() {
        System.out.println();
        // Guardem tots els planetes amb satelits de l'arraylist astros en l'arraylist planetes.
        ArrayList<Planeta> planetas = new ArrayList<Planeta>();
        //Si no posava el clear anava duplicant-se
        planetas.clear();

        //Per cada astro en l'arraylist astros comprovem si és planeta i si té satelits i en cas afirmatiu el guardem
        // en larraylist planetes
        for (Astro astro : astros) {
            if (astro instanceof Planeta && ((Planeta) astro).getNumSatelites() > 0) {
                planetas.add((Planeta) astro);
            }
        }

        if (planetas.size() == 0) {
            System.out.println("Actualmente no hay planetas con satelites en el sistema");
        } else {
            System.out.println("De que planeta deseas consultar sus satelites?");
            int ind = 0;
            for (Planeta planeta : planetas) {
                System.out.println(ind + " - " + planeta.getNombre() + " (" + planeta.getNumSatelites() + " satelites)");
                ind++;
            }
            int maximo = planetas.size() - 1;
            String texto = "Elige opcion (0 - " + maximo + "): ";
            int opcion = lector.demanarIntOpcio(0, maximo, texto);
            Planeta planetaSeleccionado = planetas.get(opcion);
            int ind2 = 0;
            System.out.println();
            System.out.println("Satelites del planeta " + planetaSeleccionado.getNombre());
            for (Satelite satelite : planetaSeleccionado.getSatelites()) {
                System.out.println(ind2 + " -> " + satelite);
                ind2++;
            }
        }

    }

    public static void eliminarPlaneta() {
        System.out.println();
        ArrayList<Planeta> planetas = new ArrayList<Planeta>();
        for (Astro astro : astros) {
            if (astro instanceof Planeta) {
                planetas.add((Planeta) astro);
            }
        }
        int ind = 0;
        for (Planeta planeta : planetas) {
            System.out.println(ind + " - " + planeta.getNombre());
            ind++;
        }

        if (planetas.size() == 0) {
            System.out.println("No hay planetas registrados en el sistema.");
        } else {

            System.out.println("Que planeta deseas eliminar? ");
            int maximo = planetas.size() - 1;
            String texto = "Elige opcion (0 - " + maximo + ") ";
            int opcion = lector.demanarIntOpcio(0, maximo, texto);
            Planeta planetaSeleccionado = planetas.get(opcion);
            astros.remove(planetaSeleccionado);
            System.out.println();
            System.out.println("Planeta " + planetaSeleccionado.getNombre().toUpperCase() + " eliminado correctamente");
        }

    }

    public static void vaciarArrayList() {
        Boolean seguro = lector
                .demanarBooleanSiNo("Seguro que deseas eliminar todos os contenidos del arraylist? (Si/no, s/n): ");
        if (seguro) {
            astros.clear();
            System.out.println();

            System.out.println("Arraylist vaciado correctamente.");
        } else {
            System.out.println();
            System.out.println("Operacion de vaciado del arraylist abortada.");
        }
    }
}
 */