package classes;

import java.util.ArrayList;

public final class Planeta extends Astro {
    // atributs
    private double distancia_sol;
    private double orbita;
    private ArrayList<Satelite> satelites = new ArrayList<Satelite>();

    // constructor per defecte
    public Planeta() {
        super();
        this.distancia_sol = 0;
        this.orbita = 0;
    }

    // constructor amb 4 arguments: nombre, radio, masa, distancia_sol
    public Planeta(String nombre, double radio, double masa, double distancia_sol) {
        super(nombre, radio, masa);
        this.distancia_sol = distancia_sol;
        this.orbita = 0;
    }

    // constructor amb 4 arguments: nombre, radio, masa, distancia_sol, satelites
    public Planeta(String nombre, double radio, double masa, double distancia_sol, ArrayList<Satelite> satelites) {
        super(nombre, radio, masa);
        this.distancia_sol = distancia_sol;
        this.orbita = 0;
        this.satelites = satelites;
    }

    // constructor amb tots els arguments
    public Planeta(String nombre, double radio, double masa, double rotacion, double temperatura, double distancia_sol,
                   double orbita, ArrayList<Satelite> satelites) {
        super(nombre, radio, masa, rotacion, temperatura);
        this.distancia_sol = distancia_sol;
        this.orbita = orbita;
        this.satelites = satelites;
    }

    // getters
    public double getDistanciaSol() {
        return this.distancia_sol;
    }

    public ArrayList<Satelite> getSatelites() {
        return this.satelites;
    }
    public int getNumSatelites() {
        return this.satelites.size();
    }

    // setters
    public void setDistanciaSol(String nuevaDistanciaString) {
        double nuevaDistancia = Double.parseDouble(nuevaDistanciaString);
        this.distancia_sol = nuevaDistancia;
    }

    public void setDistanciaSol(double nuevaDistancia) {
        this.distancia_sol = nuevaDistancia;
    }

    //Afegir satelite al arraylist amb el metode .add()
    public void addSatelite(Satelite nuevoSatelite) {
        this.satelites.add(nuevoSatelite);
    }

    // IMPLEMENTACIO METODES ABSTRACTES

    // calcula el pes en superficie d'un objecte de massa m
    public double pesoEnSuperficie(double m) {
        return m * this.getGravedad();
    }

    // mostra els valors dels atributs amb valor definit
    public void muestraDatos() {
        if (this.getNombre().length() > 0) {
            System.out.println("Nombre del Planeta: " + this.getNombre().toUpperCase());
        }
        if (this.getRadio() > 0) {
            System.out.println("Radio: " + this.getRadio()/1000 + " km");
        }
        if (this.getMasa() > 0) {
            System.out.println("Masa: " + this.getMasa() + " kg");
        }
        if (this.getRotacion() > 0) {
            System.out.println("Rotacion: " + this.getRotacion() + " s");
        }
        if (this.getTemperatura() > 0) {
            System.out.println("Temperatura: " + this.getTemperatura() + " K");
        }
        if (this.distancia_sol > 0) {
            System.out.println("Distancia al Sol: " + this.distancia_sol/1000 + " km");
        }
        if (this.orbita > 0) {
            System.out.println("Orbita: " + this.orbita);
        }
        if (this.satelites.size() > 0) {
            System.out.println("Satelites del planeta:");
            for (Satelite satelite : this.satelites) {
                System.out.println("- " + satelite.getNombre());
            }
        } else {
            System.out.println("El planeta no tiene satelites registrados.");
        }

        // if (this.satelites != null){ System.out.println("Su planeta es:
        // "+this.satelites.getNombre());}

    }

    @Override
    public String toString() {
        return this.getNombre() + " - masa: " + this.getMasa() + " kg. - radio: " + this.getRadio() / 1000 + " km. - dist_sol: "
                + this.distancia_sol / 1000 + " km.";
    }

}
