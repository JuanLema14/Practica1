package practica1;

public class Practica1 {

    public static void main(String[] args) {
        double[] polinomix;
        PolinomioVectortipo2 objt=new PolinomioVectortipo2();
        
        polinomix=PolinomioVectortipo2.crearVector("24x^23-4x^3");
        boolean ve=objt.verificarExponente(polinomix);
        System.out.println(ve);
        
    }
    
}
