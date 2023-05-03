package classes;

public final class Satelite extends Astro {
    // atributs
    private double distancia_planeta;
    private int orbita;
    private Planeta planeta;

    // constructor per defecte
    public Satelite() {
        super();
        this.distancia_planeta = 0;
        this.orbita = 0;
    }

    // constructor amb 4 arguments: nombre, radio, masa, distancia_sol
    public Satelite(String nombre, double radio, double masa, double distancia_planeta) {
        super(nombre, radio, masa);
        this.distancia_planeta = distancia_planeta;
        this.orbita = 0;
    }

    // constructor amb 4 arguments: nombre, radio, masa, distancia_sol, satelites
    public Satelite(String nombre, double radio, double masa, double distancia_planeta, Planeta planeta) {
        super(nombre, radio, masa);
        this.distancia_planeta = distancia_planeta;
        this.orbita = 0;
        this.planeta = planeta;
    }

    // constructor amb tots els arguments
    public Satelite(String nombre, double radio, double masa, double rotacion, double temperatura,
                    double distancia_planeta, int orbita, Planeta planeta) {
        super(nombre, radio, masa, rotacion, temperatura);
        this.distancia_planeta = distancia_planeta;
        this.orbita = orbita;
        this.planeta = planeta;
    }

    // getters
    public double getDistanciaPlaneta() {
        return this.distancia_planeta;
    }

    public Planeta getPlaneta() {
        return this.planeta;
    }

    // setters
    public void setPlaneta(Planeta planeta) {
        this.planeta = planeta;
    }

    // IMPLEMENTACIO METODES ABSTRACTES

    // calcula el pes en superficie d'un objecte de massa m
    public double pesoEnSuperficie(double m) {
        return m * this.getGravedad();
    }

    // mostra els valors dels atributs amb valor
    public void muestraDatos() {
        if (this.getNombre().length() > 0) {
            System.out.println("Nombre del Satelite: " + this.getNombre().toUpperCase());
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
        if (this.distancia_planeta > 0) {
            System.out.println("Distancia planeta: " + this.distancia_planeta/1000 + " km");
        }
        if (this.orbita > 0) {
            System.out.println("Orbita: " + this.orbita);
        }
        if (this.planeta != null) {
            System.out.println("Su planeta es: " + this.planeta.getNombre());
        }

    }

    @Override
    public String toString() {
        return this.getNombre() + " - masa: " + this.getMasa() + " kg. - radio: " + this.getRadio() / 1000 + " km. - " +
                "dist_planeta: "
                + this.distancia_planeta / 1000 + " km.";
    }

    //
}
