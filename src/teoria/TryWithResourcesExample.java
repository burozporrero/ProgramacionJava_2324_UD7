package teoria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResourcesExample {
    public static void main(String[] args) {
        // Uso de try-with-resources para leer un archivo
        try (BufferedReader reader = new BufferedReader(new FileReader("archivo.txt"))) {
            String linea = reader.readLine();
            System.out.println(linea);
        } catch (IOException e) {
            // Manejo de excepciones
            System.err.println("Error de entrada/salida: " + e.getMessage());
        }
    }
}
