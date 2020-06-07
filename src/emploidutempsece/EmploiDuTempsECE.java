package emploidutempsece;

import controleur.LoginControleur;

// Si une erreur au niveau de la bases de données entrez: "SET GLOBAL max_connections = 1024;"
// C'est parce que nous n'avons pas pris en compte qu'il y avait un nombre maximum de connections à celle-ci.

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class EmploiDuTempsECE {

    public static void main(String[] args) {
        LoginControleur login = new LoginControleur();
        login.control();
    }
}
