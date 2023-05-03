package classes;

public class Producto {

    //ATRIBUTS

    // Declarem variable estatica per a fer seguiment dels ids
    protected static int id = 0;

    // Atributs generals per a qualsevol producte
    protected String codigo;
    protected float precio;
    protected int stock;
    protected int iva;

    // CONSTRUCTORS
    // Constructor per defecTE
    public Producto() {
        // this.codigo = codigo;
        this.codigo = "P" + Producto.id++;
        this.precio = 0;
        this.stock = 0;
        this.iva = 21;

    }

    // Constructor amb arguments
    public Producto(float precio, int stock) {

        // this.codigo = codigo;
        this.codigo = "P" + Producto.id++;
        this.precio = precio;
        this.stock = stock;
        this.iva = 21;

    }


    // MÉTODES
    // Getter
    public float precioMasIva() {
        return this.precio * this.iva / 100;
    }

    // Setter, augmenta l-stock en m unitats
    public void aumentarStock(int m) {
        this.stock += m;
    }

    // Setter, disminueix l-stock en m unitats
    public void DisminuirStock(int m) {
        if (m > this.stock) {
            System.out.println("No se pueden reducir " + m + " unidades, solo hay " + this.stock + " unidades en stock.");
        } else {
            this.stock -= m;
        }
    }

    //toString
    @Override
    public String toString() {
        return this.codigo + " p: " + this.precio + " s: " + this.stock;
    }
}



