package classes;

public class Moto extends Vehicle {
    //Atributs
    private int qRodes;

    public Moto(String matricula, String nom, double preu, Boolean itv, int qRodes) {
        super(matricula, nom, preu, itv);
        this.qRodes = qRodes;
    }

    public Moto(String matricula, String nom, double preu, int qRodes) {
        super(matricula, nom, preu);
        this.qRodes = qRodes;
    }

    public int getqRodes() {
        return qRodes;
    }

    public void setqRodes(int qRodes) {
        this.qRodes = qRodes;
    }

    public String mostrarInformacion(){
        return "El nom de la moto és " +this.getNom()+ ", amb matrícula  "+this.getMatricula()+ ", amb un preu de "+this.getPreu()+" €, i la quantitat de rodes de la moto és "+this.qRodes;
    }

    public String toString(){
        return "Tipo: Moto \tNom: "+ this.getNom() +" \tMatrícula: "+this.getMatricula()+ " \tPreu: "+this.getPreu();
    }
}
