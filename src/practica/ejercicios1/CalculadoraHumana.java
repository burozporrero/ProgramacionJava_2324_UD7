package practica.ejercicios1;

import java.util.Scanner;

public class CalculadoraHumana {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] numeros = {50, 4, 28, 33, 12};
        // Definimos un acumulador para llevar la suma
        int suma = 0;
        boolean esCorrecto = true;

        System.out.println("SUMAR Y GANAR");
        System.out.println("Vaya sumando todos los números que le iré diciendo. Empezamos por 0.");

        // Bucle iterativo para recorrer la lista de números
        for (int i = 0 ; i < numeros.length ; i ++) {
            // Preguntamos al usuario por la siguiente suma
            System.out.print("Más " + numeros[i] +": ");
            int respuesta = sc.nextInt();

            // Añadimos el siguiente número a la suma
            suma += numeros[i];
            // Si la respuesta del usuario no coincide con la suma, le avisamos y salimos del bucle.
            if (respuesta != suma) {
                System.out.println("Te has equivocado, pero has acertado " + i + " veces seguidas.");
                esCorrecto = false;
                break;
            }
        }
        // Si el acumulador suma contiene la suma de todos los números entonces el usuario ha ganado.
        if (esCorrecto) {
            System.out.println("Enhorabuena, GANASTE.");
        }
    }
}
