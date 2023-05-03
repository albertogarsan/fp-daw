package classes;

public class Cotxe extends Vehicle implements QuatreRodes {
    //Atributs
    private int qPortes;
    private Boolean maleter;
    
    //Constructor
    public Cotxe(String matricula, String nom, double preu, Boolean itv, int qPortes, Boolean maleter) {
        super(matricula, nom, preu, itv);
        this.qPortes = qPortes;
        this.maleter = maleter;
    }
    public Cotxe(String matricula, String nom, double preu, int qPortes, Boolean maleter) {
        super(matricula, nom, preu);
        this.qPortes = qPortes;
        this.maleter = maleter;
    }

    //Mètodes
    public int getqPortes() {
        return qPortes;
    }
    public void setqPortes(int qPortes) {
        this.qPortes = qPortes;
    }
    public Boolean getMaleter() {
        return maleter;
    }
    public void setMaleter(Boolean maleter) {
        this.maleter = maleter;
    }

    public String mostrarInformacion(){
        String textITV;
        if (this.getItv() == true) {
            textITV = "";
        } else {
            textITV = "no";
        }

        String textMaleter;
        if (this.maleter == true) {
            textMaleter = "";
        } else {
            textMaleter = "no";
        }

        return "El nom del cotxe és " +this.getNom()+ ", amb matrícula  "+this.getMatricula()+ ", amb un preu de "+this.getNom()+" €, "+textITV+" ha passat la ITV, té "+this.getqPortes()+" portes i "+textMaleter+" té maleter.";
    }

    public String toString() {
        return "Tipo: Cotxe \tNom: "+ this.getNom() +" \tMatrícula: "+this.getMatricula()+ " \tPreu: "+this.getPreu();
    }

    //Mètodes de la interface
    @Override
    public void pesMaxim() {
        System.out.println("El pes màxim d'un cotxe són 3200kg");
    }

    @Override
    public void capacitatMaleter() {
        System.out.println("La capacitat màxima del maleter és de 500 litres.");
    }
}
