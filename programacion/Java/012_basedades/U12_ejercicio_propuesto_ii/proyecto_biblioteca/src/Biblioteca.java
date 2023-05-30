
public class Biblioteca {
    public static void main(String[] args) {
        DBManager.loadDriver();
        DBManager.connect();
        menuPrincipal();
        /* boolean salir = false;
        do {
            salir = menuPrincipal();
        } while (!salir);
        DBManager.close(); */
    }

    public static boolean menuPrincipal() { 
        System.out.println(""); 
        System.out.println("MENU PRINCIPAL"); 
        System.out.println("1. Gestión de libros");
        System.out.println("2. Gestión de autores");
        System.out.println("0. Salir");
        
        int opcion = Leer.demanarInt("Elige una opción: ");
        
        switch (opcion) {
            case 1:
                GestionLibros.menuLibros();
                break; 
            case 2:
                GestionAutores.menuAutores();
                break; 
            case 0:
                System.out.println("Saliendo"); 
                DBManager.close();
                return true;
            default:
                System.out.println("Opción no válida");
        }
        return false;
    }
}
