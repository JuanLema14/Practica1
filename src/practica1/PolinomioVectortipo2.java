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
    
    public static double[] convertirCadena(String p){
        p= p.toLowerCase();
        char[] cadena= p.toCharArray();
        double[]polinomioV={};
        String c="", e="";
        int m=0,j=0;
        for(int i=1;i<cadena.length;i++){
            
            if(!(Character.isDigit(cadena[i]))){
                if(cadena[i]=='-'){
                    c="-";
                }else if(cadena[i]=='x' && !(Character.isDigit(cadena[i-1]))){
                    c+="1";
                }
            }else if(Character.isDigit(cadena[i])){
                if(cadena[i-1]=='^'){
                    do{
                        e+=cadena[i];
                        i++;
                    }while(Character.isDigit(cadena[i]));
                    polinomioV[j+1]=Integer.parseInt(e);
                    polinomioV[j+2]=Double.parseDouble(c);
                    j+=2;
                    m+=1;
                }else{
                    c+=cadena[i];
                }
            }
        }
        return polinomioV;
    }
    
}
