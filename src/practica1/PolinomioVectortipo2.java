package practica1;

public class PolinomioVectortipo2 {
    
    public static double[] crearVector(String p){
        p= p.toLowerCase();
        char[] cadena= p.toCharArray();
        double[]polinomioV=new double [100];
        String coheficiente="", exponente="";
        int m=0,j=0;
        for(int i=1;i<cadena.length;i++){
            
            if(!(Character.isDigit(cadena[i]))){
                if(cadena[i]=='-'){
                    coheficiente="-";
                }else if(cadena[i]=='x' && !(Character.isDigit(cadena[i-1]))){
                    coheficiente+="1";
                }
            }else if(Character.isDigit(cadena[i])){
                if(cadena[i-1]=='^'){
                    
                    do{
                        exponente+=Character.toString(cadena[i]);
                        i++;
                    }while(Character.isDigit(cadena[i]));

                    polinomioV[j+1]=Integer.parseInt(exponente);
                    polinomioV[j+2]=Double.parseDouble(coheficiente);
                    j+=2;
                    m+=1;
                }else{
                    coheficiente+=cadena[i];
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
  
}
