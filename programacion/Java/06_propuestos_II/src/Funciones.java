import java.util.Scanner;

public class Funciones {
    static Scanner sc;

    public static void main(String[] args) {
        int op;
        sc = new Scanner(System.in);

        do {
            menu();
            op = sc.nextInt();
            System.out.println("---------------");
            if (op == 1) {
                int[] vector = {1, 2, 3};
                mostrarVectorInt(vector);
                submenu();
                break;
            } else if (op == 2) {
                int[][] matriz = {{9, 2, 4}, {5, 0, 1}, {10, 89, 92}};
                mostrarMatrizInt(matriz);
                submenu();
                break;
            } else if (op == 3) {
                vectorCopia(vectorOrigen, vectorDestino);
                System.out.println("Vector de origen copiado en vector de destino");
                break;
            } else if (op == 7) {
                System.out.println("ADIOS");
                break;
            } else {
                System.out.println("Opción no válida.");
            }
        } while (op != 7);
    }

    static void menu(){
        System.out.println("---------------");
        System.out.println("EJERCICIOS");
        System.out.println("---------------");
        System.out.println("1 - Ejercicio 1");
        System.out.println("2 - Ejercicio 2");
        System.out.println("3 - Ejercicio 3");
        System.out.println("4 - Ejercicio 4");
        System.out.println("5 - Ejercicio 5");
        System.out.println("6 - Ejercicio 6");
        System.out.println("7 - Salir");
        System.out.println("---------------");
        System.out.println("Introduce el número del ejercicio: ");
    }

    static void submenu(){
        System.out.println("---------------");
        System.out.println("Introduce 1 para finalizar programa ");
        System.out.println("Introduce 2 para volver a mostrar el menu: ");
        System.out.print("Introduce 1 o 2: ");
        int op;
        op = sc.nextInt();
        if (op == 2) {
            menu();
        } else if (op == 1) {
            System.out.println("ADIOS");
        }
    }

    static void mostrarVectorInt(int[] vector) {
//      Realiza la función mostrarVectorInt,que imprima un vector de enteros pasado como parámetro. Se deben mostrar
//      los elementos separados por comas y con salto de línea final.

        //System.out.print("El contenido del vector es: ");
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i]);
            //Para que imprima una coma hasta el último elemento del vector
            //La longitud es = 3 pero la posición sería 2
            if (i < vector.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    static void mostrarMatrizInt (int[][] matriz) {
//        Función mostrarMatrizInt,que imprima una matriz de enteros. Debe mostrarse en forma de matriz donde, en cada
//        fila los elementos deben estar separados por comas. Ayúdate de la función del ejercicio 1 mostrarVectorInt.
        for (int i = 0; i < matriz.length; i++) {
            mostrarVectorInt(matriz[i]);
        }
    }

    static int[] vectorOrigen = {1, 2, 3, 4, 5};
    static int[] vectorDestino = new int[vectorOrigen.length];

    static void vectorCopia(int[] vectorOrigen, int[] vectorDestino){
        //Función copiar 2 Vectores. Recibirá 2 vectores como parámetros y debe copiar el primer vector al segundo.
        // Hágalo sin utilizar System.arraycopy. Comprobar que el vector de origen acabe en el vector de destino.
        if (vectorOrigen.length > vectorDestino.length) {
            throw new IllegalArgumentException("Vector de destino es demasiado pequeño para copiar el vector de origen");
        }
        for (int i = 0; i < vectorOrigen.length; i++) {
            vectorDestino[i] = vectorOrigen[i];
        }
    }

    public static int[] vectorCopia(int[] origen) {
        int[] destino = new int[origen.length];
        vectorCopia(origen, destino);
        return destino;
    }
}
