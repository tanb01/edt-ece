package controleur;

import dao.SeanceDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import static java.util.Collections.sort;
import java.util.Comparator;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.Seance;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class SortByDate implements Comparator<Seance> {

    @Override
    public int compare(Seance t, Seance t1) {
        Date d = null;
        Date d1 = null;
        try {
            SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
            d = sdformat.parse(t.getDate());
            d1 = sdformat.parse(t1.getDate());
        } catch (ParseException ex) {
            Logger.getLogger(SortByDate.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (d.compareTo(d1) > 0) {
            return 1;
        } else if (d.compareTo(d1) < 0) {
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
        sort(s, new SortByDate());
//        sort(s, new SortByDateTime().thenComparing(new SortByTime()));

        for (Seance d : s) {
            System.out.println(d.getNumeroSemaine());
            System.out.println(d.getDate());
            System.out.println(d.getDebutHeure());
        }
    }
}
