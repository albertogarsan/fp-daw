import utils.Leer;
import static utils.MenuComptes.menuComptes;
import static utils.MenuPersones.menuPersones;

public class App {
    
    static Leer lector = new Leer();

    public static void main(String[] args) throws Exception {
        menuPrincipal();
    }

    public static void menuPrincipal() { 
            
        int opcion;
        
        do {
            System.out.println(""); 
            System.out.println("BANC POPULAR DE POTRIES"); 
            System.out.println("1. Gestió de comptes");
            System.out.println("2. Gestió de persones");
            System.out.println("0. Sortir");
            
            opcion = lector.demanarInt("Elegeix una opció: ");
            
            switch (opcion) {
                case 1:
                    menuComptes();
                    break; 
                case 2:
                    menuPersones();
                    break; 
                case 0:
                    System.out.println("Fins a la pròxima!"); 
                
                default:
                    System.out.println("Opció no vàlida");
            }

        } while (opcion != 0);
    }
}


//La interfaz Comparable en Java se utiliza para definir un orden natural de los objetos de una clase.

// La interfaz nos recuerda que los métodos de la interfaz se deben implement en las clases que se implement la interfaz.

// COMPARABLE se utiliza comúnmente para ordenar colecciones de objetos en Java, como por ejemplo, ordenar una lista de estudiantes por su nombre o por su edad.

// compareTo() es un método definido en la interfaz Comparable, que se utiliza para comparar objetos de una clase que SI tienen un ORDEN natural DEFINIDO.

// COMPARATOR se utiliza para definir un orden personalizado de los objetos de una clase que NO tienen un orden natural o para ordenar objetos de una clase en múltiples formas.

// compare() es un método definido en la interfaz Comparator, que se utiliza para comparar objetos de una clase que NO tienen un ORDEN natural DEFINIDO o para ordenar objetos en múltiples formas.

// ITERABLE define una secuencia de elementos que se pueden iterar. Si implementan Iterable se puede garantizar que los objetos de esa clase se puedan recorrer de forma iterativa en un for each.

// ITERATOR se utiliza para recorrer colecciones de objetos y acceder a sus elementos secuencialmente.

// SERIALIZABLE es el proceso de convertir un objeto en una secuencia de bytes.

// Collections es una clase de utilidad que proporciona métodos estáticos para trabajar con colecciones de objetos.

// Collections.sort() = Ordena la lista dada en orden natural ascendente
// Collections.reverse(ArrayList<vehicle> vehicles) = Ordena la lista invirtiendo el orden dado
// Collections.shuffle(vehicles): Mezcla los elementos de la lista dada en orden aleatorio.
// Collections.max()
// Collections.min()