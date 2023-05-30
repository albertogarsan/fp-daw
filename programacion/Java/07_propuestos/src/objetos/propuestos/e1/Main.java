package objetos.propuestos.e1;

public class Main {
    public static void main(String[] args) {
        //Instanciació d'objectes
        IdPersona nombreCompleto = new IdPersona("Alberto", "Garcia", "Sanchez");
        Domicilio domicilio = new Domicilio("Calle 1", 4, 1, 2, 46721, "Carlet", "Valencia");
        Fecha fecha = new Fecha(20, 10, 2022);
        Tiempo tiempo = new Tiempo(20, 30, 40, 50);
        Concurso concurso = new Concurso("Concurso de fotografía", fecha, tiempo);
        Concursante concursante = new Concursante(nombreCompleto, "Garsan", domicilio, fecha, concurso);

        // Muestra el nombre completo
        System.out.println("Nombre completo: " + concursante.nombreCompleto.nombre + " " + concursante.nombreCompleto.primerApellido + " " + concursante.nombreCompleto.segundoApellido);

        // Muestra el nombre artistico
        System.out.println("Nombre artístico: " + concursante.nombreArtistico);

        // Muestra el domicilio
        System.out.println("Domicilio: " + concursante.domicilio.calle + " " + concursante.domicilio.numero + " " + concursante.domicilio.piso + " " + concursante.domicilio.puerta + " " + concursante.domicilio.codigoPostal + " " + concursante.domicilio.poblacion + " " + concursante.domicilio.provincia);

        // Muestra el año de nacimiento
        System.out.println("Año de nacimiento: " + concursante.fecha.year);

        // Muestra el concurso
        System.out.println("Concurso: " + concursante.concurso.titulo + " " + concursante.concurso.fecha.dia + "/" + concursante.concurso.fecha.mes + "/" + concursante.concurso.fecha.year);
    }
}
