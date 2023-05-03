import static utils.Funcions.menu;

/**
 * @author Alberto Garcia
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        menu();
    }
}

/*
 * Se utilizará la estructura ArrayList, en la clase principal para gestionar los productos.
 * Se utilizarán 3 clases diferentes: producto, Llavero y Bolígrafo
 *
 * Clase producto:
 * - Un producto tiene un códifo (que tomara valores como "p1", un precio de venta, un IVA(%) y un stock (representa
 * la cantidad de ese artículo disponible en almacen).
 * El codido de un producto se establecerá automaticamente, es unico y no puede cambiar.
 * Estara formado por la letra "P"+numero entero (empezando en 1 y aumentando de 1 en 1)
 * El IVA es el mismo para todos los productos 21%
 * El stock ha de ser superior o igual a cero.
 * Deberá tener 2 constructories:
 * - Uno por fedecto que genere un producto con su codigo precio 0 y stock 0
 * - Un constructor general que cree un producto con todos sus atributos.
 * Incluir los getters y setters que sean necesarios.
 * Al imprimir un producto se mostrará el codigo, precio y stock con el siguiente formato:
 * "CODIGO p: precio s: stock"
 * La clase incluira un metodoprecioMasIva() que devolverá el resultado de aplicar el IVA al precio del prodcuto.
 * La clase incluirá un metodo aumentarStock(m) para aumentar el stock en m unidades
 * La clase incluirá un metodo disminuirStock(m) paara reducir el stock en m unidades indicando si se ha podido hacer
 * o no.
 *
 * Clase Llavero:
 * Un llavero es un tipo de Producto que además incluirá metálico (booleano para indicar si es metalico o de tela),
 * texto (número de letras que puede incluir para personalizarse).
 * Incluira un constructor general y la creacion de un llavero conllevara un stock inicial de 100 unidades
 *
 *
 * Clase Bolígrafo:
 * un boligrafo es un tipo de Producto que además incluirá color (plateado, negro, rojo, azul, verde) y texto (nuemro
 * de letras que puede incluir para personalizarse).
 * Incluirá un constructor general
 * Al imprimir un boligrafo se mostrará el código, color, stock y precio con el formato: "Boligrafo COLOR : STOCK a
 * PRECIO €"
 *
 * Clase Principal
 * Donde se implementará la gestión de los productos
 * 1. Alta de un producto: alta y se guardará en el arraylist
 * 2. Baja de un producto: se mostrara listado de proudctos para saber cual eliminar
 * 3. Listar precio con IVA de los productos: mostrar el codifo del producto y tipo de prodcuto y cual seria su precio
 *  con iva
 * 4. Modificar stock de un producto: mostrar listado de productos para seleccionar aquel que se quiere modificar el
 * stock (aumentar o reducir) haciendo la operacion para la cantidad indicada (teniendo en cuenta la restriccion del
 * stock)
 * 5. Salir
 *
 *
 * */