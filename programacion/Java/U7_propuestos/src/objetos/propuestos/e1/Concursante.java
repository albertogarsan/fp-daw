package objetos.propuestos.e1;

public class Concursante {
    //Un concursante: nombre completo, nombre artístico, domicilio, año de nacimiento y concurso

    //Atributos
    IdPersona nombreCompleto;
    String nombreArtistico;
    Domicilio domicilio;
    Fecha fecha;
    Concurso concurso;

    //Constructor
    public Concursante(IdPersona nombreCompleto, String nombreArtistico, Domicilio domicilio, Fecha fecha,
                       Concurso concurso) {
        this.nombreCompleto = nombreCompleto;
        this.nombreArtistico = nombreArtistico;
        this.domicilio = domicilio;
        this.fecha = fecha;
        this.concurso = concurso;
    }

    //Metodos
}
