package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.DataOutputStream;
import java.io.EOFException;

import classes.*;
import classes.comparators.*;

public class Funcions {

  static ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
  
  static Leer lector = new Leer();
  
  public static void menu() {
    int opcio;
    do {
      System.out.println();
      System.out.println();
      System.out.println("-".repeat(18));
      System.out.println("| CONCESSIONARI |");
      System.out.println("-".repeat(18));
      System.out.println("1. Alta vehicle");
      System.out.println("2. Baixa vehicle");
      System.out.println("3. Mostrar informació");
      System.out.println("4. Modificar informació");
      System.out.println("5. Ordenar vehicles");
      System.out.println("6. Mostrar listado de precios");
      System.out.println("7. Importar vehicles");
      System.out.println("8. Exportar datos");
      System.out.println("9. Inicialitzar objectes per defecte");
      System.out.println("10. Mostrar tots els vehicles");
      System.out.println("11. Salir");
      System.out.println();
      opcio = lector.demanarIntOpcio(1,11,"Escoje una opción (1-11): ");

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
          ordenarVehicles();  
          break;
        case 6:
          mostrarListadoPrecios();  
          break;
        case 7:
          importar();  
          break;
        case 8:
          exportarDatos();  
          break;
        case 9:
          inicialitzarObjectesDefecte();
          break;
        case 10:
          mostrarTotsElsVehicles();
          break;
        case 11:
          System.out.println("Finalizando programa...");
          System.out.println();
          System.out.println("¡¡¡ADIÓS!!!");
          System.exit(0);
          break;
        default:
          System.out.println("Opción no válida. Inténtalo de nuevo.");
          break;
      } 
    } while (opcio != 11);
  }

  private static void alta(){
    int opcio = lector.demanarIntOpcio(1, 3, "Introdueix el tipo de vehicle on 1 = Cotxe, 2 = Furgoneta, 3 = Moto: ");
    String nom = lector.demanarString("\nIntrodueix el nom del vehicle: ");
    String matricula = lector.demanarString("Introudeix el número de matriculació: ");
    double preu = lector.demanarDouble("Introdueix el preu del vehicle: ");
     
    if (opcio == 1) {
      int qPortesCotxe = lector.demanarInt("Introdueix la quantitat de portes que té el cotxe: ");
      Boolean maleter = lector.demanarBooleanSiNo("Té maleter? (s/n): ");
      Cotxe cotxe = new Cotxe(matricula, nom, preu, qPortesCotxe, maleter);
      vehicles.add(cotxe);
    } else if (opcio == 2) {
      Boolean portaCorredera = lector.demanarBooleanSiNo("Té porta corredera? (s/n): ");
      String tipoFurgoneta = lector.demanarString("Introdueix el tipo de furgoneta (camperitzada o industrial): ");
      Furgoneta furgoneta = new Furgoneta(matricula, nom, preu, portaCorredera, tipoFurgoneta);
      vehicles.add(furgoneta);
    } else if (opcio == 3) {
      int qRodesMoto = lector.demanarInt("Introdueix la quantitat de rodes que té la moto (2 o 3): ");
      Moto moto = new Moto(matricula, nom, preu, qRodesMoto);
      vehicles.add(moto);
    }
    
    System.out.println("Vehicle afegit correctament.");
  };

  private static void baixa(){
    int comptador = 1;
    for (Vehicle vehicle : vehicles) {
      System.out.println(" "+(comptador++)+") "+vehicle);
    }
    int seleccio = lector.demanarIntOpcio(1, vehicles.size(), "Quin vehicle vols borrar? (1-"+vehicles.size()+") ");
    vehicles.remove(seleccio-1);
    System.out.println("Vehicle esborrat correctament.");
  };



  private static void mostrarInformacio(){
    if (vehicles.size() == 0) {
      System.out.println("No hi ha vehicles");
    } else {
      System.out.println("\nEl concessionari té "+vehicles.size()+" vehicles: ");
      int comptador = 1;
      for (Vehicle vehicle : vehicles) {
        System.out.println((comptador++) +" - Nom: "+vehicle.getNom() + " Preu: "+vehicle.getPreu());
      }

      int opcio = lector.demanarIntOpcio(1, vehicles.size(), "Escull un vehicle a mostrar informació de la llista: ");

      Vehicle seleccio = vehicles.get(opcio-1);

      System.out.println(seleccio.mostrarInformacion());

      /* if (seleccio instanceof Cotxe) {
        Cotxe cotxe = (Cotxe) seleccio;
        System.out.println(cotxe.mostrarInformacion());
      } else if (seleccio instanceof Furgoneta) {
        Furgoneta furgoneta = (Furgoneta) seleccio;
        System.out.println(furgoneta.mostrarInformacion());
      }else if (seleccio instanceof Moto) {
        Moto moto = (Moto) seleccio;
        System.out.println(moto.mostrarInformacion());
      } */
    } 
  }



  private static void modificarInformacio(){
    if (vehicles.size() == 0) {
      System.out.println("No hi ha vehicles");
    } else {
      System.out.println("\nEl concessionari té "+vehicles.size()+" vehicles: ");
      int comptador = 1;
      for (Vehicle vehicle : vehicles) {
        System.out.println((comptador++) +" - Nom: "+vehicle.getNom() + " Preu: "+vehicle.getPreu());
      }
    }

    int seleccio = lector.demanarIntOpcio(1, vehicles.size(), "Quin vehicle vols modificar? (1-"+vehicles.size()+") ");
    Vehicle seleccionat = vehicles.get(seleccio-1);

    int tipus = lector.demanarIntOpcio(1, 2, "Què vols modificar? 1) Nom - 2) Matricula - 3) Preu: ");
    switch (tipus){
      case 1:
        String nom = lector.demanarString("Introdueix un nou nom: ");
        seleccionat.setNom(nom);
        break;
      case 2:
        String matricula = lector.demanarString("Introdueix la matriculació: ");
        seleccionat.setMatricula(matricula);
        break;
      case 3:
        Double preu = lector.demanarDouble("Introdueix un preu: ");
        seleccionat.setPreu(preu);;
      break;
    }
    System.out.println("Contacto actualizado correctamente:");
    System.out.println(seleccionat);
  }
  
  private static void ordenarVehicles(){
    int opcio = lector.demanarIntOpcio(1, 2,"Tria ordenar la llista de vehicles per (1) Nom - (2) Matricula - (3) Preu: ");

    if (opcio == 1) {
      // Collections es una clase de utilidad que proporciona métodos estáticos para trabajar con colecciones de objetos.
      Collections.sort(vehicles);
    } else if (opcio == 2) {
      Collections.sort(vehicles, new ComparatorMatricula());
    } else if (opcio == 3) {
      Collections.sort(vehicles, new ComparatorPreu());
    }

    boolean mostrarLista = lector.demanarBooleanSiNo("S'ha ordenat, ¿Mostrar? (S/N): ");
    if (mostrarLista) {
      for (Vehicle vehicle : vehicles) {
        System.out.println(vehicle);
      }
    } else {
      System.out.println("Vale...");
    }
  }


  public static void mostrarListadoPrecios(){
    if (vehicles.size() == 0) {
      System.out.println("No hi ha vehicles");
    } else {
      System.out.println("\nEl concessionari té "+vehicles.size()+" vehicles: ");

      int comptador = 1;
      for (Vehicle vehicle : vehicles) {
        System.out.println((comptador++) +" - Nom: "+vehicle.getNom() + " Preu: "+vehicle.getPreu());
      }

      int opcio = lector.demanarIntOpcio(1, vehicles.size(), "Escull un vehicle a mostrar informació dels preus: ");

      Vehicle seleccio = vehicles.get(opcio-1);

      for (Integer preu : seleccio){
        System.out.println(preu);
      }
    }
  }

