// IMPORTACIONES
import java.sql.*;

//import javax.print.DocFlavor.STRING;

/**
 *
 * @author Alberto
 */
public class DBManager {

    // Conexión a la base de datos
    private static Connection conn = null;

    // Configuración de la conexión a la base de datos
    private static final String DB_HOST = "localhost";
    private static final String DB_PORT = "3306";
    private static final String DB_NAME = "bdlibros";
    private static final String DB_URL = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME + "?serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "nocalentrar";
    private static final String DB_MYSQ_CONN_OK = "CONEXIÓN CORRECTA";
    private static final String DB_MYSQ_CONN_NO = "ERROR EN LA CONEXIÓN";

    // Configuración de la tabla libros
    private static final String DB_LIB = "libros";
    private static final String DB_LIB_SELECT = "SELECT * FROM " + DB_LIB;
    private static final String DB_LIB_ID = "id";
    private static final String DB_LIB_NOM = "nombre";
    private static final String DB_LIB_PRE = "precio";
    private static final String DB_LIB_AUTID = "IdAutor";

    private static final String DB_AUT = "autores";
    private static final String DB_AUT_SELECT = "SELECT * FROM " + DB_AUT;
    private static final String DB_AUT_ID = "id";
    private static final String DB_AUT_NOM = "nom";





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
            System.out.print("Cargando el driver JDBC...");
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
            System.out.print("Conectando a la base de datos...");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            System.out.println("OK!");
            return true;
        } catch (SQLException e) {
            System.out.println("No se pudo cargar el driver");
            return false;
        } 
    }
    

    /**
     * Comprueba la conexión y muestra su estado por pantalla
     *
     * @return true si la conexión existe y es válida, false en caso contrario
     */
    public static boolean isConnected() {
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
    }

    /**
     * Cierra la conexión con la Base de Datos
     */
    public static void close() {
        try {
            System.out.print("Cerrando la conexión...");
            conn.close();
            System.out.println("OK!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    //////////////////////////////////////////////////
    // MÉTODOS DE LA TABLA AUTORES
    //////////////////////////////////////////////////
    public static void crearTablaAutores(){
        PreparedStatement ps;

        try {
            String sql1 = "CREATE TABLE IF NOT EXISTS `autores`(id bigint(20) NOT NULL PRIMARY KEY AUTO_INCREMENT, " + DB_AUT_NOM + " varchar(255) NOT NULL)";
            ps = conn.prepareStatement(sql1);
            ps.executeUpdate();

            try {
                String sql2 = "ALTER TABLE libros ADD COLUMN " + DB_LIB_AUTID + " BIGINT(20) REFERENCES autores(id)";
                ps = conn.prepareStatement(sql2);
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println("La columna ya existe. No es necesario volver a crearla.");
            }

            System.out.println("Se ha creado la tabla autores correctamente con campos: ID, Nombre.");
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("No se pudo preparar la sentencia SQL");
        }
    }


    public static void insertarDatosIniciales(){
        PreparedStatement ps;

        try {
            String sql1 = "INSERT INTO autores (" + DB_AUT_ID + "," + DB_AUT_NOM + ") VALUES (1, 'Alberto Garcia'), (2, 'Blasco Ibáñez');";
            ps = conn.prepareStatement(sql1);
            ps.executeUpdate();

            
            String sql2 = "UPDATE libros SET "+DB_LIB_AUTID+" = 1 WHERE id = 1 OR id = 2 OR id = 4 OR id = 5 OR id = 6;";
            ps = conn.prepareStatement(sql2);
            ps.executeUpdate();

            String sql3 = "UPDATE libros SET "+DB_LIB_AUTID+" = 2 WHERE id = 2;";
            ps = conn.prepareStatement(sql3);
            ps.executeUpdate();

            System.out.println("Se ha insertado los datos iniciales de autores correctamente!!");
        } catch (SQLException e) {
            System.out.println("Los datos iniciales ya existen en la tabla.");
        }
        
    }

    public static ResultSet getTablaAutores(int resultSetType, int resultSetConcurrency) {
        try {
            Statement stmt = conn.createStatement(resultSetType, resultSetConcurrency);
            ResultSet rs = stmt.executeQuery(DB_AUT_SELECT);
            return rs;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public static ResultSet getTablaAutores() {
        return getTablaAutores(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
    }

    /**
     * Solicita a la BD el autor id
     *
     * @param id id del autor
     * @return ResultSet con el resultado de la consulta, null en caso de error
     */
    public static ResultSet getAutor(int id) {
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM autores WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.setString(1, String.valueOf(id));
            rs = stmt.executeQuery();

            // Si no hay primer registro entonces no existe el libro
            if (!rs.first()) {
                return null;
            }

            return rs;

        }  catch (SQLException e) {
            e.printStackTrace();
            return rs;
        }
    }

    public static void mostrarAutores() {
        try {
            ResultSet rs = getTablaAutores(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            System.out.printf("%-5s %-30s \n", "ID", "Nom");
            while (rs.next()){
                int id = rs.getInt(DB_AUT_ID);
                String nom = rs.getString(DB_AUT_NOM);
                System.out.printf("%-5s %-30s \n", id, nom);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static boolean nuevoAutor(String nombre) {
        try {
            // Obtenemos la tabla libros
            System.out.print("Insertando el autor: " + nombre + "...");
            ResultSet rs = getTablaAutores(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);

            // Insertamos el nuevo registro
            rs.moveToInsertRow();
	    // CORREGIR - ACTUALIZAR EL nombre
            rs.updateString(DB_AUT_NOM, nombre);
            rs.insertRow();

            // Todo bien, cerramos ResultSet y devolvemos true
            rs.close();
            System.out.println("OK!");
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }


    public static boolean existsAutor(int id) {
        try {
            // Obtenemos el libro
            ResultSet rs = getAutor(id);

            // Si rs es null, se ha producido un error
            if (rs == null) {
                return false;
            }

            // Si no existe primer registro
            if (!rs.first()) {
                rs.close();
                return false;
            }

            // Todo bien, existe el libro
            rs.close();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }


     /**
     * Imprime los datos del autor id
     *
     * @param id id del autor
     */
    public static void printAutor(int id) {
        try {
            // Obtenemos el libro
            ResultSet rs = getAutor(id);
            if (rs == null || !rs.first()) {
                System.out.println("Autor con id: " + id + " NO EXISTE");
                return;
            }

            // Imprimimos su información por pantalla
            int aid = rs.getInt(DB_AUT_ID);
            String anom = rs.getString(DB_AUT_NOM);
            
            System.out.println("Autor " + aid + "\t" + anom);

        }  catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Solicita a la BD modificar los datos de un libro
     *
     * @param id id del libro a modificar
     * @param nuevoNombre nuevo nombre del libro
     * @param nuevoPrecio nuevo precio del libro
     * @return verdadero si pudo modificarlo, false en caso contrario
     */
    public static boolean modificarAutor(int id, String nuevoNombre) {
        try {
            // Obtenemos el autor
            System.out.print("Actualizando el autor con el id: " + id);
            ResultSet rs = getAutor(id);

            // Si no existe el Resultset
            if (rs == null) {
                System.out.println("Error. ResultSet null.");
                return false;
            }

            // Si tiene un primer registro, lo "modificamos"
            if (rs.first()) {
                rs.updateString(DB_AUT_NOM, nuevoNombre);
                rs.updateRow();
                rs.close();
                System.out.println(" - OK!");
                return true;
            } else {
                System.out.println("ERROR. ResultSet vacío.");
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Elimina de la BD el AUTOR id
     *
     * @param id id del AUTOR a eliminar
     * @return verdadero si pudo eliminarlo, false en caso contrario
     */
    public static boolean eliminarAutor(int id) {
        try {
            System.out.print("Eliminando el autor con id: " + id + "... ");

            // Obtenemos el autor
            ResultSet rs = getAutor(id);

            // Si no existe el Resultset
            if (rs == null) {
                System.out.println("ERROR. ResultSet null.");
                return false;
            }

            // Si existe y tiene primer registro, lo eliminamos
            if (rs.first()) {
                // CORREGIR - ELIMINAR FILA
                rs.deleteRow();
                rs.close();
                System.out.println("OK!");
                return true;
            } else {
                System.out.println("ERROR. ResultSet vacío.");
                return false;
            }

        }  catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }



    
    //////////////////////////////////////////////////
    // MÉTODOS DE LA TABLA LIBROS
    //////////////////////////////////////////////////
    
        // Los argumentos indican el tipo de ResultSet deseado
    /**
     * Obtiene toda la tabla libros de la Base de Datos
     *
     * @param resultSetType Tipo de ResultSet
     * @param resultSetConcurrency Concurrencia del ResultSet
     * @return ResultSet (del tipo indicado) con la tabla, null en caso de error
     */
    public static ResultSet getTablaLibros(int resultSetType, int resultSetConcurrency) {
        try {
            Statement stmt = conn.createStatement(resultSetType, resultSetConcurrency);
            ResultSet rs = stmt.executeQuery(DB_LIB_SELECT);
            return rs;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

    }
    

    /**
     * Obtiene toda la tabla libros de la Base de Datos
     *
     * @return ResultSet (por defecto) con la tabla, null en caso de error
     */
    public static ResultSet getTablaLibros() {
        return getTablaLibros(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
    }

    /**
     * Imprime por pantalla el contenido de la tabla libros
     */
    public static void mostrarLibros() {
        try {
            int idAutor;
            
            ResultSet rs = getTablaLibros(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            //Capçalera
            System.out.printf("%-5s %-30s %-5s %-5s \n", "ID", "Nom", "Preu", "Id Autor");
            
            while (rs.next()){
                int id = rs.getInt(DB_LIB_ID);
                String nom = rs.getString(DB_LIB_NOM);
                double preu = rs.getDouble(DB_LIB_PRE);
                idAutor = rs.getInt(DB_LIB_AUTID);
                //Contingut de la taula amb columna d'autor
                System.out.printf("%-5s %-30s %-5s %-5s \n", id, nom, preu, idAutor);
            }
            
            rs.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    

    /**
     * Solicita a la BD el libro id
     *
     * @param id id del libro
     * @return ResultSet con el resultado de la consulta, null en caso de error
     */
    public static ResultSet getLibro(int id) {
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM Libros WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.setString(1, String.valueOf(id));
            rs = stmt.executeQuery();

            // Si no hay primer registro entonces no existe el libro
            if (!rs.first()) {
                return null;
            }

            return rs;

        }  catch (SQLException e) {
            e.printStackTrace();
            return rs;
        }
    }

    /**
     * Solicita a la BD el libro id
     *
     * @param id id del libro
     * @return ResultSet con el resultado de la consulta, null en caso de error
     */
    public static ResultSet getLibro(int id, int resultSetType, int concurrencySetTy) {
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM Libros WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.setString(1, String.valueOf(id));
            rs = stmt.executeQuery();

            // Si no hay primer registro entonces no existe el libro
            if (!rs.first()) {
                return null;
            }

            return rs;

        }  catch (SQLException e) {
            e.printStackTrace();
            return rs;
        }
    }
    

    /**
     * Comprueba si en la BD existe el libro id 
     *
     * @param id id del libro
     * @return verdadero si existe, false en caso contrario
     */
    public static boolean existsLibro(int id) {
        try {
            // Obtenemos el libro
            ResultSet rs = getLibro(id);

            // Si rs es null, se ha producido un error
            if (rs == null) {
                return false;
            }

            // Si no existe primer registro
            if (!rs.first()) {
                rs.close();
                return false;
            }

            // Todo bien, existe el libro
            rs.close();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Imprime los datos del libro id
     *
     * @param id id del libro
     */
    public static void printLibro(int id) {
        try {
            // Obtenemos el libro
            ResultSet rs = getLibro(id);
            if (rs == null || !rs.first()) {
                System.out.println("Libro " + id + " NO EXISTE");
                return;
            }

            // Imprimimos su información por pantalla
            int lid = rs.getInt(DB_LIB_ID);
            String lnom = rs.getString(DB_LIB_NOM);
            double lpreu = rs.getDouble(DB_LIB_PRE);
            int lidAutor = rs.getInt(DB_LIB_AUTID);
            
            System.out.println("Libro " + lid + "\t" + lnom + "\t" + lpreu + "\t" + lidAutor);

        }  catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Solicita a la BD insertar un nuevo registro libro
     *
     * @param nombre nombre del libro
     * @param precio precio del libro
     * @return verdadero si pudo insertarlo, false en caso contrario
     */
    public static boolean nuevoLibro(String nombre, Double precio) {
        try {
            // Obtenemos la tabla libros
            System.out.print("Insertando libro " + nombre + "...");
            ResultSet rs = getTablaLibros(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);

            // Insertamos el nuevo registro
            rs.moveToInsertRow();
	    // CORREGIR - ACTUALIZAR EL nombre
            rs.updateDouble(DB_LIB_PRE, precio);
            rs.updateString(DB_LIB_NOM, nombre);
            rs.insertRow();

            // Todo bien, cerramos ResultSet y devolvemos true
            rs.close();
            System.out.println("OK!");
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }


    /**
     * Solicita a la BD modificar los datos de un libro
     *
     * @param id id del libro a modificar
     * @param nuevoNombre nuevo nombre del libro
     * @param nuevoPrecio nuevo precio del libro
     * @return verdadero si pudo modificarlo, false en caso contrario
     */
    public static boolean modificarLibro(int id, String nuevoNombre, Double nuevoPrecio) {
        try {
            // Obtenemos el libro
            System.out.print("Actualizando libro " + id + "... ");
            ResultSet rs = getLibro(id);

            // Si no existe el Resultset
            if (rs == null) {
                System.out.println("Error. ResultSet null.");
                return false;
            }

            // Si tiene un primer registro, lo "modificamos"
            if (rs.first()) {
                rs.updateString(DB_LIB_NOM, nuevoNombre);
                rs.updateDouble(DB_LIB_PRE, nuevoPrecio);
                rs.updateRow();
                rs.close();
                System.out.println("OK!");
                return true;
            } else {
                System.out.println("ERROR. ResultSet vacío.");
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    

    /**
     * Elimina de la BD el libro id
     *
     * @param id id del libro a eliminar
     * @return verdadero si pudo eliminarlo, false en caso contrario
     */
    public static boolean eliminarLibro(int id) {
        try {
            System.out.print("Eliminando libro " + id + "... ");

            // Obtenemos el libro
            ResultSet rs = getLibro(id);

            // Si no existe el Resultset
            if (rs == null) {
                System.out.println("ERROR. ResultSet null.");
                return false;
            }

            // Si existe y tiene primer registro, lo eliminamos
            if (rs.first()) {
                // CORREGIR - ELIMINAR FILA
                rs.deleteRow();
                rs.close();
                System.out.println("OK!");
                return true;
            } else {
                System.out.println("ERROR. ResultSet vacío.");
                return false;
            }

        }  catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void asignarAutorALibro(int idLibro, int idAutor){
        PreparedStatement ps;
        try {
            String sql = "UPDATE libros SET "+DB_LIB_AUTID+" = " + idAutor + " WHERE id = " + idLibro + ";";
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();

            System.out.println("Se ha asignado correctamente el autor con id: " + idAutor + " al libro con id: " + idLibro);
        } catch (SQLException e) {
            System.out.println("ERROR GARRAFAL!");
        }
    }
}



