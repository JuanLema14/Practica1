
package practica1;

public class PolinomioVectortipo2 {
    
    public static double[] ingresarPolinomio(String p){
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
                    for(int k=1;k<polinomioV.length;k+=2){
                        
                    }
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
    
}
