package classes;

public class Furgoneta extends Vehicle implements QuatreRodes {
    //Atributs
    private Boolean portaCorredera;
    private String tipo;
    
    //Constructor
    public Furgoneta(String matricula, String nom, double preu, Boolean itv, Boolean portaCorredera, String tipo) {
        super(matricula, nom, preu, itv);
        this.portaCorredera = portaCorredera;
        this.tipo = tipo;
    }
    public Furgoneta(String matricula, String nom, double preu, Boolean portaCorredera, String tipo) {
        super(matricula, nom, preu);
        this.portaCorredera = portaCorredera;
        this.tipo = tipo;
    }
    

    //Mètodes
    public Boolean getPortaCorredera() {
        return portaCorredera;
    }
    public void setPortaCorredera(Boolean portaCorredera) {
        this.portaCorredera = portaCorredera;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String mostrarInformacion(){
        return "El nom de la furgoneta és " +this.getNom()+ ", amb matrícula  "+this.getMatricula()+ ", amb un preu de "+this.getPreu()+" €, "+(this.portaCorredera ? "" : "no")+ " té porta corredera "+ (this.getItv() ? "" : "no")+" ha passat la ITV, i el tipo de furgoneta és "+this.tipo;
    }

    
    public String toString() {
        return "Tipo: Furgoneta \tNom: "+ this.getNom() +" \tMatrícula: "+this.getMatricula()+ " \tPreu: "+this.getPreu();
    }

    //Mètodes de la interface
    @Override
    public void pesMaxim() {
        System.out.println("El pes màxim d'una furgoneta és 6400kg");
    }

    @Override
    public void capacitatMaleter() {
        System.out.println("La capacitat màxima del maleter és de 16000 litres.");
    }
}
