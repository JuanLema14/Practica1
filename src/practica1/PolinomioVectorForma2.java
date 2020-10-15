/*
 * Copyright 2019 Carlos Alejandro Escobar Marulanda ealejandro101@gmail.com
 * Permission is hereby granted, free of charge, to any person 
 * obtaining a copy of this software and associated documentation 
 * files (the "Software"), to deal in the Software without 
 * restriction, including without limitation the rights to use, 
 * copy, modify, merge, publish, distribute, sublicense, and/or 
 * sell copies of the Software, and to permit persons to whom the 
 * Software is furnished to do so, subject to the following 
 * conditions:
 * The above copyright notice and this permission notice shall 
 * be included in all copies or substantial portions of the 
 * Software.
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, 
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES 
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND 
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 *  WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING 
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR 
 * OTHER DEALINGS IN THE SOFTWARE.
 */
package practica1;

import javax.swing.JOptionPane;


/**
 *
 * @author alejandroescobar
 */
public class PolinomioVectorForma2 {

    private Termino[] loquesea;

    /**
     * Constructor para el polinomio
     *
     * @param loquesea arreglo de terminos del polinomios
     */
    public PolinomioVectorForma2(Termino[] loquesea) {
        this.loquesea = loquesea;
    }

    public PolinomioVectorForma2() {
        loquesea = null;
    }
    
    public PolinomioVectorForma2 crearVector(String p){
        p= p.toLowerCase();
        double[]polinomioV=new double[p.length()+2];
        String coeficiente="", exponente="";
        int m=0,j=0, x=1;
        char[] cadena=new char[p.length()+1];
        PolinomioVectorForma2 PolinomioVF2=new PolinomioVectorForma2();
        cadena[0]=(char) m;
        while (x <= p.length()) {
            cadena[x]=p.charAt(x-1);
            x=x+1;
        }
        for(int i=1;i<cadena.length;i++){
            
            if(!(Character.isDigit(cadena[i]))){
               if(cadena[i]=='-'){
                   if(cadena[i-1]=='^'){
                       exponente+="-";
                       i++;
                       while(i<cadena.length && Character.isDigit(cadena[i])){
                           exponente+=Character.toString(cadena[i]);
                           if(i==cadena.length){
                                break;
                           }else{
                                i++;
                           }
                       }
                       polinomioV[j+1]=Integer.parseInt(exponente);
                       exponente="";
                       polinomioV[j+2]=Double.parseDouble(coeficiente);
                       coeficiente="";
                       i=i-1;
                       j+=2;
                       m+=1;
                   }else{
                       coeficiente="-";   
                   }
                /*}else if(cadena[i]=='x' && !(Character.isDigit(cadena[i-1]))){
                    coeficiente+="1";*/
                }else if(i<cadena.length && cadena[i]=='x'){
                    if(cadena[i]=='x' && !(Character.isDigit(cadena[i-1]))){
                        coeficiente+="1";
                    }
                    if(i==cadena.length-1){
                        exponente+="1";
                        polinomioV[j+1]=Double.parseDouble(exponente);
                        exponente="";
                        polinomioV[j+2]=Double.parseDouble(coeficiente);
                        coeficiente="";
                        j+=2;
                        m+=1;
                    }else if(cadena[i+1]!='^'){
                        exponente+="1";
                        polinomioV[j+1]=Integer.parseInt(exponente);
                        exponente="";
                        polinomioV[j+2]=Double.parseDouble(coeficiente);
                        coeficiente="";
                        j+=2;
                        m+=1;
                    }
                }    
            }else if(Character.isDigit(cadena[i])){
                if(cadena[i-1]=='^'){
                    
                   do{
                       exponente+=Character.toString(cadena[i]);
                       if(i==cadena.length){
                           break;
                       }else{
                           i++;
                       }
                    }while(i<cadena.length && Character.isDigit(cadena[i]));

                    polinomioV[j+1]=Integer.parseInt(exponente);
                    exponente="";
                    polinomioV[j+2]=Double.parseDouble(coeficiente);
                    coeficiente="";
                    i=i-1;
                    j+=2;
                    m+=1;
                }else{
                    if(!"0".equals(Character.toString(cadena[i]))){
                        do{
                            coeficiente+=Character.toString(cadena[i]);
                            if(i==cadena.length){
                            break;
                        }else{
                           i++;
                       }
                        }while(i<cadena.length && Character.isDigit(cadena[i]));
                        i=i-1;
                        if(i==cadena.length-1 || cadena[i+1]=='-' || cadena[i+1]=='+'){
                            polinomioV[j+1]=0;
                            exponente="";
                            polinomioV[j+2]=Double.parseDouble(coeficiente);
                            coeficiente="";
                            j+=2;
                            m+=1;
                        }
                    }else if(Character.toString(cadena[i])=="0" && ((i==cadena.length-1) || !Character.isDigit(cadena[i+1]))){
                        i++;
                    }
                }
            }
        }
        polinomioV[0]=m;
        loquesea=new Termino[m+1];
        Termino prueba = new Termino(0, 0);
        double[] polinomioNormalizado=new double[(m*2)+1];
        for(int g=0;g<polinomioNormalizado.length;g++){
            polinomioNormalizado[g]=polinomioV[g];
        }
        for(int h=0;h<loquesea.length;h++){
            for(int k=0;k<polinomioNormalizado.length;k+=2){
                if(k==0){
                    prueba=new Termino((int)polinomioNormalizado[k],0);
                    loquesea[k]=prueba;
                    h++;
                }else {
                    prueba=new Termino((int)polinomioNormalizado[k-1],polinomioNormalizado[k]);
                    loquesea[h]=prueba;
                    h++;
            }
                
            }
        }
        
        PolinomioVF2= new PolinomioVectorForma2(loquesea);
        System.out.println(PolinomioVF2);
        return PolinomioVF2;
    }
    
