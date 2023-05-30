public class GestionLibros {
    
    public static boolean menuLibros() {
        System.out.println("");
        System.out.println("SUBMENU - Gestión de libros");
        System.out.println("1. Listar libros");
        System.out.println("2. Nuevo libro");
        System.out.println("3. Modificar libro");
        System.out.println("4. Eliminar libro");
        System.out.println("5. Salir");

        int opcion = Leer.demanarInt("Elige una opción: ");
        switch (opcion) {

            case 1:
                opcionMostrarLibros();
                menuLibros();
                break;
            case 2:
                opcionNuevoLibro();
                menuLibros();
                break;
            case 3:
                opcionModificarLibro();
                menuLibros();
                break;
            case 4:
                opcionEliminarLibro();
                menuLibros();
                break;
            case 5:
                return Biblioteca.menuPrincipal();
            default:
                System.out.println("Opción elegida incorrecta");
        }
        return false;

    }

    public static void opcionMostrarLibros() {
        System.out.println("\nListado de Libros:");
        System.out.println("------------------");

        DBManager.mostrarLibros();
    }

    public static void opcionNuevoLibro() {
        System.out.println("\nIntroduce los datos del nuevo libro:");
        System.out.println("------------------------------------");
        String nombre = Leer.demanarString("Nombre: ");
        Double precio = Leer.demanarDouble("Precio: ");

        boolean res = DBManager.nuevoLibro(nombre, precio);

        if(res) {
            System.out.println("Libro registrado correctamente");
        } else {

            System.out.println("Error :(");
        }
    }
    

    public static void opcionModificarLibro() {
        
        int id = Leer.demanarInt("Indica el id del libro a modificar: ");
        
        // Comprobamos si existe el libro
        if (!DBManager.existsLibro(id)) {
            System.out.println("El libro " + id + " no existe.");
            return;
        }
    
        // Mostramos datos del libro a modificar
        DBManager.printLibro(id);
    
        // Solicitamos los nuevos datos
        String nuevoNombre = Leer.demanarString("Nuevo nombre: ");
        Double nuevoPrecio = Leer.demanarDouble("Nuevo precio: ");
    
        // Registramos los cambios
        boolean res = DBManager.modificarLibro(id, nuevoNombre, nuevoPrecio);
        if (res) {
            System.out.println("Libro modificado correctamente");
        } else {
            System.out.println("Error :(");
        } 
    }

    public static void opcionEliminarLibro() {
        int id = Leer.demanarInt("Indica el id del libro a eliminar: ");
        
        // Comprobamos si existe el libro
        if (!DBManager.existsLibro(id)) {
            System.out.println("El libro " + id + " no existe."); 
            return;
        } 
        
        // Eliminamos el libro
        boolean res = DBManager.eliminarLibro(id);
        
        if (res) {
            System.out.println("Libro eliminado correctamente"); 
        } else {
            System.out.println("Error :(");
        }
    }
}