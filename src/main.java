import Complex.Complex;
import Graphique.Fractale;
import Graphique.Window;

public class main {
    public static void main(String[] args) {
        Fractale fractale = new Fractale();
        Window w = new Window("Fractale", fractale);


       /* Complex c = new Complex(1, 1);
        int i = 0;
        while (i < 10) {
            System.out.println(c.toString());
            System.out.println("module : " +c.module());
            Complex temp1 = (c.multiply(c));
            Complex temp2 = temp1.add(new Complex(1, 0));
            c = temp2;
            i++;
        }
        */
    }

}
