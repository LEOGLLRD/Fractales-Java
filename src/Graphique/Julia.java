package Graphique;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class Julia extends FractaleAbstract{

    double xmin = -1;
    double xmax = 1;
    double ymin = -1.2;
    double ymax = 1.2;

    public void drawFractale(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        for (int x = 0; x < largeur; x++) {

            for (int y = 0; y < hauteur; y++) {

                double cx = 0.285;
                double cy = 0.01 ;
                double xn = convertXposToCx(x);
                double yn = convertYposToCy(y);


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
