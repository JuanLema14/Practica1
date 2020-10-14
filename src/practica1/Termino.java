package practica1;

public class Termino {

    // Variable para almacenar el exponente
    private int e;
    // Variable para almacenar el coeficiente
    private double c;

    public Termino(int e, double c) {
        this.e = e;
        this.c = c;
    }
    
    public int getE() {
        return e;
    }
    public void setE(int e) {
        this.e = e;
    }
    
    public double getC() {
        return c;
    }
    
    public void setC(double c) {
        this.c = c;
    }

}
