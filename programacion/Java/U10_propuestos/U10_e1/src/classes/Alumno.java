package classes;
import java.util.Random;
import java.util.Iterator;
import java.lang.Iterable;

public class Alumno implements Iterable {
    //Atributos
    private int CEVA = 3;
    private int CEJER = 5;

    //Matriz de notas
     int notas[][];

    //Constructor
    public Alumno() {
        this.notas = new int[CEVA][CEJER];
    }

    public Alumno(boolean inicializarRandom) {
        this.notas = new int[CEVA][CEJER];
        if (inicializarRandom){
            Random random = new Random();
            for (int i = 0; i < CEVA; i++) {
                for (int j = 0; j < CEJER; j++) {
                    notas[i][j] = random.nextInt(11);
                }
            }
        }
    }

    //Metodos
    public void ponerNota (int nota, int numEv, int numEj) throws CustomException {
        if (numEv > 3 || numEv < 1) {
            throw new CustomException("La evaluación no puede ser inferior a 1 o superior a 3.");
        }
        if (numEj > 5 || numEj < 1){
            throw new CustomException("Los ejercicios no pueden ser inferiores a 1 o superiores a 5.");
        }
        this.notas[numEv - 1][numEj - 1] = nota;
    }

    protected class IteradorDeNotas implements Iterator<Integer> {
        private int evaluacio = 0;
        private int exercici = 0;

        @Override
        public boolean hasNext() {
            return evaluacio < CEVA && exercici < CEJER;
        }

        @Override
        public Integer next() {
            int nota = notas[evaluacio][exercici];
            exercici++;
            if (exercici >= CEJER) {
                evaluacio++;
                exercici = 0;
            }
            return nota;
        }
    }

    //La fem accessible
    public Iterator<Integer> iterator() {
        return new IteradorDeNotas();
    }
}
