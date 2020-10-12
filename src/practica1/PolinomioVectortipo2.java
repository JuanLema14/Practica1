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
    
    public static double convertirCadena(String p){
        p= p.toLowerCase();
        char[] cadena= p.toCharArray();
        double[]polinomio={};
        String c=" ";
        int m=0;
        for(int i=1;i<cadena.length;i++){
            
            if(!(Character.isDigit(cadena[i]))){
                if(cadena[i]=='-'){
                    c="-";
                }else if(cadena[i]=='x' && !(Character.isDigit(cadena[i-1]))){
                    c+="1";
                    polinomio[i]=Double.parseDouble(c);
                    m+=1;
                }
            }else if(Character.isDigit(cadena[i])){
                if(cadena[i-1]=='^'){
                    c+=cadena[i];
                    polinomio[i]=Double.parseDouble(c);
                }else{
                    c+=cadena[i];
                    polinomio[i]=Double.parseDouble(c);
                    m+=1;
                }
            }
        }
        polinomio[0]=m;
        return polinomio[];
    }
    
}
