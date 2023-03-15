// EXERCICIS PROPOSTOS U5 - JAVA
// ALBERTO GARCIA
// PRG - 1ER CURS DAW
// IES JAUME II EL JUST

import java.util.Scanner;

public class Main {
    static Scanner teclado;

    public Main() {
    }

    public static void main(String[] args) {
        int op;
        do {
            System.out.println("-----------");
            System.out.println("EJERCICIOS");
            System.out.println("-----------");
            System.out.println("Ver ejercicios -> 1");
            System.out.println("Salir -> 2");
            System.out.print("Introduce una opción: ");
            op = teclado.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Ejercicios disponibles: 1, 2, 3, 4, 5, 6, 7, 8, 9, 12, 15, 17");
                    System.out.print("Introduce el número del ejercicio: ");
                    int opcion = teclado.nextInt();
                    if (opcion == 1) {
                        ejercicio1();
                    } else if (opcion == 2) {
                        ejercicio2();
                    } else if (opcion == 3) {
                        ejercicio3();
                    } else if (opcion == 4) {
                        ejercicio4();
                    } else if (opcion == 5) {
                        ejercicio5();
                    } else if (opcion == 6) {
                        ejercicio6();
                    } else if (opcion == 7) {
                        ejercicio7();
                    } else if (opcion == 8) {
                        ejercicio8();
                    } else if (opcion == 9) {
                        ejercicio9();
                    } else if (opcion == 12) {
                        ejercicio12();
                    } else if (opcion == 15) {
                        ejercicio15();
                    } else if (opcion == 17) {
                        ejercicio17();
                    }
                    break;
                case 2:
                    System.out.println("ADIOS");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while(op != 2);

    }

    static void ejercicio1() {
        System.out.println("Ejercicio-1 - Suma, resta, productorio, potencia y división.");
        System.out.print("¿Introduce un número?: ");
        int x = teclado.nextInt();
        teclado.nextLine();
        System.out.print("¿Introduce otro número?: ");
        int y = teclado.nextInt();
        teclado.nextLine();
        int suma = x + y;
        int resta = x - y;
        int producto = x * y;
        int potencia = x ^ y;
        int división = x / y;
        System.out.println("La Suma es igual a " + suma);
        System.out.println("La Resta es igual a " + resta);
        System.out.println("El Producto es igual a " + producto);
        System.out.println("La Potencia es igual a " + potencia);
        System.out.println("La División es igual a " + división);
    }

    static void ejercicio2() {
        System.out.println("Ejercicio-2 - ¿Qué número más grande, o son iguales?");
        System.out.print("¿Introduce un número?: ");
        int x = teclado.nextInt();
        teclado.nextLine();
        System.out.print("¿Introduce otro número?: ");
        int y = teclado.nextInt();
        teclado.nextLine();
        if (x == y) {
            System.out.println("Son los mismos números.");
        } else if (x > y) {
            System.out.println("" + x + " Es el número más grande.");
        } else {
            System.out.println("" + y + " Es el número más grande.");
        }

    }

    static void ejercicio3() {
        System.out.println("Ejercicio-3 - Precio del producto + IVA al 4%, 10% y 21%");
        int precio = 10;
        double iva1 = (double)precio * 0.04;
        double precio_final1 = (double)precio + iva1;
        double iva2 = (double)precio * 0.1;
        double precio_final2 = (double)precio + iva2;
        double iva3 = (double)precio * 0.21;
        double precio_final3 = (double)precio + iva3;
        System.out.println("El precio de este producto es " + precio);
        System.out.println("El precio con el IVA al 4% es de " + precio_final1);
        System.out.println("El precio con el IVA al 10% es de " + precio_final2);
        System.out.println("El precio con el IVA al 21% es de " + precio_final3);
    }

    static void ejercicio4() {
        System.out.println("Ejercicio-4 - Notas de evaluación.");
        System.out.print("Introduce una puntuación entre 0 y 10: ");
        int nota = teclado.nextInt();
        teclado.nextLine();
        switch (nota) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
                System.out.println("Insuficiente");
                break;
            case 5:
                System.out.println("Suficiente");
                break;
            case 6:
            case 7:
                System.out.println("Bien");
                break;
            case 8:
                System.out.println("Notable");
                break;
            case 9:
                System.out.println("Excelente");
                break;
            case 10:
                System.out.println("M.H");
        }

    }

