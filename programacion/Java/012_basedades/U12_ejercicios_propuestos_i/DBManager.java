/*
CORREGIR - IMPORTS
*/

/**
 *
 * @author Espe
 */
public class DBManager {

    // Conexión a la base de datos
    private static Connection conn = null;

    // Configuración de la conexión a la base de datos
    private static final String DB_HOST = "localhost";
    private static final String DB_PORT = "3336";
    private static final String DB_NAME = "CORREGIR - NOMBRE DE LA BASE DE DATOS";
    private static final String DB_URL = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME + "?serverTimezone=UTC";
    private static final String DB_USER = "CORREGIR - USUARIO";
    private static final String DB_PASS = "CORREGIR - PASSWORD";
    private static final String DB_MYSQ_CONN_OK = "CONEXIÓN CORRECTA";
    private static final String DB_MYSQ_CONN_NO = "ERROR EN LA CONEXIÓN";

    // Configuración de la tabla libros
    private static final String DB_LIB = "libros";
    private static final String DB_LIB_SELECT = "CORREGIR - SENTENCIA PARA MOSTRAR TODOS LOS LIBROS";
    private static final String DB_LIB_ID = "id";
    private static final String DB_LIB_NOM = "nombre";
    private static final String DB_LIB_PRE = "precio";



    //////////////////////////////////////////////////
    // MÉTODOS DE CONEXIÓN A LA BASE DE DATOS
    //////////////////////////////////////////////////
    ;

    /**
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
        } /*
            CORREGIR - CAPTURAR EXCEPCIÓN
          */
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
            ResultSet rs = getTablaLibros(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            /*
            CORREGIR - INTRODUCE EL BUCLE PARA RECORRER EL RESULTADO DE LA CONSULTA
            */
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
        try {
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "CORREGIR - INTRODUCE LA SENTENCIA SQL QUE SELECCIONA EL LIBRO ID";
            ResultSet rs = stmt.executeQuery(sql);

            // Si no hay primer registro entonces no existe el libro
            if (!rs.first()) {
                return null;
            }

            return rs;

        }  /*
            CORREGIR - CAPTURAR EXCEPCIÓN
          */
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
            int lid = rs.getInt(DB_LIB_ID);RE
            
            /*
            CORREGIR - OBTENER EL NOMBRE Y PRECIO DEL LIBRO PARA IMPRIMIR    
            */
            
            System.out.println("Libro " + lid + "\t" + nombre + "\t" + precio);

        }  /*
            CORREGIR - CAPTURAR EXCEPCIÓN
          */
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

            // Si tiene un primer registro, lo eliminamos
            if (rs.first()) {
                rs.updateString(DB_LIB_NOM, nuevoNombre);
                // CORREGIR - ACTUALIZAR EL PRECIO NUEVO

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
                rs.close();
                System.out.println("OK!");
                return true;
            } else {
                System.out.println("ERROR. ResultSet vacío.");
                return false;
            }

        }  /*
            CORREGIR - CAPTURAR EXCEPCIÓN
          */
        }
    }
}
