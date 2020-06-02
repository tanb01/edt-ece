package controleur;

import dao.EtudiantDAO;
import dao.SeanceDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
public class EDTControleur implements ActionListener, ItemListener {

    private EtudiantDAO etuddao = null;
    private Etudiant e = null;

    private SeanceDAO seance = null;
    private ArrayList<Seance> listSeances = null;

    private EtudiantVue ve = null;

    DefaultTableModel dtm;

    /**
     *
     * @param m
     * @param v
     */
    public EDTControleur(User m, EtudiantVue v) {
        ve = new EtudiantVue("Etudiant vue");
        ve = v;

        etuddao = new EtudiantDAO();
        e = new Etudiant();
        seance = new SeanceDAO();

        e = etuddao.chercher(m.getUserId());
        listSeances = new ArrayList<Seance>();
        listSeances = seance.chercherSeancesParGroupeId(e.getGroupeId());

        String[][] data = new String[84][7];

        String[] horairesPossibles = new String[]{"08:30-10:00", "10:15-11:45", "12:00-13:30", "13:45-15:15", "15:30-17:00", "17:15-18:45", "19:00-20:30"};
        for (int i = 0; i < 7; i++) {
            data[i][0] = horairesPossibles[i];
        }

        int g = 0;
        int colinc = 1;
        String jour = "null";
        jour = getJourDeLaSemaine(listSeances.get(0).getDate());

        // Vue en grille
        while (g < listSeances.size()) {
            //System.out.println("id: " + g);
            if (jour == getJourDeLaSemaine(listSeances.get(g).getDate())) {
                for (int i = 0; i < 7; i++) {
                    if ((listSeances.get(g).getDebutHeure() + "-" + listSeances.get(g).getFinHeure()).equals(data[i][0])) {
                        data[i][colinc] = listSeances.get(g).stringify();
                    }
                }
                g++;
            } else {
                System.out.println("nooo");
                colinc++;
                jour = getJourDeLaSemaine(listSeances.get(g).getDate());
            }
        }

        DefaultTableModel dtm = new DefaultTableModel(
                data,
                new String[]{
                    " ", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"
                }
        );
        this.dtm = dtm;
    }

    /**
     * Affiche l'emploi du temps
     */
//    public void afficherEDT() {
//        ve.updateVue(dtm);
//        ve.setVisible(true);
//    }
    /**
     * Change les jours de la semaine de Anglais à Francais.
     *
     * @param date
     * @return
     */
    public String getJourDeLaSemaine(String date) {
        LocalDate localDate = LocalDate.parse(date);
        DayOfWeek day = localDate.getDayOfWeek();
        String jour = "null";
        switch (day.toString()) {
            case "MONDAY":
                jour = "Lundi";
                break;
            case "TUESDAY":
                jour = "Mardi";
                break;
            case "WEDNESDAY":
                jour = "Mercredi";
                break;
            case "THURSDAY":
                jour = "Jeudi";
                break;
            case "FRIDAY":
                jour = "Vendredi";
                break;
            case "SATURDAY":
                jour = "Samedi";
                break;
            case "SUNDAY":
                jour = "Dimanche";
                break;
        }
        return jour;
    }

    public void control() {
        ve.getBoutonEmploiDuTemps().addActionListener(this);
        ve.getBoutonSallesLibres().addActionListener(this);
        ve.getBoutonReporting().addActionListener(this);
        ve.getJComboBoxSelectionVue().addItemListener(this);
        ve.setTableEnGrille(dtm);
        ve.setVisible(true);
        System.out.println("Control");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == ve.getBoutonEmploiDuTemps()) {
            ve.showEmploiDuTemps();
        }
        if (ae.getSource() == ve.getBoutonSallesLibres()) {
            ve.showSallesLibres();
        }
        if (ae.getSource() == ve.getBoutonReporting()) {
            ve.showReporting();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        if (ie.getStateChange() == ItemEvent.SELECTED) {
            switch (ve.getJComboBoxSelectionVue().getSelectedItem().toString()) {
                case "en grille":
                    montrerVueEnGrille();
                    break;
                case "en liste":
                    System.out.println("liste");
                    montrerVueEnListe();
                    break;
            }
        }
    }

    public void montrerVueEnGrille() {
        System.out.println("grille");
        String[][] data = new String[84][7];
        int g = 0;
        int colinc = 1;
        int rowinc = 0;
        String jour = "null";
        jour = getJourDeLaSemaine(listSeances.get(0).getDate());
        while (g < listSeances.size()) {
            System.out.println("id: " + g);
            if (jour == getJourDeLaSemaine(listSeances.get(g).getDate())) {
                //System.out.println("Jour: " + jour);
                data[rowinc][colinc] = listSeances.get(g).stringify();
                rowinc++;
                g++;
            } else {
                colinc++;
                rowinc = 0;
                jour = getJourDeLaSemaine(listSeances.get(g).getDate());
            }
        }

        for (int i = 0; i < 7; i++) {
            data[i][0] = "De " + listSeances.get(i).getDebutHeure() + " a " + listSeances.get(i).getFinHeure();
        }

        DefaultTableModel dtm = new DefaultTableModel(
                data,
                new String[]{
                    " ", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"
                }
        );
        ve.changeAVueEnGrille(dtm);
        ve.setVisible(true);
    }

    public void montrerVueEnListe() {
        String[][] data2 = new String[listSeances.size()][1];
        for (int i = 0; i < listSeances.size(); i++) {
            data2[i][0] = getJourDeLaSemaine(listSeances.get(i).getDate()) + "     " + listSeances.get(i).stringify();
        }

        DefaultTableModel dtm2 = new DefaultTableModel(
                data2,
                new String[]{
                    " "
                }
        );
        ve.changeAVueEnListe(dtm2);
        ve.setVisible(true);
    }

    public static void main(String[] args) {
        EtudiantDAO dao = new EtudiantDAO();
        Etudiant m = new Etudiant();
        m = dao.chercher(525);
        EtudiantVue v = new EtudiantVue("Etudiant Vue");
        EDTControleur controler = new EDTControleur(m, v);
        controler.control();
    }
}
