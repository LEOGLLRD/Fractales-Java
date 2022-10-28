package Graphique;


import javax.swing.*;
import java.awt.*;


public class Fractale extends JPanel {

    double xmin = -2;
    double xmax = 0.5;
    double ymin = -1.25;
    double ymax = 1.25;
    int zoom = 100;
    int maxIterations = 50;

    double largeur = 500;
    double hauteur = 500;

    // on calcule la taille de l'image :


    public Fractale() {
        this.setSize((int) largeur, (int) hauteur);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawFractale(g);

    }

    public void drawFractale(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

//test
        for (int x = 0; x < largeur; x++) {

            for (int y = 0; y < hauteur; y++) {


                double cx = (x * (xmax - xmin) / largeur + xmin);
                double cy = (y * (ymax - ymin) / hauteur + ymin);
                double xn = 0;
                double yn = 0;
                int i = 0;
                do {
                    double tmp_x = xn;
                    double tmp_y = yn;
                    xn = tmp_x * tmp_x - tmp_y * tmp_y + cx;
                    yn = 2 * tmp_x * tmp_y + cy;
                    i++;

                }while ((xn * xn + yn * yn) < 4 && i < maxIterations);
                if (i == maxIterations) {
                    g2.setColor(Color.BLACK);
                } else {

                    g2.setColor(new Color(255* i / maxIterations, 0, 0));
                }

                g2.drawLine(x, y, x, y);

            }

        }

        System.out.println("finished");



    }

    public Color getColor(double i) {

        return Color.BLACK;

    }

}
