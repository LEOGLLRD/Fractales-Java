package Graphique;

import javax.swing.*;
import java.awt.*;

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

    public Window(String name, Fractale f){
        super(name);
        this.setSize(1000, 1000);
        this.getContentPane().add(f);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);


    }

}
