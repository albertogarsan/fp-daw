package utils;
import classes.Compte;
import classes.Comparadors.ComparadorID;
import classes.Comparadors.ComparadorQPreu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.lang.Iterable;

//En lloc de fer l'array list, fem una classe on farem sobre esta classe les operacions sobre l'arraylist. Ho fem aixi perque a part del metodes propis de larraylist, per a ferho escalable el fem en una classe per a poder utilitzar més mètodes per a donarli funcionalitat extra.
public class LlistatComptes implements Iterable<Compte>{
    private static ArrayList<Compte> llistatComptes = new ArrayList<Compte>();

    public void add(Compte nouCompte){
        llistatComptes.add(nouCompte);
    }

    public void remove(Compte compte){
        llistatComptes.remove(compte);
    }

    public void remove(int index){
        llistatComptes.remove(index);
    }

    public Boolean contains(Compte compte){
        return llistatComptes.contains(compte);
    }

    //Per a no fer (perquè no podem fer-ho perquè tindríem dos comptes diferents, perquè obtenim un nou objecte d'eixe tipus per tant sols l'instanciem en Funcions) declarem que esta siga static
    public static int size(){
        return llistatComptes.size();
    }

    /* public int sizeMod(){
        return llistatComptes.size();
    } */

    //Per a obtindre un compte
    public Compte get(int index){
        return llistatComptes.get(index);
    }

    public Compte getById(int id){
        for (Compte compte : llistatComptes){
            if (compte.getId() == id){
                return compte;
            }
        }
        return null;
    }

    public static void ordenarTitular(){
        Collections.sort(llistatComptes);
    }

    public static void ordenarId(){
        Collections.sort(llistatComptes, new ComparadorID());
    }
    public static void ordenarQPreu(){
        Collections.sort(llistatComptes, new ComparadorQPreu());
    }
    //provisiional fins a que tinguem el iterable
    /* public static void mostrarTots(){
        int index = 1;
        for (Compte compte : llistatComptes){
            System.out.println((index++) + ": " + compte);
        }
    }
 */
    //Iterator se utiliza para recorrer colecciones de objetos y acceder a sus elementos secuencialmente.
    //IteradorDPComptes es el iterador. I baix creem un metode public per a accedir a ell.
    protected class IteradorDComptes implements Iterator<Compte> {
        private int posicio = 0;

        //Seria com un for each
        @Override
        public boolean hasNext() {
            return posicio < llistatComptes.size();
        }
 
        @Override
        public Compte next() {
            return llistatComptes.get(posicio++);
        }
        
    }


    //metode public per a accedir a l'iterador
    public Iterator<Compte> iterator() {
        return new IteradorDComptes();
    } 
    
}
