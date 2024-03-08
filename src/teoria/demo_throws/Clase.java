package teoria.demo_throws;

import java.io.IOException;

//Clase que se utiliza para entender la utilidad y necesidad del throws en la cabecera de un método en función del
// tipo de excepción al que nos enfrentemos
public class Clase {

    // Constructor con throw y sin throws que lanza una excepción no verificada
    public Clase(int param) {
        throw new IllegalArgumentException("Probando uno, dos");
    }

    // Constructor con throw y throws que lanza una excepción no verificada
    public Clase() throws IllegalArgumentException{
        throw new IllegalArgumentException("Probando uno, dos");
    }

    // Método con throw y SIN throws que lanza una excepción NO verificada
    public void verificar0() {
        throw new IllegalArgumentException("Probando uno, dos");
    }

    // Método con throw y throws que lanza una excepción NO verificada
    public void verificar1() throws IllegalArgumentException {
        throw new IllegalArgumentException("Probando uno, dos");
    }

    // Método con throw y SIN throws que lanza una excepción verificada
    public void verificar2() {
        //TODO descomentar
        //throw new IOException("Probando uno, dos");
    }

    // Método con throw y throws que lanza una excepción verificada
    public void verificar3() throws IOException{
        throw new IOException("Probando uno, dos");
    }
}
