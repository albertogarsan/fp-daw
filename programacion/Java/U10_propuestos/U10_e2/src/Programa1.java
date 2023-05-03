public class Programa1 {
    public static void main (String [] args) {
        System.out.println("Programa 1.");
        System.out.println("Instrucción 1.");
        try {
            int n = Integer.parseInt("M"); //error forzado
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Instrucción 2.");
    }
}