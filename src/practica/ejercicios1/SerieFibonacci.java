package practica.ejercicios1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Jaime G. y Hugo A.
 */
public class SerieFibonacci {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int longitud;

        System.out.print("Introduzca el número de valores que quiere en la serie de Fibonacci: ");
        longitud = sc.nextInt();

        sumaSerieFibonacci(longitud);

        sc.close();
    }

    /**
     * Suma números de la serie fibonacci hasta la cantidad de dígitos indicada en param e imprime el resultado por
     * pantalla
     * @param longitud Cantidad de números de la serie que se sumarán
     */
    public static void sumaSerieFibonacci(int longitud){
        int[] serieFib = new int[longitud];

        serieFib[0] = 0;
        serieFib[1] = 1;

        for (int i = 2; i <longitud ; i++) {
            serieFib[i] = serieFib[i - 1] + serieFib[i - 2];
        }
        System.out.println(Arrays.toString(serieFib));
    }
}
