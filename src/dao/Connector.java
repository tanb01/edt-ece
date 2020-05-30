package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class Connector {

    public static final String nomBaseDeDonnees = "edt_ece";
    // Pour mac URL : "jdbc:mysql://localhost:3306/edt_ece?serverTimezone=UTC"
    public static final String endPointSSL = "?autoReconnect=true&useSSL=false";
    public static final String url = "jdbc:mysql://localhost:3306/" + nomBaseDeDonnees + endPointSSL;
    public static final String user = "root";
    public static final String motDePasse = "";

    public static Connection getConnection() {
        Connection connect = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Il y a eu un problème avec le chargement du Driver!");
        }
        try {
            connect = DriverManager.getConnection(url, user, motDePasse);
        } catch (SQLException e) {
            throw new RuntimeException("Erreur de connexion a la base de données", e);
        }
        System.out.println("CONNEXION!!!");
        return connect;
    }
}
