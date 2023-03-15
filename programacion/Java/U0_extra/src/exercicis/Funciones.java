package exercicis;

import java.util.Scanner;

public class Funciones {

    static Scanner sc = new Scanner(System.in);

    public static void cuantasCifras() {

        System.out.print("Inserta un número entre 0 y 9999 para decir cuántas cifras tiene: ");
        int num = sc.nextInt();
        String numero = Integer.toString(num);

        System.out.println("El número tiene: " + numero.length() + " cifras.");

    }

    public static void multiplo() {

        System.out.print("Inserta un número: ");
        int op1 = sc.nextInt();
        System.out.print("Inserta otro número: ");
        int op2 = sc.nextInt();

        if (op1 > op2) {
            if (op1 % op2 == 0) {
                System.out.println(op1 + " es múltiplo de " + op2);
            } else {
                System.out.println(op1 + " no es múltiplo de " + op2);
            }
        } else if (op2 > op1) {
            if (op2 % op1 == 0) {
                System.out.println(op2 + " es múltiplo de " + op1);
            } else {
                System.out.println(op2 + " no es múltiplo de " + op1);
            }
        }
    }

    public static void numPosNeg(){
        //leer un numero e indicar si es positivo o negativo y el proceso se repetirá hasta que se introduzca un cero

        int num = 1;
        while (num != 0){
            System.out.print("Inserta un número y te indicaremos si es positivo o negativo: ");
            num = sc.nextInt();

            if (num > 0){
                System.out.println("El número es positivo");
            } else {
                System.out.println("Número negativo!");
            }

        }

        System.out.println("Hasta pronto!");
    }

    public static void sumador(){

        //pedir numeros hasta que se teclee un 0, mostrar la suma de todos los numeros.

        int num = 1;
        int resultado = 0;

        while (num != 0){
            System.out.print("Inserta un número y te indicaremos si es positivo o negativo: ");
            num = sc.nextInt();
            resultado = resultado + num;
        }

        System.out.println("La suma de todos los números es: " + resultado);
    }

    public static void deCienACerodeSieteEnSiete() {
        //Escribir todos los numero del 100 al 0 de 7 en 7

        for (int i = 100; i >= 0; i = i - 7) {
            System.out.println(i);
        }
    }

    public static void tablasMultiplicar(){
        //Diseña una aplicacion que muestre las tablas de multiplicar del 1 al 10.
        System.out.print("Inserta el número de la tabla que quieras multiplicar: ");
        int num = sc.nextInt();

        for (int i = 1; i <= 10; i++) {
            System.out.println(num + " x " + i + " = " + (num * i));
        }

    }

    public static void tablasMultiplicarV2(){
        System.out.print("Inserta el número de la tabla que quieras multiplicar: ");
        int num = sc.nextInt();
        int[] arrayNumeros = new int[10];

        for (int i = 1; i <= arrayNumeros.length; i++) {
            arrayNumeros[i - 1] = num * i;
        }

        for (int arrayNumero : arrayNumeros) {
            System.out.println(arrayNumero);
        }

    }

    public static void dibujarCuadrado(){
        //Dibuja un cuadrado de n elementos de lado utilizando *
        System.out.print("Inserta el lado del cuadrado: ");
        int lado = sc.nextInt();

        for (int i = 1; i <= lado; i++) {
            for (int j = 1; j <= lado; j++) {
                if (i == 1 || i == lado || j == 1 || j == lado) {
                    System.out.print("*");
                } else {
                    //No és el mateix un emptyString que un espai en blanc. Per això fem un print amb un espai en
                    // blanc per a que per cada iteració ocupe espai per a poder fer el quadrat
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }

    public static void leerCincoNumInversos(){
        //Leer 5 numeros y mostrarlos en orden inverso al introducido.
        int[] arrayNumeros = new int[5];

        //Leer 5 numeros y guardarlos en arrayNumeros
        for (int i = 0; i < arrayNumeros.length; i++) {
            System.out.print("Inserta un número: ");
            arrayNumeros[i] = sc.nextInt();
        }

        //Orden inverso
        for (int i = arrayNumeros.length; i > 0; i--) {
            System.out.println(arrayNumeros[i - 1]);
        }


    }

    public static void mezclarTablas(){
        //leer por teclado dos tablas de 5 numeros enteros y mezclarlas en una tercera de la forma: el primero de A, el
        // primero de B, el segundo de A, el segundo de B...

        int[] tablaA = new int[5];
        int[] tablaB = new int[5];
        int[] tablaC = new int[10];

        for (int i = 0; i < tablaA.length; i++) {
            System.out.print("Inserta un número: ");
            tablaA[i] = sc.nextInt();
        }

        for (int i = 0; i < tablaB.length; i++) {
            System.out.print("Inserta un número: ");
            tablaB[i] = sc.nextInt();
        }

        for (int i = 0; i < 5; i++) {
            tablaC[i * 2] = tablaA[i];
            tablaC[(i * 2) + 1] = tablaB[i];

            /* En este el for deuria de ser < 10
            if (i % 2 == 0) {
                tablaC[i] = tablaA[i / 2];
            } else {
                tablaC[i] = tablaB[(i - 1) / 2];
            }*/
        }


    }

    public static void desplazarTabla(){
        //Crear un programa que lea por teclado una tabla de 5 numeros enteros y la desplace una posición hacia abajo (el
        // ultimo pasa a ser el primero)
        int[] arrayNumeros = new int[5];
        int[] arrayDesplazado = new int[5];

        for (int i = 0; i < arrayNumeros.length; i++) {
            System.out.print("Inserta un número: ");
            arrayNumeros[i] = sc.nextInt();
        }

        for (int j = 0; j < arrayNumeros.length; j++) {
            arrayDesplazado[j] = arrayNumeros[(j+1) % 5];
        }
    }

    public static void tablaBidimensional(){
        //Crear una tabla bidimesional de 5x5 y rellenarla de la siguiente forma: la posicion T[n,m] debe contener n
        // + m.
        // Mostra su contenido.
        int[][] tabla = new int[5][5];

        for (int n = 0; n < tabla.length; n++) {
            for (int m = 0; m < tabla.length; m++) {
                tabla[n][m] = n + m;
                System.out.print(tabla[n][m]);
            }
            System.out.println();
        }


    }

}
