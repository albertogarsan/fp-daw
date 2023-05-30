package utils;
import java.sql.*;
import java.util.ArrayList;

import classes.*;

public class GestorBD {
    // Conexión a la base de datos
    private static Connection conn = null;

    // Configuración de la conexión a la base de datos
    private static final String DB_HOST = "localhost";
    private static final String DB_PORT = "3306";
    private static final String DB_NAME = "tenda_instruments";
    private static final String DB_URL = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME + "?serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "nocalentrar";
    private static final String DB_MYSQ_CONN_OK = "CONEXIÓN CORRECTA";
    private static final String DB_MYSQ_CONN_NO = "ERROR EN LA CONEXIÓN";

    // Configuración de la tabla libros
    private static final String INSTR = "instruments";
    private static final String INSTR_SELECTALL = "SELECT * FROM " + INSTR;
    private static final String INSTR_ID = "numSerie";
    private static final String INSTR_NOM = "nom";
    private static final String INSTR_PREU = "preu";
    private static final String INSTR_TIPUS = "tipus";
    private static final String INSTR_TIPUSFUSTA = "FUSTA";
    private static final String INSTR_TIPUSMETALL = "METALL";
    private static final String INSTR_IDCLIENT = "idClient";
    private static final String INSTR_SELECTBYID = "SELECT * FROM instruments WHERE numSerie = ?";
    private static final String INSTR_SELECTINSTRBYPREU = "SELECT * FROM instruments WHERE preu < ?";
    private static final String INSTR_SELECTINSTRBYTIPUS = "SELECT * FROM instruments WHERE tipus = ?";

    
    // Configuració de la taula clients (aniria ací baix)

    //////////////////////////////////////////////////
    // MÉTODOS DE CONEXIÓN A LA BASE DE DATOS
    //////////////////////////////////////////////////

    /**
     * CARGA DEL DRIVER
     * Intenta cargar el driver JDBC
     * @return true si pudo cargar el driver, false en caso contrario
     */
    public static boolean loadDriver() {
        try {
            System.out.print("Carregant el driver JDBC...");
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("OK!");
            return true;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            return false;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    

    /**
     * ESTABLECER LA CONEXIÓN
     * Intenta conectar con la Base de Datos.
     *
     * @return true si pudo conectarse, false en caso contrario
     */
    public static boolean connect() {
        try {
            System.out.print("Conectant a la base de dades...");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            System.out.println("OK!");
            return true;
        } catch (SQLException e) {
            System.out.println("No s'ha pogut conectar el driver...");
            return false;
        } 
    }
    

    /**
     * Comprueba la conexión y muestra su estado por pantalla
     *
     * @return true si la conexión existe y es válida, false en caso contrario
     */
    /* public static boolean isConnected() {
        try {
            if (conn != null && conn.isValid(0)) {
                System.out.println(DB_MYSQ_CONN_OK);
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            System.out.println(DB_MYSQ_CONN_NO);
            ex.printStackTrace();
            return false;
        }
    } */

    /**
     * Cierra la conexión con la Base de Datos
     */
    public static void close() {
        try {
            System.out.print("Tancant la connexió...");
            conn.close();
            System.out.println("OK!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }    


    //////////////////////////////////////////////////
    // MÈTODES REFERITS A LA TAULA INSTRUMENTS
    //////////////////////////////////////////////////
    /**
     * 
     * @param resultSetType
     * @param resultSetConcurrency
     * @return
     */
    public static ResultSet getTaulaInstruments(int resultSetType, int resultSetConcurrency) {
        try {
            PreparedStatement ps = conn.prepareStatement(INSTR_SELECTALL);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public static ResultSet getTaulaInstruments() {
        return getTaulaInstruments(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
    }

    public static ResultSet getInstrumentById(String id) {
        try {
            PreparedStatement ps = conn.prepareStatement(INSTR_SELECTBYID);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        
    }

    //El tipo que anem a retornar es un ArrayList
    public static ArrayList<Instrument> carregarInstruments(){
        //Per tant instanciem un arrayList que serà el resultat de la funció
        ArrayList<Instrument> resultat = new ArrayList<>();
        //Obtenim la taula d'Instrument i el tipo es ResultSet
        ResultSet rs_instruments = getTaulaInstruments();
        
        try {
            //Mentres hi haja files de la taula per llegir amb next() obtenim la següent fila
            while (rs_instruments.next()){
                //Obtenim els atributs/columnes mitjançant mètodes del ResultSet
                String id = rs_instruments.getString(INSTR_ID);
                String nom = rs_instruments.getString(INSTR_NOM);
                Double preu = rs_instruments.getDouble(INSTR_PREU);
                String tipus = rs_instruments.getString(INSTR_TIPUS);
                
                //Comprovem si el tipus ENUM és FUSTA o METALL
                if (tipus == INSTR_TIPUSFUSTA) {
                    //Creem un nou instrument de fusta
                    Fusta instrumentFusta = new Fusta(nom, preu, id, null, "");
                    //I l'afegim a l'arrayList instruments
                    resultat.add(instrumentFusta);
                }
                if (tipus == INSTR_TIPUSMETALL) {
                    Metall instrumentMetall = new Metall(nom, preu, id, 0, false);
                    resultat.add(instrumentMetall);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }  
        return resultat;
    }

    public static ResultSet getInstrumentByTipus(String tipus) {
        try {
            PreparedStatement ps = conn.prepareStatement(INSTR_SELECTINSTRBYTIPUS);
            ps.setString(1, tipus);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static void mostrarInstrumentsByTipus(String tipus){
        //Obtenim la taula d'Instrument i el tipo es ResultSet
        ResultSet rs_instruments = getInstrumentByTipus(tipus);

        try {
            //Cmprovem si el tipus ENUM és FUSTA o METALL
            /* if (tipus == INSTR_TIPUSFUSTA) {
                while (rs_instruments.next()){
                    String id = rs_instruments.getString(INSTR_ID);
                    String nom = rs_instruments.getString(INSTR_NOM);
                    Double preu = rs_instruments.getDouble(INSTR_PREU);
                    System.out.printf("%-5s %-20s %-10s \n", id, nom, preu);
                }
                
            }
            if (tipus == INSTR_TIPUSMETALL) {
                while (rs_instruments.next()){
                    String id = rs_instruments.getString(INSTR_ID);
                    String nom = rs_instruments.getString(INSTR_NOM);
                    Double preu = rs_instruments.getDouble(INSTR_PREU);
                    System.out.printf("%-5s %-20s %-5s \n", id, nom, preu);
                }
            } */
            while (rs_instruments.next()){
                String id = rs_instruments.getString(INSTR_ID);
                String nom = rs_instruments.getString(INSTR_NOM);
                Double preu = rs_instruments.getDouble(INSTR_PREU);
                System.out.printf("%-5s %-20s %-10s \n", id, nom, preu);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }  
        
    }

}















