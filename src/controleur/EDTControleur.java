package controleur;

import dao.EtudiantDAO;
import dao.SeanceDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modele.Etudiant;
import modele.Seance;
import modele.User;
import vue.EtudiantVue;
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

    private EtudiantVue ve = null;

    DefaultTableModel dtm;

    //private UserVue edtVue = null;
    private ActionListener actionListener;

    public EDTControleur(User m, EtudiantVue v) {
        ve = new EtudiantVue("Etudiant vue");
        ve = v;

        etuddao = new EtudiantDAO();
        e = new Etudiant();
        seance = new SeanceDAO();

        e = etuddao.chercher(m.getUserId());
        listSeances = new ArrayList<Seance>();
        listSeances = seance.chercherSeancesParGroupeId(e.getGroupeId());
        listSeances.toString();

        //Object edt = new Object[2];
        String[][] data = new String[12][8];

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 1; j++) {
                data[i][j] = "De " + listSeances.get(i).getDebutHeure() + " a " + listSeances.get(i).getFinHeure();
            }
        }

        for (int i = 0; i < 7; i++) {
            for (int j = 1; j < 8; j++) {
                data[i][j] = Integer.toString(listSeances.get(i).getSeanceId());
                System.out.println(data[i][j] + "\n");
            }
        }
//        for (int i = 0; i < data.length; i++) {
//            for (int j = 0; j < 8; j++) {
//                System.out.println(data[i][j] + "\n");
//            }
//        }

        DefaultTableModel dtm = new DefaultTableModel(
                data,
                //                new Object[][]{
                //                    {"8h30-10h00", "fdsfd", null, null, null, null, null, null},
                //                    {"10h15-11h45", null, null, null, null, null, null, null},
                //                    {"12h00-13h30", null, null, "fdu", null, null, null, null},
                //                    {"13h45-15h00", null, null, null, null, null, null, null},
                //                    {"15h15-16h45", null, null, null, null, null, null, null},
                //                    {"17h00-18h45", null, null, null, null, null, null, null},
                //                    {"19h00-20h30", null, null, null, null, null, null, null}
                //                },
                new String[]{
                    " ", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"
                }
        );
        ve.updateVue(dtm);
        ve.setVisible(true);
    }

    public void afficherEDT() {
        ve.updateVue(dtm);
        ve.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

    }

    public static void main(String[] args) {

        EtudiantDAO dao = new EtudiantDAO();
        Etudiant m = new Etudiant();
        m = dao.chercher(525);
        EtudiantVue v = new EtudiantVue("Etudiant Vue");
        EDTControleur controler = new EDTControleur(m, v);
        v.setVisible(true);
        //controler.afficherEDT();
//        SeanceDAO et = new SeanceDAO();
        //        ArrayList<Seance> un = et.chercherSeancesParGroupeId(31);
        //        for (Seance s : un) {
        //            System.out.println("Seance: " + s.getDebutHeure() + "\n");
        //        }
    }
}
