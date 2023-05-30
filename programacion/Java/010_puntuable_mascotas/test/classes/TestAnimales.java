package test.classes;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.Assert.*;
import classes.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestAnimales {
    Perro perro1;

    @BeforeAll
    public void setUp(){
        

        Date data1 = new Date();

        try {
            data1 =  new SimpleDateFormat("dd/MM/yyyy").parse("12/10/2020");
            
        } catch (ParseException e) {
            System.out.println("Error al parsear la fecha.");
            e.printStackTrace();
        }

        perro1 = new Perro("perro1", 4, 2, data1, "Jeremias", "Salchicha", true, 2);
        System.out.println("Perro 1 inicializado");
    }

    @Test
    public void testCodigo(){
    
        String valorEsperado = "perro1";
        String valorReal = this.perro1.getCodigo();
        assertEquals("El código del perro no es el esperado", valorEsperado, valorReal);
    }
}
