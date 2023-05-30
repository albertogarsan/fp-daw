import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps;
        ResultSet rs;

        // Este bloc està deprecated.
        /*
         * try{ // Carreguem el driver
         * Class.forName("com.mysql.jdbc.Driver");
         * } catch (ClassNotFoundException e) {
         * System.out.println("No se pudo cargar el driver");
         * }
         */

        try { // Establim la connexió
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzeria", "root", "nocalentrar");
        } catch (SQLException e) {
            System.out.println("No se pudo conectar a la base de datos");
        }

        try { // Creem i preparem la sentencia SQL

            // Tipo 1
            Statement s = conn.createStatement();
            rs = s.executeQuery("SELECT * FROM preparation");
            rs = s.executeQuery("SELECT * FROM pizzas");
            
            // Tipo 2 (Recomanada per a reutilitzar la consulta)
            // Escrivim el que anem a utilitzar amb el prepare statement
            ps = conn.prepareStatement("SELECT * FROM (?)");
            // L'executem la consulta amb el result set
            rs = ps.executeQuery("preparation");
            rs = ps.executeQuery("pizzas");
            rs = ps.executeQuery("sales");
              
            // Recorrem les files de la selecció que acabem d'executar (linia 25)
            while (rs.next()) {
                Float quantity = rs.getFloat("Quantity");
                String NPizza = rs.getString("NPizza");
                String ingredient = rs.getString("ingredient");
                System.out.printf("%-15s %-15s %-15s\n", NPizza, ingredient, quantity);
            }

        } catch (SQLException e) {
            System.out.println("No se pudo preparar la sentencia SQL");
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("No se pudo cerrar la conexión a la base de datos");
            }
        }
    }
}
