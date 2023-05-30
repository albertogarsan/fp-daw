package classes;

import java.io.Serializable;

import utils.Funcions;

public abstract class Instrument implements Afinable, Comparable<Instrument>, Serializable {
    
    //Atributs
    private String nom;
    private Double preu;
    private String numSerie;
    
    //Constructor
    public Instrument(String nom, Double preu, String numSerie) {
        this.nom = nom;
        this.preu = preu;
        this.numSerie = numSerie;
        Funcions.exportNumSerie(numSerie);
    }

    //Mètodes getters i setters
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public Double getPreu() {
        return preu;
    }
    public void setPreu(Double preu) {
        this.preu = preu;
    }
    public String getNumSerie() {
        return numSerie;
    }
    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    //Mètode toString()
    public String toString(){
        return "Nº de serie: " + numSerie + ", Nom: " + nom + ", Preu: " + preu;
    }

    //Mètode abstracte
    public abstract void mostrarInformacio();

    //Mètode de la interficie
    @Override
    public void afinar(String nota){
        System.out.println("Afinat a 440Hz");
    }

    //Mètode compareTo per nom
    public int compareTo(Instrument instrument){
        return this.getNom().compareTo(instrument.getNom());
    }
    
}
