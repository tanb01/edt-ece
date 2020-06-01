package vue;

/**
 *
 * @author Benjamin Tan, Quentin Bonnard, Diana Ortiz
 */
import java.awt.Graphics;
import javax.swing.JPanel;

class GridsCanvas extends JPanel {

    int width, height;
    int rows;
    int cols;

    /**
     * 
     * @param w
     * @param h
     * @param r
     * @param c 
     */
    GridsCanvas(int w, int h, int r, int c) {
        setSize(width = w, height = h);
        rows = r;
        cols = c;
    }

    /**
     * 
     * @param g 
     */
    public void paint(Graphics g) {
        int i;
        width = getSize().width;
        height = getSize().height;

        // Dessiner les lignes
        int rowHt = height / (rows);
        for (i = 0; i < rows; i++) {
            g.drawLine(0, i * rowHt, width, i * rowHt);
        }

        // Dessiner les colonnes
        int rowWid = width / (cols);
        for (i = 0; i < cols; i++) {
            g.drawLine(i * rowWid, 0, i * rowWid, height);
        }
    }
}
