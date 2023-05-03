package utils;

import java.util.ArrayList;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.EOFException;

import classes.Contacte;

public class Funcions {

  static ArrayList<Contacte> contactes = new ArrayList<Contacte>();
  
  static Leer lector = new Leer();
  
  public static void menu() {
    int opcio;
    do {
      System.out.println();
      System.out.println();
      System.out.println("-".repeat(18));
      System.out.println("| AGENDA TELEFONICA |");
      System.out.println("-".repeat(18));
      System.out.println("1. Alta contacto");
      System.out.println("2. Consultar contacto (por nombre)");
      System.out.println("3. Cantidad de contactos");
      System.out.println("4. Mostrar agenda");
      System.out.println("5. Borrar contacto");
      System.out.println("6. Modificar contacto");
      System.out.println("7. Importar datos");
      System.out.println("8. Exportar datos");
      System.out.println("9. Salir");
      System.out.println();
      opcio = lector.demanarIntOpcio(1,9,"Escoje una opción (1-9): ");

      switch (opcio) {
        case 1:
          altaContacto();
          break;
        case 2:
          consultarContacto();  
          break;
        case 3:
          cantidadContactos();  
          break;
        case 4:
          mostrarAgenda();  
          break;
        case 5:
          borrarContacto();  
          break;
        case 6:
          modificarContacto();  
          break;
        case 7:
          importarDatos();  
          break;
        case 8:
          exportarDatos();  
          break;
        case 9:
          System.out.println("Finalizando programa...");
          System.out.println();
          System.out.println("¡¡¡ADIÓS!!!");
          System.exit(0);
          break;
        default:
          System.out.println("Opción no válida. Inténtalo de nuevo.");
          break;
      } 
    } while (opcio != 9);
  }

  private static void altaContacto(){
    String nom = lector.demanarString("\nIntroduce el nombre del contacto: ");
    String num = lector.demanarString("Introduce el número del contacto: ");
    Contacte contacte = new Contacte(nom, num);
    contactes.add(contacte);
    System.out.println("Contacto añadido correctamente.");
  };

  private static void consultarContacto(){
    int comptador = 1;
    for (Contacte contacte : contactes) {
      System.out.println(" "+(comptador++)+") "+contacte.getNom());
    }
    int seleccio = lector.demanarIntOpcio(1, contactes.size(), "Qué contacto quieres consultar? (1-"+contactes.size()+") ");
    Contacte seleccionat = contactes.get(seleccio-1);
    System.out.println("Información del contacto seleccionado: ");
    System.out.println(seleccionat);
  };

  private static void cantidadContactos(){
    int total = contactes.size();
    System.out.println("\nEn la agenda existe un total de "+total+" contactos.");
  };

  private static void mostrarAgenda(){
    System.out.println("\nContenido de la agenda ("+contactes.size()+" contactos): ");
    for (Contacte contacte : contactes) {
      System.out.println(contacte);
    }
  };

  private static void borrarContacto(){
    int comptador = 1;
    for (Contacte contacte : contactes) {
      System.out.println(" "+(comptador++)+") "+contacte.getNom());
    }
    int seleccio = lector.demanarIntOpcio(1, contactes.size(), "Qué contacto quieres borrar? (1-"+contactes.size()+") ");
    contactes.remove(seleccio-1);
    System.out.println("Contacto borrado correctamente.");
  };

  private static void modificarContacto(){
    int comptador = 1;
    for (Contacte contacte : contactes) {
      System.out.println(" "+(comptador++)+") "+contacte.getNom());
    }
    int seleccio = lector.demanarIntOpcio(1, contactes.size(), "Qué contacto quieres modificar? (1-"+contactes.size()+") ");
    Contacte seleccionat = contactes.get(seleccio-1);

    int tipus = lector.demanarIntOpcio(1, 2, "Qué quieres modificar? 1) Nombre - 2) Teléfono: ");
    switch (tipus){
      case 1:
        String nom = lector.demanarString("Introduce en nuevo nombre: ");
        seleccionat.setNom(nom);
        break;
      case 2:
        String num = lector.demanarString("Introduce en nuevo número: ");
        seleccionat.setNum(num);
      break;
    }
    System.out.println("Contacto actualizado correctamente:");
    System.out.println(seleccionat);
  };

  private static void importarDatos(){
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
  };
}
