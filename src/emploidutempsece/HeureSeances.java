package emploidutempsece;

import javax.swing.JFrame;
import dao.SalleDAO;
import dao.SeanceDAO;
import dao.SiteDAO;
import java.util.ArrayList;
import modele.Salle;
import modele.Seance;
import modele.Site;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class HeureSeances {
    private static final long serialVersionUID = 1L;

    /**
     *
     * @param applicationTitle
     * @param chartTitle
     */
//    public HeureSeances(String applicationTitle, String chartTitle) {
//        super(applicationTitle);
//        // On crée la dataset
//        //   PieDataset dataset = creationPieDataset();
//        DefaultCategoryDataset dataset = creationHistoDataset();
//        // On crée la chart grâce à la dataset
//        //  JFreeChart chart = creationDiag2D(dataset, chartTitle);
//        //  JFreeChart chart = creationDiag3D(dataset, chartTitle);
//        JFreeChart chart = creationHisto(dataset, chartTitle);
//        // On met la chart dans un panel
//        ChartPanel chartPanel = new ChartPanel(chart);
//        // Taille par défaut
//        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
//        // On ajoute à l'application
//        setContentPane(chartPanel);
//    }

    /**
     * Créer un exemple de dataset
     */
    private PieDataset creationPieDataset() {
        DefaultPieDataset result = new DefaultPieDataset();

        SeanceDAO si = new SeanceDAO();
        ArrayList<Seance> seances = new ArrayList<Seance>();
        seances = si.chercherToutesLesSeances();

//        for (Seance seance : seances.get(2).getSeanceId()) {
//            result.setValue(seance.getCoursSeance(), seance.getDebutHeure());
//        }
        return result;
    }
    
    private DefaultCategoryDataset creationHistoDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        SiteDAO si = new SiteDAO();
        ArrayList<Site> sites = new ArrayList<Site>();
        sites = si.chercherTousLesSites();
        
        for (Salle salle : sites.get(2).getSalles()) {
            dataset.addValue(salle.getCapacite(), sites.get(2).getNomSite(), salle.getNomSalle()); 
        }
        for (Salle salle : sites.get(3).getSalles()) {
            dataset.addValue(salle.getCapacite(), sites.get(3).getNomSite(), salle.getNomSalle()); 
        }
        return dataset;
    }

    /**
     * Crée le diagramme 3D
     *
     * @param dataset
     * @param title
     * @return
     */
    private JFreeChart creationDiag3D(PieDataset dataset, String title) {

        JFreeChart pieChart3D = ChartFactory.createPieChart3D(
                title, // chart title
                dataset, // data
                true, // include legend
                true,
                false
        );

        PiePlot3D plot = (PiePlot3D) pieChart3D.getPlot();
        plot.setStartAngle(290);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        return pieChart3D;
    }

    /**
     * Crée le diagramme 2D
     *
     * @param dataset
     * @param title
     * @return
     */
    private JFreeChart creationDiag(PieDataset dataset, String title) {
        JFreeChart pieChart = ChartFactory.createPieChart(
                title, // chart title
                dataset, // data
                true, // include legend
                true,
                false
        );
        return pieChart;
    }
    
    private JFreeChart creationHisto(DefaultCategoryDataset dataset, String title) {
        
        final JFreeChart barChart = ChartFactory.createBarChart(title, "Cours", "Heure",
                dataset, PlotOrientation.VERTICAL, true, true, false);

        final ChartPanel cPanel = new ChartPanel(barChart);
        return barChart;
    }

    /**
     * 
     * @param args 
     */
//    public static void main(String[] args) {
//        HeureSeances demo = new HeureSeances("Nombres de séances par cours", "Heures");
//        demo.pack();
//        demo.setVisible(true);
//    }
}
