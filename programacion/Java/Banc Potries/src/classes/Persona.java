package classes;

public abstract class Persona implements Comparable<Persona>{
    private String nom;
    private int edat;
    private String direccio;
    private Compte compte;

    // Constructor
    public Persona(String nom, int edat, String direccio, Compte compte) {
        this.nom = nom;
        this.edat = edat;
        this.direccio = direccio;
        this.compte = compte;
    }
    public Persona(String nom) {
        this.nom = nom;
        this.edat = 0;
        this.direccio = null;
        this.compte = null;
    }

    // Métodos getter y setter
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getEdad() {
        return edat;
    }

    public void setEdad(int edat) {
        this.edat = edat;
    }

    public String getDireccion() {
        return direccio;
    }

    public void setDireccion(String direccio) {
        this.direccio = direccio;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public int compareTo(Persona persona){
        return this.getNom().compareTo(persona.getNom());
    }
    @Override
    public String toString() {
        return "Nom " + nom + ", edat " + edat + ", direccio " + direccio;
    }

    
}

