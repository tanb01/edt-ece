package controleur;

import dao.CoursDAO;
import dao.EnseignantDAO;
import dao.EtudiantDAO;
import dao.GroupeDAO;
import dao.PromotionDAO;
import dao.SalleDAO;
import dao.SeanceDAO;
import dao.SiteDAO;
import dao.TypeCoursDAO;
import dao.UserDAO;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class RechercheControleur {

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

    public RechercheControleur() {

    }
}
