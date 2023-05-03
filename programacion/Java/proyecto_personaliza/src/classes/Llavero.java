package classes;

public class Llavero extends Producto {

    // ATRIBUTS
    private boolean metalico;
    private int texto;


    //CONSTRUCTORS
    public Llavero() {
        super(0, 100);
        this.metalico = false;
        this.texto = 0;

    }

    public Llavero(float precio, int stock, boolean metalico, int texto) {
        super(precio, stock);
        this.metalico = metalico;
        this.texto = texto;

    }

}
