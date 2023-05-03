package utils;

import java.util.ArrayList;

import classes.*;

public class Funcions {

    // inicialitzem arraylist per guardar astres
    static ArrayList<Figura2d> figuras = new ArrayList<Figura2d>();

    // inicialitzem el lector per demanar inputs a l'usuari
    static Leer lector = new Leer();

    // declarem metodes del programa: menu + 6 metodes
    public static void menu() {

        int opcion;

        do {
            System.out.println();

            System.out.println("-".repeat(18));
            System.out.println("| EJERCICIO 2 |");
            System.out.println("-".repeat(18));
            System.out.println("1. Iniciarlizar el array");
            System.out.println("2. Añadir figura");
            System.out.println("3. Mostrar información de todas las figuras");
            System.out.println("4. Escalar todas las figuras");
            System.out.println("5. Mostrar información de una figura");
            System.out.println("6. Mostrar el área de una figura");
            System.out.println("7. Mostrar el perímetro de una figura");
            System.out.println("8. Salir");
            System.out.println("-".repeat(18));

            opcion = lector.demanarIntOpcio(1, 8, "Opción (1 - 8): ");

            switch (opcion) {
                case 1:
                    inicializarArrayList();
                    break;
                case 2:
                    registrarFiguras();
                    break;
                case 3:
                    mostrarInformacionTodas();
                    break;
                case 4:
                    escalarFiguras();
                    break;
                case 5:
                    mostrarInformacion();
                    break;
                case 6:
                    areaFigura();
                    break;
                case 7:
                    perimetroFigura()
                    break;
                case 8:
                    System.out.println("Finalizando programa...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        } while (opcion != 7);
    }

    public static void inicializarArrayList() {

        // inicialitzem figures
        Circulo circulo1 = new Circulo(2);
        Cuadrado cuadrado1 = new Cuadrado(2);
        Rectangulo rectangulo1 = new Rectangulo(2,4);
        Triangulo triangulo1 = new Triangulo(2,3);


        // omplim l'arraylist
        figuras.add(circulo1);
        figuras.add(cuadrado1);
        figuras.add(rectangulo1);
        figuras.add(triangulo1);


        System.out.println();
        System.out.println("Se han añadido 4 figuras en el ArrayList");

    }

    public static void registrarFiguras() {
        // demanar si es circulo, cuadrado, rectangulo o triangulo
        int opcio = lector.demanarIntOpcio(1, 2, "Que quieres registrar? 1) Circulo, 2) Cuadrado, 3) Rectangulo, 4)" +
                "Triangulo:" +
                " ");

        switch (opcio) {
            case 1:
                double radi = lector.demanarDouble("Radi del cercle: ");
                Circulo nuevoCirculo = new Circulo(radi);
                figuras.add(nuevoCirculo);
                System.out.println("S'ha afegit un cercle de radi: " + radi + " a l'ArrayList.");
                break;

            case 2:
                double lado = lector.demanarDouble("Costat del quadrat: ");
                Cuadrado nuevoCuadrado = new Cuadrado(lado);
                figuras.add(nuevoCuadrado);
                System.out.println("S'ha afegit un quadrat de costat: " + lado + " a l'ArrayList.");
                break;

            case 3:
                double lado1 = lector.demanarDouble("Costat 1 del rectangle: ");
                double lado2 = lector.demanarDouble("Costat 2 del rectangle: ");
                Rectangulo nuevoRectangulo = new Rectangulo(lado1, lado2);
                figuras.add(nuevoRectangulo);
                System.out.println("S'ha afegit un rectangle amb el costat 1: " + lado1 + " i costat 2: " + lado2 +
                        " a l'ArrayList.");
                break;

            case 4:
                double base = lector.demanarDouble("Base del triangle: ");
                double altura = lector.demanarDouble("Altura del triangle: ");
                Triangulo nuevoTriangulo = new Triangulo(base, altura);
                figuras.add(nuevoTriangulo);
                System.out.println("S'ha afegit un triangle amb base: " + base + " i altura: " + altura +
                        " a l'ArrayList.");

            default:
                break;
        }

        System.out.println();
        System.out.println("El " + opcio + " s'ha registrat correctament.");
    }

    public static void mostrarInformacionTodas() {
        System.out.println();
        if (figuras.size() == 0) {
            System.out.println("Actualment no existeixen figures registrades en el sistema");
        } else {
            System.out.println("Ací van totes les figures: ");
            for (Figura2d figura : figuras) {
                System.out.println("- " + figura.toString());
            }
        }

    }

    public static void escalarFiguras() {
        System.out.println();
        if (figuras.size() == 0) {
            System.out.println("Actualment no existeixen figures registrades en el sistema");
        } else {
            double escala = lector.demanarDouble("Introdueix l'escala: ")
            System.out.println("Ací van totes les figures escalades: ");
            for (Figura2d figura : figuras) {
                figura.escalar(escala);
            }
        }
    }

    public static void mostrarInformacion() {
        System.out.println();
        if (figuras.size() == 0) {
            System.out.println("Actualment no existeixen figures registrades en el sistema");
        } else {

            System.out.println("De quina figura vols saber informació?");
            int ind = 1;
            for (Figura2d figura : figuras) {
                System.out.println(ind + " - " + figura.toString());
                ind++;
            }

            int maximo = figuras.size();
            String texto = "Eligeix opció (1 - " + maximo + "): ";
            int opcion = lector.demanarIntOpcio(0, maximo, texto);
            Figura2d figuraSeleccionada = figuras.get(opcion -1);
            System.out.println(figuraSeleccionada);
        }

    }

    public static void areaFigura() {
        System.out.println();
        if (figuras.size() == 0) {
            System.out.println("Actualment no existeixen figures registrades en el sistema");
        } else {

            System.out.println("De quina figura vols saber l'àrea?");
            int ind = 1;
            for (Figura2d figura : figuras) {
                System.out.println(ind + " - " + figura.);
                ind++;
            }

            int maximo = figuras.size();
            String texto = "Eligeix opció (1 - " + maximo + "): ";
            int opcion = lector.demanarIntOpcio(0, maximo, texto);
            Figura2d figuraSeleccionada = figuras.get(opcion -1);
            System.out.println("L'àrea de la figura és: " + figuraSeleccionada.area());
        }

    }

    public static void perimetroFigura() {
        System.out.println();
        if (figuras.size() == 0) {
            System.out.println("Actualment no existeixen figures registrades en el sistema");
        } else {

            System.out.println("De quina figura vols saber el perímetre?");
            int ind = 1;
            for (Figura2d figura : figuras) {
                System.out.println(ind + " - " + figura.);
                ind++;
            }

            int maximo = figuras.size();
            String texto = "Eligeix opció (1 - " + maximo + "): ";
            int opcion = lector.demanarIntOpcio(0, maximo, texto);
            Figura2d figuraSeleccionada = figuras.get(opcion -1);
            System.out.println("El perímetre de la figura és: " + figuraSeleccionada.perimetro());
        }

    }

}
