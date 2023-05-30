package classes;

public interface CompteBancari {
    public void ingressar(double qDiners);
    public void retirar(double qDiners);
    public void transferir(Compte compteDestinament, double qDiners);
}
