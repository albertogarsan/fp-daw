package classes;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class PersonaClient extends Persona {
    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
    
    //Data d'alta
    private Date dataAlta;
    //Llistat d'operacions del client en concret
    private ArrayList<Operacio> llistatOperacionsClient; 


    //Constructors
    public PersonaClient(String nom, int edat, String direccio, Compte compte) {
        super(nom, edat, direccio, compte);
        this.dataAlta = new Date();
        this.llistatOperacionsClient = new ArrayList<Operacio>();
    }

    public PersonaClient(String nom, int edat, String direccio) {
        super(nom, edat, direccio, null);
        this.dataAlta = new Date();
        this.llistatOperacionsClient = new ArrayList<Operacio>();
    }

    public PersonaClient(String nom) {
        super(nom);
        this.dataAlta = new Date();
        this.llistatOperacionsClient = new ArrayList<Operacio>();
    }


    public Date getDataAlta() {
        return dataAlta;
    }

    public String getDataAltaString() {
        return formatoFecha.format(dataAlta);
    }


    public ArrayList<Operacio> getLlistatOperacionsClient() {
        return llistatOperacionsClient;
    }

    public void setLlistatOperacionsClient(ArrayList<Operacio> llistatOperacionsClient) {
        this.llistatOperacionsClient = llistatOperacionsClient;
    } 

    public void addOperacio(Operacio novaOperacio){
        llistatOperacionsClient.add(novaOperacio);
    }

    

    public void mostrarInformacio(){
        System.out.println("Client \nNom: " + this.getNom() + "\n Edat: "+ this.getEdad() + "\n Direcció: " + this.getDireccion() + "\n Data d'alta: " + this.getDataAltaString());
    }

    public SimpleDateFormat getFormatoFecha() {
        return formatoFecha;
    }

    @Override
    public String toString() {
        return "PersonaClient \n" + super.toString() + "Data d'alta= " + formatoFecha.format(dataAlta);
    }

    

    
}