    /*public static PolinomioVectorForma2 Multiplicar(PolinomioVectorForma2 polinomioA, PolinomioVectorForma2 polinomioB){
        PolinomioVectorForma2 polinomioC= new PolinomioVectorForma2();
        Termino objT = new Termino(polinomioA.getGrado()+polinomioB.getGrado(), 0);
        int mayor=polinomioA.getGrado()-polinomioB.getGrado(),i=1,pos=0,AuxE=0,m=0;
        Termino[] vectorTermino = new Termino[(polinomioA.getGrado()+polinomioB.getGrado())+2];
        double AuxC=0;
        vectorTermino[0]=objT;
        for(int j=1;i<polinomioB.getGrado()+1 || i<polinomioA.getGrado()+1;j++){
            pos++;
            if(mayor>0){
                if(j<polinomioA.getGrado()+1){
                    AuxC=polinomioA.getCo(j)*polinomioB.getCo(i);
                    AuxE=polinomioA.getExp(j)+polinomioB.getExp(i);
                    objT=new Termino(AuxE,AuxC);
                    vectorTermino[pos]=objT;
                }else if(j==polinomioA.getGrado()+1){
                    j=0;
                    i++;
                }
            }else if(mayor==0){
                if(j<polinomioB.getGrado()+1){
                    AuxC=polinomioA.getCo(i)*polinomioB.getCo(j);
                    AuxE=polinomioA.getExp(i)+polinomioB.getExp(j);
                    System.out.println(AuxC);
                    System.out.println(AuxE);
                    objT=new Termino(AuxE,AuxC);
                    vectorTermino[pos]=objT;
                }else if(j==polinomioB.getGrado()+1){
                    j=0;
                    i++;   
                }
            }else{
                if(j<polinomioB.getGrado()+1){
                    AuxC=polinomioA.getCo(i)*polinomioB.getCo(j);
                    AuxE=polinomioA.getExp(i)+polinomioB.getExp(j);
                    objT=new Termino(AuxE,AuxC);
                    vectorTermino[pos]=objT;
                }else if(j==polinomioB.getGrado()+1){
                    j=0;
                    i++;
                }
            }
        }
        polinomioC= new PolinomioVectorForma2(vectorTermino);
        return polinomioC;
    }*/
    public PolinomioVectorForma2 Multiplicar(PolinomioVectorForma2 polinomioB,PolinomioVectorForma2 polinomioA){
        PolinomioVectorForma2 polinomioC=new PolinomioVectorForma2();
        Termino[] terminosPolB = polinomioB.getTerminos();
        Termino[] terminosPolA = polinomioB.getTerminos();
        int TamB =  terminosPolB.length,TamA =  terminosPolA.length,i = 0,j=0,t=0;

         while(t< TamA){
            double coeA= terminosPolA[t].getC();
            int expA=terminosPolA[t].getE();
            Termino[] terminosPolD=new Termino[TamB];
            while(j< TamB){
                double coeB= terminosPolB[j].getC();
                int expB=terminosPolB[j].getE();

                double AuxC=coeA * coeB;
                int AuxE=expB+expA;
                Termino nuevoTermino=new Termino(AuxE,AuxC);
                terminosPolD[i]=nuevoTermino;
                i++;
                j++;
            }

            PolinomioVectorForma2 polinomioD=new PolinomioVectorForma2(terminosPolD);
            polinomioC = polinomioC.sumar(polinomioD);
            terminosPolD = null;
            i = 0;
            j = 0;
            t++; 

            }
        return polinomioC;
    }
        
