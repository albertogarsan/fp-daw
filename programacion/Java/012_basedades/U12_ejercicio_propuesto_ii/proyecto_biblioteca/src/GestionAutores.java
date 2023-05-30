public class GestionAutores {
    public static boolean menuAutores() {
        System.out.println("");
        System.out.println("SUBMENU - Gestión de autores");
        System.out.println("1. Crear Tabla Autores");
        System.out.println("2. Insertar Datos Iniciales");
        System.out.println("3. Listar Autores");
        System.out.println("4. Nuevo Autor");
        System.out.println("5. Modificar Autor");
        System.out.println("6. Eliminar Autor");
        System.out.println("7. Salir");

        int opcion = Leer.demanarInt("Elige una opción: ");
        switch (opcion) {

            case 1:
                crearTablaAutores();
                menuAutores();
                break;
            case 2:
                insertarDatosIniciales();
                menuAutores();
                break;
            case 3:
                listarAutores();
                menuAutores();
                break;
            case 4:
                nuevoAutor();
                menuAutores();
                break;
            case 5:
                modificarAutor();
                menuAutores();
                break;
            case 6:
                eliminarAutor();
                menuAutores();
                break;
            case 7:
                return Biblioteca.menuPrincipal();
            default:
                System.out.println("Opción elegida incorrecta");
        }
        return false;

    }

    public static void crearTablaAutores(){
        DBManager.crearTablaAutores();
    }
    public static void insertarDatosIniciales(){
        DBManager.insertarDatosIniciales();
    }
    public static void listarAutores(){
        DBManager.mostrarAutores();
    }
    public static void nuevoAutor(){
        System.out.println("\nIntroduce los datos del nuevo autor:");
        System.out.println("------------------------------------");
        String nombre = Leer.demanarString("Nombre: ");
        boolean res = DBManager.nuevoAutor(nombre);

        if(res) {
            System.out.println("Autor registrado correctamente");
        } else {

            System.out.println("Error :(");
        }
    }
    public static void modificarAutor(){
        DBManager.mostrarAutores();
        int id = Leer.demanarInt("Indica el id del autor a modificar: ");
        
        // Comprobamos si existe el libro
        if (!DBManager.existsLibro(id)) {
            System.out.println("El autor con id: " + id + " no existe.");
            return;
        }
    
        // Mostramos datos del libro a modificar
        DBManager.printAutor(id);
    
        // Solicitamos los nuevos datos
        String nuevoNombre = Leer.demanarString("Nuevo nombre: ");
    
        // Registramos los cambios
        boolean res = DBManager.modificarAutor(id, nuevoNombre);
        if (res) {
            System.out.println("Autor modificado correctamente");
        } else {
            System.out.println("Error :(");
        } 

        DBManager.mostrarAutores();
    }
    public static void eliminarAutor(){
        DBManager.mostrarAutores();
        int id = Leer.demanarInt("Indica el id del autor a eliminar: ");
        
        // Comprobamos si existe el libro
        if (!DBManager.existsAutor(id)) {
            System.out.println("El autor con id: " + id + " no existe."); 
            return;
        } 
        
        // Eliminamos el libro
        boolean res = DBManager.eliminarAutor(id);
        
        if (res) {
            System.out.println("Autor eliminado correctamente"); 
        } else {
            System.out.println("Error :(");
        }

        DBManager.mostrarAutores();
    }
}
