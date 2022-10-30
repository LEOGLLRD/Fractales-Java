package Graphique;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Fractale extends JPanel implements MouseMotionListener, MouseWheelListener, MouseListener {


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

    double largeur = 1000;
    double hauteur = 1000;

    //Variable pour le zoom et le deplacement

    double zoom_x = 1;
    double zoom_y = 1;
    int draggedX;
    int draggedY;


    public Fractale() {
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

    public void drawFractale(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        for (int x = 0; x < largeur; x++) {

            for (int y = 0; y < hauteur; y++) {

                //Valeur de test

                double cx = convertXposToCx(x) / zoom_x;
                double cy = convertYposToCy(y) / zoom_y;
                double xn = 0;
                double yn = 0;




                /*  Buddhabrot  XMIN, XMAX, YMIN, YMAX = -1.25, 1.25, -1.25, +1.25

                double cx = convertXposToCx(x);
                double cy = convertYposToCy(y);
                double cx = 0.285;
                double cy = 0.01;

                 */


                /*  Connait pas le nom

                double cx = convertXposToCx(x);
                double cy = convertYposToCy(y);
                double cx = -0.2;
                double cy = 0.7;

                 */

                // Mandelbrot  XMIN, XMAX, YMIN, YMAX = -2, +0.5, -1.25, +1.25

                /*
                double cx = convertXposToCx(x);
                double cy = convertYposToCy(y);
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

    /*Conversion d'une position X, en une valeur cx tel que z = cx + cy*i
    Conversion d'une abscisse vers un plan complex se basant sur l'intervalle [xmin-xmax]
    */
    public double convertXposToCx(int posx) {

        return (posx * (xmax - xmin) / largeur + xmin);

    }

    /*Conversion d'une position Y, en une valeur cy tel que z = cx + cy*i
    Conversion d'une ordonnée vers un plan complex se basant sur l'intervalle [ymin-ymax]
    */
    public double convertYposToCy(int posy) {

        return (posy * (ymin - ymax) / hauteur + ymax);

    }

    //Permet d'obtenir le deplacement entre deux x d'un point
    //Avec x1 appartenant au premier point et x2 au deuxieme
    public double getMovementBetween2Cx(double cx1, double cx2) {

        return cx2 - cx1;

    }
    //Permet d'obtenir le deplacement entre deux y d'un point

    //Avec y1 appartenant au premier point et y2 au deuxieme
    public double getMovementBetween2Cy(double cy1, double cy2) {

        return cy2 - cy1;

    }

//MouseMotionListener

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("Dragged");

        //Ce sont les coordonnées actuelles de la souris
        double relativeCX = convertXposToCx(e.getX());
        double relativeCY = convertYposToCy(e.getY());

        double movX = getMovementBetween2Cx(convertXposToCx(draggedX), relativeCX);
        double movY = getMovementBetween2Cy(convertYposToCy(draggedY), relativeCY);

        System.out.println("cx : " + movX);
        System.out.println("cy : " + movY);


        xmin -= movX / 50;
        xmax -= movX / 50;
        ymin -= movY / 50;
        ymax -= movY / 50;
        repaint();


    }


    //Permet le zoom
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

        //Getting the mouse position on the Window

        int relativeX = e.getX();
        int relativeY = e.getY();

        System.out.println(" x : " + relativeX + " y : " + relativeY);

        double disX = Math.abs(xmax) - Math.abs(xmin);
        double disY = Math.abs(ymax) - Math.abs(ymin);


        double cx = convertXposToCx(relativeX);
        double cy = convertYposToCy(relativeY);

        System.out.println(" cx : " + cx + " cy : " + cy);


        if (e.getWheelRotation() < 0) {

            zoom_x++;
            zoom_y++;
            System.out.println("mouse wheel Up");
            repaint();


        } else {
            zoom_x--;
            zoom_y--;
            System.out.println("mouse wheel Down");
            repaint();

        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {


    }

    //MouseListener
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        //Ce sont les coordonnées qui ont été attrapé

        draggedX = e.getX();
        draggedY = e.getY();

    }

    @Override
    public void mouseReleased(MouseEvent e) {


    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
