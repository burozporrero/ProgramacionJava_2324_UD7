package teoria.demo_logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Division {

    //private static Logger LOGGER = LogManager.getLogger("practica.ejercicios1.soluciones");
    private static Logger LOGGER = LogManager.getRootLogger();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Ingrese el numerador: ");
            int numerador = scanner.nextInt();
            System.out.print("Ingrese el denominador: ");
            int denominador = scanner.nextInt();

            int resultado = dividir(numerador, denominador);
            System.out.println("El resultado es: " + resultado);
        } catch (ArithmeticException e) {
            LOGGER.error("¡Error aritmético! No se puede dividir por cero.");
            LOGGER.debug("prueba");
            //System.out.println("¡Error aritmético! No se puede dividir por cero.");
        } finally {
            System.out.println("Se ha ejecutado el bloque finally.");
            scanner.close(); // Cerramos el Scanner para liberar recursos
        }
    }

    public static int dividir(int numerador, int denominador) {
        return numerador / denominador;
    }
}
