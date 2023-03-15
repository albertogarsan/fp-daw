package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LeerScanner {
    //Scanner per a llegir els inputs
    private Scanner sc;


    public LeerScanner() {
        sc = new Scanner(System.in);
    }

    /**
     * Demana a l'usuari un valor numèric enter i el valida
     *
     * @return nombre enter introduït per l'usuari
     */
    public int demanarInt() {
        int num = 0;
        boolean correcte;
        do {
            correcte = true;
            try {
                System.out.print("Introdueix un nombre enter: ");
                num = sc.nextInt();
            } catch (InputMismatchException ex) {
                // En cas d'error, es marca com a incorrecte
                correcte = false;
                sc.next();
            }

            //En cas d'error, mostrem l'error
            if (!correcte) {
                System.out.println("Error, no has introduït un nombre enter.");
            }

        } while (!correcte);

        return num;

    }

    /**
     * Demana a l'usuari un valor numèric enter amb un missatge específic i el valida
     *
     * @param missatge
     * @return nombre enter introduït per l'usuari
     */
    public int demanarInt(String missatge) {

        int num = 0;
        boolean correcte;
        do {
            correcte = true;
            try {
                System.out.print(missatge);
                num = sc.nextInt();
            } catch (InputMismatchException ex) {
                // En cas d'error, es marca com a incorrecte
                correcte = false;
                sc.next();
            }

            //En cas d'error, mostrem l'error
            if (!correcte) {
                System.out.println("Error, no has introduït un nombre enter.");
            }

        } while (!correcte);

        return num;
    }

    /**
     * Demana a l'usuari un nombre enter que deu estar entre dos nombres que li passem
     *
     * @param minim
     * @param maxim
     * @return nombre enter introduït per l'usuari
     */
    public int demanarIntOpcio(int minim, int maxim) {
        int num;

        //En cas que el mínim siga major, els intercanviem
        if (minim > maxim) {
            int aux = minim;
            minim = maxim;
            maxim = aux;
        }

        do {
            try {
                System.out.print("Introdueix l'opció que desitges. Ha de ser un nombre entre " + minim + " i " + maxim+": ");
                num = sc.nextInt();
            } catch (InputMismatchException ex) {
                // En cas d'error, el num es marca com un valor no vàlid
                num = maxim + 1;
                sc.next();
            }

            if (!(num >= minim && num <= maxim)) {
                System.out.println("Error, no has introduït un nombre entre " + minim + " i " + maxim);
            }

        } while (!(num >= minim && num <= maxim));

        return num;
    }

    /**
     * Demana a l'usuari una cadena
     *
     * @return cadena introduïda per l'usuari
     */
    public String demanarString() {

        System.out.print("Introduïx una cadena: ");
        String cadena = sc.next();

        return cadena;

    }

    /**
     * Demana a l'usuari una cadena amb un missatge espacífic
     *
     * @param missatge
     * @return cadena introduïda per l'usuari
     */
    public String demanarString(String missatge) {

        System.out.print(missatge);
        String cadena = sc.next();

        return cadena;

    }

    /**
     * Demana a l'usuari un double i el valida
     *
     * @return double introduït per l'usuari
     */
    public double demanarDouble() {

        double real = 0;
        boolean correcte;
        do {
            correcte = true;
            try {
                System.out.print("Introduïx un nombre real double: ");
                real = sc.nextDouble();
            } catch (InputMismatchException ex) {
                // En cas d'error, es marca com a incorrecte
                correcte = false;
                sc.next();
            }

            if (!correcte) {
                System.out.println("Error, no has introduït un nombre real double.");
            }

        } while (!correcte);

        return real;

    }

    /**
     * Demana a l'usuari un double con missatge espacífic i el valida
     *
     * @param missatge
     * @return double introduït per l'usuari
     */
    public double demanarDouble(String missatge) {

        double real = 0;
        boolean correcte;
        do {
            correcte = true;
            try {
                System.out.print(missatge);
                real = sc.nextDouble();
            } catch (InputMismatchException ex) {
                // En cas d'error, es marca com a incorrecte
                correcte = false;
                sc.next();
            }

            if (!correcte) {
                System.out.println("Error, no has introduït un nombre real double.");
            }

        } while (!correcte);

        return real;

    }

    /**
     * Demana a l'usuari un boolean i el valida
     *
     * @return boolean introduït per l'usuari
     */
    public boolean demanarBoolean() {

        boolean booleano = false, correcte;
        do {
            correcte = true;
            try {
                System.out.print("Introduïx un boolean (true o false): ");
                booleano = sc.nextBoolean();
            } catch (Exception ex) {
                correcte = false;
                sc.next();
            }
            if (!correcte) {
                System.out.println("Error, no has introduït un valor boolean");
            }

        } while (!correcte);

        return booleano;
    }

    /**
     * Demana a l'usuari un si o un no, valida la resposta i retorna el booleano corresponent
     *
     * @return booleano introduït per l'usuari
     */
    public boolean demanarBooleanSiNo() {

        boolean correcte, booleano = false;
        String resposta = "";
        do {
            correcte = true;
            try {
                System.out.print("Introduïx Si/No (S/N, s/n): ");
                resposta = sc.next();
                resposta = resposta.toLowerCase().trim();
            } catch (Exception ex) {
                correcte = false;
                sc.next();
            }

            if (resposta.equals("si") || resposta.equals("s")) {
                booleano = true;
            } else if (resposta.equals("no") || resposta.equals("n")) {
                booleano = false;
            } else {
                correcte = false;
            }


            if (!correcte) {
                System.out.println("Error, no has introduït Si o No.");
            }

        } while (!correcte);

        return booleano;
    }

    /**
     * Demana a l'usuari un si o un no con missatge espacífic, valida la resposta i retorna el booleano corresponent
     *
     * @param missatge
     * @return boolean introduït per l'usuari
     */
    public boolean demanarBooleanSiNo(String missatge) {

        boolean correcte, booleano = false;
        String resposta = "";
        do {
            correcte = true;
            try {
                System.out.print(missatge);
                resposta = sc.next();
                resposta = resposta.toLowerCase().trim();
            } catch (Exception ex) {
                correcte = false;
                sc.next();
            }

            if (resposta.equals("si") || resposta.equals("s")) {
                booleano = true;
            } else if (resposta.equals("no") || resposta.equals("n")) {
                booleano = false;
            } else {
                correcte = false;
            }


            if (!correcte) {
                System.out.println("Error, no has introduït Si o No.");
            }

        } while (!correcte);

        return booleano;
    }

}
