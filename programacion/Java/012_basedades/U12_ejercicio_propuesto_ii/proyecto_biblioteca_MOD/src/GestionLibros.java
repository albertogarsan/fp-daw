public class GestionLibros {
    
    public static void menuLibros() {
        int opcion;
        do {
            System.out.println("");
            System.out.println("SUBMENU - Gestión de libros");
            System.out.println("1. Listar libros");
            System.out.println("2. Nuevo libro");
            System.out.println("3. Modificar libro");
            System.out.println("4. Eliminar libro");
            System.out.println("5. Asignar autor");
            System.out.println("0. Salir");

            opcion = Leer.demanarInt("Elige una opción: ");
            switch (opcion) {

                case 1:
                    opcionMostrarLibros();
                    break;
                case 2:
                    opcionNuevoLibro();
                    break;
                case 3:
                    opcionModificarLibro();
                    break;
                case 4:
                    opcionEliminarLibro();
                    break;
                case 5: 
                    asignarAutor();
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

    public static void asignarAutor(){
        System.out.println("Tabla de libros: ");
        DBManager.mostrarLibros();
        int idLibro = Leer.demanarInt("Indica el id del libro para asignárselo a un autor: ");
        
        System.out.println("Tabla de autores: ");
        DBManager.mostrarAutores();
        int idAutor = Leer.demanarInt("Indica el id del auto para asignárselo al libro: ");

        DBManager.asignarAutorALibro(idLibro, idAutor);
    }
}