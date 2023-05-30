# File 
La clase File representa una ruta de acceso a un archivo o directorio en el sistema de archivos. 

La clase File no está diseñada para leer o escribir datos en el archivo, sino más bien para obtener información sobre él y realizar operaciones como crear, eliminar o renombrar archivos y directorios. File permite algunas operaciones como cambiar el nombre del archivo.

1. Obtener la granularidad de un archivo:

``` java
import java.io.File;

public class FileExample {
    
    public static void main(String[] args) {
        File file = new File("ruta/al/archivo.txt");
        
        if (file.exists()) {
            long fileSize = file.length(); // Tamaño en bytes
            System.out.println("Tamaño del archivo: " + fileSize + " bytes");
        } else {
            System.out.println("El archivo no existe.");
        }

    }
}
```

2. Cambiar el nombre de un archivo:

```java

import java.io.File;

public class FileExample {
    
    public static void main(String[] args) {
        File file = new File("ruta/al/archivo.txt");
        File nuevoNombre = new File("ruta/al/nuevo_nombre.txt");
        
        if (file.exists()) {
            if (file.renameTo(nuevoNombre)) {
                System.out.println("Archivo renombrado exitosamente.");
            } else {
                System.out.println("No se pudo renombrar el archivo.");
            }
        } else {
            System.out.println("El archivo no existe.");
        }
    }
}

```

## Métodos File
1. `exists()`: Verifica si el archivo o directorio representado por el objeto `File` existe en el sistema de archivos.

2. `isFile()`: Verifica si el objeto `File` representa un archivo.

3. `isDirectory()`: Verifica si el objeto `File` representa un directorio.

4. `getName()`: Devuelve el nombre del archivo o directorio representado por el objeto `File`.

5. `getPath()`: Devuelve la ruta absoluta del archivo o directorio representado por el objeto `File`.

6. `length()`: Devuelve el tamaño del archivo en bytes.

7. `canRead()`: Verifica si el archivo o directorio tiene permisos de lectura.

8. `canWrite()`: Verifica si el archivo o directorio tiene permisos de escritura.

9. `createNewFile()`: Crea un nuevo archivo en el sistema de archivos utilizando la ruta y el nombre proporcionados.
                      Este método puede lanzar una excepción IOException si ocurre un error al crear el archivo. Por ejemplo, puede lanzar esta excepción si no tienes los permisos adecuados para crear el archivo o si el archivo ya existe.

10. `mkdir()`: Crea un nuevo directorio en el sistema de archivos utilizando la ruta y el nombre proporcionados.
               Este método puede lanzar una excepción SecurityException si ocurre un error de seguridad al intentar crear el directorio.

11. `delete()`: Elimina el archivo o directorio representado por el objeto `File` del sistema de archivos.
                Este método puede lanzar una excepción SecurityException si ocurre un error de seguridad al intentar eliminar el archivo o directorio.

12. `list()`: Devuelve un arreglo de `String` con los nombres de los archivos y directorios en el directorio representado por el objeto `File`.
              Este método puede lanzar una excepción SecurityException si ocurre un error de seguridad al intentar obtener los nombres de los archivos y directorios en el directorio especificado.

13. `renameTo(File dest)`: Cambia el nombre del archivo o directorio representado por el objeto `File` al nombre especificado por el objeto `dest`.

### LINK DOCUMENTACIÓN
[java.io.File - Oracle Documentation](https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/io/File.html)



# FileReader (caracter a caracter)
La clase FileReader se utiliza para leer caracteres de un archivo de texto.
Proporciona métodos para leer caracteres de un archivo de forma secuencial.

- Puedes usar los métodos de FileReader, como read(), para leer caracteres individuales 
- O utilizar métodos como read(char[] buffer) para leer un bloque de caracteres en un arreglo.


## Nota
Para leer o escribir archivos, el File no hace falta realmente, puedes poner el path en el FileReader directamente y funciona. Lo que opcionalmente, puedes insertar el path en el File y pasarle el File al FileReader, lo que es una línea más de código:

