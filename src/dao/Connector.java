package dao;

import java.sql.*;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class Connector {

    // Déclaration des variables
    // Nom de la BDD
    public static final String nomBaseDeDonnees = "edt_ece";
    // Pour MAC OS, URL : "jdbc:mysql://localhost:3306/edt_ece?serverTimezone=UTC"
    public static final String endPointSSL = "?autoReconnect=true&useSSL=false";

    public static final String url = "jdbc:mysql://localhost:3308/" + nomBaseDeDonnees + endPointSSL;

    public static final String user = "root";
    // Mot de passe : root pour MAC OS
    public static final String motDePasse = "";

    /**
     * Fonction qui permet de se connecter à la base de données SQL. D'abord on
     * essaye de trouver le driver, si il n'est pas trouvé l'exception est
     * attrapée. Ensuite, on essaye de se connecter à la base de données, si la
     * base de données n'est pas trouvée ou qu'il y a une erreur, on l'attrape
     * avec une exception.
     *
     * @return
     */
    public static Connection getConnection() {
        Connection connect = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Il y a eu un problème avec le chargement du Driver!");
        }
        try {
            connect = DriverManager.getConnection(url, user, motDePasse);
        }catch (SQLException ex) {
            throw new RuntimeException("Erreur de connexion a la base de données", ex);
        }
        System.out.println("CONNEXION");
        return connect;
    }
}
