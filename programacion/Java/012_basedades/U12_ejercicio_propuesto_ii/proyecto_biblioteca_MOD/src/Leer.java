import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Leer {

    /*Mètodes de la classe:
     * 1) demanarInt(), demanarInt(missatge)
     * 2) demanarIntOpcio(min,max, missatge)
     * 3) demanarString(), demanarString(missatge)
     * 4) demanarDouble(), demanarDouble(missatge)
     * 5) demanarBoolean()
     * 6) demanarBooleanSiNo(), demanarBooleanSiNo(missatge)
     */

    // Scanner per a llegir els inputs
    private final static BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Demana a l'usuari un valor numèric enter i el valida
     *
     * @return nombre enter introduït per l'usuari
     */
    public static int demanarInt() {
        int num = 0;
        boolean correcte = false;

        while (!correcte) {
            try {
                num = Integer.parseInt(demanarString("Introdueix un nombre enter: "));
                correcte = true;
            } catch (NumberFormatException e) {
                System.out.println("Error, no has introduït un nombre enter.");
            }
        }

        return num;

    }

    /**
     * Demana a l'usuari un valor numèric enter amb un missatge específic i el
     * valida
     *
     * @param missatge
     * @return nombre enter introduït per l'usuari
     */
    public static int demanarInt(String missatge) {

        int num = 0;
        boolean correcte = false;

        while (!correcte) {
            try {
                num = Integer.parseInt(demanarString(missatge));
                correcte = true;
            } catch (NumberFormatException e) {
                System.out.println("Error, no has introduït un nombre enter.");
            }
        }

        return num;
    }

    /**
     * Demana a l'usuari un nombre enter que deu estar entre dos nombres que li
     * passem
     *
     * @param minim
     * @param maxim
     * @return nombre enter introduït per l'usuari
     */
    public static int demanarIntOpcio(int minim, int maxim) {
        int num = -1;
        boolean correcte = false;

        // En cas que el mínim siga major, els intercanviem
        if (minim > maxim) {
            int aux = minim;
            minim = maxim;
            maxim = aux;
        }

        while (!correcte || !(num >= minim && num <= maxim)) {
            try {
                num = Integer.parseInt(demanarString(
                        "Introdueix l'opció que desitges. Ha de ser un nombre entre " + minim + " i " + maxim + ": "));
                correcte = true;
            } catch (NumberFormatException e) {
                System.out.println("Error, no has introduït un nombre enter.");
            }
            if (!(num >= minim && num <= maxim)) {
                System.out.println("Error, no has introduït un nombre entre " + minim + " i " + maxim);
            }

        }

        return num;
    }

    /**
     * Demana a l'usuari un nombre enter que deu estar entre dos nombres que li
     * passem
     *
     * @param minim
     * @param maxim
     * @return nombre enter introduït per l'usuari
     */
    public static int demanarIntOpcio(int minim, int maxim, String missatge) {
        int num = -1;
        boolean correcte = false;

        // En cas que el mínim siga major, els intercanviem
        if (minim > maxim) {
            int aux = minim;
            minim = maxim;
            maxim = aux;
        }

        while (!correcte || !(num >= minim && num <= maxim)) {
            try {
                num = Integer.parseInt(demanarString(missatge));
                correcte = true;
            } catch (NumberFormatException e) {
                System.out.println("Error, no has introduït un nombre enter.");
            }
            if (!(num >= minim && num <= maxim)) {
                System.out.println("Error, no has introduït un nombre entre " + minim + " i " + maxim);
            }

        }

        return num;
    }

    /**
     * Demana a l'usuari una cadena
     *
     * @return cadena introduïda per l'usuari
     */
    public static String demanarString() {

        String cadena = null;

        do {
            try {
                System.out.print("Introduïx una cadena: ");
                cadena = sc.readLine();

            } catch (IOException e) {
                return "";
            }
        } while (cadena == null);

        return cadena;

    }

    /**
     * Demana a l'usuari una cadena amb un missatge espacífic
     *
     * @param missatge
     * @return cadena introduïda per l'usuari
     */
    public static String demanarString(String missatge) {

        String cadena = null;

        do {
            try {
                System.out.print(missatge);
                cadena = sc.readLine();

            } catch (IOException e) {
                return "";
            }
        } while (cadena == null);

        return cadena;

    }

    /**
     * Demana a l'usuari un double i el valida
     *
     * @return double introduït per l'usuari
     */
    public static double demanarDouble() {

        double real = 0.0;
        boolean correcte = false;

        while (!correcte) {
            try {
                real = Double.parseDouble(demanarString("Introduïx un nombre real double: "));
                correcte = true;
            } catch (NumberFormatException e) {
                System.out.println("Error, no has introduït un nombre real double.");
            }
        }

        return real;

    }

    /**
     * Demana a l'usuari un double con missatge espacífic i el valida
     *
     * @param missatge
     * @return double introduït per l'usuari
     */
    public static double demanarDouble(String missatge) {

        double real = 0.0;
        boolean correcte = false;

        while (!correcte) {
            try {
                real = Double.parseDouble(demanarString(missatge));
                correcte = true;
            } catch (NumberFormatException e) {
                System.out.println("Error, no has introduït un nombre real double.");
            }
        }

        return real;

    }

    /**
     * Demana a l'usuari un boolean i el valida
     *
     * @return boolean introduït per l'usuari
     */
    public static boolean demanarBoolean() {

        String auxiliar;
        boolean resposta = false;
        boolean correcte = false;

        while (!correcte) {

            auxiliar = demanarString("Introduïx un boolean (true o false): ");
            auxiliar = auxiliar.toLowerCase().trim();
            correcte = true;

            if (auxiliar.equals("true")) {
                resposta = true;
            } else if (auxiliar.equals("false")) {
                resposta = false;
            } else {
                correcte = false;
            }

            if (!correcte) {
                System.out.println("Error, no has introduït un valor boolean (true o false)");
            }

        }

        return resposta;

    }

    /**
     * Demana a l'usuari un si o un no, valida la resposta i retorna el booleano
     * corresponent
     *
     * @return booleano introduït per l'usuari
     */
    public static boolean demanarBooleanSiNo() {

        String auxiliar;
        boolean resposta = false;
        boolean correcte = false;

        while (!correcte) {

            auxiliar = demanarString("Introduïx Si/No (S/N, s/n): ");
            auxiliar = auxiliar.toLowerCase().trim();
            correcte = true;

            if (auxiliar.equals("si") || auxiliar.equals("s")) {
                resposta = true;
            } else if (auxiliar.equals("no") || auxiliar.equals("n")) {
                resposta = false;
            } else {
                correcte = false;
            }

            if (!correcte) {
                System.out.println("Error, no has introduït Si o No.");
            }
        }
        return resposta;

    }

    /**
     * Demana a l'usuari un si o un no con missatge espacífic, valida la resposta i
     * retorna el booleano corresponent
     *
     * @param missatge
     * @return boolean introduït per l'usuari
     */
    public static boolean demanarBooleanSiNo(String missatge) {

        String auxiliar;
        boolean resposta = false;
        boolean correcte = false;

        while (!correcte) {

            auxiliar = demanarString(missatge);
            auxiliar = auxiliar.toLowerCase().trim();
            correcte = true;

            if (auxiliar.equals("si") || auxiliar.equals("s")) {
                resposta = true;
            } else if (auxiliar.equals("no") || auxiliar.equals("n")) {
                resposta = false;
            } else {
                correcte = false;
            }

            if (!correcte) {
                System.out.println("Error, no has introduït Si o No.");
            }
        }
        return resposta;


    }

}
