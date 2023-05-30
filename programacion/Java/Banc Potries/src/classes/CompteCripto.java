package classes;

public class CompteCripto extends Compte {

    //Atributs
    private String email;

    //Constructor
    public CompteCripto(PersonaClient titular, double qDiners, String email) {
        super(titular, qDiners);
        this.email = email;
    }
    public CompteCripto(PersonaClient titular, String email) {
        super(titular);
        this.email = email;
    }
   

    //Mètodes
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString(){
        return "Compte Cripto \n" + super.toString() + "\n" + "Email: " + email;
    }

    //Mètode propi
    public void mostrarInformacio(){
        System.out.println("Compte Cripto\n Nom:     " + this.getTitular().getNom() + "\n Saldo:   " + this.getqDiners() + "\n Email:   " + this.email);
    }


}
