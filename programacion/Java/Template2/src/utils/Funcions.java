package utils;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


import classes.*;
import classes.Fusta.Tonalitat;

public class Funcions {

  public static LlistatInstruments llistatInstruments = new LlistatInstruments();
  
  static Leer lector = new Leer();
  
  public static void altaInstrumentFusta(String numSerie, String nom, Double preu, String tonalitat, String material){
    
    Tonalitat to = Tonalitat.valueOf(tonalitat.toUpperCase());
    
    Fusta instrumentFusta = new Fusta(nom, preu, numSerie, to, material);
    llistatInstruments.add(instrumentFusta);
    System.out.println("Instrument donat d'alta correctament!");
  }

  public static void altaInstrumentMetall(String numSerie, String nom, Double preu, int diametre, Boolean usat){
    Metall instrumentMetall = new Metall(nom, preu, numSerie, diametre, usat);
    llistatInstruments.add(instrumentMetall);
    System.out.println("Instrument donat d'alta correctament!");
  }

  public static void mostrarInstruments(){
    System.out.println("\nTotal d'instruments: ");
        
    int index = 1;
    for (Instrument instrument : llistatInstruments) {
        System.out.println((index++) + ": " + instrument);
    }
  }

  public static void baixaInstrument(int opcio){
    llistatInstruments.remove(opcio - 1);
    System.out.println("Instrument eliminat.");
  }

  public static void mostrarIntrument(int opcio){
    Instrument instrument = llistatInstruments.get(opcio-1);
    instrument.mostrarInformacio();
  }

  public static void modificarInfo(int opcio, String nom, Double preu, String numSerie) {
    Instrument instrument = llistatInstruments.get(opcio-1);
    instrument.setNom(nom);
    instrument.setPreu(preu);
    instrument.setNumSerie(numSerie);
    System.out.println("Instrument modificat.");
  }

  public static void afinarInstrument(int opcio, String nota){
    Instrument instrument = llistatInstruments.get(opcio-1);
    instrument.afinar(nota);
  }
  
  public static void provarInstrument(int opcio){
    Instrument instrument = llistatInstruments.get(opcio-1);
    //instanceof és un operador que fa la comprovació (comprova si el tipus que té a la dreta és la classe de l'objecte que té a la esquerra) i retorna un boolean
    if (instrument instanceof Fusta){
      ((Fusta) instrument).tocar();
    } else {
      ((Metall) instrument).tocar();
    }
  }

  public static void importarInstruments(String ruta){
    try {
      FileInputStream fis = new FileInputStream(ruta);
      ObjectInputStream ois = new ObjectInputStream(fis);
     
      Instrument instrument;

      if (LlistatInstruments.size() != 0) {
        
        Boolean substituir = lector.demanarBooleanSiNo("Ja hi ha elements en la llista, vols substituir-los? (s/n): ");
       
        if (substituir) {
          llistatInstruments.clear();
        } 
      } 

      while (fis.available() > 0 ) {
        instrument = (Instrument) ois.readObject();
        llistatInstruments.add(instrument);
      }

      ois.close();
      fis.close();
      
      System.out.println("Dades d'instruments importats correctament a: "+ ruta);
    
    } catch(Exception e) {
      System.out.println(e);
    }
  }

  public static void exportarInstruments(String ruta){
    try (FileOutputStream fos = new FileOutputStream(ruta)) {
      ObjectOutputStream oos = new ObjectOutputStream(fos);

      try {
        for (Instrument instrument : llistatInstruments) {
          oos.writeObject(instrument);
        }

        oos.close();

        System.out.println("Dades d'instruments exportats correctament a: "+ ruta);
      
      } catch (IOException e) {
        e.printStackTrace();
      }
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }

  /* public static void guardarLlistatInstruments(String ruta){
    FileWriter fw = null;
    BufferedWriter bw = null;
      
    try {
      fw = new FileWriter(ruta);
      bw = new BufferedWriter(fw);

      bw.write("INSTRUMENTS: ");
      bw.write("\n\n");
      for (Instrument instrument : llistatInstruments) {
        bw.write(instrument.getNom() + " " + instrument.getPreu());
        bw.newLine();
      }

      bw.close();
      fw.close();

    } catch (Exception e){
      e.printStackTrace();
    }

  } */

  public static void exportarLlistatInstrumentsBinari(String ruta){
    try {
      FileOutputStream fos = new FileOutputStream(ruta);
      ObjectOutputStream oos = new ObjectOutputStream(fos);

      for (Instrument instrument : llistatInstruments) {
        oos.writeObject(instrument);
      }

      oos.close();
      fos.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void exportarInstrumentBinari(String ruta, Instrument instrument){
    try {
      FileOutputStream fos = new FileOutputStream(ruta);
      ObjectOutputStream oos = new ObjectOutputStream(fos);

      oos.writeObject(instrument);

      oos.close();
      fos.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static Instrument importarInstrument(String ruta) {
    Instrument instrument = null;

    try {
      FileInputStream fis = new FileInputStream(ruta);
      ObjectInputStream ois = new ObjectInputStream(fis);

      instrument = (Instrument) ois.readObject();

      ois.close();
      fis.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return instrument;

  }

  public static void exportNumSerie(String numSerie){
  
    try {
      FileOutputStream fos = new FileOutputStream("arxius/numsSerie.dat", true);
      DataOutputStream dos = new DataOutputStream(fos);
      
      dos.writeUTF(numSerie);
      
      dos.close();
    
    } catch(Exception e) {
      System.out.println(e);
    }
  }

  public static void mostrarNumsSerie() {
    FileInputStream fis;
    DataInputStream dis = null;

    try {
      fis = new FileInputStream("/arxius/numsSerie.dat");
      dis = new DataInputStream(fis);
      System.out.println("Llistat de cada número de serie de cada instrument: ");
      while (dis.available() > 0) {
          String numSerie = dis.readUTF();
          System.out.println(numSerie);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
}

