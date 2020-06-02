package emploidutempsece;

import javax.swing.JFrame;
import dao.SalleDAO;
import dao.SiteDAO;
import java.util.ArrayList;
import modele.Salle;
import modele.Site;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
public class PieChart extends JFrame {

    private static final long serialVersionUID = 1L;

    /**
     *
     * @param applicationTitle
     * @param chartTitle
     */
    public PieChart(String applicationTitle, String chartTitle) {
        super(applicationTitle);
        // On crée la dataset
        PieDataset dataset = creationPieDataset();
        // On crée la chart grâce à la dataset
        JFreeChart chart = creationDiag3D(dataset, chartTitle);
        // On met la chart dans un panel
        ChartPanel chartPanel = new ChartPanel(chart);
        // Taille par défaut
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        // On ajoute à l'application
        setContentPane(chartPanel);
    }

    /**
     * Créer un exemple de dataset
     */
    private PieDataset creationPieDataset() {
        DefaultPieDataset result = new DefaultPieDataset();

        SiteDAO si = new SiteDAO();
        ArrayList<Site> sites = new ArrayList<Site>();
        sites = si.chercherTousLesSites();

        for (Salle salle : sites.get(1).getSalles()) {
            result.setValue(salle.getNomSalle(), salle.getCapacite());
        }
        return result;
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

    public static void main(String[] args) {
        PieChart demo = new PieChart("Capacité des salles", "Site : ");
        demo.pack();
        demo.setVisible(true);
    }
}