```java
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {
    public static void main(String[] args) {
        String filePath = "ruta/al/archivo.txt";
        
        try (FileReader fileReader = new FileReader(filePath)) {
            int character;
            while ((character = fileReader.read()) != -1) {
                System.out.print((char) character);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

```
```java
 //S'inicialitza l'objecte FileReader que permet llegir l'arxiu de text i se li passa per paràmetre la ruta on es troba l'arxiu.
FileReader fr = new FileReader("exercicis/e1/archivo.txt");

//S'inicialitza l'objecte BufferedReader que permet llegir l'arxiu de text línia per línia. Li passem per paràmetre l'objecte FileReader. 
BufferedReader br = new BufferedReader(fr);

//S'inicialitza la variable s per a guardar cada línia de l'arxiu (cada string) de text que s'està llegint en cada iteració del bucle while (p.e guardarà la info "hola mundo")
String s = "";

//S'inicialitza a 0 la variable contador de tipo enter que s'utilitza per a contar la quantitat de paràgrafs que hi ha a l'arxiu.
int contador = 0;

//Quantitat de lletres
int qletras;

//Inicialització de l'ArrayList que emmagatzemarà la quantitat de lletres de cada paràgraf.
ArrayList <Integer> lletresParagraf = new ArrayList<Integer>();

//S'inicialitza l'objecte FileReader que permet escriure sobre un arxiu de text i se li passa per paràmetre la ruta on es troba l'arxiu.
FileWriter fw = new FileWriter("exercicis/e2/salida.txt",true);

//S'inicialitza l'objecte BufferedWriter que permet escriure informació nova a final de l'arxiu. Li passem per paràmetre l'objecte FileWriter. 
BufferedWriter bw = new BufferedWriter(fw);
```

# FileWriter (caracter a caracter)
La clase FileWriter en Java se utiliza para escribir caracteres en un archivo de texto. Proporciona métodos para escribir caracteres individuales, arreglos de caracteres y cadenas de caracteres en un archivo.

# BufferedReader (linea a linea hasta encontrarse un salto de linea)
Utilizamos FileReader para abrir el archivo de texto y luego pasamos el objeto FileReader como argumento al constructor de BufferedReader. Esto crea un BufferedReader que lee datos del archivo subyacente de manera eficiente utilizando un búfer interno.
Recordar meterlo en try...
```java
BufferedReader reader = new BufferedReader(new FileReader("ruta/al/archivo.txt"));
```
Métodos:

1. int read(): Lee un solo carácter del flujo de entrada y lo devuelve como un valor entero. Devuelve -1 si se alcanza el final del flujo.

2. int read(char[] cbuf): Lee una serie de caracteres del flujo de entrada y los almacena en el arreglo de caracteres especificado (cbuf). Devuelve el número de caracteres leídos o -1 si se alcanza el final del flujo.

3. String readLine(): Lee una línea completa del flujo de entrada y la devuelve como una cadena de caracteres. El método lee caracteres hasta encontrar un carácter de nueva línea ('\n') o el final del flujo. Devuelve null si se alcanza el final del flujo.

4. boolean ready(): Verifica si hay datos listos para ser leídos desde el flujo de entrada sin bloquear. Devuelve true si hay datos disponibles, y false de lo contrario.

5. void mark(int readAheadLimit): Marca la posición actual en el flujo de entrada. Puedes llamar al método reset() posteriormente para volver a esta posición marcada.

6. void reset(): Restablece la posición del flujo de entrada a la última marca realizada.

7. long skip(long n): Omite y descarta un número especificado de caracteres del flujo de entrada. Devuelve el número real de caracteres omitidos.

8. void close(): Cierra el flujo de entrada y libera los recursos asociados.

# BufferedRWriter (linea a linea hasta encontrarse un salto de linea)

# FICHEROS BINARIOS

## Lectura de ficheros binarios:

1. Paso 1: Crea un objeto FileInputStream pasando la ruta del fichero binario como argumento en el constructor. Por ejemplo:
```java
FileInputStream fis = new FileInputStream("ruta/al/archivo.bin");
```

