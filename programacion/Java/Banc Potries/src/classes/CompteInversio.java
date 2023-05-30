package classes;

public class CompteInversio extends Compte{
    // Enumeració que defineix els tipus de monedes
    public enum Tipus {
        EURO,
        DOLAR,
        PENIQUES,
        DIRHAMS
    }

    // Atributs
    private Tipus tipusMoneda;

    // Constructor
    public CompteInversio(PersonaClient titular, double qDiners, Tipus tipusMoneda) {
        super(titular, qDiners);
        this.tipusMoneda = tipusMoneda;
    }

    public CompteInversio(PersonaClient titular, Tipus tipusMoneda) {
        super(titular);
        this.tipusMoneda = tipusMoneda;
    }

    // Mètodes
    public Tipus getTipusMoneda() {
        return tipusMoneda;
    }

    public void setTipusMoneda(Tipus tipusMoneda) {
        this.tipusMoneda = tipusMoneda;
    }

    @Override
    public String toString() {
        return "Compte Corrent \n" + super.toString() + "Tipus de moneda del compte:" + tipusMoneda + "\n";
    }

    @Override
    public void mostrarInformacio(){
        System.out.println("Compte Corrent\n Nom:   " + this.getTitular().getNom() + "\n Saldo: " + this.getqDiners() + "\n Tipus de moneda: " + this.tipusMoneda);
    }
    
}
