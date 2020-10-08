/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polinomioTermino;

/**
 * Almacenar los datos de un termino en la representación de un polinomio.
 *
 * @author alejandroescobar
 */
public class Termino {

    // Variable para almacenar el exponente
    private int e;
    // Variable para almacenar el coeficiente
    private double c;

    public Termino(int e, double c) {
        this.e = e;
        this.c = c;
    }

    /**
     * Obtener el exponente
     *
     * @return
     */
    public int getE() {
        return e;
    }

    /**
     * Fijar el exponente
     *
     * @param e
     */
    public void setE(int e) {
        this.e = e;
    }

    /**
     * Obtener el Coeficiente del termino
     *
     * @return
     */
    public double getC() {
        return c;
    }

    /**
     * Fijar el coeficiente
     *
     * @param c
     */
    public void setC(double c) {
        this.c = c;
    }

}
