package classes;
import java.util.Random;

public abstract class Compte implements CompteBancari, Comparable<Compte> {
    Random random = new Random();

    //Atributs
    private int id;
    private PersonaClient titular;
    private double qDiners;
    private int qualificacio;
    private static int idMax = 1;
    

    //Constructor
    public Compte(PersonaClient titular, double qDiners) {
        this.id = idMax++;
        this.titular = titular;
        this.qDiners = qDiners;
        this.qualificacio =  random.nextInt(101); 
    }

    public Compte(PersonaClient titular) {
        this.id = idMax++;
        this.titular = titular;
        this.qDiners = 0;
        this.qualificacio =  random.nextInt(101); ;
    }


    //Mètodes
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PersonaClient getTitular() {
        return titular;
    }

    public void setTitular(PersonaClient titular) {
        this.titular = titular;
    }

    public double getqDiners() {
        return qDiners;
    }

    public void setqDiners(double qDiners) {
        this.qDiners = qDiners;
    }

    public int getQualificacio() {
        return qualificacio;
    }

    public void setQualificacio(int qualificacio) {
        this.qualificacio = qualificacio;
    }

    @Override
    public String toString(){
        return "Id: " + id + ", Titular: " + titular + ", Saldo: " + qDiners + ", Score: " + qualificacio;
    }
    
    //Mètodes propis

    //Mètodes de la interficie
    @Override
    public void ingressar(double qDiners){
        this.qDiners += qDiners;
    }

    @Override
    public void retirar(double qDiners){
        if (qDiners > this.qDiners) {
            System.out.println("No hi ha suficient diners");
            
        } else {
            this.qDiners -= qDiners;
        }
    }

    @Override
    public void transferir(Compte compteDestinament, double qDiners){
        if (qDiners > this.qDiners){
            System.out.println("No hi ha suficient diners");
        } else {
            this.retirar(qDiners);
            compteDestinament.ingressar(qDiners);
        }
    }

    //Mètode propi abstracte (és equivalent a una interface). Ens obliga a que tots els fill de la classe Compte implementen esta classe.
    public abstract void mostrarInformacio();

    public int compareTo(Compte compte){
        return this.getTitular().getNom().compareTo(compte.getTitular().getNom());
    }
}
