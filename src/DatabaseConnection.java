import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection;

    // Statische Methode zur Herstellung der Datenbankverbindung
    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Laden Sie den JDBC-Treiber entsprechend Ihrer Datenbank herunter
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Ersetzen Sie die folgenden Werte durch Ihre Datenbankinformationen
                String url = "jdbc:mysql://localhost:3306/beispiel";
                String username = "root";
                String password = "Oppenheimer68@";

                connection = DriverManager.getConnection(url, username, password);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    // Methode zum Schließen der Datenbankverbindung
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
