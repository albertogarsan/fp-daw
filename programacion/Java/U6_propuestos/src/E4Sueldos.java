import java.util.Scanner;

public class E4Sueldos {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ejercicio 4");

        System.out.print("Ingrese el número de personas: ");
        int personas = teclado.nextInt();
        double[][] sueldos = new double[2][personas];
        int[] contadores = new int[2];

        for (int i = 0; i < personas; i++) {
            System.out.print("Introduce el género (0 varón, 1 mujer) " + (i + 1) + ": ");
            int genero = teclado.nextInt();
            System.out.print("Introduce el sueldo " + (i + 1) + ": ");
            double sueldo = teclado.nextDouble();

            sueldos[genero][contadores[genero]++] = sueldo;
        }

        double[] sueldoMedio = {0, 0};
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < contadores[i]; j++) {
                sueldoMedio[i] += sueldos[i][j];
            }
            sueldoMedio[i] /= contadores[i];
        }

        String[] generos = {"los varones", "las mujeres"};
        for (int i = 0; i < 2; i++) {
            System.out.println("El sueldo medio de " + generos[i] + " es de " + sueldoMedio[i] + ".");
        }

        if (sueldoMedio[0] > sueldoMedio[1]) {
            System.out.println("Existe una brecha salarial entre hombres y mujeres.");
        } else {
            System.out.println("No existe una brecha salarial entre hombres y mujeres.");
        }
    }
}


/*Necesitamos crear un programa para registrar sueldos de hombres y mujeres de una empresa
y detectar si existe brecha salarial entre ambos. El programa pedirá por teclado la información
de N personas distntas (valor también introducido por teclado).

Para cada persona, pedirá su género (0 para varón y 1 para mujer) y su sueldo.
Esta información debe guardarse en una única matriz.
Luego se mostrará por pantalla el sueldo medio de cada género.*/