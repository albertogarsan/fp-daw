import java.util.Scanner;

public class Main {
    //Variables globals
    public static int dimension;
    public static String tablero;

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("-".repeat(25));
            System.out.println("| LA CAZA DEL SUBMARINO |");
            System.out.println("-".repeat(25));
            System.out.println();
            System.out.println("-".repeat(18));
            System.out.println("| Menú principal |");
            System.out.println("-".repeat(18));
            System.out.println("1. Jugar partida ");
            System.out.println("2. Ayuda");
            System.out.println("3. Salir");
            System.out.println();
            System.out.print("Opción (1, 2 o 3): ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    jugar();
                    break;
                case 2:
                    ayuda();
                    break;
                case 3:
                    System.out.println("Finalizando programa...");
                    System.out.println();
                    System.out.println("¡¡¡ADIÓS!!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        } while (opcion != 3);
    }

    public static int[] iniciarSubmarino() {
        int[] posicion = new int[2];
        //posición random del submarino
        posicion[0] = (int) Math.floor(Math.random() * dimension);
        posicion[1] = (int) Math.floor(Math.random() * dimension);
        // Imprimim les posicions per comprovar
        //System.out.println(posicion[0] + " / " + posicion[1]);

        return posicion;
    }

    /*public static int[] iniciarSubmarino(){
        return FuncionesSubmarino.iniciarSubmarino();
    }*/

    public static int[] posicionCalibrar() {
        // [Posición calibrada] Leer y asignar una posición al radar para intentar localizar el submarino.
        int[] posicion = new int[2];

        // posicion introducida por el usuario: X
        Scanner sc = new Scanner(System.in);
        System.out.print("Posición del eje X: ");
        int posicionX = sc.nextInt();
        posicion[0] = posicionX;

        // posicion introducida por el usuario: Y
        System.out.print("Posición del eje Y: ");
        int posicionY = sc.nextInt();
        posicion[1] = posicionY;
        // Imprimim les posicions per comprovar
        //System.out.println(posicionX + " / " + posicionY);

        return posicion;
    }


    public static String leerSonar(int[] posicionSubmarino, int[] posicionCalibrada) {
        //A partir de la posicion calibrada en el radar y la del submarino determina si se
        //ha localizado el submarino, si se está cerca (alrededor) o lejos (agua) y escribirá los mensajes
        //adecuados.

        //El tipo de la funció és String perquè retorna "PLENO" o "AGUA" o "CERCA"

        if (posicionCalibrada[0] == posicionSubmarino[0] && posicionCalibrada[1] == posicionSubmarino[1]) {
            return "PLENO";
        } else if ((posicionCalibrada[0] - posicionSubmarino[0]) <= 1 && (posicionCalibrada[0] - posicionSubmarino[0]) >= -1 && (posicionCalibrada[1] - posicionSubmarino[1]) <= 1 && (posicionCalibrada[1] - posicionSubmarino[1]) >= -1) {
            return "CERCA";
        } else {
            return "AGUA";
        }
    }


    public static int[] moverSubmarino(int[] posicionActual) {
        int[] nuevaPosicion;

        do {
            nuevaPosicion = iniciarSubmarino();
        } while (nuevaPosicion[0] == posicionActual[0] && nuevaPosicion[1] == posicionActual[1]);

        return nuevaPosicion;
    }

    public static String imprimirTablero(String tipo, int[] posicionSubmarino) {
        //Deixe un espai en blanc per a maquetar el tauler
        String mar = " ";

        //Eix x
        for (int columna = 0; columna < dimension; columna++) {
            mar += (" " + columna);
        }

        for (int columna = 0; columna < dimension; columna++) {
            mar += "\n";
            for (int fila = 0; fila < dimension; fila++) {
                //Eix y
                if (fila == 0) {
                    mar += columna;
                }

                //Posicio del submarino
                if (posicionSubmarino[0] == fila && posicionSubmarino[1] == columna && tipo.equals("PLENO")) {
                    mar += " x";
                } else if (tipo.equals("CERCA") && (fila - posicionSubmarino[0]) <= 1 && (fila - posicionSubmarino[0]) >= -1 && (columna - posicionSubmarino[1]) <= 1 && (columna - posicionSubmarino[1]) >= -1 && !(posicionSubmarino[0] == fila && posicionSubmarino[1] == columna)) {
                    mar += " *";
                } else {
                    mar += " -";
                }
            }
        }
        return mar;
    }

    public static void jugar() {

        // Pedir al usuario la dimensión del mar
        Scanner sc = new Scanner(System.in);
        System.out.print("¿Dimensión del mar virtual? ");
        dimension = sc.nextInt();

        // Pedir al usuario la cantidad de intentos
        System.out.print("Número de intentos: ");
        int intentos = sc.nextInt();

        int[] posicionSubmarino = iniciarSubmarino();

        // Comencem per 1 perquè sinos comença per 0 i ha de ser <= per a que arribe fins al tope d'intentos
        for (int i = 1; i <= intentos; i++) {
            //Intento 1 de 3...
            System.out.println("Intento " + i + " de " + intentos);

            //Ara tot hem de passar-ho per ací.
            int[] posicionCalibrada = posicionCalibrar();
            String lecturaSonar = leerSonar(posicionSubmarino, posicionCalibrada);

            if (lecturaSonar.equals("PLENO")) {
                System.out.println("Submarino localizado.");
                tablero = imprimirTablero("PLENO", posicionSubmarino);
                System.out.println(tablero);
                break;

            } else if (lecturaSonar.equals("CERCA")) {
                System.out.println("Submarino cerca!");
                //System.out.println("Coordenadas del submarino: (" + posicionSubmarino[0] + " / " +
                // posicionSubmarino[1] + " )");
                tablero = imprimirTablero("CERCA", posicionSubmarino);
                System.out.println(tablero);
                posicionSubmarino = moverSubmarino(posicionSubmarino);

            } else if (lecturaSonar.equals("AGUA")) {
                System.out.println("Agua!");
                System.out.println("Coordenadas del submarino:  (" + posicionSubmarino[0] + " , ?)");
            }
        }

        System.out.println("El submarino estaba en la posición: (" + posicionSubmarino[0] + " , " + posicionSubmarino[1] + ")");
        System.out.println();
        System.out.println("Fin de la partida.");
    }
    public static void ayuda() {
        System.out.println();
        System.out.println("Instrucciones de funcionamiento del juego:");
        System.out.println();
        System.out.println("Escoge la opción 1 para iniciar la partida.");
        System.out.println("- Especifica la dimensión del mar.");
        System.out.println("- Especifica el número de intentos.");
        System.out.println();
        System.out.println("Mientras te queden intentos, prueba suerte con tus coordenadas:");
        System.out.println("- Si aciertas, obtendrás un PLENO y ganarás la partida.");
        System.out.println("- Si te acercas, obtendrás un CERCA y el submarino cambiará de posición.");
        System.out.println("- Si no aciertas, obtendrás un AGUA y recibirás una pista sobre la posición del submarino.");
        System.out.println();
        System.out.println("¡¡¡SUERTE!!!");
        System.out.println();
        System.out.println();
    }
}
