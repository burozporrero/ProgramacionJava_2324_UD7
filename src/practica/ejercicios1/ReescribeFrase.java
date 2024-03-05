package practica.ejercicios1;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Víctor C.
 */
public class ReescribeFrase {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String output = "";

        final char[] abc = desordenarArray();

        System.out.println("Introduce frase");
        String frase = sc.nextLine();

        for (int i = 0; i < frase.length(); i++) {
            for (char letraABC : abc) {

                if (frase.charAt(i) == letraABC) {
                    output += letraABC;
                    System.out.print("\r" + output);
                    break;
                } else {
                    System.out.print("\r" + output + letraABC);
                    System.out.flush();

                    //Thread.sleep(5);  // Añade un pequeño retraso para una mejor visualización

                }
            }
        }

        sc.close();
    }

    public static char[] desordenarArray() {

        Random random = new Random();

        final char[] array = {'!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '_', '+', '-', '=', '{', '}', '[', ']', ';', ':', ',', '.', '<', '>', '/', '|', '?', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', ' ', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '?'};

        for (int i = array.length - 1; i > 0; i--) {

            int index = random.nextInt(i + 1);

            // Intercambiar elementos para que el orden en el que se verán por pantalla, no sea siempre el mismo
            char temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
        return array;
    }
}
