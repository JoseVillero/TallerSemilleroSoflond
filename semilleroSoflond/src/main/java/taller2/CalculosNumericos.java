package taller2;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class CalculosNumericos {

    public static double raizCuadrada(double valor){
        if(valor < 0){
            throw new ArithmeticException("El valor ingresado debe ser positivo");
        }
        return Math.sqrt(valor);
    }
    public static int pendienteDeUnaRecta(Punto A, Punto B){
        if(B.getX() == A.getX()){
            throw new ArithmeticException("No es posible dividir entre cero");
        }
       return (B.getY() - A.getY()) / (B.getX() - A.getX());
    }
    public static double puntoMedioDeUnaRecta(Punto A, Punto B){
        return ((A.getX() + B.getX()) / 2) + ((A.getY() + B.getY()) / 2);
    }

    /**
     * Una ecuacion cuadratica es  a^2 + bx + c = 0
     * su  formula de solucion es:  x = [ -b ± √ (b^2 – 4ac) ] / 2a
     * si la parte discriminante (b^2 – 4ac) es positiva la ecuacion tiene dos soluciones
     * si es igual a cero solo hay una solucion
     * si es negativo hay dos soluciones que incluyen numeros imaginarios
     */

    public static void raicesDeUnaEcuacionCuadratica(int a, int b, int c){
        // formula de la parte discriminante del la ecuacion cuadratica b2 – 4ac
        double parteDiscriminante = Math.pow(b,2) - 4 * a * c;
        if (parteDiscriminante > 0){
            double x1 = ((b*-1) + Math.sqrt(parteDiscriminante)) / (2*a);
            double x2 = ((b*-1) - Math.sqrt(parteDiscriminante)) / (2*a);
            System.out.println("La ecuacion tiene dos soluciones, las dos raices son: " + "X1: " + x1 + " \tX2: " + x2);
        } else if (parteDiscriminante == 0){
            double x = ((b*-1) + Math.sqrt(parteDiscriminante)) / (2*a);
            System.out.println("La ecuacion tienen una solucion, la raiz es: " + "X: " + x);
        }else{
            throw new ArithmeticException("La parte discriminante es negativa, la ecuacion tiene dos soluciones" +
                    "\nque incluyen numeros imaginarios");
        }
    }
    public static void conversorBaseNumeros(int numeroBaseDiez, int baseDestino){
        String resultado = "";

        while (numeroBaseDiez != 0) {
            int residuo = numeroBaseDiez % baseDestino;
            resultado = residuo + resultado;
            numeroBaseDiez = numeroBaseDiez / baseDestino;
        }

        System.out.println("El resultado en base " + baseDestino + " es: " + resultado);
    }

    }
class Punto {

    private int x;
    private int y;

    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

class Principal {

    public static void main(String[] args) {

        Punto A = new Punto(2,1);
        Punto B = new Punto(6,9);


        // 1 calcular raiz cuadrada
        System.out.println("calcular raiz cuadrada");
        System.out.println(CalculosNumericos.raizCuadrada(9));

        System.out.println("\n");

        // 2 pendiente de una recta
        System.out.println("pendiente de una recta");
        System.out.println(CalculosNumericos.pendienteDeUnaRecta(A,B));

        System.out.println("\n");

        // 3 punto medio de una recta
        System.out.println("punto medio de una recta");
        System.out.println(CalculosNumericos.puntoMedioDeUnaRecta(A,B));

        System.out.println("\n");

        //4 raices de una ecuacion cuadritica
        System.out.println("raices de una ecuacion cuadritica");
        CalculosNumericos.raicesDeUnaEcuacionCuadratica(1,-2,-3);
        // solucion con numeros imaginarios CalculosNumericos.raicesDeUnaEcuacionCuadratica(1,-6,25);

        System.out.println("\n");

        // 5 número en base 10 a un número en base b
        CalculosNumericos.conversorBaseNumeros(666,7);



    }





}
