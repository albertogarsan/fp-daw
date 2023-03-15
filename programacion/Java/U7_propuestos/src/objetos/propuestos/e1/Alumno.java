package objetos.propuestos.e1;

public class Alumno {
    /*Realizar la implementación de la Clase Alumno (num, edad y curso) vista en los apuntes. Además:
         - Añade un atributo Nombre
        - Modifica las funciones ya empezadas leerAlumno e imprimirAlumno para que procesen el nombre también.
        - Crear un constructor por defecto, uno general y otro copia
        - Añade una función copiaAlumno donde le pasaremos dos Alumnos (origen y destino) y copiará uno en el otro.
        - Añade una función igualAlumno, que dados dos alumnos indicará si contienen o no la misma información.
        - Piensa cómo reescribirías las dos funciones anteriores, si éstas estuvieran implementadas dentro de la
        clase Alumno.
        Deja comentadas las que ya has hecho y modifícalas para que estén como métodos de la clase Alumno.*/

    //Atributos
    int num;
    int edad;
    String curso;
    String nombre;

    //Constructor por defecto
    public Alumno(){
        this.num = 0;
        this.edad = 0; // 0 per defecte
        this.curso = "";
        this.nombre = ""; //empty string
    }
    //Constructor general: si no claves els arguments dona error
    public Alumno(int num, int edad, String curso, String nombre){
        this.num = num;
        this.edad = edad;
        this.curso = curso;
        this.nombre = nombre;
    }

    //Constructor copia
    public Alumno(Alumno alumno1){
        this.num = alumno1.num;
        this.edad = alumno1.edad;
        this.curso = alumno1.curso;
        this.nombre = alumno1.nombre;
    }

    //Metodo para leer un alumno
    public void leerAlumno() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el número de alumno: ");
        this.num = sc.nextInt();
        System.out.print("Introduce la edad: ");
        this.edad = sc.nextInt();
        System.out.print("Introduce el curso: ");
        this.curso = sc.nextLine();
        System.out.print("Introduce el nombre del alumno: ");
        this.nombre = sc.nextLine();
    }

    // Método para imprimir un alumno
    public void imprimirAlumno() {
        System.out.println("Número: " + this.num);
        System.out.println("Edad: " + this.edad);
        System.out.println("Curso: " + this.curso);
        System.out.println("Nombre: " + this.nombre);
    }

}