    public PolinomioVectorForma2 sumar(PolinomioVectorForma2 polinomioB){
        PolinomioVectorForma2 polC = new PolinomioVectorForma2();
        
        if(this.getTerminos()== null){
            Termino[] terminosPolB = polinomioB.getTerminos();
            int cantidadTerminosPolB = terminosPolB.length;
            Termino[] terminosPolC = new Termino[cantidadTerminosPolB];
            int indicePolC = 0;
            int indRecorridoB = 0;
            while (indRecorridoB < cantidadTerminosPolB){
                int expB = terminosPolB[indRecorridoB].getE();
                double coeB = terminosPolB[indRecorridoB].getC();
                terminosPolC[indicePolC] = new Termino(expB,coeB );
                indRecorridoB++;
                indicePolC++;
            }
            polC = new PolinomioVectorForma2(terminosPolC);

            
        }else if(polinomioB.getTerminos()==null){
            Termino[] terminosPolA = this.getTerminos();
            int cantidadTerminosPolA = terminosPolA.length;
            Termino[] terminosPolC = new Termino[cantidadTerminosPolA];
            int indicePolC = 0;
            int indRecorridoA = 0;
            while (indRecorridoA < cantidadTerminosPolA){
                int expA = terminosPolA[indRecorridoA].getE();
                double coeA = terminosPolA[indRecorridoA].getC();
                terminosPolC[indicePolC] = new Termino(expA,coeA );
                indRecorridoA++;
                indicePolC++;
            }
            polC = new PolinomioVectorForma2(terminosPolC);
            
        }else{
            
            Termino[] terminosPolB = polinomioB.getTerminos();
            Termino[] terminosPolA = loquesea;
            
            
            int cantidadTerminosPolB =  terminosPolB.length;
            int cantidadTerminosPolA =  terminosPolA.length;

            Termino[] terminosPolC = new Termino[cantidadTerminosPolB + cantidadTerminosPolA];
             
            int indRecorridoB = 0;
            int indicePolC = 0;
            int indRecorridoA = 0;
            

            while (indRecorridoA < cantidadTerminosPolA && indRecorridoB < cantidadTerminosPolB){
                int expA = terminosPolA[indRecorridoA].getE();
                double coeA = terminosPolA[indRecorridoA].getC() ;
                int expB = terminosPolB[indRecorridoB].getE();
                double coeB = terminosPolB[indRecorridoB].getC();

                if(expA > expB){
                    terminosPolC[indicePolC] = new Termino(expA,coeA);
                    indRecorridoA++;
                    indicePolC++;
                }else if (expA == expB){
                    double posibleCoeficienteC = coeA+coeB;
                    if(posibleCoeficienteC != 0){
                        terminosPolC[indicePolC] =new Termino(expA,posibleCoeficienteC);
                        indicePolC++;
                    }
                    indRecorridoA++;
                    indRecorridoB++;
                }else {
                    terminosPolC[indicePolC]= new Termino(expB,coeB);
                    indRecorridoB++;
                    indicePolC++;
                }
            }
            while (indRecorridoA<cantidadTerminosPolA) {
                int expA = terminosPolA[indRecorridoA].getE();
                double canA = terminosPolA[indRecorridoA].getC();
                terminosPolC[indicePolC] =new Termino(expA,canA);
                indRecorridoA++;
                indicePolC++;
            }

            while (indRecorridoB < cantidadTerminosPolB){
                int expB = terminosPolB[indRecorridoB].getE();
                double coeB = terminosPolB[indRecorridoB].getC();
                terminosPolC[indicePolC] = new Termino(expB,coeB);
                indRecorridoB++;
                indicePolC++;
            }
            
            if (indicePolC == 0){
                polC = new PolinomioVectorForma2(null);
                return polC;
            }else{
                if (indicePolC < terminosPolC.length){
                    Termino[] terminosCTemporal = new Termino [indicePolC];
                    System.arraycopy(terminosPolC, 0, terminosCTemporal, 0,indicePolC);
                    polC = new PolinomioVectorForma2(terminosCTemporal);
                    return polC;
                }
            }
        }
        return polC;    
    }
    
