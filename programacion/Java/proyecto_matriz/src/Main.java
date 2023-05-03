import utils.Leer;
import java.util.Random;


/**
 * @author Alberto Garcia
 * @version 1.0
 */
public class Main {

    // Declaracio variables globals: dimensio M, numero N (usuari), tabla
    public static int dimension;
    public static int numero;
    public static int[][] tabla;

    //objecte lector, importat des de utils
    public static Leer lector = new Leer();

    public static void main(String[] args) {

        // Demanar la dimensio M del tauler i inicialitzar la taula
        dimension = lector.demanarInt("Introduce la dimension de la tabla: ");
        tabla = new int[dimension][dimension];

        while (true) {
            // Demanar el numero N a l'usuari
            numero = lector.demanarInt("Introduce un numero entero: ");

            rellenarTabla();

            imprimirTabla();

            // Espai entre la matriu i els resultats
            System.out.println();
            System.out.println();

            mostrarDivisores();

            //Separador entre iteracions del bucle infinit
            System.out.println("-".repeat(15));

        }

    }

    // Ompli la taula de valors aleatoris menors que dimension
    public static void rellenarTabla() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                // Sumem 1 per a que no siga entre 0 i 29, sino entre 1 i 30
                tabla[i][j] = new Random().nextInt(30) + 1;
            }
        }
    }

    //Imprimix la taula
    public static void imprimirTabla() {
        System.out.println("Matriz generada");
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                System.out.print(tabla[i][j]);
                if (j < dimension - 1) {
                    System.out.print(" | ");
                } else {
                    System.out.println();
                }
            }
            if (i < dimension - 1) {
                System.out.print(" - ".repeat(dimension));
            }
            System.out.println();
        }
    }

    //Mostra els resultats (divisors d'N)
    public static void mostrarDivisores() {
        System.out.println("Divisores de n = " + numero);
        for (int i = 0; i < dimension; i++) {
            System.out.print("Fila " + (i + 1) + ": ");
            for (int j = 0; j < dimension; j++) {
                if (numero % tabla[i][j] == 0) {
                    System.out.print(tabla[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}

/*Implementa un programa en lenguaje Java que cree una matriz de tamaño MxM (valor introducido por teclado) y lo
rellene con números ENTEROS aleatorios entre 1 y 30. También pedirá por teclado un número N y mostrará por pantalla
cuántos valores de cada fila son divisores de N.

El programa se ejecutará repetidamente hasta que se introduzca el valor para M.

- Desde el metodo main se ejecuta el código o llama a una funcion que lo ejecute.
- Por ejemplo, una matriz de 3x3 y N = 50
2 | 10 | 7
-   -    -
1 | 3 | 28
-   -   -
20 | 11 | 18

El programa mostrará por pantalla:

Matriz generada
2 | 10 | 7
-   -    -
1 | 3 | 28
-   -   -
20 | 11 | 18

Divisores de n =50
FILA 1: 2
fILA 2: 1
fILA3: 0

El proyecto se debe ejecutar de manera infinita.
*/
