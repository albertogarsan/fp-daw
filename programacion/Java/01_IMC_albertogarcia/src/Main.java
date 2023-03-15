/*import java.io.*;*/
import java.io.BufferedReader;
import java.io.IOException;

public class Main {

    //Función que calcula el IMC
    public static double IMC(double peso, double altura) {
        return peso / (altura * altura);
    }

    //Programa - ReadLine(); lanza la excepción IOException, es necesario la palabra "throws" seguida de Exception.
    public static void main(String[] args) throws Exception {

        //Instanciar la clase definiendo el origen de la entrada de datos
        private final static BufferedReader br =
                new java.io.BufferedReader(new java.io.InputStreamReader(System.in));

        String op = "s";

        while (op.equalsIgnoreCase("s")){
            //Bloque try-catch, para controlar posibles errores
            try {
                //Pedir nombre y capturarlo con el método readLine(); = readLine sirve para leer de teclado y archivos.
                System.out.print("Nombre: ");
                String nombre = br.readLine();

                //Pedir Apellidos
                System.out.print("Apellidos: ");
                String apellidos = br.readLine();

                //Pedir edad
                System.out.print("Edad: ");
                int edad = Integer.parseInt(br.readLine());

                //Pedir peso
                System.out.print("Peso (en Kg): ");
                double peso = Double.parseDouble(br.readLine());

                //Pedir altura
                System.out.print("Altura (en metros): ");
                double altura = Double.parseDouble(br.readLine());

                //Pedir telefono
                System.out.print("Teléfono: ");
                int telefono = Integer.parseInt(br.readLine());

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
                System.out.println("¿Otro usuario? (S/N): ");
                op = br.readLine();
                System.out.println("-".repeat(20));

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}