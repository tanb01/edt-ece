package controleur;

import dao.UserDAO;
import modele.User;
import vue.UserVue;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class UserControleur {

    // Variables locales de UserControleur
    private UserDAO udao = null;
    private User modele = null;
    private UserVue vue = null;

    /**
     * Constructeur
     * 
     * @param modele
     * @param vue 
     */
    public UserControleur(User modele, UserVue vue) {
        udao = new UserDAO();
        this.modele = new User();
        this.modele = modele;
        this.vue = new UserVue();
        this.vue = vue;
    }

    /**
     * Getters
     * Pour l'id de l'utilisateur
     * 
     * @return 
     */
    public int getUserId() {
        return modele.getUserId();
    }

    /**
     * Pour l'email de l'utilisateur
     * 
     * @return 
     */
    public String getUserEmail() {
        return modele.getEmail();
    }

    /**
     * Pour le nom de l'utilisateur
     * 
     * @return 
     */
    public String getUserNom() {
        return modele.getNom();
    }

    /**
     * Pour le prénom de l'utilisateur
     * 
     * @return 
     */
    public String getUserPrenom() {
        return modele.getPrenom();
    }
    
    /**
     * Pour le droit de l'utilisateur
     * 
     * @return 
     */
    public int getDroit() {
        return modele.getDroit();
    }
    
    /**
     * Mise à jour de la vue
     */
//    public void updateVue() {
//        vue.printDetailsUser(modele.getUserId(), modele.getNom(), modele.getPrenom(), modele.getNumeroUser(), modele.getGroupeId());
//    }
}
