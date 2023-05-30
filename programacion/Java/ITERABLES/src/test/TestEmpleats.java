package test;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;
import classes.*;

public class TestEmpleats{
    @Test
    @DisplayName("Test nom")
    public void testNom(){
        Empleat empleat1 = new Empleat("Marc");

        String valorReal = empleat1.getNom();
        String valorEsperat = "Marc";

        assertEquals(valorReal, valorEsperat);
    }
}

