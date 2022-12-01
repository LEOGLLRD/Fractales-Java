package Graphique;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;

public abstract class FractaleAbstract extends JPanel implements MouseMotionListener, MouseWheelListener, MouseListener {


    Color[] colorsWhiteToBlueToOrange = {

            new Color(0, 6, 255), new Color(7, 10, 248), new Color(13, 14, 242), new Color(20, 18, 235),
            new Color(26, 21, 229), new Color(33, 25, 222), new Color(39, 29, 216), new Color(46, 33, 209),
            new Color(52, 37, 203), new Color(59, 41, 196), new Color(65, 44, 190), new Color(72, 48, 183),
            new Color(78, 52, 177), new Color(85, 56, 170), new Color(92, 60, 163), new Color(98, 64, 157),
            new Color(105, 68, 150), new Color(111, 71, 144), new Color(118, 75, 137), new Color(124, 79, 131),
            new Color(131, 83, 124), new Color(137, 87, 118), new Color(144, 91, 111), new Color(150, 94, 105),
            new Color(157, 98, 98), new Color(163, 102, 92), new Color(170, 106, 85), new Color(177, 110, 78),
            new Color(183, 114, 72), new Color(190, 118, 65), new Color(196, 121, 59), new Color(203, 125, 52),
            new Color(209, 129, 46), new Color(216, 133, 39), new Color(222, 137, 33), new Color(229, 141, 26),
            new Color(235, 144, 20), new Color(242, 148, 13), new Color(248, 152, 7), new Color(255, 156, 0),
            new Color(255, 156, 0), new Color(255, 158, 19), new Color(255, 161, 31), new Color(255, 163, 40),
            new Color(255, 166, 49), new Color(255, 168, 56), new Color(255, 171, 63), new Color(255, 173, 70),
            new Color(255, 176, 76), new Color(255, 178, 82), new Color(255, 181, 88), new Color(255, 183, 94),
            new Color(255, 186, 100), new Color(255, 188, 106), new Color(255, 191, 112), new Color(255, 193, 118),
            new Color(255, 196, 123), new Color(255, 198, 129), new Color(255, 201, 135), new Color(255, 204, 141),
            new Color(255, 206, 146), new Color(255, 209, 152), new Color(255, 211, 158), new Color(255, 214, 163),
            new Color(255, 216, 169), new Color(255, 219, 175), new Color(255, 221, 180), new Color(255, 224, 186),
            new Color(255, 226, 192), new Color(255, 229, 197), new Color(255, 232, 203), new Color(255, 234, 209),
            new Color(255, 237, 214), new Color(255, 239, 220), new Color(255, 242, 226), new Color(255, 245, 232),
            new Color(255, 247, 238), new Color(255, 250, 243), new Color(255, 252, 249), new Color(255, 255, 255),
            new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255),
            new Color(255, 255, 255)
    };


    double xmin = -2;
    double xmax = 2;
    double ymin = -1.75;
    double ymax = 1.75;
    int zoom = 0;
    int maxIterations = 40;

    double largeur = 750;
    double hauteur = 1000;

    //Variable pour le zoom et le deplacement

    double zoom_x = 1;
    double zoom_y = 1;
    int draggedX;
    int draggedY;


    public FractaleAbstract() {
        this.setSize((int) largeur, (int) hauteur);
        this.addMouseMotionListener(this);
        this.addMouseWheelListener(this);
        this.addMouseListener(this);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawFractale(g);

    }

    public abstract void drawFractale(Graphics g);


    public double convertXposToCx(int posx) {

        return (posx * (xmax - xmin) / largeur + xmin);

    }

    /*Conversion d'une position Y, en une valeur cy tel que z = cx + cy*i
    Conversion d'une ordonnée vers un plan complex se basant sur l'intervalle [ymin-ymax]
    */
    public double convertYposToCy(int posy) {

        return (posy * (ymin - ymax) / hauteur + ymax);

    }

}
