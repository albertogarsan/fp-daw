package classes;

public class Empleat {
    String nom;

    public Empleat(String nom) {
        this.nom = nom;
    }

    

    @Override
    public String toString() {
        return "Empleat [nom=" + nom + "]";
    }



    public String getNom() {
        return nom;
    }



    public void setNom(String nom) {
        this.nom = nom;
    }

    
    
    
}
