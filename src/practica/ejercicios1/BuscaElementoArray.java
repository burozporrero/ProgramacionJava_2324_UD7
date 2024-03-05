package practica.ejercicios1;

import java.util.Scanner;


public class BuscaElementoArray {

    public static void main(String[] args) {
        buscarElemento();
        buscarElemento2();
    }

    /**
     * @author Hugo R.
     */
    public static void buscarElemento() {
        int[] matriz = {7, 14, 21, 28, 35};
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el número que desea buscar en la matriz: ");
        int elementoBuscado = scanner.nextInt();
        int posicion = -1;

        // Buscar el elemento en la matriz
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i] == elementoBuscado) {
                posicion = i;
                break; // Detener la búsqueda una vez encontrado el elemento
            }
        }

        if (posicion != -1) {
            System.out.println("El elemento " + elementoBuscado + " se encuentra en la posición: " + posicion);
        } else {
            System.out.println("El elemento no se encuentra en la matriz.");
        }

        scanner.close();
    }

    /**
     * @author Jesús S.
     */
    public static void buscarElemento2() {

        boolean encontrado = false;
        int [] numerosCadena = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        String pedirBuscarNumero = System.console().readLine("Diga un numero del 1 al 10: ");
        int numeroBuscado = Integer.parseInt(pedirBuscarNumero);

        for (int numeroEncontrado : numerosCadena) {
            if (numeroBuscado == numeroEncontrado) {
                encontrado = true;
                System.out.println("El numero buscado es: " + numeroBuscado);
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se ha encontrado el numero ma g :/ ");
        }
    }
}
