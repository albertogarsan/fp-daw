public class Main {
    public static void main(String[] args) {
        try {
            customCharAt("Hola", 10);
        } catch (RangeExeption e) {
            System.out.println(e);
        }
    }

    public static char customCharAt(String str, int index) throws RangeExeption {
        if (index < 0 || index >= str.length()) {
            throw new RangeExeption("L'index està fora de rang.");
        }
        return str.charAt(index);
    }

    public static class RangeExeption extends Exception {
        public RangeExeption(String msg){
            super(msg);
        }
    }
}

