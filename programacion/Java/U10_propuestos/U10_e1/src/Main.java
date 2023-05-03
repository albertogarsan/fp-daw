import classes.Alumno;
import classes.CustomException;
import static utils.Funciones.menu;

public class Main {
    public static void main(String[] args) throws CustomException {
        Alumno alumno1 = new Alumno();
        try {
            alumno1.ponerNota(5, 2, 10);
        } catch (CustomException e) {
            System.out.println(e);
        }

        menu();
    }
}
