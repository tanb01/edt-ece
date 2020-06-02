package emploidutempsece;

import controleur.LoginControleur;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class EmploiDuTempsECE {

    public static void main(String[] args) {
        //LoginControleur login = new LoginControleur();
        //login.control();
        
        PieChart demo = new PieChart("Capacité des salles", "Site : ");
        demo.pack();
        demo.setVisible(true);
    }
}