2. Paso 2: Lee los datos binarios del fichero utilizando el método read() del FileInputStream. El método read() devuelve el siguiente byte del fichero como un entero (-1 si se alcanza el final del fichero).
```java
int byteData;
while ((byteData = fis.read()) != -1) {
    // Procesa el byte leído
}
```

3. Paso 3: Cierra el FileInputStream después de finalizar la lectura para liberar los recursos del sistema. Puedes hacer esto en un bloque finally o utilizando el bloque try-with-resources para asegurar que el fichero se cierre correctamente.
```java
fis.close();
```

## Escritura de ficheros binarios:

*FileOutputStream* es una clase en Java que se utiliza para escribir datos binarios en un fichero. Proporciona métodos para escribir bytes individuales o arreglos de bytes en un fichero.

Al crear una instancia de FileOutputStream, puedes especificar la ruta del fichero en el constructor, indicando el fichero en el que deseas escribir los datos. Luego, puedes utilizar los métodos proporcionados por FileOutputStream para escribir los datos binarios.

- write(int byte): Escribe un byte en el fichero.
- write(byte[] bytes): Escribe un arreglo de bytes en el fichero.
- write(byte[] bytes, int offset, int length): Escribe una porción específica de un arreglo de bytes en el fichero, comenzando desde la posición de desplazamiento (offset) y escribiendo una cantidad específica de bytes (length).
- flush(): Limpia el búfer interno y garantiza que todos los bytes pendientes se escriban en el fichero.

Después de escribir los datos binarios en el fichero, es importante cerrar el FileOutputStream utilizando el método close() para asegurarse de que los recursos del sistema se liberen correctamente.

1. Paso 1: Crea un objeto FileOutputStream pasando la ruta del fichero binario como argumento en el constructor. Por ejemplo:
```java
FileOutputStream fos = new FileOutputStream("ruta/al/archivo.bin");
```

2. Paso 2: Escribe los datos binarios en el fichero utilizando el método write() del FileOutputStream. Puedes escribir bytes individuales o un arreglo de bytes.
```java
byte[] data = { 0x48, 0x65, 0x6C, 0x6C, 0x6F }; //Output spected:0x48, 0x65, 0x6C, 0x6C, 0x6F. Estos valores representan los caracteres ASCII correspondientes a "Hello".
fos.write(data);
```





# FITXERS DE TEXT -> ESCRIPTURA (Export):
```java
FileWriter fw = null;     // FileWriter ens permet escriure caràcters
BufferedWriter bw = null; // BufferedWritter permet escriure línies senceres i salts de línia

// utilitzm try per capturar les posibles excepcions
try {  
  fw = new FileWriter("path/to/poesia.txt"); // Si l'arxiu poesia.txt no existix ja, el crea. però la carpeta ha d'existir precís, si no, dóna error
  bw = new BufferedWriter(fw);
  
  bw.write("¡De una juvenil inocencia");  // Escriu el text
  bw.newLine();                           // Afegix un salt de línia
  bw.write("qué conserva sino el sutil"); // Escriu nou text
  bw.newLine();                           // Nou salt de línia
  bw.write("perfume, esencia de su Abril,");  // TÍPICAMENT, ESTA REPETICIÓ D'AFEGIR
  bw.newLine();                               // TEXT I AFEGIR SALT DE LÍNIA, LA FARÀS
  bw.write("la más maravillosa esencia!");    // DINS D'UN LOOP QUE RECORRE UN ARRAY AMB
  bw.newLine();                               // ELS CONTINGUTS DE CADA LÍNIA
  bw.close();
  fw.close();
} catch (IOException ex) {
  //...
}
```

Amb el loop

```java
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {
    public static void main(String[] args) {
        String[] lines = {
            "¡De una juvenil inocencia",
            "qué conserva sino el sutil",
            "perfume, esencia de su Abril,",
            "la más maravillosa esencia!"
        };
        
        FileWriter fw = null;
        BufferedWriter bw = null;
        
        try {
            fw = new FileWriter("path/to/poesia.txt");
            bw = new BufferedWriter(fw);
            
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
```

