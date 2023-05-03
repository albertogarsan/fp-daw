package classes;

public class Boligrafo extends Producto {

    //ATRIBUTS
    private String color;
    private int texto;

    //CONSTRUCTORS
    public Boligrafo() {
        super(0, 100);
        this.color = "Plateado";
        this.texto = 0;

    }

    public Boligrafo(float precio, int stock, String color, int texto) {
        super(precio, stock);
        this.color = color;
        this.texto = texto;

    }

    //METODE
    @Override
    public String toString() {
        return "Boligrafo " + this.color.toUpperCase() + ": " + this.stock + " a " + this.precio + " €";
    }

}
