public class Coche2mano extends Coche {
    //Atributos
    private int km;
    private int anys;

    //Constructor
    public Coche2mano(int numBastidor, String matricula, String marca, String modelo, String color, double precio,
                      int km, int anys) {
        super(numBastidor, matricula, marca, modelo, color, precio);
        this.km = km;
        this.anys = anys;
    }

    //Method
    public int getKm() {
        return this.km;
    }

    public int getAnys() {
        return this.anys;
    }

    //Setter (no cal normalment retornar res) - (actualizant el valor intern de l'objecte
    public void setKm(int km) {
        this.km += km;
    }

    public void setAnys(int anys) {
        this.anys += anys;
    }

    @Override
    public void mostrarInfo(){
        //Reimplementació de mostrarInfo de la classe mare: Coche.
        super.mostrarInfo();
        System.out.println("Km: " + this.km);
        System.out.println("Anys: " + this.anys);
    }

    public void revisar(boolean[] revisiones) {
        for (int i = 0; i < revisiones.length; i++) {
            super.revisiones[i] = revisiones[i];
        }

    }

}
