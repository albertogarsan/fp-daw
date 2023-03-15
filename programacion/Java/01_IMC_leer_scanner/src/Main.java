/*import java.io.*;*/
import utils.Leer;
import utils.Menu;

public class Main {

    //Función que calcula el IMC
    public static double IMC(double peso, double altura) {
        return peso / (altura * altura);
    }

    //Programa - ReadLine(); lanza la excepción IOException, es necesario la palabra "throws" seguida de Exception.
    public static void main(String[] args) throws Exception {

        //Inicialitzem el nostre objecte lector per a poder utilitzar-lo
        Leer lector = new Leer();

        Menu.menu();

        Boolean op = true;

        while (op){

            String nombre = lector.demanarString("Nombre: ");
            String apellidos = lector.demanarString("Apellidos: ");
            int edad = lector.demanarInt("Edad: ");
            double peso = lector.demanarDouble("Peso (en Kg): ");
            double altura = lector.demanarDouble("Altura (en metros): ");
            int telefono = lector.demanarInt("Telefono: ");

            //Guardar el resultado en la variable imc
            double imc = IMC(peso, altura);

            //Condiciones para establecer los niveles segun el IMC
            String nivel = "";
            if (imc < 18.5) {
                nivel = "bajo";
            } else if (imc < 25) {
                nivel = "normal";
            } else if (imc < 30) {
                nivel = "sobrepeso";
            } else {
                nivel = "obesidad";
            }

            System.out.println(nombre + " " + apellidos + " de " + edad + " de edad, los datos introducidos son " +
                    "correctos.");
            System.out.println("El teléfono de contacto es " + telefono);
            System.out.println("Se ha registrado su altura " + altura + " y su peso " + peso);
            System.out.println("Su IMC es: " + imc +  ". Nivel: " + nivel);
            System.out.println("-".repeat(20));
            op = lector.demanarBooleanSiNo("¿Otro usuario? S/N: ");
            System.out.println("-".repeat(20));
        }
    }
}