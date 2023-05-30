package classes;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CompteCorrent extends Compte {
    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");

    //Atributs
    private Date dataObertura;
    private Boolean bonificacio;

    //Constructor
    public CompteCorrent(PersonaClient titular, double qDiners, String dataObertura, Boolean bonificacio) {
        super(titular, qDiners);
        try {
            this.dataObertura = formatoFecha.parse(dataObertura);
        } catch (ParseException e){
            System.out.println("Error al fer parsing de la data");
        }
        this.bonificacio = bonificacio;
    }

    public CompteCorrent(PersonaClient titular, double qDiners, Boolean bonificacio) {
        super(titular, qDiners);
        this.dataObertura = new Date();
        this.bonificacio = bonificacio;
    }

    public CompteCorrent(PersonaClient titular, double qDiners) {
        super(titular, qDiners);
        this.dataObertura = new Date();
        this.bonificacio = false;
    }
    
    public CompteCorrent(PersonaClient titular, String dataObertura, Boolean bonificacio) {
        super(titular);
        try {this.dataObertura = formatoFecha.parse(dataObertura);} catch (ParseException e){
            System.out.println("Error al fer parsing de la data");
        }
        this.bonificacio = bonificacio;
    }



    //Mètodes
    public Date getDataObertura() {
        return dataObertura;
    }

    public void setDataObertura(Date dataObertura) {
        this.dataObertura = dataObertura;
    }

    public Boolean getBonificacio() {
        return bonificacio;
    }


    public void setBonificacio(Boolean bonificacio) {
        this.bonificacio = bonificacio;
    }


    public String toString(){
        return "Compte Corrent \n" + super.toString() + "Data d'obertura: " + formatoFecha.format(dataObertura) +"Bonificació: "+ bonificacio + "\n";
    }

    //Mètode propi
    public void mostrarInformacio(){
        System.out.println("Compte Corrent\n Nom:   " + this.getTitular().getNom() + "\n Saldo: " + this.getqDiners() + "\n Bonif: " + this.bonificacio);
    }

    /* @Override
    public Iterator<Integer> iterator() {
        
    } */

}
