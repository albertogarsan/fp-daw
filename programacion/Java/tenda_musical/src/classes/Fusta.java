package classes;

public class Fusta extends Instrument {
    
    public enum Tonalitat {
        LA,
        SIB,
        DO,
        MIB;

        public String toUpperCase() {
            return null;
        }
    }

    //Atributs
    private Tonalitat tonalitat;
    private String material;
    
    //Constructor
    public Fusta(String nom, Double preu, String numSerie, Tonalitat tonalitat, String material) {
        super(nom, preu, numSerie);
        this.tonalitat = tonalitat;
        this.material = material;
    }


    //Mètode getters i setters
    public Tonalitat getTonalitat() {
        return tonalitat;
    }

    public void setTonalitat(Tonalitat tonalitat) {
        this.tonalitat = tonalitat;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    //Mètode toString()
    public String toString(){
        return "Instrument de fusta: \n" + super.toString() + ", Tonalitat: " + tonalitat +", Material: "+ material + "\n";
    }

    //Mètode abstracte
    public void mostrarInformacio(){
        System.out.println("Instrument de fusta\n Nº de serie: " + this.getNumSerie() + "\n Nom: " + this.getNom() + "\n Preu: " + this.getPreu() + "\n Tonalitat: " + this.tonalitat + "\n Material: " + this.material);
    }

    //Mètode interficie
    public void tocar(){
        System.out.println("La-la-la-liii");
    }

}
