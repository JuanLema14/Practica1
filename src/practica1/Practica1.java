package practica1;

import java.awt.HeadlessException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
public class Practica1 {
    
    static PolinomioVectorForma2 pol;
    static PolinomioVectorForma2[] polV=new PolinomioVectorForma2[30];
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
                    try{
                                          System.out.println("Ingrese la cantidad de polinomios a agregar (Minimo 10)");
                    cantpol=leer.nextInt();  
                    }catch(Exception e){
                        System.out.println("---------------------------------");
                        System.out.println("----------Valor erroneo----------");
                        System.out.println("---------------------------------");
                    }

                    if(cantpol>=10){
                        while(i<cantpol){
                            String polinomio="";
                            System.out.println("Ingrese un polinomio(recuerde no repetir exponentes)");
                            polinomio=leer.next();
                            pol=obj.crearVector(polinomio);
                            polV[i]=pol;
                            i++;
                            
                        }
                        i=0;
                    }else{
                        System.out.println("Recuerde que debe agregar 10 como minimo");
                    }
                    break;
                case '2':
                     if(polV!=null){
                        System.out.println("Ingrese el numero corrrespondiente al polinomio A: ");
                        int aPosicion = leer.nextInt();
                        System.out.println("Ingrese el numero corrrespondiente al polinomio B: ");
                        int bPosicion =leer.nextInt();
                        PolinomioVectorForma2 a = polV[aPosicion-1];
                        PolinomioVectorForma2 b = polV[bPosicion-1];
                        
                        PolinomioVectorForma2 polinomioM = new PolinomioVectorForma2();
                        System.out.println("El Resultado de A + B :");
                        System.out.println(obj.Multiplicar(a,b));
                        
                        /*PolinomioVectorForma2[] nuevoPolV = new PolinomioVectorForma2[polV.length+1];
                         for(int w = 0; w<nuevoPolV.length; w++){
                           nuevoPolV[w]=polV[w];
                         }
                         nuevoPolV[nuevoPolV.length] = polinomioM;
                         polV = nuevoPolV;*/
                        
                    }else{
                        System.out.println("aun no ingresa los polinomios");
                    }
                    break;
                case '3':
                    if(polV!=null){
                        System.out.println("Ingrese el numero del polinomio que desea Derivar: ");
                        int PosD =leer.nextInt();
                        PolinomioVectorForma2 PDerivar= new PolinomioVectorForma2();
                        PDerivar = polV[PosD-1];
                        PolinomioVectorForma2 Derivado =new PolinomioVectorForma2();
                        Derivado=obj.Derivar(PDerivar);
                        System.out.println(Derivado);
                    }else{
                        System.out.println("aun no ingresa los polinomios"); 
                    }
                    break;
                case '4':
                     if(polV!=null){
                        double x=0;
                        System.out.println("Ingrese el numero a evaluar de X");
                        x=leer.nextDouble();
                        System.out.println("Ingrese el el número correspondiente al polinomio que quiere evaluar");
                        int p=leer.nextInt();
                        double cantidadEvaluar;
                        cantidadEvaluar = obj.Evaluar(polV[p-1], x);
                        System.out.println("El resultado de la evaluación es: "+cantidadEvaluar);
                    }else{
                        System.out.println("aun no ingresa los polinomios");
                    }
                    break;
                case '5':
                    System.out.println("1. Imprimir un polinomio especifico cual? (adjunte posicion del polinomio)");
                    System.out.println("2. Imprimir todos");
                    int opcion=leer.nextInt();
                    
                    if(opcion==1){
                        System.out.println("Adjunte la posicion del polinomio");
                        int pos=leer.nextInt();
                        
                        System.out.println("El polinomio elegido es:");
                        if(polV!=null){
                            System.out.println(polV[pos-1]);
                        }else{
                            System.out.println("aun no ingresa los polinomios");
                        }

                    }else if(opcion==2){
                        if(polV!=null){
                            int t=0;
                            while(t<polV.length){
                                System.out.println((t+1)+". "+polV[t]);
                                t++;
                            }
                        
                        }else{
                            System.out.println("aun no ingresa los polinomios");
                        }
                    }else{
                        System.out.println("Opcion Incorrecta");
                    }
                    
                    break;
                case '6':
                    System.out.println("Gracias, vuelva pronto");
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