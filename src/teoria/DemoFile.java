package teoria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DemoFile {
    public static void main(String[] args) {
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader("archivo.txt"));
            String linea = reader.readLine();
            System.out.println(linea);

        } catch (IOException e) {

            System.err.println("Error de entrada/salida: " + e.getMessage());

        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.err.println("Error al cerrar el archivo: " + e.getMessage());
            }
        }
    }
}
