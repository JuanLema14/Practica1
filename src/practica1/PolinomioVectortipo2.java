package practica1;

public class PolinomioVectortipo2 {
    
    public static double[] crearVector(String p){
        p= p.toLowerCase();
        double[]polinomioV=new double [100];
        String coeficiente="", exponente="";
        int m=0,j=0, x=1;
        char[] cadena=new char[p.length()+1];
        cadena[0]=(char) m;
        while (x <= p.length()) {
            cadena[x]=p.charAt(x-1);
            x=x+1;
        }
        for(int i=1;i<=cadena.length;i++){
            
            if(!(Character.isDigit(cadena[i]))){
               if(cadena[i]=='-'){
                    coeficiente="-";
                }else if(cadena[i]=='x' && !(Character.isDigit(cadena[i-1]))){
                    coeficiente+="1";
                }
            }else if(Character.isDigit(cadena[i])){
                if(cadena[i-1]=='^'){
                    
                   do{
                       exponente+=Character.toString(cadena[i]);
                        i++;   
                    }while(Character.isDigit(cadena[i]));

                    /*while(Character.isDigit(cadena[i])){
                       exponente+=Character.toString(cadena[i]);
                       i++;  
                    }*/
                    /*for(i=i;Character.isDigit(cadena[i]);i++){
                        exponente+=Character.toString(cadena[i]);
                    }*/

                    polinomioV[j+1]=Integer.parseInt(exponente);
                    System.out.println(polinomioV[j+1]);
                    polinomioV[j+2]=Double.parseDouble(coeficiente);
                    System.out.println(polinomioV[j+2]);
                    i=i-1;
                    j+=2;
                    m+=1;
                }else{
                    coeficiente+=Character.toString(cadena[i]);
                }
            }
        }
        polinomioV[0]=m;
        return polinomioV;
    }
    
    public static boolean verificarExponente(double[] polinomioEx){
        boolean v=true;
        double[] polinomioE=polinomioEx;
        for(int i=1;i<polinomioE.length;i+=2){
            for(int j=1;(polinomioE[i]==polinomioE[j])&&(i!=j);j+=2){
                return v=false;
            } 
        }
        return v;
    }
    public static void Multiplicar(double[]PolinomioA, double[]PolinomioB){
        double[] PolinomioC=null;
        int mayor=0,menor=0;
        if(PolinomioA.length-1<PolinomioB.length-1){
            menor=PolinomioA.length-1;
            mayor=PolinomioB.length-1;
        }else{
            menor=PolinomioB.length-1;
            mayor=PolinomioA.length-1;
        }
        for(int i=2;i<menor;i+=2){
            
        }
    }
    public static double[] Derivar(double [] polinomioD){
        double[] polinomioR=null;
        double auxE,auxC;
        for(int i=1;i<=polinomioD.length;i++){
            auxC=polinomioD[i+1]*polinomioD[i];
            auxE=polinomioD[i]-1;
            
            polinomioR[i]=auxE;
            polinomioR[i+1]=auxC;
        }
        return polinomioR;
    }
    
    public static double evaluar(double[] polinomioEV,double x){
        double valorF=0;
        for(int i=1;i<=polinomioEV.length;i++){
            valorF=valorF+(polinomioEV[i+1]*(Math.pow(x,polinomioEV[i])));
        }
        return valorF;
    }
  
}
