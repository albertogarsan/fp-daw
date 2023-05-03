package classes;

public abstract class Astro {

    // atributs
    private String nombre;
    private double radio;
    private double masa;
    private double rotacion;
    private double temperatura;
    private double densidad;
    private double gravedad;
    private double G = 6.67384e-11;

    // constructor per defecte
    public Astro() {
        this.nombre = "";
        this.radio = 0;
        this.masa = 0;
        this.rotacion = 0;
        this.temperatura = 0;
        //Dividim la massa del planeta entre el volum del planeta (volum del planeta = 4 * Math.PI * Math.pow(radio,
        // 3) / 3)
        this.densidad = 3 * this.masa / (4 * Math.PI * Math.pow(this.radio, 3));
        this.gravedad = G * this.masa / Math.pow(this.radio, 2);
    }

    // constructor amb 3 arguments: nombre, radio, masa
    public Astro(String nombre, double radio, double masa) {
        this.nombre = nombre;
        this.radio = radio;
        this.masa = masa;
        this.rotacion = 0;
        this.temperatura = 0;
        this.densidad = 3 * this.masa / (4 * Math.PI * Math.pow(this.radio, 2));
        this.gravedad = G * this.masa / Math.pow(this.radio, 2);
    }

    // constructor amb tots els arguments
    public Astro(String nombre, double radio, double masa, double rotacion, double temperatura) {
        this.nombre = nombre;
        this.radio = radio;
        this.masa = masa;
        this.rotacion = rotacion;
        this.temperatura = temperatura;
        this.densidad = 3 * this.masa / (4 * Math.PI * Math.pow(this.radio, 2));
        this.gravedad = G * this.masa / Math.pow(this.radio, 2);
    }

    // getters
    public String getNombre() {
        return this.nombre;
    }

    public double getRadio() {
        return this.radio;
    }

    public double getMasa() {
        return this.masa;
    }

    public double getRotacion() {
        return this.rotacion;
    }

    public double getTemperatura() {
        return this.temperatura;
    }

    public double getGravedad(){
        return this.gravedad;
    }

    // setters (establir)
    public void setNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }

    public void setRadio(String nuevoRadioString) {
        double nuevoRadio = Double.parseDouble(nuevoRadioString);
        this.radio = nuevoRadio;
    }

    //Si utlitzem Leer no cal parsejar-lo a String, directament double perquè la variable que obtenim ja és un double.
    public void setRadio(double nuevoRadio) {
        this.radio = nuevoRadio;
    }

    //Lo mateix passa ací
    public void setMasa(String nuevaMasaString) {
        double nuevaMasa = Double.parseDouble(nuevaMasaString);
        this.masa = nuevaMasa;
    }

    public void setMasa(double nuevaMasa) {
        this.masa = nuevaMasa;
    }

    // metodes abstractes (són mètodes que s'han d'implementar/definir/existir en les classes filles)
    public abstract void muestraDatos();

    public abstract double pesoEnSuperficie(double m);
}
