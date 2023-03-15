import utils.Leer;

public class Main {
    public static void main(String[] args) throws Exception {

        //Inicialitzem el nostre objecte lector per a poder utilitzar-lo
        Leer lector = new Leer();

        //EXEMPLES: anem a utilitzar el lector que acabem d'inicialitzar per a demanar i validar diferents tipus d'inputs a l'usuari:

        /*Mètodes de la classe:
         * 1) demanarInt(), demanarInt(missatge)
         * 2) demanarIntOpcio(min,max, missatge)
         * 3) demanarString(), demanarString(missatge)
         * 4) demanarDouble(), demanarDouble(missatge)
         * 5) demanarBoolean()
         * 6) demanarBooleanSiNo(), demanarBooleanSiNo(missatge)
         */

        //EX 1: demanar un nombre enter (mentres no li clavem un enter, ens dirà que hi ha un error i tornarà a demanar-lo fins que l'introduïm bé)

        int inputEnter = lector.demanarInt();
        System.out.println("S'ha introduït correctament un enter: "+ inputEnter);

        System.out.println("-".repeat(20));



        //EX2: demanar igual que abans un nombre enter, però esta vegada abans d'introduir-lo mostra el missatge que li passem com a paràmetre a la funció

        int inputEnterAmbMissatge = lector.demanarInt("Introduïx el teu nombre favorit: ");
        System.out.println("S'ha introduït correctament un enter amb missatge específic: "+ inputEnterAmbMissatge);

        System.out.println("-".repeat(20));



        //EX3: demana un enter, però ha d'estar entre els valors mínim i màxim (inclusius) passats com a paràmetres; l'utilitzarem per als menús normalment. En este cas anem a suposar un menú amb 5 opcions

        int opcioElegida = lector.demanarIntOpcio(1,5);
        System.out.println("S'ha introduït correctament una opció entre 1 i 5: "+ opcioElegida);

        System.out.println("-".repeat(20));



        //EX4: demana una cadena de text a l'usuari, ens dóna error i torna a demanar mentre no clavem una cadena

        String inputString = lector.demanarString();
        System.out.println("S'ha introduït correctament una cadena: "+ inputString);

        System.out.println("-".repeat(20));



        //EX4: demana una cadena de text a l'usuari mostrant un missatge específic que passem com a argument, ens dóna error i torna a demanar mentre no clavem una cadena

        String inputStringAmbMissatge = lector.demanarString("Introduïx el teu color preferit: ");
        System.out.println("S'ha introduït correctament una cadena amb missatge específic: "+ inputStringAmbMissatge);

        System.out.println("-".repeat(20));



        //EX5: demana un nombre double a l'usuari, ens dóna error i torna a demanar mentre no clavem un double

        double inputDouble = lector.demanarDouble();
        System.out.println("S'ha introduït correctament un double: "+ inputDouble);

        System.out.println("-".repeat(20));



        //EX6: demana un nombre double a l'usuari amb missatge espcífic passat com a paràmetre, ens dóna error i torna a demanar mentre no clavem un double

        double inputDoubleAmbMissatge = lector.demanarDouble("Introdueix el preu d'un kg de creïlles: ");
        System.out.println("S'ha introduït correctament un double (preu creïlles): "+ inputDoubleAmbMissatge);

        System.out.println("-".repeat(20));



        //EX7: demana a l'usuari true o false i retorna el boolean corresponent

        boolean inputBoolean = lector.demanarBoolean();
        System.out.println("S'ha introduït correctament un boolean: "+ inputBoolean);

        System.out.println("-".repeat(20));



        //EX8: demana a l'usuari si o no i retorna el boolean corresponent

        boolean inputBooleanSiNo = lector.demanarBooleanSiNo();
        System.out.println("S'ha introduït correctament una opció (sí/no): "+ inputBooleanSiNo);

        System.out.println("-".repeat(20));



        //EX9: demana a l'usuari si o no amb un missatge espcífic i retorna el boolean corresponent

        boolean inputBooleanSiNoAmbMissatge = lector.demanarBooleanSiNo("Estàs d'acord amb les condicions (Si/No, S/N, s/n)? ");
        System.out.println("S'ha introduït correctament una opció (sí/no) amb missatge específic: "+ inputBooleanSiNoAmbMissatge);

        System.out.println("-".repeat(20));
    }
}
