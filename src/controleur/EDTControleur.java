package controleur;

import dao.EtudiantDAO;
import dao.SeanceDAO;
import java.awt.Color;
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
import modele.Cours;
import modele.Enseignant;
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
    private ArrayList<Seance> listSeancesSelectionnees = null;
    private int numeroSemaineSelected = 1;
    private int numeroVueEDT = 0;

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
        listSeancesSelectionnees = new ArrayList<Seance>();
        listSeancesSelectionnees = seance.chercherSeancesParGroupeIdEtNumeroSemaine(e.getGroupeId(), numeroSemaineSelected);

        String[][] data = new String[84][100];

        String[] horairesPossibles = new String[]{"08:30-10:00", "10:15-11:45", "12:00-13:30", "13:45-15:15", "15:30-17:00", "17:15-18:45", "19:00-20:30"};
        for (int i = 0; i < 7; i++) {
            data[i][0] = horairesPossibles[i];
        }

        int g = 0;
        int colinc = 1;
        String jour = "null";
        jour = getJourDeLaSemaine(listSeancesSelectionnees.get(0).getDate());

        // Vue en grille
        while (g < listSeancesSelectionnees.size()) {
            //System.out.println("id: " + g);
            if (jour == getJourDeLaSemaine(listSeancesSelectionnees.get(g).getDate())) {
                for (int i = 0; i < 7; i++) {
                    if ((listSeancesSelectionnees.get(g).getDebutHeure() + "-" + listSeancesSelectionnees.get(g).getFinHeure()).equals(data[i][0])) {
                        data[i][colinc] = listSeancesSelectionnees.get(g).stringify();
                    }
                }
                g++;
            } else {
                colinc++;
                jour = getJourDeLaSemaine(listSeancesSelectionnees.get(g).getDate());
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
        for (JButton bouton : ve.getBoutonsSemaine()) {
            bouton.addActionListener(this);
        }
        ve.getBoutonSallesLibres().addActionListener(this);
        ve.getBoutonReporting().addActionListener(this);
        ve.getJComboBoxSelectionVue().addItemListener(this);

        ve.getJComboBoxFilterSelection().addItemListener(this);

        ve.getJComboBoxFilterSelectionEx().addItemListener(this);

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
        for (JButton bouton : ve.getBoutonsSemaine()) {
            if (ae.getSource() == bouton) {
                numeroSemaineSelected = (ve.getBoutonsSemaine().indexOf(bouton)) + 1;
                ve.selectSemaine(numeroSemaineSelected);
                affecterSeancesDeSemaine();
                montrerEDT();
            }
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
            switch (ve.getJComboBoxFilterSelection().getSelectedItem().toString()) {
                case " ":
                    ve.getJComboBoxFilterSelectionEx().setSelectedIndex(0);
                    ve.selectSemaine(numeroSemaineSelected);
                    affecterSeancesDeSemaine();
                    montrerEDT();
                    break;
                case "Nom enseignant(e)":
                    ArrayList<String> names = new ArrayList();
                    getListeEnseignants().forEach(enseignant -> names.add(enseignant.getNom()));
                    getListeEnseignants().forEach(enseignant -> System.out.println("f: " + enseignant.getNom()));

                    String[] n = new String[names.size()];
                    n[0] = " ";
                    for (int i = 1; i < names.size(); i++) {
                        n[i] = names.get(i - 1);
                    }

                    ve.setJComboBoxFilterSelectionText(n);
                    String nomEnseignant = ve.getJComboBoxFilterSelectionEx().getSelectedItem().toString();
                    listSeancesSelectionnees = filtrerParEnseignant(nomEnseignant);
                    montrerEDT();
                    break;
                case "Matière":
                    String nomMatiere = ve.getJComboBoxFilterSelectionEx().getSelectedItem().toString();
                    listSeancesSelectionnees = filtrerParMatiere(nomMatiere);
                    montrerEDT();
                    break;
            }
        }
    }

    public void affecterSeancesDeSemaine() {
        ArrayList<Seance> tempArray = new ArrayList<Seance>();
        listSeancesSelectionnees = new ArrayList<Seance>();
        for (Seance s : listSeances) {
            if (s.getNumeroSemaine() == numeroSemaineSelected) {
                tempArray.add(s);
                System.out.println("hi : " + s.getNumeroSemaine());
            }
        }
        if (!tempArray.isEmpty()) {
            listSeancesSelectionnees = tempArray;
        }
    }

    public void montrerVueEnGrille() {
        System.out.println("grille");
        String[][] data = new String[84][100];
        String[] horairesPossibles = new String[]{"08:30-10:00", "10:15-11:45", "12:00-13:30", "13:45-15:15", "15:30-17:00", "17:15-18:45", "19:00-20:30"};
        for (int i = 0; i < 7; i++) {
            data[i][0] = horairesPossibles[i];
        }

        int g = 0;
        int colinc = 1;
        String jour = "null";
        if (!listSeancesSelectionnees.isEmpty()) {
            jour = getJourDeLaSemaine(listSeancesSelectionnees.get(0).getDate());
        }

        // Vue en grille
        while (g < listSeancesSelectionnees.size()) {
            //System.out.println("id: " + g);
            if (jour == getJourDeLaSemaine(listSeancesSelectionnees.get(g).getDate())) {
                for (int i = 0; i < 7; i++) {
                    if ((listSeancesSelectionnees.get(g).getDebutHeure() + "-" + listSeancesSelectionnees.get(g).getFinHeure()).equals(data[i][0])) {
                        data[i][colinc] = listSeancesSelectionnees.get(g).stringify();
                    }
                }
                g++;
            } else {
                colinc++;
                jour = getJourDeLaSemaine(listSeancesSelectionnees.get(g).getDate());
            }
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
        String[][] data2 = new String[listSeancesSelectionnees.size()][1];
        for (int i = 0; i < listSeancesSelectionnees.size(); i++) {
            data2[i][0] = getJourDeLaSemaine(listSeancesSelectionnees.get(i).getDate()) + "     " + listSeancesSelectionnees.get(i).stringify();
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

    public void montrerEDT() {
        if (ve.getJComboBoxSelectionVue().getSelectedItem().toString().equals("en grille")) {
            montrerVueEnGrille();
        } else {
            montrerVueEnListe();
        }
    }

    public ArrayList<Seance> filtrerParEnseignant(String nomEnseignant) {
        ArrayList<Seance> tempArray = new ArrayList<Seance>();
        listSeancesSelectionnees = new ArrayList<Seance>();
        for (int i = 0; i < listSeances.size(); i++) {
            for (int j = 0; j < listSeances.get(i).getListeEnseignants().size(); j++) {
                for (Enseignant e : listSeances.get(i).getListeEnseignants()) {
                    if (e.getNom().equals(nomEnseignant)) {
                        tempArray.add(listSeances.get(i));
                    }
                }
            }
        }
//        if (!tempArray.isEmpty()) {
//            listSeancesSelectionnees = tempArray;
//        }
        return tempArray;
    }

    public ArrayList<Seance> filtrerParMatiere(String nomMatiere) {
        ArrayList<Seance> tempArray = new ArrayList<Seance>();
        for (int i = 0; i < listSeances.size(); i++) {
            if (listSeances.get(i).getCoursSeance().getNomCours().equals(nomMatiere)) {
                tempArray.add(listSeances.get(i));
            }
        }
        return tempArray;
    }

    public ArrayList<Enseignant> getListeEnseignants() {
        ArrayList<Enseignant> tempArray = new ArrayList<Enseignant>();
        for (int i = 0; i < listSeances.size(); i++) {
            for (int j = 0; j < listSeances.get(i).getListeEnseignants().size(); j++) {
                for (Enseignant e : listSeances.get(i).getListeEnseignants()) {
                    tempArray.add(e);
                }
            }
        }
        return tempArray;
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
