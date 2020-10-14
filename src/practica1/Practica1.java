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
                            verificar=objt.verificarExponente(polinomix);
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
                    if(polinomix!=null){
                        polinomioM=objt.Multiplicar(,);
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
                            System.out.println(polV[t].toString());
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