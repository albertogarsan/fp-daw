// EXERCICIS PROPOSTOS II U5 - JAVA
// ALBERTO GARCIA
// PRG - 1ER CURS DAW
// IES JAUME II EL JUST

import java.util.Scanner;

public class E3FrasePalindrome {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingresa una frase o palabra:");
        String frase = teclado.nextLine();

        String fraseInvertida = invertirFrase(frase);
        System.out.println("Frase invertida: " + fraseInvertida);

        if(esPalindrome(frase)) {
            System.out.println("La frase es un palindrome");
        } else {
            System.out.println("La frase no es un palindrome");
        }
    }

    public static String invertirFrase(String frase) {
        // Se inicializa una variable vacía para almacenar la frase invertida
        String fraseInvertida = "";
        // Se recorre la frase caracter por caracter desde el final hasta el principio
        for (int i = frase.length() - 1; i >= 0; i--) {
            // Se concatena cada caracter en la variable fraseInvertida
            fraseInvertida += frase.charAt(i);
        }
        // Se retorna la frase invertida
        return fraseInvertida;
    }

    public static boolean esPalindrome(String frase) {
        // Se eliminan los espacios en blanco de la frase
        String fraseSinEspacios = frase.replaceAll("\\s","");
        // Se convierte la frase a minúsculas
        fraseSinEspacios = fraseSinEspacios.toLowerCase();
        // Se invierte la frase sin espacios
        String fraseInvertida = invertirFrase(fraseSinEspacios);
        // Se comparan la frase original sin espacios y la frase invertida
        return fraseSinEspacios.equals(fraseInvertida);
    }
}


