package classes;

public class Metall extends Instrument {
    //Atributs
    private int diametre;
    private Boolean usat;
    
    //Constructor
    public Metall(String nom, Double preu, String numSerie, int diametre, Boolean usat) {
        super(nom, preu, numSerie);
        this.diametre = diametre;
        this.usat = usat;
    }

    //Mètodes Getters i Setters
    public int getDiametre() {
        return diametre;
    }


    public void setDiametre(int diametre) {
        this.diametre = diametre;
    }


    public Boolean getUsar() {
        return usat;
    }


    public void setUsar(Boolean usat) {
        this.usat = usat;
    }

    //Mètode toString
    public String toString(){
        return "Instrument de metall: \n" + super.toString() + ", Diàmetre: " + diametre +", Usat: "+ usat + "\n";
    }

    //Mètode abstracte
    @Override
    public void mostrarInformacio() {
        System.out.println("Instrument de metall:\n Nº de serie: " + this.getNumSerie() + "\n Nom: " + this.getNom() + "\n Preu: " + this.getPreu() + "\n Diàmetre: " + this.diametre + "\n Usat: " + this.usat);
    }

    //Mètode interficie
    public void tocar(){
        System.out.println("To-to-to-taaan");
    }

    
    
}
