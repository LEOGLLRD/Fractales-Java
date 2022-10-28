package Complex;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;

public class Complex {
    public double real = 0;
    public double imag = 0; //real, imag sont des variables d'instances

    public Complex() {
    } // on utilise la valeur par défaut 0 + i0

    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public void conjugate() {
        imag = -imag;
    }

    public Complex add(Complex c) {
        //le résultat est aussi un complexe, il faut donc introduire une autre variable de type Complexe
        Complex sum = new Complex();
        sum.real = real + c.real;
        sum.imag = imag + c.imag;
        return sum;
    }

    public Complex minus(Complex c) {
        //le résultat est aussi un complexe, il faut donc introduire une autre variable de type Complexe
        Complex minus = new Complex();
        minus.real = real - c.real;
        minus.imag = imag - c.imag;
        return minus;
    }

    public Complex multiply(Complex c) {

        Complex product = new Complex();
        product.real = (this.real * c.real) + (-this.imag * c.imag);
        product.imag = (this.imag * c.real) + (this.real * c.imag);
        return product;
    }

    public String toString() {
        // exemple de la méthode prépondérante
        if (imag >= 0)
            return real + "+i" + Math.abs(imag);
        else
            return real + "-i" + Math.abs(imag);
    }

    public static Complex getComplexFromString(String z) {
        try {
            int reel = Integer.parseInt(z.substring(z.indexOf("i") + 2));
            int imaginaire = Integer.parseInt(z.substring(z.indexOf("i") - 1, z.indexOf("i")));
            return new Complex(reel, imaginaire);
        } catch (Exception e) {
            System.out.println("Impossible de convertir le String en Complex !");
            return null;
        }


    }

    public double module() {
        return Math.sqrt((this.imag * this.imag) + (this.real * this.real));
    }
}