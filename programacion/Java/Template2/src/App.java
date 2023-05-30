import utils.*;

public class App {
    static Leer lector = new Leer();
    /*static GestorBD gestor = new GestorBD();*/
    /* static App app = new App(); */

    public static void main(String[] args) throws Exception {
      /*gestor.loadDriver();*/
      GestorBD.loadDriver();
      GestorBD.connect();
      menu();
    }

    public static void menu() {
        int opcio;
        do {
          System.out.println();
          System.out.println();
          System.out.println("-".repeat(40));
          System.out.println("| GESTIÓ TENDA D'INSTRUMENTS MUSICALS |");
          System.out.println("-".repeat(40));
          System.out.println("1. Alta instrument");
          System.out.println("2. Baixa instrument");
          System.out.println("3. Mostrar tots els instruments");
          System.out.println("4. Mostrar un instrument");
          System.out.println("5. Modificar un instrument");
          System.out.println("6. Ordenar un instrument");
          System.out.println("7. Afinar un instrument");
          System.out.println("8. Provar un instrument");
          System.out.println("9. Importar dades d'instruments");
          System.out.println("10. Exportar dades d'instruments");
          System.out.println("11. Mostrar números de sèrie");
          System.out.println("12. Mostrar separats per tipus");
          System.out.println("0. Sortir");
          System.out.println();
          opcio = lector.demanarIntOpcio(0,12,"Escull una opció (0-12): ");
    
          switch (opcio) {
            case 1:
              /* app.alta(); */
              alta();
              break;
            case 2:
              baixa();  
              break;
            case 3:
              mostrarInfoTots(); 
              break;
            case 4:
              mostrarInfoUn();  
              break;
            case 5:
              modificarInfo();  
              break;
            case 6:
              ordenar();  
              break;
            case 7:
              afinar();  
              break;
            case 8:
              provar();  
              break;
            case 9:
              importar();  
              break;
            case 10:
              exportar();  
              break;
            case 11:
              mostrarNumsSerie();  
              break;
            case 12:
              mostrarPerTipus();  
              break;
            case 0:
              System.out.println("Finalitzant programa...");
              System.out.println();
              System.out.println("¡¡¡ADÉU!!!");
              System.exit(0);
              break;
            default:
              System.out.println("Opció no vàlida. Torna a intentar-ho de nou.");
              break;
          } 
        } while (opcio != 0);
    }

    private static void alta(){

        String numSerie = lector.demanarString("Introdueix el Nº de serie de l'instrument: ");

        String nom = lector.demanarString("Introdueix el nom de l'instrument: ");

        Double preu = lector.demanarDouble("Introdueix el preu de l'instrument: ");

        int opcio = lector.demanarIntOpcio(1, 2, "Quin tipus d'instrument és -> (1)Fusta, (2)Metall: ");

        switch(opcio) {
            case 1:
            String tonalitat = lector.demanarString("Introdueix la tonalitat de l'instrument: ");
            String material = lector.demanarString("Introdueix el material: ");
            Funcions.altaInstrumentFusta(numSerie, nom, preu, tonalitat, material);
            break;
            case 2:
            int diametre = lector.demanarInt("Introdueix el diàmetre: ");
            Boolean usat = lector.demanarBooleanSiNo("Introdueix si està usat o no (s/n): ");
            Funcions.altaInstrumentMetall(numSerie, nom, preu, diametre, usat);
            break;
        }
         
         System.out.println("\nInstrument afegit correctament.");
    };

    private static void baixa(){
        mostrarInfoTots();
        int opcio = lector.demanarIntOpcio(1, LlistatInstruments.size(), "Elegeix l'instrument (per índex) a eliminar: ");
        Funcions.baixaInstrument(opcio);
    }

    private static void mostrarInfoTots() {
        Funcions.mostrarInstruments();
    }

    private static void mostrarInfoUn(){
        int opcio = lector.demanarIntOpcio(1, LlistatInstruments.size(), "Elegeix l'instrument (per índex) a mostrar: ");
        Funcions.mostrarIntrument(opcio);
    }

    private static void modificarInfo(){
        mostrarInfoTots();
        int opcio = lector.demanarIntOpcio(1, LlistatInstruments.size(), "Elegeix l'instrument a modificar informació: ");
        String nouNom = lector.demanarString("Modifica el nom: ");
        Double nouPreu = lector.demanarDouble("Modifica el preu: ");
        String nouNumSerie = lector.demanarString("Modifica el Nº de serie: ");
        Funcions.modificarInfo(opcio, nouNom, nouPreu, nouNumSerie);
    }

    private static void ordenar(){
        int opcio = lector.demanarInt("Elegeix 1)Ordena per nom \n 2)Ordena per preu \n 3)Ordena per número de sèrie: ");

        switch (opcio) {
        case 1:
        LlistatInstruments.ordenarPerNom();
        break;
        case 2: 
        LlistatInstruments.ordenarPreu();
        break;
        case 3:
        LlistatInstruments.ordenarNumSerie();
        break;
        } 
    }

    private static void afinar(){
        System.out.println("Quin instrument vols afinar? ");
        mostrarInfoTots();
        int opcio = lector.demanarIntOpcio(1, LlistatInstruments.size(), "Tria un instrument: ");
        String nota = lector.demanarString("Escull quina nota vols afinar: ");
        Funcions.afinarInstrument(opcio, nota);
    }

    private static void provar(){
        System.out.println("Quin instrument vols provar? ");
        mostrarInfoTots();
        int opcio = lector.demanarIntOpcio(1, LlistatInstruments.size(), "Tria un instrument: ");
        Funcions.provarInstrument(opcio);
    }

    private static void importar(){
      String ruta = lector.demanarString("\nIntrodueix la ruta de l'arxiu: ");
      Funcions.importarInstruments(ruta);
    }

    private static void exportar(){
      String ruta = lector.demanarString("\n Introdueix la ruta de l'arxiu: ");
      Funcions.exportarInstruments(ruta);
    }

    private static void mostrarNumsSerie() {
      Funcions.mostrarNumsSerie();
    }

    private static void mostrarPerTipus() {
      System.out.println("Fustes: ");
      GestorBD.mostrarInstrumentsByTipus("FUSTA");
      System.out.println("\n Metall:");
      GestorBD.mostrarInstrumentsByTipus("METALL");
    } 
}