public class GestionAutores {
    public static void menuAutores() {
        int opcion;
        do {
            System.out.println("");
            System.out.println("SUBMENU - Gestión de autores");
            System.out.println("1. Crear Tabla Autores");
            System.out.println("2. Insertar Datos Iniciales");
            System.out.println("3. Listar Autores");
            System.out.println("4. Nuevo Autor");
            System.out.println("5. Modificar Autor");
            System.out.println("6. Eliminar Autor");
            System.out.println("7. Asinar libro");
            System.out.println("0. Salir");
            
            opcion = Leer.demanarInt("Elige una opción: ");
            switch (opcion) {
    
                case 1:
                    crearTablaAutores();
                    break;
                case 2:
                    insertarDatosIniciales();
                    break;
                case 3:
                    listarAutores();
                    break;
                case 4:
                    nuevoAutor();
                    break;
                case 5:
                    modificarAutor();
                    break;
                case 6:
                    eliminarAutor();
                    break;
                case 7:
                    asignarLibro();
                    break;
                case 0:
                    Biblioteca.menuPrincipal();
                    break;
                default:
                    System.out.println("Opción elegida incorrecta");
            }
            //return false;
        } while (opcion != 0);
    
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

    public static void asignarLibro(){
        //Asignar libro a autor
        System.out.println("Tabla de autores: ");
        DBManager.mostrarAutores();
        int idAutor = Leer.demanarInt("Indica el id del auto para asignárselo al libro: ");

        System.out.println("Tabla de libros: ");
        DBManager.mostrarLibros();
        int idLibro = Leer.demanarInt("Indica el id del libro para asignárselo a un autor: ");

        DBManager.asignarAutorALibro(idLibro, idAutor);
    }
}
