package Graphique;

import java.awt.Frame;
import javax.media.opengl.*;
import javax.media.opengl.awt.GLCanvas;

public class AWTFrame implements GLEventListener {

    @Override
    public void init(GLAutoDrawable glAutoDrawable) {

    }

    @Override
    public void dispose(GLAutoDrawable glAutoDrawable) {

    }

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {

    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }

    public static void main(String[] args) {


        final GLProfile gp = GLProfile.get(GLProfile.GL4);
        GLCapabilities cap = new GLCapabilities(gp);


        final GLCanvas gc = new GLCanvas(cap);
        AWTFrame af = new AWTFrame();
        gc.addGLEventListener(af);
        gc.setSize(350, 350);

        //Now creating a frame using Frame class of AWT
        final Frame frame = new Frame ("AWT Frame");

        frame.add(gc);
        frame.setSize( 500, 400 );
        frame.setVisible(true);
    }
}
