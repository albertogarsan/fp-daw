import java.util.Scanner;

public class Main {
    public static String[][] canvas;
    public static int[] puntero = new int[2];
    public static int on = 1;

    public static int distancia;
    public static String direccion;

    public static int dimension;

    public static void main(String[] args) {
        // Crear un canvas i preguntar a l'usuari quina és la dimensió.
        // Estarà pintat en "#"
        // Demanar la distància i la direcció a l'usuari de cada traç que vol fer en el canvas.
        // Per a indicar que ha acabat de dibuixar introduirà la X.
        // Buble
        jugar();
    }

    public static void pedirDimension(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduïu la dimensió de la pantalla: ");
        dimension = sc.nextInt();
        canvas = new String[dimension][dimension];

    }

    public static void pedirPuntoInicial(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduïu la punt inicial X e Y separat per una ,: ");
        String valorUsuario = sc.next();

        if (valorUsuario.contains(",")){
            String[] puntoInicial = valorUsuario.split(",");
            int x = Integer.parseInt(puntoInicial[0]);
            int y = Integer.parseInt(puntoInicial[1]);
            puntero[0] = x;
            puntero[1] = y;
            System.out.println(x + " " + y);

        } else {
            System.out.println("Introduce un valor válido");
        }
    }

    public static void pedirDistanciaDireccion(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduïu la distància i la direcció separades per una ,: ");
        String valorUsuario = sc.next();

        if (valorUsuario.equalsIgnoreCase("X")){
            on = 0;
            return;
        }

        if (!valorUsuario.contains(",")){
            System.out.println("Introduce un valor válido");
        }

        String[] distanciaDireccion = valorUsuario.split(",");
        distancia = Integer.parseInt(distanciaDireccion[0]);
        direccion = distanciaDireccion[1];
        System.out.println(distancia + " " + direccion);

    }

    public static void iniciarCanvas(){
        for (int i = 0; i < canvas.length; i++){
            for (int j = 0; j < canvas[i].length; j++){
                canvas[i][j] = "#";
            }
        }
    }

    public static void actualizarCanvas(){
        for (int col = 0; col < dimension; col++){
            for (int fil = 0; fil < dimension; fil++){
                if (puntero[0] == col && puntero[1] == fil){
                    canvas[col][fil] = " ";
                }
                if (direccion.equalsIgnoreCase("v")){
                    if (puntero[1] - fil < distancia && puntero[0] == col){
                        canvas[col][fil] = " ";
                    }
                } else if (direccion.equalsIgnoreCase("h")) {
                    if (puntero[0] - col < distancia && puntero[1] == fil)
                        canvas[col][fil] = " ";
                }
            }
        }

        if (direccion.equalsIgnoreCase("v")){
            puntero[1] += distancia;
        } else if (direccion.equalsIgnoreCase("h")) {
            puntero[0] += distancia;
        }
    }

    public static void imprimirCanvas(){
        for (int i = 0; i < canvas.length; i++){
            for (int j = 0; j < canvas[i].length; j++){
                System.out.print(canvas[i][j]);
            }
            System.out.println();
        }
    }

    public static void jugar(){
        pedirDimension();
        pedirPuntoInicial();
        iniciarCanvas();

        do {
            pedirDistanciaDireccion();
            actualizarCanvas();
            imprimirCanvas();
            System.out.println();
        } while (on == 1);
    }
}