    static void ejercicio5() {
        System.out.println("Ejercicio-5");

        for(int i = 1; i <= 20; ++i) {
            System.out.println(i);
        }

    }

    static void ejercicio6() {
        System.out.println("Ejercicio-6");

        for(int i = 1; i <= 200; ++i) {
            if (i % 2 == 0) {
                System.out.println(i + 2);
            }
        }

    }

    static void ejercicio7() {
        System.out.println("Ejercicio-7");

        for(int i = 1; i <= 200; ++i) {
            if (i % 2 == 1) {
                System.out.println(i + 1);
            }
        }

    }

    static void ejercicio8() {
        System.out.println("Ejercicio-8 - sumatorio y productorio");
        System.out.print("Introduce un número para sumar y realizar el producto desde 1 hasta el valor introducido: ");
        int num = teclado.nextInt();
        teclado.nextLine();
        int sumatorio = 0;
        int producto = 0;

        for(int i = 1; i < num + 1; ++i) {
            System.out.println(i);
            sumatorio = i + num;
            producto = i * num;
        }

        System.out.println("El sumatorio de " + num + " es " + sumatorio);
        System.out.println("El producto de " + num + " es " + producto);
    }

    static void ejercicio9() {
        System.out.println("Ejercicio 9 - Calcular el factorial");
        int factorial_num = 1;
        System.out.print("Escribe un número positivo: ");
        int user_num = teclado.nextInt();
        teclado.nextLine();
        if (factorial_num != 0) {
            for(int i = 1; i < user_num + 1; ++i) {
                factorial_num *= i;
                System.out.println(factorial_num);
            }
        }

    }

    static void ejercicio12() {
        System.out.println("Ejercicio 12 - Programa de números");
        int i = 1;
        int num_positivo = 0;
        int num_negativo = 0;

        while(i != 0) {
            System.out.print("Leyendo número (0 para finalizar): ");
            int num_user = teclado.nextInt();
            i = num_user;
            if (num_user < 0) {
                ++num_negativo;
            } else if (num_user > 0) {
                ++num_positivo;
            } else {
                System.out.println("Analizando números...");
                if (num_negativo >= 1) {
                    System.out.println("Si hay algún número negativo.");
                }

                System.out.println("Total de números positivos ingresados: " + num_positivo);
                System.out.println("Total de números negativos ingresados: " + num_negativo);
            }
        }

    }

    static void ejercicio15() {
        for(int i = 100; i <= 200; ++i) {
            System.out.println(i);
        }

    }

    static void ejercicio17() {
        System.out.println("Ejercicio-17 - Adivinar del 1 al 100.");
        int valorAleatorio = (int)Math.floor(Math.random() * -98.0 + 100.0);
        int veces = 5;

        for(int intentos = 1; intentos < veces + 1; ++intentos) {
            System.out.print("Adivina un número entre el 1 y el 100: ");
            int num_user = teclado.nextInt();
            if (num_user == valorAleatorio) {
                System.out.println("¡Felicidades! Lo has adivinado en " + intentos + " intento.");
                break;
            }

            if (num_user < valorAleatorio) {
                if (num_user < 1) {
                    System.out.println("El valor debe de ser entre 1 y 100.");
                } else {
                    System.out.println("El número a adivinar es más alto");
                    System.out.println("Este es tu " + intentos + " intento(s).");
                }
            } else if (num_user > valorAleatorio) {
                if (num_user > 100) {
                    System.out.println("El valor debe de ser entre 1 y 100.");
                } else {
                    System.out.println("El número a adivinar es más bajo");
                    System.out.println("Este es tu " + intentos + " intento(s).");
                }
            } else {
                System.out.println("Introduce un valor valido.");
            }
        }

        System.out.println("Has superado los intentos posibles...");
    }

    static {
        teclado = new Scanner(System.in);
    }
}
