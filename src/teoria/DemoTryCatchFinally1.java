package teoria;

public class DemoTryCatchFinally1 {

    public static void main(String[] args) {

        System.out.println("Vamos a ver que se ejecuta exactamente:");

        try {

            System.out.println("Instrucción 1");
            System.out.println("Instrucción 2");

            System.out.println("Instrucción 3");

        } catch (Exception e) {
            System.out.println("Instrucciones a ejecutar cuando se produce un error");
        } finally {
            System.out.println("Instrucciones a ejecutar tanto si se producen errores como si no.");
        }
        System.out.println("Instrucciones posteriores al bloque try/catch");

    }
}