/*   private static void importarDatos(){
    String ruta = lector.demanarString("\nIntroduce la ruta del archivo: ");
    int comptador = 0;
    // necessari inicialitzar-lo a null perquè el finally no es queixe per scope.
    ObjectInputStream ois = null;
    // buidem l'arraylist perquè només continga els contactes que anem a llegir de l'arxiu
    contactes.clear();
    try {
      ois = new ObjectInputStream(new FileInputStream(ruta));
      while (true) {
        Contacte contacte = (Contacte) ois.readObject();
        contactes.add(contacte);
        comptador++;
      }
    } catch (EOFException e) {
      System.out.println("Lectura del archivo finalizada.");
    } catch (Exception e) {
      System.out.println(e);
    } finally {
      if (ois != null) {
        try {
          ois.close();
          System.out.println("Se han importado correctamente "+comptador+" contactos desde el archivo: "+ruta);
        } catch (Exception e) {
          System.out.println(e);
        }
      }
    }
  };

  private static void exportarDatos(){
    String ruta = lector.demanarString("\nIntroduce la ruta del archivo: ");
    try {
      FileOutputStream fileOut = new FileOutputStream(ruta);
      ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
      for (Contacte contacte : contactes) {
        objectOut.writeObject(contacte);
      }
      objectOut.close();
      System.out.println("Datos de "+contactes.size()+" contactos exportados correctamente a: "+ruta);
    } catch (Exception e) {
      System.out.println(e);
    }
  }; */

  private static void importar(){
    /* String ruta = lector.demanarString("\nIntroduce la ruta del archivo: ");
    
    int comptador = 0;
    // necessari inicialitzar-lo a null perquè el finally no es queixe per scope.
    ObjectInputStream ois = null;
    
    // buidem l'arraylist perquè només continga els contactes que anem a llegir de l'arxiu
    contactes.clear();
    
    try {
      ois = new ObjectInputStream(new FileInputStream(ruta));
      while (true) {
        Contacte contacte = (Contacte) ois.readObject();
        contactes.add(contacte);
        comptador++;
      }
    
    } catch (EOFException e) {
      System.out.println("Lectura del archivo finalizada.");
    
    } catch (Exception e) {
      System.out.println(e);
    
    } finally {
      if (ois != null) {
        try {
          ois.close();
          System.out.println("Se han importado correctamente "+comptador+" contactos desde el archivo: "+ruta);
        } catch (Exception e) {
          System.out.println(e);
        }
      }
    } */

    // Importar significa llegir un arxiu i a cada objecte que anem llegint anirem afegint-lo a l'arraylist de vehicles.
    //Demanem a l'usuari que introduisca la ruta
    //Després inicialitzem els objectes necessaris per a llegir els arxius (FileInputStream, i ObjectInputStream)
    //Englobarem en un try catch per a les possibles excepcions
    
    String ruta = lector.demanarString("\nIntrodueix la ruta de l'arxiu: ");
  
    try {
      FileInputStream fis = new FileInputStream(ruta);
      ObjectInputStream ois = new ObjectInputStream(fis);
      
      //Retorna un objecte, per tant anem a assignar-ho a una variable
      Vehicle vehicle;

      //vehicles.clear();
      if (vehicles.size() != 0) {
        
        Boolean substituir = lector.demanarBooleanSiNo("Ja hi ha elements en la llista, vols substituir-los? (s/n): ");
       
        if (substituir) {
          vehicles.clear();
        } 
      } 

      while (fis.available() > 0 ) {
        vehicle = (Vehicle) ois.readObject();
        vehicles.add(vehicle);
      }


      ois.close();
      fis.close();
    } catch(Exception e) {
      System.out.println(e);
    }
  
  }
  

  private static void exportarDatos(){

    int opcio = lector.demanarIntOpcio(1, 2, "Tria (1) Exportar vehicles o (2) Exportar preus: ");

    //L'usuari introdueix la ruta (podria ser Desktop/)
    String ruta = lector.demanarString("\nIntroduce la ruta del archivo: ");

    switch (opcio) {
      case 1: 
        try {
          FileOutputStream fileOut = new FileOutputStream(ruta);
          ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
          
          for (Vehicle vehicle : vehicles) {
            objectOut.writeObject(vehicle);
          }
    
          objectOut.close();
    
          System.out.println("Dades de "+vehicles.size()+" vehicles exportats correctament a: "+ruta);
        
        } catch (Exception e) {
          System.out.println(e);
        } 
      break;
      
      case 2:
        try {
          FileOutputStream fileOut = new FileOutputStream(ruta);
          DataOutputStream dataOut = new DataOutputStream(fileOut);
          
          int seleccio = lector.demanarIntOpcio(1, vehicles.size(), "Tria un vehicle per a exportar els seus preus: ");

          Vehicle vehicle1 = vehicles.get(seleccio);
          //Vehicle vehicle1 = vehicles.get(0);

          for (Integer precio : vehicle1){
            dataOut.writeInt(precio);
          }
          
          dataOut.close();
    
          System.out.println("Dades de "+vehicles.size()+" vehicles exportats correctament a: "+ruta);
        
        } catch (Exception e) {
          System.out.println(e);
        }
      break;
    }
  }


  public static void inicialitzarObjectesDefecte(){
    Cotxe cotxe1 = new Cotxe("123456789MDS", "Aplha", 19292, true, 30, true);
    Cotxe cotxe2 = new Cotxe("12921LSD", "Beta", 393933, false,  4, false);
    Furgoneta furgoneta1 = new Furgoneta("98383HHB", "Citroen", 999999, true, true, "industrial");
    Moto moto1 = new Moto("3838383EER", "motosecleta", 8383, true, 3);

    vehicles.add(cotxe1);
    vehicles.add(cotxe2);
    vehicles.add(furgoneta1);
    vehicles.add(moto1);
  }


  public static void mostrarTotsElsVehicles() {
    if (vehicles.size() == 0) {
      System.out.println("No hi ha vehicles");
    } else {
      System.out.println("\nEl concessionari té "+vehicles.size()+" vehicles: ");
      int comptador = 1;
      for (Vehicle vehicle : vehicles) {
        System.out.println((comptador++) +" - Nom: "+vehicle.getNom() + " Preu: "+vehicle.getPreu());
      }
    }
  }
}

