import java.io.File;
import java.io.FileNotFoundException;
import utils.Leer;

public class Main {
    
    static Leer lector = new Leer();

    public static void main(String[] args) {
        try{
            /* exercici1(); */
            /* exercici2(); */
            exercici3();
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public static void exercici1() throws FileNotFoundException {

        Boolean continuar = true;
        while (continuar) {
            String rutaUsuari = lector.demanarString("Introdueix una ruta d'arxiu o carpeta (p.e /carpeta, arxiu.txt): ");
            File fUsuari = new File(rutaUsuari);
            mostrarInfoRuta(fUsuari);

            continuar = lector.demanarBooleanSiNo("Vols continuar? (s/n): ");
        }

    }

    public static void mostrarInfoRuta(File f) throws FileNotFoundException {

        if (!f.exists()){
            throw new FileNotFoundException("El archivo no existe");
        }
        

        if (f.isFile()) {
            System.out.println("Es un archivo cuyo nombre es: " + f.getName());
        }
        
        if (f.isDirectory()) {
            
            File[] listadoDirectoriosArchivos = f.listFiles();

            System.out.println("Es una carpeta y estos son sus contenidos: ");
            for (File item : listadoDirectoriosArchivos) {
                if (item.isFile()) {
                    System.out.println("- " + item.getName());
                } else {
                    System.out.println("d " + item.getName());
                }
            }

        }
      

    }

    public static void exercici2() {
        File f1 = new File("exercici2/imagenes");
        File f2 = new File("exercici2/documentos");
        File f3 = new File("exercici2/movies");
        
        File fnew1 = new File("exercici2/IMGS");
        File fnew2 = new File("exercici2/DOCS");
        File fnew3 = new File("exercici2/PELIS");
        
        f1.renameTo(fnew1);
        f2.renameTo(fnew2);
        f3.renameTo(fnew3);
    }

    public static void exercici3() throws FileNotFoundException{
        
            String rutaUsuari = "exercici3/directori1";
            File f = new File(rutaUsuari);
            Boolean resultado = borraTodo(f);
            System.out.println("Se puede borrar? " + resultado);

    }

    public static Boolean borraTodo(File f) throws FileNotFoundException {
        
        if (!f.exists()){
            throw new FileNotFoundException("El archivo no existe");
        }

        if (f.isFile()) {
            f.delete();
            System.out.println("El archivo se ha borrado!!!");
        }
        
        if (f.isDirectory()) {
            
            File[] listadoDirectoriosArchivos = f.listFiles();

            for (File item : listadoDirectoriosArchivos) {
                /* Borra a un nivell
                item.delete(); */
                //Borra a tots els nivells
                borraTodo(item);
            }

            /* System.out.println("Se han borrado todos los contenidos :("); */

            f.delete();

            /* System.out.println("Y ahora las carpetas :((((("); */
            System.out.println("Se han borrado TODOS los contenidos y  la carpeta :((((((");

        }

        return true;
    }

}