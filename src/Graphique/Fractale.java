package Graphique;


import javax.swing.*;
import java.awt.*;
import java.util.Set;


public class Fractale extends JPanel {

    Color[] colorsBlueToOrange1 = {
            new Color(0, 0, 0), new Color(2, 4, 39),
            new Color(3, 6, 55), new Color(4, 7, 67),
            new Color(5, 8, 78), new Color(5, 9, 87),
            new Color(6, 10, 95), new Color(6, 11, 103),
            new Color(7, 12, 110), new Color(7, 12, 117),
            new Color(8, 13, 123), new Color(8, 14, 129),
            new Color(8, 14, 135), new Color(9, 15, 140),
            new Color(9, 16, 146), new Color(9, 16, 151),
            new Color(10, 17, 156), new Color(10, 17, 160),
            new Color(10, 18, 165), new Color(10, 18, 170),
            new Color(11, 19, 174), new Color(11, 19, 178),
            new Color(11, 20, 183), new Color(12, 20, 187),
            new Color(12, 20, 191), new Color(12, 21, 195),
            new Color(12, 21, 198), new Color(12, 22, 202),
            new Color(13, 22, 206), new Color(13, 22, 210),
            new Color(13, 22, 210), new Color(41, 30, 207),
            new Color(56, 37, 205), new Color(69, 43, 202),
            new Color(79, 47, 199), new Color(88, 52, 196),
            new Color(96, 56, 193), new Color(104, 60, 190),
            new Color(111, 63, 187), new Color(117, 67, 184),
            new Color(124, 70, 181), new Color(130, 73, 178),
            new Color(135, 76, 175), new Color(141, 79, 172),
            new Color(146, 82, 168), new Color(151, 84, 165),
            new Color(156, 87, 162), new Color(161, 89, 158),
            new Color(165, 92, 154), new Color(170, 94, 151),
            new Color(174, 96, 147), new Color(179, 99, 143),
            new Color(183, 101, 139), new Color(187, 103, 135),
            new Color(191, 105, 131), new Color(195, 107, 126),
            new Color(199, 109, 122), new Color(202, 111, 117),
            new Color(206, 113, 112), new Color(210, 115, 107),
            new Color(213, 117, 102), new Color(217, 119, 96),
            new Color(220, 121, 90), new Color(224, 123, 84),
            new Color(227, 124, 76), new Color(230, 126, 69),
            new Color(233, 128, 60), new Color(237, 130, 50),
            new Color(240, 131, 37), new Color(243, 133, 15)

    };

    Color[] colorsBlueToOrange2 = {
            new Color(13, 22, 210),
            new Color(41, 30, 207),
            new Color(56, 37, 205),
            new Color(69, 43, 202),
            new Color(79, 47, 199),
            new Color(88, 52, 196),
            new Color(96, 56, 193),
            new Color(104, 60, 190),
            new Color(111, 63, 187),
            new Color(117, 67, 184),
            new Color(124, 70, 181),
            new Color(130, 73, 178),
            new Color(135, 76, 175),
            new Color(141, 79, 172),
            new Color(146, 82, 168),
            new Color(151, 84, 165),
            new Color(156, 87, 162),
            new Color(161, 89, 158),
            new Color(165, 92, 154),
            new Color(170, 94, 151),
            new Color(174, 96, 147),
            new Color(179, 99, 143),
            new Color(183, 101, 139),
            new Color(187, 103, 135),
            new Color(191, 105, 131),
            new Color(195, 107, 126),
            new Color(199, 109, 122),
            new Color(202, 111, 117),
            new Color(206, 113, 112),
            new Color(210, 115, 107),
            new Color(213, 117, 102),
            new Color(217, 119, 96),
            new Color(220, 121, 90),
            new Color(224, 123, 84),
            new Color(227, 124, 76),
            new Color(230, 126, 69),
            new Color(233, 128, 60),
            new Color(237, 130, 50),
            new Color(240, 131, 37),
            new Color(243, 133, 15)
    };

    Color[] colorsWhiteToBlueToOrange = {new Color(255, 255, 255),
            new Color(13, 22, 210),
            new Color(60, 43, 204),
            new Color(84, 57, 199),
            new Color(102, 67, 193),
            new Color(118, 77, 187),
            new Color(131, 85, 180),
            new Color(144, 93, 174),
            new Color(155, 100, 167),
            new Color(166, 106, 160),
            new Color(176, 113, 152),
            new Color(185, 118, 145),
            new Color(194, 124, 136),
            new Color(203, 129, 127),
            new Color(211, 135, 118),
            new Color(219, 140, 108),
            new Color(227, 144, 96),
            new Color(234, 149, 83),
            new Color(241, 153, 68),
            new Color(248, 158, 48),
            new Color(255, 162, 0),
            new Color(255, 255, 255),
            new Color(248, 248, 253),
            new Color(241, 241, 251),
            new Color(234, 234, 248),
            new Color(227, 227, 246),
            new Color(219, 219, 244),
            new Color(211, 211, 242),
            new Color(203, 203, 239),
            new Color(194, 195, 237),
            new Color(185, 186, 235),
            new Color(176, 176, 232),
            new Color(166, 166, 230),
            new Color(155, 156, 228),
            new Color(144, 144, 225),
            new Color(131, 132, 223),
            new Color(118, 119, 220),
            new Color(102, 103, 218),
            new Color(84, 85, 215),
            new Color(60, 62, 213),
            new Color(13, 22, 210)
    };


    double xmin = -2;
    double xmax = 2;
    double ymin = -1.75;
    double ymax = 1.75;
    int zoom = 100;
    int maxIterations = 40;

    double largeur = 1000;
    double hauteur = 1000;

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

                //Valeur de test

                double xn = (x * (xmax - xmin) / largeur + xmin);
                double yn = (y * (ymin - ymax) / hauteur + ymax);
                double cx = -0.2;
                double cy = 0.7;




                /*  Buddhabrot  XMIN, XMAX, YMIN, YMAX = -1.25, 1.25, -1.25, +1.25

                double xn = (x * (xmax - xmin) / largeur + xmin);
                double yn = (y * (ymin - ymax) / hauteur + ymax);
                double cx = 0.285;
                double cy = 0.01;

                 */


                /*  Connait pas le nom

                double xn = (x * (xmax - xmin) / largeur + xmin);
                double yn = (y * (ymin - ymax) / hauteur + ymax);
                double cx = -0.2;
                double cy = 0.7;

                 */

                // Mandelbrot  XMIN, XMAX, YMIN, YMAX = -2, +0.5, -1.25, +1.25

                /*
                double cx = (x * (xmax - xmin) / largeur + xmin);
                double cy = (y * (ymin - ymax) / hauteur + ymax);
                double xn = 0;
                double yn = 0;
                */

                int i = 0;
                do {
                    double tmp_x = xn;
                    double tmp_y = yn;
                    xn = tmp_x * tmp_x - tmp_y * tmp_y + cx;
                    yn = 2 * tmp_x * tmp_y + cy;
                    i++;

                } while ((xn * xn + yn * yn) < 4 && i < maxIterations);
                if (i == maxIterations) {
                    g2.setColor(Color.BLACK);
                } else {

                    g2.setColor(colorsWhiteToBlueToOrange[i]);
                }

                g2.drawLine(x, y, x, y);

            }

        }

        System.out.println("finished");


    }



}
