import java.io.*;
import java.util.Random;
import java.util.ArrayList;
import static utils.Funcions.menu;
import utils.Leer;


public class App {
    static Leer lector = new Leer();

    public static void main(String[] args) throws Exception {
        menu();
    }
}


/* 

Tindrem un concessionari amb 3 tipus de vehicles

Van a heretar cada tipus de vehicle (cotxe, furgona i moto) la classe abstracta vehicle.

Cotxe i furgona implementaran la interficie quatreRodes(); 

Vehicle: 
- Atributs: String matricula, String nom, double preu, Boolean ITV

Cotxe:
- Atributs: int qPortes, Boolean maleter

Fragoneta:
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