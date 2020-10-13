package practica1;
import java.util.Scanner;
public class Practica1 {
static Scanner leer =new Scanner(System.in);
    public static void main(String[] args) {
        char opc=' ';
        int CantidadEvaluar=0;
        double[] polinomix;
        PolinomioVectortipo2 objt=new PolinomioVectortipo2();
        
        do{
            opc=menu();
            switch(opc){
                case '1':
                    break;
                case '2':
                    break;
                case '3':
                    break;
                case '4':
                    break;
                case '5':
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