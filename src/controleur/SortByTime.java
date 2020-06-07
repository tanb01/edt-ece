package controleur;

import dao.SeanceDAO;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import static java.util.Collections.sort;
import java.util.Comparator;
import modele.Seance;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class SortByTime implements Comparator<Seance> {

    @Override
    public int compare(Seance t, Seance t1) {

        LocalTime time = LocalTime.parse(t.getDebutHeure());
        LocalTime timet1 = LocalTime.parse(t1.getDebutHeure());

        if (time.compareTo(timet1) > 0) {
            return 1;
        } else if (time.compareTo(timet1) < 0) {
            return -1;
        } else {
            return 0;
        }
    }
    
//test sort
    public static void main(String[] args) {
        SeanceDAO dao = new SeanceDAO();
        ArrayList<Seance> s = new ArrayList<Seance>();
        s = dao.chercherToutesLesSeances();
        Collections.shuffle(s);
        sort(s, new SortByTime());
        for (Seance d : s) {
            System.out.println(d.getNumeroSemaine());
            System.out.println(d.getDate());
            System.out.println(d.getDebutHeure());
        }
    }
}