     public double Evaluar(PolinomioVectorForma2 pol ,double x){
        double valorF=0;
        for(int i=1;i<=pol.getGrado();i++){
            valorF+=(pol.getCo(i)*(Math.pow(x,pol.getExp(i))));
        }
        return valorF;
    }
     
    public static PolinomioVectorForma2 Derivar(PolinomioVectorForma2 polinomioD){
        Termino obj =new Termino(polinomioD.getGrado(),0);
        Termino[] polinomix= new Termino[polinomioD.getGrado()+1];
        PolinomioVectorForma2 polinomioDerivado = new PolinomioVectorForma2();
        int auxE=0;
        double auxC=0.0;
        for(int i=1;i<polinomix.length;i++){
            auxC=(polinomioD.getCo(i))*(polinomioD.getExp(i));
            auxE=polinomioD.getExp(i)-1;
            obj = new Termino(auxE, auxC);
            polinomix[i]=obj;
        }
        polinomioDerivado= new PolinomioVectorForma2(polinomix);
        
        return polinomioDerivado;
    }

     
    /**
     * Obtener el grado del polinomio
     *
     * @return grado del polinomio
     */
    public int getGrado() {
        return loquesea[0].getE();
    }
    public int getExp(int pos){
        return loquesea[pos].getE();
    }
    public double getCo(int pos){
        return loquesea[pos].getC();
    }
    public void setExp(int ex,int pos){
        loquesea[pos].setE(ex);
    }
    public void setCo(double co,int pos){
        loquesea[pos].setC(co);
    }

    @Override
    public String toString() {
        StringBuilder polinomio = new StringBuilder();
        boolean primerTermino = true;
        if (loquesea == null) {
            return "0";
        }
        for (int t=1;t<loquesea.length;t++) {
            double j = loquesea[t].getC();
            int i = loquesea[t].getE();
            // Para adicionar el simbolo del coeficiente para numeros positivos, excluyendo el simbolo + del primer termino si es positivo.
            if (j >= 0) {
                polinomio.append("+");
            }
            polinomio.append(j).append("X^").append(i).append(" ");

        }
        return polinomio.toString();
    }

    /**
     * Obtener el arreglo de terminos del polinomio
     *
     * @return
     */
    public Termino[] getTerminos() {
        return loquesea;
    }

    /**
     * Cantidad de terminos diferentes de coeficiente 0 en el polinomio
     *
     * @return
     */
    public int getDiferentesCero() {
        return this.loquesea.length;
    }

    /**
     * Obtiene el coeficiente de un termino dado un exponente
     *
     * @param exponente
     * @return
     */
    public double getCoeficiente(int exponente) {
        double coeficiente = 0;
        for (Termino t : loquesea) {
            if (t.getE() == exponente) {
                return t.getC();
            }
        }
        return coeficiente;
    }

}
