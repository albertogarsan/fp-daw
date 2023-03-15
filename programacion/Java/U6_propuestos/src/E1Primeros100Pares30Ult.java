public class E1Primeros100Pares30Ult {
    public static void main(String[] args) {
        System.out.println("Ejercicio 1");

        /*Ejercicio 1: Programa que guarde los 100 primeros números pares en un vector. Después mostrará la
        suma de los últimos 30 números guardados.*/

        int[] numeros = new int[100];

        for (int i = 0; i < 100; i++) {
            numeros[i] = (i + 1) * 2;
            //            0 + 1 * 2 = 2
            //            1 + 1 * 2 = 4
            //                ...
            // System.out.println(numeros[i]);
        }

        int suma = 0;
        for (int i = 70; i < 100; i++) {
            //System.out.println(numeros[i]);
            suma = suma + numeros[i];
            //      0   + 142
            //      142 + 144
            //      286 + 146
            //         ...
        }

        System.out.println("La suma de los últimos 30 números guardados es: " + suma);

    }
}