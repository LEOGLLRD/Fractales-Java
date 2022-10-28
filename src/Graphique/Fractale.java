package Graphique;

import Complex.Complex;

import javax.swing.*;
import java.awt.*;


public class Fractale extends JPanel {

    double x1 = -2.1;
    double x2 = 0.6;
    double y1 = -1.2;
    double y2 = 1.2;
    int maxIterations = 50;

    double image_x = 600;
    double image_y = 600;

    // on calcule la taille de l'image :
    double zoom_x = image_x/(x2 - x1);
    double zoom_y = image_y/(y2 - y1);





    public Fractale() {
        this.setSize((int) image_x, (int) image_y);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawFractale(g);

    }

    public void drawFractale(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;


        for (int x = 0; x < image_x; x++) {

            for (int y = 0; y < image_y; y++) {


                Complex c = new Complex((x + (x2 - x1) / image_x + x1), (y + (y2 - y1) / image_y + y1));
                Complex z = new Complex(0, 0);
                int i = 0;
                while ((z.imag*z.imag) + (z.real*z.real) < 4 && i < maxIterations) {
                    double temp = z.real;
                    z.real = (z.real*z.real) - (z.imag*z.imag) + c.real;
                    z.imag = 2 * z.imag * temp + c.imag;
                    i++;

                }
                if (i == maxIterations) {
                    g2.setColor(Color.BLACK);
                } else {

                    g2.setColor(Color.WHITE);
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
