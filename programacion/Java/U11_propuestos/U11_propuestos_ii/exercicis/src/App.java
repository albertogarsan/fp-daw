import java.io.*;
import java.util.Random;
import java.util.ArrayList;
import static utils.Funcions.menu;
import utils.Leer;


public class App {
    static Leer lector = new Leer();

    public static void main(String[] args) throws Exception {
        //exercici1();
        //exercici2();
        //exercici3();
        //exercici4();
        //Exercici5 (menu)
        menu();
    }

    public static void exercici1() {
        
        try {
            //S'inicialitza l'objecte FileReader que permet llegir l'arxiu de text i se li passa per paràmetre la ruta on es troba l'arxiu.
            FileReader fr = new FileReader("exercicis/e1/archivo.txt");
            //S'inicialitza l'objecte BufferedReader que permet llegir l'arxiu de text línia per línia. Li passem per paràmetre l'objecte FileReader. 
            BufferedReader br = new BufferedReader(fr);
            
            //Inicialització de les variables que anem a utilitzar
            
            //S'inicialitza la variable s per a guardar cada línia de l'arxiu (cada string) de text que s'està llegint en cada iteració del bucle while (p.e guardarà la info "hola mundo")
            String s = "";
            
            //S'inicialitza a 0 la variable contador de tipo enter que s'utilitza per a contar la quantitat de paràgrafs que hi ha a l'arxiu.
            int contador = 0;
            
            //Quantitat de lletres
            int qletras;

            //Inicialització de l'ArrayList que emmagatzemarà la quantitat de lletres de cada paràgraf.
            ArrayList <Integer> lletresParagraf = new ArrayList<Integer>();

            //Mentres hi haja línies per llegir en l'arxiu, a cada iteració es llig una línia de l'arxiu i la guarda en la variable s.
            while (br.ready()){
              //Llig una línia de text per cada iteració guardant-la en la variable s
              s = br.readLine();
              
              //Comprovem que la línia de text no siga menor a 0 (és a dir que no estiga buida) per a contar en +1 la quantitat de paràgrafs que hi ha a l'arxiu.
              if (s.length() != 0) {
                //Contar en +1 la quantitat de paràgrafs que hi ha a l'arxiu.
                contador++;
                //Guardar la quantitat de lletres que és igual a la longitud de tota una línia (que no deixa de ser caràcter per caràcter, p.e "hola mundo = 11 caracters en una primera iteració")
                //Nota: un string pot ocupar diferents línies, és fins a que hi haja un salt de linia.
                qletras = s.length();
                //Afegir la quantitat de lletres a l'arraylist que guarda la quantitat de lletres per cada paràgraf.
                lletresParagraf.add(qletras);
              }
            }

            //Recorrem el arraylist per a contar cada paràgraf i la quantitat de lletres que té
            for (int i = 1; i <= lletresParagraf.size(); i++){
              //.get() li passem com a argument la posició i retorna l'element que està en eixa posició.
              System.out.println("El paràgraf número " + i + " té " + lletresParagraf.get(i-1) + " lletres.");
            } 
            //Quantitat total de paràgrafs
            System.out.println("El número de paràgrafs és: " + contador);

            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void exercici2(){
      try {

        String input = "";
        //Mentres siga true no pares de demanar a l'usuari que introduisca una frase 
        Boolean continuar = true;
        while (continuar){
          //S'inicialitza l'objecte FileReader que permet escriure sobre un arxiu de text i se li passa per paràmetre la ruta on es troba l'arxiu.
          FileWriter fw = new FileWriter("exercicis/e2/salida.txt",true);
          //S'inicialitza l'objecte BufferedWriter que permet escriure informació nova a final de l'arxiu. Li passem per paràmetre l'objecte FileWriter. 
          BufferedWriter bw = new BufferedWriter(fw);

          input = lector.demanarString("Introdueix una frase i fes enter (tecleja Fin, per a acabar): ");

          //Comprovar que a menos que el que ha introduit no siga fin, afegisca (en el else) el que ha introduit com a frase i si és fin que isca del bucle perquè li diguem que ara continuar siga false.
          if (input.equals("Fin") || input.equals("fin")){
            bw.close();
            fw.close();
              continuar = false;
          } else {
            bw.write(input);
            bw.newLine();

            bw.close();
            fw.close();
          }
        }
          
        System.out.println("Programa finalizado.");
      } catch (IOException ex) {
        System.out.println(ex);
      }
    }

    public static void exercici3(){
        try {
            String nom = "";
            String telf = "";
            String contacte = "";
            
            Boolean continuar = true;
            while (continuar){
                FileWriter fw = new FileWriter("exercicis/e3/agenda.txt",true);
                BufferedWriter bw = new BufferedWriter(fw);

                nom = lector.demanarString("Introdueix el nom d'un nou contacte: ");
                telf = lector.demanarString("Introdueix el seu número de contacte: ");
                contacte = nom + " - " + telf;

                continuar = lector.demanarBooleanSiNo("Vols continuar afegint contactes a l'agenda? (s/n): ");
                
                bw.write(contacte);
                bw.newLine();

                bw.close();
                fw.close();
                
            }
            System.out.println("Agenda tancada.");
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public static void exercici4(){
        generarFicheroEnteros("exercicis/e4/enters.bin",50);
        File f = new File("exercicis/e4/enters.bin");
        mostrarFicheroEnteros(f);
        añadirFicheroEnteros(f,25);
        mostrarFicheroEnteros(f);
      }
      
      public static void generarFicheroEnteros(String nomArxiu, int quantitat){
        Random rand = new Random();
        try {
          //Dades binaries (integers, doubles, booleans, date, caracters...)
          DataOutputStream dos = new DataOutputStream(new FileOutputStream(nomArxiu));
          for (int i = 0; i < quantitat; i++) {
            int nouEnter = rand.nextInt(100);
            dos.writeInt(nouEnter);
          }
          dos.close();
          System.out.println("\nS'ha creat un nou arxiu amb "+quantitat+" nombres enters.");
        } catch (IOException e) {
          System.out.println(e);
        }
      }
      
      public static void mostrarFicheroEnteros(File arxiu){
        try {
          DataInputStream dis = new DataInputStream(new FileInputStream(arxiu));
          while(dis.available() > 0) {
              int num = dis.readInt();
              System.out.print(num + "\t");
          }
          System.out.println();
          dis.close();
        } catch(IOException e) {
          System.out.println(e);
        }
      }
  
      public static void añadirFicheroEnteros(File arxiu, int quantitat){
        Random rand = new Random();
        try {
          DataOutputStream dos = new DataOutputStream(new FileOutputStream(arxiu, true));
          for (int i = 0; i < quantitat; i++) {
            int nouEnter = rand.nextInt(100);
            dos.writeInt(nouEnter);
          }
          dos.close();
          System.out.println("\nS'han afegit "+quantitat+" nombres enters a l'arxiu.");
        } catch (IOException e) {
          System.out.println(e);
        }
    }
}
    
/* 

Tindrem un concessionari amb 3 tipus de vehicles

[DONE]Van a heretar cada tipus de vehicle (cotxe, furgona i moto) la classe abstracta vehicle.

[DONE]Cotxe i furgona implementaran la interficie quatreRodes(); 

[DONE]Vehicle: 
- Atributs: String matricula, String nom, double preu, Boolean ITV

[DONE]Cotxe:
- Atributs: int qPortes, Boolean maleter

[DONE]Fragoneta:
- Atributs: Boolean portaCorredera, String tipo (camperitzada, industrial)

Moto:
- Atributs: int qRodes (2 o 3 rodes).

Realitzarem un programa per a poder manejar els nostres vehicles del concesionari:
- Donar de alta un vehicle
- Donar de baixa un vehicle
- Mostrar informació d'un vehicle
- Modificar la informació d'un vehicle
- Ordenar els vehicles per preu, per nom (per defecte alfabèticament) i per matricula
- Iterable
- Importar els vehicles des d0'un arxiu d'objectes
- Exportar els vehicles a un arxiu d'objectes
- Exportar a un arxiu binari els preus de cada vehicle.


*/