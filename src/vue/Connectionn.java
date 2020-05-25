package vue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class Connectionn {

    public static Connection getConnectionn() {
        Connection connect=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect= DriverManager.getConnection("jdbc:mysql://localhost/edt_ece","root,"");
        } catch (ClassNotFoundException e) {
            System.out.println("Il y a eu un problème avec le chargement du Driver!");
        }
        return connect;
    }
