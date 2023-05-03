package classes;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.ArrayList;
import java.util.Iterator;

//La interfaz Comparable en Java se utiliza para definir un orden natural de los objetos de una clase.

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

public abstract class Vehicle implements Comparable<Vehicle>, Iterable<Integer>, Serializable {
    //Atributs
    private String matricula; 
    private String nom; 
    private double preu; 
    private Boolean itv;
    private ArrayList<Integer> listaPreciosAntigua = new ArrayList<Integer>();
    private ArrayList<Integer> listaPreciosActual = new ArrayList<Integer>();

    
    //Constructor
    public Vehicle(String matricula, String nom, double preu, Boolean itv) {
        this.matricula = matricula;
        this.nom = nom;
        this.preu = preu;
        this.itv = itv;
        this.listaPreciosAntigua.add(1200);
        this.listaPreciosAntigua.add(3200);
        this.listaPreciosAntigua.add(240);
        this.listaPreciosActual.add(9800);
        this.listaPreciosActual.add(7200);
    }

    public Vehicle(String matricula, String nom, double preu) {
        this.matricula = matricula;
        this.nom = nom;
        this.preu = preu;
        this.listaPreciosAntigua.add(1200);
        this.listaPreciosAntigua.add(3200);
        this.listaPreciosAntigua.add(240);
        this.listaPreciosActual.add(9800);
        this.listaPreciosActual.add(7200);
    }

    //Mètodes
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    public Boolean getItv() {
        return itv;
    }

    public void setItv(Boolean itv) {
        this.itv = itv;
    }

    //Metodo de Comparable
    //Compara el objeto actual con otro objeto pasado como parámetro y devuelve un valor entero que indica si el objeto actual es menor, igual o mayor que el objeto comparado
    public int compareTo(Vehicle vehicle){
        return this.nom.compareTo(vehicle.nom);
    }

    //Metodes abstractes = les classes que hereten han de implementar este mètode i implementar la seua lògica pròpia.
    public abstract String mostrarInformacion();


    //Iterator se utiliza para recorrer colecciones de objetos y acceder a sus elementos secuencialmente.
    //IteradorDPrecios es el iterador. I baix creem un metode public per a accedir a ell.
    protected class IteradorDPrecios implements Iterator<Integer> {

        private int posicion = 0;

        //Seria com un for each
        @Override
        public boolean hasNext() {
            return posicion < listaPreciosAntigua.size() + listaPreciosActual.size();
        }

        //En el if comprova la quantitat d'elements del primer array i una vegada el sobrepassa, passa a l'else i amb logica recorrem els elements de la segona llista actualitzant l'index
        @Override
        public Integer next() {
            if (posicion < listaPreciosAntigua.size()) {
                return listaPreciosAntigua.get(posicion++);
            } else {
                int resultat = listaPreciosActual.get(posicion - listaPreciosAntigua.size());
                posicion++;
                return resultat;
            }
        }

    }

    //metode public per a accedir a l'iterador
    public Iterator<Integer> iterator() {
        return new IteradorDPrecios();
    } 
}
