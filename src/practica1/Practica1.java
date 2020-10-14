package practica1;

import java.util.Scanner;
public class Practica1 {
    
    static PolinomioVectorForma2 pol;
    static PolinomioVectorForma2[] polV=new PolinomioVectorForma2[20];
    static Scanner leer =new Scanner(System.in);
    
    public static void main(String[] args) {
        char opc=' ';
        int CantidadEvaluar=0,cantpol=0,i=0;
        PolinomioVectorForma2 obj =new PolinomioVectorForma2();
        boolean verificar=true;
        
        do{
            opc=menu();
            switch(opc){
                case '1':
                    System.out.println("Ingrese la cantidad de polinomios a agregar (Minimo 10)");
                    cantpol=leer.nextInt();
                    while(i<cantpol){
                        String polinomio="";
                        System.out.println("Ingrese un polinomio(recuerde no repetir exponentes ni usar exponente 0)");
                        polinomio=leer.next();
                        pol=obj.crearVector(polinomio);
                        /*if(polinomix!=null){
                            verificar=objt.verificarExponente(pol);
                        }
                        if(verificar==false){
                            System.out.println("Recuerde no ingresar exponentes repetidos");
                        }else{*/
                            i++;
                        //}
                        polV[i]=pol;    
                    }
                    break;
                case '2':
                     if(polV!=null){
                        System.out.println("Ingrese el numero corrrespondiente al polinomio A: ");
                        int aPosicion = Integer.parseInt(leer.next());
                        System.out.println("Ingrese el numero corrrespondiente al polinomio A: ");
                        int bPosicion =Integer.parseInt( leer.next());
                        PolinomioVectorForma2 a = polV[aPosicion];
                        PolinomioVectorForma2 b = polV[bPosicion];
                        
                        PolinomioVectorForma2 polinomioM = obj.Multiplicar(a,b);
                        System.out.println("El Resultado de A + B :");
                        System.out.println(polinomioM);
                        
                        PolinomioVectorForma2[] nuevoPolV = new PolinomioVectorForma2[polV.length+1];
                         for(int w = 0; w<nuevoPolV.length; w++){
                           nuevoPolV[w]=polV[w];
                         }
                         nuevoPolV[nuevoPolV.length] = polinomioM;
                         polV = nuevoPolV;
                        
                    }else{
                        System.out.println("aun no ingresa los polinomios");
                    }
                    break;
                case '3':
                    if(polinomix!=null){
                        polinomioD=objt.Derivar();
                    }else{
                        System.out.println("aun no ingresa los polinomios");
                    }
                    break;
                case '4':
                    if(polinomix!=null){
                        double x=0;
                        System.out.println("Ingrese el numero a evaluar de X");
                        x=leer.nextDouble();
                        CantidadEvaluar=objt.evaluar(, );
                    }else{
                        System.out.println("aun no ingresa los polinomios");
                    }
                    break;
                case '5':
                    if(polV!=null){
                        for(int t=0;t<polV.length;t++){
                            
                        }
                        
                    }else{
                        System.out.println("aun no ingresa los polinomios");
                    }
                    break;
                case '6':
                    break;
            }
        }while(opc!='6'); 
        
    }
    static char menu(){
        char opcion;
        System.out.println("1. Ingresar Polinomio");
        System.out.println("2. Multiplicar Polinomio");
        System.out.println("3. Derivar polinomio");
        System.out.println("4. Evaluar");
        System.out.println("5. Mostrar ");
        System.out.println("6. Salir");
        do{
            opcion=leer.next().charAt(0);
        }while(opcion<'1'||opcion>'6');
        return (opcion);
    }
}