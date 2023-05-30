package test;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;
import classes.*;
import java.util.ArrayList;

public class TestDepartaments{
    @Test
    @DisplayName("Test Departaments")
    public void TestDepartaments(){
        ArrayList<Empleat> arrayEsperat = new ArrayList<Empleat>();
        ArrayList<Empleat> arrayReal;


        Empleat marc = new Empleat("Marc");
        Empleat alberto = new Empleat("Alberto");
        Empleat jeremias = new Empleat("Jeremias");
        Empleat marina = new Empleat("Marina");

        Departament informatica = new Departament("Informàtica");

        informatica.addEmpleat(marina);
        informatica.addEmpleat(alberto);

        arrayReal = informatica.getEmpleats();
        arrayEsperat.add(alberto);
        arrayEsperat.add(marina);
        
        
        assertEquals(arrayEsperat, arrayReal, ()-> "Els dos arrays no són iguals!");
    }

}


