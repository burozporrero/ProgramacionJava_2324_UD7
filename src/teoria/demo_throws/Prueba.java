package teoria.demo_throws;

import java.io.IOException;

public class Prueba {
    public static void main(String[] args)  {
        Clase c = new Clase();

        c.verificar0();
        c.verificar1();
        c.verificar2();
        try {
            c.verificar3();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
