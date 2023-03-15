import java.util.Scanner;

public class E3NotasAlumnos {
    /*Ejercicio 3: Hacer un programa que lea 20 notas de unos alumnos, todas ellas entre 0 y 10.
    A continuación, y en un sólo bucle deberá calcularse:
        La nota más alta
        La nota más baja
        La nota media
    Informar si ha habido algún 10 y/o algún 0
    Posteriormente, como ya sabemos la media, debemos calcular cuántos alumnos tienen una nota inferior a la media
    y cuántos tienen una nota superior.*/

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ejercicio 3");

        //variables
        int notas[] = new int[20];
        int maxima = 10;
        int minima = 0;
        int sumador = 0;
        boolean excelente = false;
        boolean insuficiente = false;
        int mediaInferior = 0;
        int mediaSuperior = 0;

        //Bucle pral
        for (int nota = 0; nota < notas.length; nota++){
            //Añadir la nota de cada alumno por consola
            System.out.print("Ingresa la nota del alumno " + (nota + 1) + ": "); //1,2,3...20
            notas[nota] = teclado.nextInt();
            sumador = sumador + notas[nota];

            //Comprobar que la nota no sea mayor a 10
            while (notas[nota] > maxima) {
                if (notas[nota] > maxima) {
                    System.out.print("Ingresa una nota entre 0 y 10 para el alumno " + (nota + 1) + ": ");
                    notas[nota] = teclado.nextInt();
                }
            }

            //Comprobar la nota máxima
            if (notas[nota] == maxima) {
                maxima = notas[nota];
            }
            //Comprobar la nota mínima
            if (notas[nota] < minima){
                minima = notas[nota];
            }

            //Comprobar si ha habido un 10
            if (notas[nota] == 10){
                excelente = true;
            }

            //Comprobar si ha habido un 0
            if (notas[nota] == 0) {
                insuficiente = true;
            }
        }

        //Sacar la media
        int media = sumador / notas.length;

        //Pintar la máxima nota, la mínima y la media
        System.out.println("La nota más alta es: " + maxima);
        System.out.println("La nota más baja es: " + minima);
        System.out.println("La nota media es: " + media);

        //Comprobar si ha habido un excelento y pintarlo
        if (excelente == true) {
            System.out.println("Hay algun 10");
        }
        //Comprobar si ha habido algun 0 y pintarlo
        if (insuficiente == true) {
            System.out.println("Hay algun 0");
        }

        //Comprobar los alumnos que están por la media inferior y superior
        for (int nota : notas) {
            if (nota < media) {
                mediaInferior++;
            } else if (nota > media) {
                mediaSuperior++;
            }
        }

        //Y pintarlo
        System.out.println("Hay " + mediaInferior + " alumnos con nota inferior a la media.");
        System.out.println("Hay " + mediaSuperior + " alumnos con nota superior a la media.");
    }
}
