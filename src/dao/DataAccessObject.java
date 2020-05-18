package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public abstract class DataAccessObject<T> {

    public static final String nomBaseDeDonnees = "edt_ece";
    public static final String endPointSSL = "?autoReconnect=true&useSSL=false";
    public static final String url = "jdbc:mysql://localhost:3306/" + nomBaseDeDonnees + endPointSSL;
    public static final String user = "root";
    public static final String motDePasse = "";

    protected Connection connect = null;

    public DataAccessObject() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Il y a eu un probleme avec le chargement du Driver!");
        }
        try {
            Connection connect = DriverManager.getConnection(url, user, motDePasse);
        } catch (SQLException e) {
            throw new RuntimeException("Erreur de connection a la base de donnees", e);
        }
    }

    public abstract boolean creer(T objet);

    public abstract boolean effacer(T objet);

    public abstract boolean mettreAJour(T objet);

    public abstract T chercher(int id);
}
