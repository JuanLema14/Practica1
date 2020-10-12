
package practica1;

public class PolinomioVectortipo2 {
    
    public static double[] crearVector(String p){
        p= p.toLowerCase();
        char[] cadena= p.toCharArray();
        double[]polinomioV={};
        String co="", ex="";
        int m=0,j=0;
        for(int i=1;i<cadena.length;i++){
            
            if(!(Character.isDigit(cadena[i]))){
                if(cadena[i]=='-'){
                    co="-";
                }else if(cadena[i]=='x' && !(Character.isDigit(cadena[i-1]))){
                    co+="1";
                }
            }else if(Character.isDigit(cadena[i])){
                if(cadena[i-1]=='^'){
                    do{
                        ex+=cadena[i];
                        i++;
                    }while(Character.isDigit(cadena[i]));
                    polinomioV[j+1]=Integer.parseInt(ex);
                    polinomioV[j+2]=Double.parseDouble(co);
                    j+=2;
                    m+=1;
                }else{
                    co+=cadena[i];
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
    
}
