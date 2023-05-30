// EXERCICIS PROPOSTOS II U5 - JAVA
// ALBERTO GARCIA
// PRG - 1ER CURS DAW
// IES JAUME II EL JUST

import java.util.Scanner;

public class E2RemplazarVocal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Escribe una frase: ");
        String frase = teclado.nextLine();

        System.out.println("Escribe la vocal a sustituir de la frase: ");
        String vocalSustituir = teclado.next();

        System.out.println("¿Por qué vocal quieres sustituirla?: ");
        String vocalSustituta = teclado.next();

        /*if (vocalSustituir.equals("a")){
            String resultado = frase.replace(vocalSustituir, vocalSustituta);
            System.out.println("Frase modificada: " + resultado);
        } else if(vocalSustituir.equals("e")) {
            String resultado = frase.replace(vocalSustituir, vocalSustituta);
            System.out.println("Frase modificada: " + resultado);
        } else if (vocalSustituir.equals("i")) {
            String resultado = frase.replace(vocalSustituir, vocalSustituta);
            System.out.println("Frase modificada: " + resultado);
        } else if (vocalSustituir.equals("o")) {
            String resultado = frase.replace(vocalSustituir, vocalSustituta);
            System.out.println("Frase modificada: " + resultado);
        } else if (vocalSustituir.equals("u")) {
            String resultado = frase.replace(vocalSustituir, vocalSustituta);
            System.out.println("Frase modificada: " + resultado);
        }*/
        for (int i = 0; i < frase.length(); i++){
            //System.out.println(frase.charAt(i));
            if (frase.charAt(i) == vocalSustituir.charAt(0)){
                String resultado = frase.replace(vocalSustituir, vocalSustituta);
                System.out.println("Frase modificada: " + resultado);
            }
        }

    }
}

/*
Hacer un programa que le pida una frase al usuario y que también pida dos vocales para reemplazar la primera vocal
pedida por la segunda (en caso de estar en la frase).

Realizar dos versiones diferentes:
Una con todas las funciones auxiliares que queramos
Otras donde sólo se puede utilizar el método length()

 Frase: "Hola que tal"
          vocal a substituir: 'a'
          substituir amb: 'e'

         Resultat amb el canvi fet: "Hole que tel"
*/