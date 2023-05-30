package classes;
import classes.comparadores.*;
import java.util.ArrayList;
import utils.Leer;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.Objects;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class ListaAnimales implements Iterable<Animal> {
    static Leer lector = new Leer();

    //Atributs
    private ArrayList<Animal> listaAnimales;

    //Construct
    public ListaAnimales() {
        listaAnimales = new ArrayList<Animal>();
    }

    //Metodes
    public void anadirAnimal() throws ErrorRangoEdad {
        //Elegir quin tipo d'animal anem a posar
        int opcio = lector.demanarIntOpcio(1 ,4, "Elige el tipo de animal (1 = perro; 2 = gato; 3 = loro; 4 = " + "gallina): ");

        //Atributs comuns a tots els animals
        String codigo = lector.demanarString("Introduce un código de animal: ");
        int qpatas = lector.demanarInt("Introduce el número de patas:");
        int edad = lector.demanarInt("Introduce la edad: ");
        if (edad < 0) {
            throw new ErrorRangoEdad("La edad no puede ser negativa");
        } if (edad > 100) {
            throw new ErrorRangoEdad("La edad no puede ser superior a 100.");
        }
        String dataString = lector.demanarString("Introduce la fecha en formato dd/mm/yyyy: ");
        //He hagut de crear una data per defecte.
        Date data = new Date();
        try {
            data =  new SimpleDateFormat("dd/MM/yyyy").parse(dataString);
        } catch (ParseException e) {
            System.out.println("Error al parsear la fecha.");
            e.printStackTrace();
        }

        //Atributs propis segons l'opció triada
        switch (opcio) {
            case 1:
                String nombrePerro = lector.demanarString("Introduce un nombre: ");
                String razaPerro = lector.demanarString("Introduce una raza: ");
                boolean desparasitado = lector.demanarBooleanSiNo("Está desparasitado? (S/N): ");
                int numVacunas = lector.demanarInt("Numero de vacunas: ");

                //Inicializar/crear un perro
                Perro perro = new Perro(codigo, qpatas, edad, data, nombrePerro, razaPerro, desparasitado, numVacunas);

                //Añadir al arrayList
                listaAnimales.add(perro);
                System.out.println("Se ha añadido el gato correctamente.");
                break;
            case 2:
                String nombreGato = lector.demanarString("Introduce un nombre: ");
                String razaGato = lector.demanarString("Introduce una raza: ");
                boolean peloLargo = lector.demanarBooleanSiNo("Tiene el pelo largo? (S/N); ");

                //Inicializar gato
                Gato gato = new Gato(codigo, qpatas, edad, data, nombreGato, razaGato, peloLargo);

                //Añadir al arrayLit
                listaAnimales.add(gato);
                System.out.println("Se ha añadido el gato correctamente.");
                break;
            case 3:
                boolean picoLoro = lector.demanarBooleanSiNo("Tiene pico? (S/N): ");
                boolean vuelaLoro = lector.demanarBooleanSiNo("Vuela? (S/N): ");
                String nombreLoro = lector.demanarString("Introduce un nombre: ");
                String tipo = lector.demanarString("Introduce un tipo: ");
                boolean habla = lector.demanarBooleanSiNo("Habla? (S/N): ");

                //Inicializar loro
                Loro loro = new Loro(codigo, qpatas, edad, data, picoLoro, vuelaLoro, nombreLoro, tipo, habla);

                //Añadir al arrayLit
                listaAnimales.add(loro);
                System.out.println("Se ha añadido el loro correctamente.");
                break;
            case 4:
                boolean picoGallina = lector.demanarBooleanSiNo("Tiene pico? (S/N): ");
                boolean vuelaGallina = lector.demanarBooleanSiNo("Vuela? (S/N): ");
                boolean ponedora = lector.demanarBooleanSiNo("Es ponedora? (S/N): ");

                //Inicializar gallina
                Gallina gallina = new Gallina(codigo, qpatas, edad, data, picoGallina, vuelaGallina,ponedora);

                //Añadir al arrayLit
                listaAnimales.add(gallina);
                System.out.println("Se ha añadido la gallina correctamente.");
                break;
        }
    }

    public void mostrarListaAnimales(){
        int contador = 1;
        for (Animal animal : listaAnimales) {
            System.out.println((contador++) + " ) " + animal.getClass().getSimpleName() + " - " + animal.getCodigo());
        }
    }

    public void eliminarAnimal(){
        /* int contador = 1;
        System.out.println("Estos son los animales disponibles en la lista de animales: ");
        for (Animal animal : listaAnimales) {
            System.out.println((contador++) + " ) " + animal.getClass().getSimpleName() + " - " + animal.getCodigo());
        }
        int opcio = lector.demanarIntOpcio(1, listaAnimales.size(), "Cuál quieres eliminar? :");
        listaAnimales.remove(opcio - 1);
        System.out.println("Se ha eliminado correctamente."); */
        
        Iterator<Animal> it = listaAnimales.iterator();
        int opcio = lector.demanarIntOpcio(1, listaAnimales.size(), "Cuál quieres eliminar? :");

        while(it.hasNext()){
            Animal comprovacio = it.next();
            if (Objects.equals(comprovacio, listaAnimales.get(opcio -1 ))){
                it.remove();
            }
        }

        System.out.println(listaAnimales);
    }

    public void ordenarAnimalesCodigo() {
        /*Collections.sort(listaAnimales, new ComparadorAnimalesCodigo());*/
        Collections.sort(listaAnimales);
    }

    public void ordenarAnimalesTipo() {
        Collections.sort(listaAnimales, new ComparadorAnimalesTipo());
    }

    public ArrayList<Animal> getListaAnimales() {
        return listaAnimales;
    }

    @Override
    public Iterator<Animal> iterator() {
        return listaAnimales.iterator();
    }
}
