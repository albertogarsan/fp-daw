import java.util.Scanner;

public class E5IsDigit {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingresa una cadena:");
        String cadena = teclado.nextLine();
        if(isDigit(cadena)) {
            System.out.println("La cadena contiene solo dígitos");
        } else {
            System.out.println("La cadena no contiene solo dígitos");
        }
    }

    public static boolean isDigit(String cadena) {
        for(int i = 0; i < cadena.length(); i++) {
            if(!Character.isDigit(cadena.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}