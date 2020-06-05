package controleur;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
import dao.EtudiantDAO;
import dao.SeanceDAO;
import dao.CoursDAO;
import dao.EnseignantDAO;
import dao.GroupeDAO;
import dao.PromotionDAO;
import dao.SalleDAO;
import dao.SiteDAO;
import dao.TypeCoursDAO;
import dao.UserDAO;

public class AdminEDTControleur {

    private CoursDAO cours = null;
    private EnseignantDAO enseignant = null;
    private EtudiantDAO etudiant = null;
    private GroupeDAO groupe = null;
    private PromotionDAO promotion = null;
    private SalleDAO salle = null;
    private SeanceDAO seance = null;
    private SiteDAO site = null;
    private TypeCoursDAO typeCours = null;
    private UserDAO user = null;

    public AdminEDTControleur() {
    cours = new CoursDAO();
    enseignant = new EnseignantDAO();
    etudiant = new EtudiantDAO();
    groupe = new GroupeDAO();
    promotion = new PromotionDAO();
    salle = new SalleDAO();
    seance = new SeanceDAO();
    site = new SiteDAO();
    typeCours = new TypeCoursDAO();
    UserDAO user = new UserDAO();

}

//    public void affecterEnseignantASeance() {
//
//    }
//
//    public void affecterGroupeASeance() {
//
//    }
//
//    public void modifierNomCoursSeance() {
//
//    }
//
//    public void modifierTypeCoursSeance() {
//
//    }
//
//    affecterSalleASeance() {
//
//    }
//
//    changerHeureSeance() {
//
//    }

    public void ajouterSeance() {
        
    }
//
//    ajouterEnseignant() {
//
//    }
//
//    ajouterGroupeASeance{
//
//}
//
//    changerEtatSeance() {
//
//}
//
//    remplacerEnseignantASeance(){
//}
//
//    enleverGroupeDeSeance() {
//
//}
//
}
