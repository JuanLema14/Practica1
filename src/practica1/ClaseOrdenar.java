package practica1;

public class ClaseOrdenar {
    
        
    
public static boolean verificarExponente(PolinomioVectorForma2 polinomioEx){
        boolean v=true, bandera=true;

        do{
            if(polinomioEx){
                bandera=v=false;
            }else{
                if(j<=polinomioEx.length-1){
                    j+=2;
                }else if(i<=polinomioEx.length-1){
                    i+=2;
                    j=3;
                }
            }
        }while(bandera==true);
        
        return v;
    }
    public static double[] Multiplicar(double[]PolinomioA, double[]PolinomioB){
        double[] PolinomioC=null;
        double AuxC=0,AuxE=0;
        int mayor=0,menor=0,i=2,j=2,m=0;
        PolinomioC[0]=m;
        boolean bandera=true;
        if(PolinomioA.length-1<PolinomioB.length-1){
            menor=PolinomioA.length-1;
            mayor=PolinomioB.length-1;
        }else{
            menor=PolinomioB.length-1;
            mayor=PolinomioA.length-1;
        }
        do{
            if(PolinomioA.length-1==menor){
                if(j<=PolinomioB.length-1){
                    AuxC=PolinomioA[i]*PolinomioB[j];
                    AuxE=PolinomioA[i-1]+PolinomioB[j-1];
                    
                    PolinomioC[j]=AuxC;
                    PolinomioC[j-1]=AuxE;
                    m+=1;
                    j+=2;
                    
                }else if(i<=PolinomioA.length-1){
                    i+=2;
                    j=2;
                }

            }else if(PolinomioA.length-1==PolinomioB.length-1){
                if(j<=PolinomioB.length-1){
                    AuxC=PolinomioA[j]*PolinomioB[j];
                    AuxE=PolinomioA[j-1]+PolinomioB[j-1];
                    
                    PolinomioC[j]=AuxC;
                    PolinomioC[j-1]=AuxE;
                    m+=1;
                    j+=2;
                }
            }else{
                if(j<=PolinomioA.length-1){
                    AuxC=PolinomioA[j]*PolinomioB[i];
                    AuxE=PolinomioA[j-1]+PolinomioB[i-1];
                    
                    PolinomioC[j]=AuxC;
                    PolinomioC[j-1]=AuxE;
                    m+=1;
                    j+=2;
                    
                }else if(i<=PolinomioB.length-1){
                    i+=2;
                    j=2;
                } 
            }
            if(i==PolinomioA.length-1 || i==PolinomioB.length-1){
                    bandera=false;
            }
        }while(bandera==true);
        return PolinomioC;
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
    public static void normalizar(double[]polinomioCN){
        int j=1;
        double auxA=0;
        for(int i=1;i<=polinomioCN.length-1;i+=2){
            if(polinomioCN[j]==polinomioCN[i]){
                polinomioCN[j]=polinomioCN[j]+polinomioCN[i];
                while(i>=j){
                    auxA=polinomioCN[i-1];
                    polinomioCN[i-1]=polinomioCN[i];
                    i--;
                }
                
            }else if(i==polinomioCN.length-1 && j<=polinomioCN.length-1){
                j+=2;
                i=1;
            }
        }
    }
  
}
