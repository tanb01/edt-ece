package controleur;

import dao.UserDAO;
import modele.User;
import vue.UserVue;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class UserControleur {

    private UserDAO udao = null;
    private User modele = null;
    private UserVue vue = null;

    public UserControleur(User modele, UserVue vue) {
        udao = new UserDAO();
        this.modele = new User();
        this.modele = modele;
        this.vue = new UserVue();
        this.vue = vue;
    }

    public int getUserId() {
        return modele.getUserId();
    }

    public String getUserEmail() {
        return modele.getEmail();
    }

    public String getUserNom() {
        return modele.getNom();
    }

    public String getUserPrenom() {
        return modele.getPrenom();
    }

    public int getDroit() {
        return modele.getDroit();
    }
//
//    public void updateVue() {
//        vue.printDetailsUser(modele.getUserId(), modele.getNom(), modele.getPrenom(), modele.getNumeroUser(), modele.getGroupeId());
//    }
}
