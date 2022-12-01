package Graphique;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class Window extends JFrame {

    double x1 = -3;
    double x2 = 3;
    double y1 = -1;
    double y2 = 1;
    int zoom = 100;
    int maxIterations = 10;

    double image_x = (x2 - x1) * zoom;
    double image_y = (y2 - y1) * zoom;
    JPanel panel;


    public Window(JPanel panel) throws HeadlessException {

        this.panel = panel;
    }

    public Window(String name, FractaleAbstract f){
        super(name);
        this.setSize(f.getWidth(), f.getHeight());
        this.getContentPane().add(f);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(true);
        this.addComponentListener(new ComponentListener() {

            //Redimenssionnement + re calcul de la fractale

            @Override
            public void componentResized(ComponentEvent e) {
                f.largeur = getWidth();
                f.hauteur = getHeight();
                f.repaint();
            }

            @Override
            public void componentMoved(ComponentEvent e) {

            }

            @Override
            public void componentShown(ComponentEvent e) {

            }

            @Override
            public void componentHidden(ComponentEvent e) {

            }
        });

    }

}
