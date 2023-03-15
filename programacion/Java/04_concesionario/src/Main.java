public class Main {

    public static void main(String[] args) {
        Coche cocheNou1 = new Coche(74, "6083LZV", "BMW", "Ibiza", "Fucsia", 1 );

        cocheNou1.aumentarPrecioPorcentaje(3);
        cocheNou1.mostrarInfo();

        Coche2mano cocheAntic1 = new Coche2mano(30, "9012HVD", "Mersedes", "Leon", "Lapislatzuli", 500, 1000000, 60);

        cocheAntic1.mostrarInfo();

        Coche cocheNou2 = new Coche(19, "4023WWP", "SKODA", "Toledo", "Negre", 40 );
        Coche2mano cocheAntic2 = new Coche2mano(55, "9222LSD", "Mersedes", "Cordoba", "Blanc", 500, 990000, 120);

        Coche[] arrayCoche = {cocheNou1, cocheNou2, cocheAntic1, cocheAntic2};

        cocheNou1.revisar(); // true false false false false
        cocheNou1.revisar(); // true true false false false
        cocheNou1.revisar(); // true true true false false

        for (Coche coche : arrayCoche) {
            coche.mostrarInfo();
            System.out.println("-".repeat(20));
        }

        for (int i = 0; i < arrayCoche.length; i++) {
            System.out.println(arrayCoche[i]);
        }

        mostrarKm(cocheNou1);
        mostrarKm(cocheAntic1);
    }

    public static void mostrarKm(Coche coche){
        if (coche instanceof Coche2mano){
            System.out.println("Km recorridos: " + ((Coche2mano) coche).getKm()); //casteem
        } else {
            System.out.println("Coche nuevo con 0 km.");
        }
    }

}