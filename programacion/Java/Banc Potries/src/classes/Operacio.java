package classes;
import java.util.Date;
//import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Operacio {
    //per a mostrar per pantalla utilitzem açò
    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    public enum TipusOperacio {
        INGRES,
        RETIRADA
    }
    
    private Date dataOperacio;
    private Compte compte;
    private Double qDiners;
    private TipusOperacio operacio;
    private Boolean esTransferencia;
    
    public Operacio(Compte compte, Double qDiners, TipusOperacio operacio, Boolean esTransferencia) {
        //
        this.dataOperacio = new Date();
        this.compte = compte;
        this.qDiners = qDiners;
        this.operacio = operacio;
        this.esTransferencia = esTransferencia;
    }

    public Operacio(Compte compte, Double qDiners, TipusOperacio operacio) {
        this.dataOperacio = new Date();
        this.compte = compte;
        this.qDiners = qDiners;
        this.operacio = operacio;
        this.esTransferencia = false;
    }

    public Operacio(Compte compte, Date data, Double qDiners, TipusOperacio operacio, Boolean esTransferencia) {
        //
        this.dataOperacio = data;
        this.compte = compte;
        this.qDiners = qDiners;
        this.operacio = operacio;
        this.esTransferencia = esTransferencia;
    }

    public Date getDataOperacio() {
        return dataOperacio;
    }

    public Compte getCompte() {
        return compte;
    }

    public Double getqDiners() {
        return qDiners;
    }

    public TipusOperacio getOperacio() {
        return operacio;
    }

    public Boolean getEsTransferencia() {
        return esTransferencia;
    }

    @Override
    public String toString() {
        return "Data operacio: " + formatoFecha.format(dataOperacio) + ", Compte: " + compte.getId() + ", qDiners:" + qDiners + ", Operacio:" + operacio + ", esTransferencia:" + esTransferencia;
    }

   //Setters no fan falta perquè en un log sols necessitem dades estàtiques. no podem permetre que ningú canvie o modifique dades.

   
    
}
