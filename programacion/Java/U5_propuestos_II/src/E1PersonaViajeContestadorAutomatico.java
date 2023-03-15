// EXERCICIS PROPOSTOS II U5 - JAVA
// ALBERTO GARCIA
// PRG - 1ER CURS DAW
// IES JAUME II EL JUST

import java.util.Scanner;

public class E1PersonaViajeContestadorAutomatico {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        String nombre;
        String sexo;
        int telefono;
        String ciudad;

        System.out.print("¿Cómo te llamas? ");
        nombre = teclado.next();
        System.out.print("¿Cuál es tu sexo? (h / m) ");
        sexo = teclado.next();
        System.out.print("¿Cuál es tu número de teléfono? ");
        telefono = teclado.nextInt();
        System.out.print("¿De qué ciudad? ");
        ciudad = teclado.next();

        if (sexo.equals("h")){
            System.out.println("Hola! Soy el viajero " + nombre + " Has llamado al " + telefono + " y  ahora no estoy" +
                    " " +
                    "en casa porque estoy en " +  ciudad +  " de vacaciones!!!");
        } else {
            System.out.println("Hola! Soy la viajera " + nombre + " Has llamado al " + telefono + " y  ahora no estoy" +
                    " " +
                    "en casa porque estoy en " +  ciudad +  " de vacaciones!!!");
        }


    }
}

/*Dados los datos de una persona que se va de viaje (nombre, sexo(H/M), teléfono y ciudad a la  que va), crea la
cadena de texto que debería decir su contestador automático: Si el sexo es H la cadena será:
<Hola! Soy el viajero [nombre]. Has llamado al [teléfono]
y  ahora no estoy en casa porque estoy en [ciudad] de vacaciones!!!>
Si el sexo es M la cadena será: <Hola! Soy la viajera [nombre].
Has llamado al [teléfono] y ahora no estoy en casa porque estoy en [ciudad] de vacaciones!!!>*/
