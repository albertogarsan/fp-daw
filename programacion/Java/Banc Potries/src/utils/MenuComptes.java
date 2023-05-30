package utils;

import classes.PersonaClient;

public class MenuComptes {
  
  static Leer lector = new Leer();
  
  public static void menuComptes() {
    int opcio;
    do {
      System.out.println();
      System.out.println();
      System.out.println("-".repeat(18));
      System.out.println("| BANC POPULAR DE POTRIES |");
      System.out.println("-".repeat(18));
      System.out.println("1. Crea un compte");
      System.out.println("2. Dóna de baixa un compte");
      System.out.println("3. Mostrar informació");
      System.out.println("4. Modificar informació");
      System.out.println("5. Operar");
      System.out.println("6. Mostrar tots els comptes");
      System.out.println("7. Ordenar comptes");
      System.out.println("8. Inicialitzar comptes");
      System.out.println("9. Mostrar historial d'operacions");
      System.out.println("0. Sortir");
      System.out.println();
      opcio = lector.demanarIntOpcio(0,9,"Escull una opció (0-9): ");

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
          operar();  
          break;
        case 6:
          mostrarTots();  
          break;
        case 7:
          ordenar();  
          break;
        case 8:
          inicialitzar();  
          break;
        case 9:
          historial();  
          break;
        case 0:
          break;
        default:
          System.out.println("Opció no vàlida. Intenta de nou.");
          break;
      } 
    } while (opcio != 0);
  }

  public static void alta() {
    int opcio = lector.demanarIntOpcio(1, 4, "Elegeix el tipus de compte. On 1 és = Compte corrent. 2 = Compte d'estalvis. 3 = Compte d'Inversió. 4 = Compte cripto: ");
    int opcioB = lector.demanarIntOpcio(1, 2, "1) Per a nou titular - 2) Per a titular existent");
    
    String titular;
    PersonaClient client = null;
    
    switch (opcioB) {
      case 1:
        titular = lector.demanarString("Introdueix el nom del titular: ");
        client = new PersonaClient(titular);
      break;
      case 2:
        mostrarTots();
        int index = lector.demanarInt("Selecciona el titular per index: ");
        client = Funcions.getClient(index);
      break;
    }

    Double qDiners = lector.demanarDouble("Ingressa una quantitat de diners: ");

    switch (opcio) {
      case 1:
      Funcions.altaCompteCorrent(client, qDiners);
      System.out.println("Compte correct creat amb éxit!");
      break;
      case 2:
      Funcions.altaCompteEstalvis(client, qDiners);
      System.out.println("Compte d'estalvis creat amb éxit");
      break;
      case 3:
      String tipusMoneda = lector.demanarString("Introdueix el tipus de moneda en què vas a invertir: ");
      Funcions.altaCompteInversio(client, qDiners, tipusMoneda);
      System.out.println("Compte inversio creat amb éxit");
      break;
      case 4:
      String email = lector.demanarString("Introdueix l'email de contacte: ");
      Funcions.altaCompteCripto(client, qDiners, email);
      System.out.println("Compte cripto");
      break;
    }
  }

  public static void baixa() {
    mostrarTots();
    int opcio = lector.demanarIntOpcio(1, LlistatComptes.size(), "Elegeix el compte (per índex) a eliminar: ");
    Funcions.baixaCompte(opcio);
  }

  public static void mostrarTots(){
    Funcions.mostrarComptes();
  }

  public static void mostrarInformacio(){
    mostrarTots();
    int opcio = lector.demanarIntOpcio(1, LlistatComptes.size(), "Elegeix el compte a mostrar: ");
    Funcions.mostrarCompte(opcio);
  }

  public static void modificarInformacio(){
    mostrarTots();
    int opcio = lector.demanarIntOpcio(1, LlistatComptes.size(), "Elegeix el compte a modificar: ");
    String nouTitular = lector.demanarString("Modifica el nom: ");
    Funcions.modificarInformacio(opcio, nouTitular);
  }

  public static void operar(){
    int id = lector.demanarInt("Per a poder operar, introdueix l'ID del compte: ");
    int opcio = lector.demanarInt("Elegeix 1)Ingressar diners \n 2)Retirar diners \n 3)Transferir diners");
    switch (opcio) {
      case 1:
      Double qDiners = lector.demanarDouble("Ingressa una quantitat de diners: ");
      Funcions.ingressar(qDiners, id);
      break;
      case 2:
      Double qDiners2 = lector.demanarDouble("Retira una quantitat de diners: ");
      Funcions.retirar(qDiners2, id);
      break;
      case 3:
      Double qDiners3 = lector.demanarDouble("Transfereix una quantitat de diners: ");
      int idDestinament = lector.demanarInt("Introdueix la ID de destinament: ");
      Funcions.transferir(qDiners3, id, idDestinament);
      break;
    }
  }

  public static void ordenar(){
    int opcio = lector.demanarInt("Elegeix 1)Ordena per titular \n 2)Ordena per ID \n 3)Ordena per diners");
    switch (opcio) {
      case 1:
      LlistatComptes.ordenarTitular();
      break;
      case 2: 
      LlistatComptes.ordenarId();
      break;
      case 3:
      LlistatComptes.ordenarQPreu();
      break;
    } 
  }

  public static void inicialitzar(){
    Funcions.altaCompteCorrent(new PersonaClient("Alberto", 0, null, null), 100.00);
    Funcions.altaCompteCripto(new PersonaClient("Marc"), 290.0, "marc@potries.org");
    Funcions.altaCompteEstalvis(new PersonaClient("Farina"), 890.0);
    Funcions.altaCompteInversio(new PersonaClient("Abdó"), 21.0, "euro");
  }

  public static void historial(){
    Funcions.historial();
  }
}