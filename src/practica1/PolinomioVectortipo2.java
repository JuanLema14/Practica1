/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import polinomioTermino.Termino;

public class PolinomioVectortipo2 {
    
    private final Termino[] datosP;
    
    public PolinomioVectortipo2(Termino[] Pdatos) {
        datosP= Pdatos;
    }
    
    public int getGrado() {
        return datosP[0].getExponente();
    }
    
    public String mostrarp(){
        StringBuilder polinomio = new StringBuilder();
        if(datosP==null){
            return"0";
        }
        for(Termino t1 : datosP){
            double c =t1.getCoeficiente();
            int e=t1.getExponente();
            
            if(c>=0){
                polinomio.append("+");
            }
            polinomio.append(c).append("X^").append(e).append(" ");
        }
        return polinomio.toString();
    }
}
