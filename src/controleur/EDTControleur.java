package controleur;

import dao.EtudiantDAO;
import dao.SeanceDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import modele.Etudiant;
import modele.Seance;
import vue.UserVue;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class EDTControleur implements ActionListener {

    private EtudiantDAO etuddao = null;
    private Etudiant e = null;

    private SeanceDAO seance = null;
    private ArrayList<Seance> listSeances = null;
    
    //private UserVue edtVue = null;
    
    private ActionListener actionListener;

    public EDTControleur() {
        etuddao = new EtudiantDAO();
        e = new Etudiant();
        seance = new SeanceDAO();

        e = etuddao.chercher(240);
        listSeances = new ArrayList<Seance>();
        listSeances = seance.chercherSeancesParGroupeId(e.getGroupeId());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

    }

    public static void main(String[] args) {
        EDTControleur controler = new EDTControleur();
//        SeanceDAO et = new SeanceDAO();
//        ArrayList<Seance> un = et.chercherSeancesParGroupeId(31);
//        for (Seance s : un) {
//            System.out.println("Seance: " + s.getDebutHeure() + "\n");
//        }
    }
}