### FITXERS DE TEXT -> LECTURA (Import):
(FileReader llig caràcters, BufferedReader llig línies)
```java

FileReader fr = new FileReader("path/to/text.txt"); // rep com a argument el path de l'arxiu
BufferedReader br = new BufferedReader(fr) // rep com a argument l'object FileReader anomenat fr

String s = ""; string auxiliar on guardarem cada línia que llig el BufferedReader anomenat br

while (br.ready()) {     // el mètode ready() del BufferedReader és el que ens diu si queden més línies per llegir o no
  s = br.readLine();     // guardem en la variable auxiliar s el contingut de la línia (string)
  System.out.println(s); // fem el que cregam amb el text de cada línia s
}
br.close();
fr.close();
```

# FITXERS BINARIS AMB DADES -> ESCRIPTURA (Export):

```java
FileOutputStream fos; 
DataOutputStream dos;
try {
  fos = new FileOutpuStream("path/to/arxiu.dat", false); // el segon argument boolean és el append. si és false o no el posem, sobreescriurem els continguts de l'arxiu en escriure. si és true, simplement afegirem el que escrivim al final de l'arxiu (append)
  dos = new DataOutputStream(fos); // l'objecte dos oferix els mètodes writeXXX(...) on XXX és un tipus com Int, Boolean, String, etc. i a dins dels parèntesis va el contingut que volem escriure
  dos.writeInt(1); // podria ser també dos.writeBoolean(bool), dos.writeFloat(float)...
  dos.writeInt(3);
  dos.writeInt(8);
  //...etc   // podem utilitzar un for si convé
   
  dos.close()  
} catch (IOException ex) {
  //...	
}
```

# FITXERS BINARIS AMB DADES -> LECTURA (Import):

```java
FileInputStream fis;
DataInputStream dis;
try {
  fis = new FileInputStream("path/to/arxiu.dat")
  dis = new DataInputStream(fis);
  while(dis.available() > 0) {   // el mètode dis.available() ens retorna el nombre de bytes que queden per llegir, mentre siga major a 0 significa que no hem acabat de llegir tot l'arxiu  
    int num = dis.readInt();   // el mètode dis.readXXX() ens permet llegir diferents tipus, segons el tipus de dades que hem guardat a l'arxiu
    System.out.println(num);   // fem el que cregam amb el resultat obtingut
  }
  dis.close();
} catch(IOException e) {
  //...
}
```

# FITXERS BINARIS AMB OBJECTES -> ESCRIPTURA (Export):

(Per a poder exportar objectes i guardar-los en un arxiu binari, cal que la classe d'eixos objectes implemente la interfície "Serializable". Per a este exemple suposarem que tenim objectes del tipus Alumne, per exemple).

```java 
FileOutputStream fos;
ObjectOutputStream oos;
try {
  fos = new FileOutputStream("path/to/objectes.dat");
  oos = new ObjectOutputStream(fos);
  
  oos.writeObject(alumne1); 
  oos.writeObject(alumne2);
  oos.writeObject(alumne3); // podem recorrer un arraylist que continga els objectes i utilitzar només un oos.writeObject(alumne) dins d'eixe for, en lloc de escrivir-los a mà un a un com fem ací
  
  oos.close();
  System.out.println("Datos de "+contactes.size()+" contactos exportados correctamente a: "+ruta);
} catch (Exception e) {
  System.out.println(e);
}
```

# FITXERS BINARIS AMB OBJECTES -> LECTURA (Import):

```java 
FileInputStream fis;
ObjectInputStream ois = null;
try {
  fis = new FileInputStream("path/to/objectes.dat");
  ois = new ObjectInputStream(fis);
  while (fis.available() > 0) {  // utilitzem ell mètode .available() de fis (no ois!) que retorna el nombre de bytes que queden per llegir a l'arxiu, per saber si ja hem acabat la lectura o no
    Alumne alumne = (Alumne) ois.readObject(); // utilitzem el mètode .readObject() de ois, però li hem de fer el càsting al tipus adequat
    System.out.println(alumne);  // fem el que creagam amb cada alumne llegit de l'arxiu
  }
} catch (Exception ex) {
  System.out.println(ex);
}