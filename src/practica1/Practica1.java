package practica1;
import java.util.ArrayList;
import java.util.Scanner;
public class Practica1 {
    static ArrayList<double[]> polinomiosA = new ArrayList<double[]>();
    static Scanner leer =new Scanner(System.in);
    public static void main(String[] args) {
        char opc=' ';
        String Polinomio="";
        int CantidadEvaluar=0,cantpol=0,i=0;
        boolean verificar=true;
        double[] polinomix=null, polinomioD=null,polinomioM=null;
        PolinomioVectortipo2 objt=new PolinomioVectortipo2();
        
        do{
            opc=menu();
            switch(opc){
                case '1':
                    System.out.println("Ingrese la cantidad de polinomios a agregar (Minimo 10)");
                    cantpol=leer.nextInt();
                    while(i<cantpol){
                        System.out.println("Ingrese un polinomio(recuerde no repetir exponentes ni usar exponente 0)");
                        Polinomio=leer.next();
                        polinomix=objt.crearVector(Polinomio);
                        /*if(polinomix!=null){
                            verificar=objt.verificarExponente(polinomix);
                        }
                        if(verificar==false){
                            System.out.println("Recuerde no ingresar exponentes repetidos");
                        }else{*/
                            i++;
                        //}
                        polinomiosA.add(polinomix);
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
                    if(polinomix!=null){
                        System.out.println(polinomiosA.get(2));
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