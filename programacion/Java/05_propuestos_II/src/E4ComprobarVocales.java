import java.util.Scanner;

public class E4ComprobarVocales {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingresa una cadena:");
        String cadena = teclado.nextLine();
        if(contieneTodasVocales(cadena)) {
            System.out.println("La cadena contiene todas las vocales");
        } else {
            System.out.println("La cadena no contiene todas las vocales");
        }
    }

    public static boolean contieneTodasVocales(String cadena) {
        cadena = cadena.toLowerCase(); // convertir a minúsculas
        boolean contieneA = cadena.contains("a");
        boolean contieneE = cadena.contains("e");
        boolean contieneI = cadena.contains("i");
        boolean contieneO = cadena.contains("o");
        boolean contieneU = cadena.contains("u");
        return contieneA && contieneE && contieneI && contieneO && contieneU;
    }
}