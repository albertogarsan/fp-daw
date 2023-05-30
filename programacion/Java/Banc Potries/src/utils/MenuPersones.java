package utils;

public class MenuPersones {
  
  static Leer lector = new Leer();
  
  public static void menuPersones() {
    int opcio;
    do {
      System.out.println();
      System.out.println();
      System.out.println("-".repeat(18));
      System.out.println("| BANC POPULAR DE POTRIES |");
      System.out.println("-".repeat(18));
      System.out.println("1. Donar d'alta un client");
      System.out.println("2. Donar de baixa un client");
      System.out.println("3. Mostrar informació d'un client");
      System.out.println("4. Modificar informació d'un client");
      System.out.println("5. Mostrar tots els clients");
      System.out.println("6. Ordenar clients");
      System.out.println("0. Sortir");
      System.out.println();
      opcio = lector.demanarIntOpcio(0,6,"Escull una opció (0-6): ");

      switch (opcio) {
        case 1:
          alta();
          break;
        case 2:
          baixa();  
          break;
        case 3:
          mostrarInformacio();  
          break;
        case 4:
          modificarInformacio();  
          break;
        case 5:
            mostrarTots();  
          break;
        case 6:
            ordenar();
          break;
        case 0:
          break;
        default:
          System.out.println("Opció no vàlida. Intenta de nou.");
          break;
      } 
    } while (opcio != 0);
  }

  public static void alta(){
    String nom = lector.demanarString("Introdueix un nom: ");
    int edat = lector.demanarInt("Introdueix una edat: ");
    String direccio = lector.demanarString("Introdueix la direcció: ");
    Funcions.altaPersonaClient(nom, edat, direccio);
  }

  public static void baixa(){
    mostrarTots();
    int index = lector.demanarInt("Tria el client introduint l'index: ");

    Funcions.baixaClient(index);
  }

  public static void mostrarTots(){
    Funcions.mostrarClients();
  }

  public static void mostrarInformacio(){
    Funcions.mostrarClients();
    int opcio = lector.demanarIntOpcio(1,LlistatClients.size(), "Elegeix el client a mostrar: ");

    Funcions.mostrarClient(opcio);

  }

  public static void modificarInformacio(){
    Funcions.mostrarClients();
    
    int opcio = lector.demanarIntOpcio(1,LlistatClients.size(), "Elegeix el client a modificar: ");


    int opcioB = lector.demanarIntOpcio(1, 3, "1) Per a modificar el nom — 2) Per a modificar l'edat - 3) Per a modificar la direcció: ");
    switch (opcioB) {
      case 1:
      String nom = lector.demanarString("Introdueix un nom: ");
      Funcions.modificarClientNom(opcio, nom);
      break;
      case 2:
      int edat = lector.demanarInt("Introdueix l'edat: ");
      Funcions.modificarClientEdat(opcio, edat);
      break;
      case 3:
      String direccio= lector.demanarString("Introdueix una nova direccio: ");
      Funcions.modificarClientDireccio(opcio, direccio);
      break;
    }
  }

  public static void ordenar(){
    int opcio = lector.demanarInt("Elegeix 1)Ordena per nom \n 2)Ordena per edat \n 3)Data d'alta: ");
    switch (opcio) {
      case 1:
      LlistatClients.ordenarPerNom();
      break;
      case 2: 
      LlistatClients.ordenarPerEdat();
      break;
      case 3:
      LlistatClients.ordenarPerDataAlta();
      break;
    } 
  }

  

}