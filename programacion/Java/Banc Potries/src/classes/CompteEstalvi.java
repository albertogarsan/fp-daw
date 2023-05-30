package classes;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CompteEstalvi extends Compte {
    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    //Atributs
    private Date dataObertura;
    private int interes;
    
    public CompteEstalvi(PersonaClient titular, double qDiners, String dataObertura, int interes) {
        super(titular, qDiners);
        try {
            this.dataObertura = formatoFecha.parse(dataObertura);
        } catch (ParseException e){
            System.out.println("Error al fer parsing de la data");
        }
        this.interes = interes;
    }

    public CompteEstalvi(PersonaClient titular, int interes) {
        super(titular);
        this.dataObertura = new Date();
        this.interes = interes;
    }
    public CompteEstalvi(PersonaClient titular, Double qDiners) {
        super(titular, qDiners);
        this.dataObertura = new Date();
        this.interes = 0;
    }

    //Mètodes
    public Date getDataObertura() {
        return dataObertura;
    }

    public void setDataObertura(Date dataObertura) {
        this.dataObertura = dataObertura;
    }

    public int getInteres() {
        return interes;
    }

    public void setInteres(int interes) {
        this.interes = interes;
    }

    @Override
    public String toString() {
        return "Compte Corrent \n" + super.toString() + "Data d'obertura: " + formatoFecha.format(dataObertura) +"Interés: "+ interes + "\n";
    }

    @Override
    public void mostrarInformacio(){
        System.out.println("Compte Corrent\n Nom:   " + this.getTitular().getNom() + "\n Saldo: " + this.getqDiners() + "\n Interés: " + this.interes);
    }
}
