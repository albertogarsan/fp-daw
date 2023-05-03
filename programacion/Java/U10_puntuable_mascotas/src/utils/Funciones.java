package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
//Aci s'importarà totes les classes que dins tinga creades.
import classes.*;
//import java.util.Scanner;


public class Funciones {
    //Totes les cases que anem donant de alta les anem guardant en l'arraylist (que té dimensió variable que pots anar clavant-li i llevant-li).
    //Li fiquem static per a no instanciar la classe en la que esta continguda eixa peça de dades, per tal de poder gastar-ho globalment dins de l'scope que estiguem.
    static ListaAnimales claseListaAnimales = new ListaAnimales();

    //static Scanner sc = new Scanner(System.in);
    static Leer lector = new Leer();

    public static void menu() {
        int opcion;
        do {
            System.out.println("-".repeat(25));
            System.out.println("| PROYECTO MASCOTAS |");
            System.out.println("-".repeat(25));
            System.out.println();
            System.out.println("-".repeat(18));
            System.out.println("| Menú principal |");
            System.out.println("-".repeat(18));
            System.out.println("1. Mostrar la lista de animales ");
            System.out.println("2. Ordenar la lista");
            System.out.println("3. Mostrar datos animal");
            System.out.println("4. Insertar nuevo animal");
            System.out.println("5. Eliminar animal");
            System.out.println("6. Inicializar animales por defecto");
            System.out.println("7. Salir");
            System.out.println();
            opcion = lector.demanarIntOpcio(1, 7);

            switch (opcion) {
                case 1:
                    mostrarListaAnimalesMenu();
                    break;
                case 2:
                    ordenarListaAnimalesMenu();
                    break;
                case 3:
                    mostrarAnimalMenu();
                    break;
                case 4:
                    insertarAnimalMenu();
                    break;
                case 5:
                    eliminarAnimalMenu();
                    break;
                case 6:
                    inicializarAnimalesPorDefecto();
                    break;
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
        } while (opcion != 8);
    }

    public static void mostrarListaAnimalesMenu(){
        /* claseListaAnimales.mostrarListaAnimales(); */
    }

    public static void mostrarListaAnimalesMenu2(){
        for (Animal animal : claseListaAnimales) {
            System.out.println(animal);
        }
    }

    public static void ordenarListaAnimalesMenu(){
        int opcio = lector.demanarIntOpcio(1, 2,"Elige si ordenar la lista de animales por código (1) o por tipo (2)");

        if (opcio == 1) {
            claseListaAnimales.ordenarAnimalesCodigo();
        } else if (opcio == 2) {
            claseListaAnimales.ordenarAnimalesTipo();
        }

        boolean mostrarLista = lector.demanarBooleanSiNo("La lista se ha ordenado, ¿Quieres mostrarla? (S/N): ");
        if (mostrarLista) {
            claseListaAnimales.mostrarListaAnimales();
        } else {
            System.out.println("Vale...");
        }
    }

    public static void mostrarAnimalMenu(){
        //Hem definit la llista d'animals en una arraylist perquè anem a gastar-la dins de la funció
        ArrayList<Animal> listaAnimales = claseListaAnimales.getListaAnimales();
        //Accedim a la claseListaAnimales al mètode de mostrar la llista d'animals perquè l'usuari puga vore la llista i triar un animal
        claseListaAnimales.mostrarListaAnimales();
        // Guardem la tria de l'usuari
        int indice = lector.demanarIntOpcio(1, listaAnimales.size(), "Elige un número para elegir qué animal mostrar:" +
                " ");
        //Obtenim un animal de l'arraylist segons el index de l'usuari
        Animal animal = listaAnimales.get(indice - 1);

        //Mostrem la informació d'eixe animal
        System.out.println(animal);
    }

    public static void insertarAnimalMenu() {
        try {
            claseListaAnimales.anadirAnimal();
        } catch (ErrorRangoEdad e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void eliminarAnimalMenu() {
        claseListaAnimales.eliminarAnimal();
    }

    public static void inicializarAnimalesPorDefecto(){
        Date data1 = new Date();
        Date data2 = new Date();
        Date data3 = new Date();
        Date data4 = new Date();
        Date data5 = new Date();
        try {
            data1 =  new SimpleDateFormat("dd/MM/yyyy").parse("12/10/2020");
            data2 =  new SimpleDateFormat("dd/MM/yyyy").parse("21/05/1900");
            data3 =  new SimpleDateFormat("dd/MM/yyyy").parse("09/12/1235");
            data4 =  new SimpleDateFormat("dd/MM/yyyy").parse("01/01/3000");
            data5 =  new SimpleDateFormat("dd/MM/yyyy").parse("11/04/4023");
        } catch (ParseException e) {
            System.out.println("Error al parsear la fecha.");
            e.printStackTrace();
        }

        Perro perro1 = new Perro("perro1", 4, 2, data1, "Jeremias", "Salchicha", true, 2);
        Gato gato1 = new Gato("gato1", 4,123,data2,"Debussy", "Siamés", true);
        Gallina gallina1 = new Gallina("gallina1",2, 903, data3, true,true,true);
        Loro loro1 = new Loro("loro1", 2, 10002, data4, true,true,"Currupipi", "verde", true);
        Perro perro2 = new Perro("perro2", 3, 2293, data5, "Pelut", "Creuat", true, 192);


        claseListaAnimales.getListaAnimales().add(perro2);
        claseListaAnimales.getListaAnimales().add(perro1);
        claseListaAnimales.getListaAnimales().add(gato1);
        claseListaAnimales.getListaAnimales().add(gallina1);
        claseListaAnimales.getListaAnimales().add(loro1);


        System.out.println("Animales por defecto añadidos.");
    }

}
