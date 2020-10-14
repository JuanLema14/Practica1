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
        double[]polinomioV=new double[p.length()];
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
                        polinomioV[j+1]=Integer.parseInt(exponente);
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
                        polinomioV[j+1]=0.0;
                        exponente="";
                        polinomioV[j+2]=Double.parseDouble(coeficiente);
                        coeficiente="";
                        j+=2;
                        m+=1;
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
                    prueba=new Termino(0,polinomioNormalizado[k]);
                    loquesea[k]=prueba;
                    h++;
                }else {
                    prueba=new Termino((int)polinomioNormalizado[k-1],polinomioNormalizado[k]);
                    loquesea[h]=prueba;
                    h++;
            }
                
            }
        }
        //Termino prueba = new Termino(0, 0);
        //int CeldaL=1;
        //loquesea[0]=prueba;
        /*for(int h=0;h<=loquesea.length;h+=2){
            
            
            if(h==0){
                prueba=new Termino(0,polinomioV[h]);
                loquesea[h]=prueba;
            }else if(h/2==0){
                Termino prueba=new Termino((int)polinomioV[h+1],polinomioV[h+2]);
                loquesea[h+1]=prueba;
            }*/
            /*prueba=new Termino((int)polinomioV[h+1],polinomioV[h+2]);
            loquesea[CeldaL]=prueba;
            CeldaL++;*/
            
        //}
        
        PolinomioVF2= new PolinomioVectorForma2(loquesea);
        System.out.println(PolinomioVF2);
        return PolinomioVF2;
    }

    /**
     * Obtener el grado del polinomio
     *
     * @return grado del polinomio
     */
    public int getGrado() {
        return loquesea[0].getE();
    }

    @Override
    public String toString() {
        StringBuilder polinomio = new StringBuilder();
        boolean primerTermino = true;
        if (loquesea == null) {
            return "0";
        }
        for (Termino ti : loquesea) {
            double j = ti.getC();
            int i = ti.getE();
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
