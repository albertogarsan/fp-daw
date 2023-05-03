package utils;

import java.util.ArrayList;
import classes.*;

public class Funcions {

    // Declarem ArrayList com a static pa k siga accessible des de qualsevol funcio
    public static ArrayList<Producto> misProductos = new ArrayList<Producto>();

    // Inicialitzem el lector per a demanar inputs a l'usuari, no cal importar-lo xk
    // esta en el mateix paquet
    static Leer lector = new Leer();

    public static void menu() {

        int opcion;

        do {
            System.out.println("-".repeat(25));
            System.out.println("| PRODUCTOS PERSONALIZADOS |");
            System.out.println("-".repeat(25));
            System.out.println(" ".repeat(4));
            System.out.println("-".repeat(18));
            System.out.println("| Menú |");
            System.out.println("-".repeat(18));
            System.out.println("1. Alta producto");
            System.out.println("2. Baja producto");
            System.out.println("3. Lista precios con IVA");
            System.out.println("4. Modificar stock");
            System.out.println("5. Salir");
            System.out.println("-".repeat(18));

            opcion = lector.demanarIntOpcio(1, 5, "Opcion (1, 2, 3, 4 o 5): ");

            switch (opcion) {
                case 1:
                    altaProducto();
                    break;
                case 2:
                    bajaProducto();
                    break;
                case 3:
                    listaPrecios();
                    break;
                case 4:
                    modificarStock();
                    break;
                case 5:
                    System.out.println("Finalizando programa...");
                    System.exit(0);
                    break;
                default:
                    // System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        } while (opcion != 5);
    }

    public static void altaProducto(){

        int select = lector.demanarIntOpcio(1, 2, "Que producto quieres dar de alta? 1) Llavero, 2) Boligrafo: ");

        Producto nuevaAlta = new Producto();

        switch (select) {
            case 1:
                nuevaAlta = new Llavero();
                break;
            case 2:
                nuevaAlta = new Boligrafo();
                break;
        }

        misProductos.add(nuevaAlta);

    }

    public static void bajaProducto(){
        System.out.println("Que producto quieres dar de baja?");
        int contador = 0;
        for (Producto producto : misProductos) {
            System.out.println(contador++ + " " + producto);
        }
        int sel = lector.demanarIntOpcio(0, misProductos.size(), "Escoje el producto: ");

        misProductos.remove(sel);
        System.out.println("Producto eliminado");
    }


    public static void listaPrecios(){
        for (Producto producto : misProductos){
            System.out.println(producto);
        }
    }

    public static void modificarStock() {
        System.out.println("De que producto quieres modificar el stock?");
        int contador = 0;
        for (Producto prod : misProductos) {
            System.out.println(contador++ + " " + prod);
        }
        int sel = lector.demanarIntOpcio(0, misProductos.size(), "Escoje el producto: ");

        int opt = lector.demanarIntOpcio(1, 2, "Que  quieres hacer? 1) Aumentar, 2) Disminuir: ");
        int cant = lector.demanarInt("En cuantas unidades?");
        Producto prod = misProductos.get(sel);
        switch (opt) {
            case 1:
                prod.aumentarStock(cant);
                break;
            case 2:
                prod.DisminuirStock(cant);
                break;
        }
    }
}
