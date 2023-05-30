import java.util.Scanner;

public class E2Array10EnterosMenu {
    public static void main(String[] args) {
        /*Crea un programa que cree un array de 10 enteros y luego muestre el siguiente menú con distntas opciones:

            a. Mostrarvalores
            b. Introducirvalor
            c. Salir

         La opción ‘a’ mostrará todos los valores por pantalla. La opción ‘b’ pedirá un valor V y una posición P,
         luego escribirá V en la posición P del array.

         El menú se repetrá indefinidamente hasta que el usuario elija la opción ‘c’ que terminará el programa.
         */

        Scanner teclado = new Scanner(System.in);
        System.out.println("Ejercicio 2");

        int enteros[] = new int[] {1,2,3,4,5,6,7,8,9,10};

        while (true) {
            System.out.println("-".repeat(20));
            System.out.println("Menu: ");
            System.out.println("-".repeat(20));
            System.out.println("a. Mostrar valores");
            System.out.println("b. Introducir valor");
            System.out.println("c. Salir");
            System.out.println("-".repeat(20));
            System.out.print("Elige una opción (a, b, c): ");
            String op = teclado.nextLine();

            if (op.equals("a")) {
                System.out.println("La opción `a` muestra todos los valores por pantalla.");
                for (int entero:enteros){
                    System.out.println(entero);
                }
                System.out.println("No hay más acciones para esta opción seleccionada.");
            } else if (op.equals("b")) {
                System.out.println("La opción `b` pide un valor y una posición para que se añada el valor en la " +
                        "posición pedida dentro del vector de enteros. Recuerda, el vector tiene 10 posiciones de " +
                        "índice 0.");
                //Pedir V
                System.out.print("Añade un valor entero: ");
                int valor = teclado.nextInt(); //2
                //Pedir P
                System.out.print("Añade una posición: ");
                int posicion = teclado.nextInt(); //0

                if (posicion < enteros.length ){
                    enteros[posicion] = valor;
                    System.out.println("Has escrito el valor " + valor + " en la posición " + posicion + " del vector.");
                } else {
                    System.out.println("Has añadido una posición que no existe en el vector.");
                }

            } else if (op.equals("c")) {
                System.out.println("-".repeat(20));
                System.out.println("Adiós");
                System.out.println("-".repeat(20));
                break;
            } else {
                System.out.println("-".repeat(20));
                System.out.println("Opción no válida.");
            }
        }
    }
}
