# EXCEPCIONES EN JAVA: Excepciones personalizadas

Para ver esta información de forma más amena podéis acceder a [AULA EN LA NUBE](https://www.youtube.com/watch?v=QdYBKihDzog&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=137)

Las excepciones personalizadas permiten definir y lanzar excepciones propias, para situaciones específicas, en 
nuestra aplicación, esto nos permite manejar errores de manera más precisa y comunicar información detallada sobre la 
naturaleza de la excepción.

Java provee de muchas excepciones diferentes, pero es posible que necesitemos una propia si alguna de nuestras 
respuestas a las siguientes preguntas es positiva:
- ¿Necesitas un tipo de excepción que no está representado por los de la plataforma Java?
- ¿Ayudaría a los usuarios si pudieran diferenciar tus excepciones de las generadas por clases escritas por otros proveedores?
- ¿Tu código lanza más de una excepción relacionada?
- Si utilizas las excepciones de otra persona, ¿los usuarios tendrán acceso a esas excepciones? 

Para que el código sea legible, es una buena práctica agregar la cadena Exception a los nombres de todas las clases que heredan (directa o indirectamente) de la clase Exception.

## Como crear excepciones personalizadas

Definir la clase de la excepción personalizada implica crear una nueva clase que extienda `Exception`. Aunque 
también se pueden extender excepciones de `RuntimeException`, no es conveniente crear excepciones que no verificadas.
Y le escribimos los constructores necesarios, aunque lo más habitual es crear uno que reciba la cadena del mensaje de error y lo relance.
Por ejemplo, en el siguiente caso, la clase tiene dos constructores: uno sin argumentos y otro que acepta un mensaje que se pasará al constructor de la superclase.

```java
public class MiExcepcion extends Exception {
    public MiExcepcion() {
        super();
    }

    public MiExcepcion(String mensaje) {
        super(mensaje);
    }
}
```

## Utilizar excepciones personalizadas

Se utilizan como cualquier otra excepción.

Por ejemplo, si ciertas condiciones no se cumplen en un método, es posible lanzar tu excepción personalizada.

```java
public class MiClase {
    public void metodo() throws MiExcepcion {
        // Error que genera nuestra excepción
        throw new MiExcepcionPersonalizada("¡Ocurrió un error personalizado!");
    }
}
```
 
Para manejar la excepción, la capturamos en un bloque `try-catch` donde se llame al método que la lanza.

```java
public class Main {
    public static void main(String[] args) {
        MiClase miClase = new MiClase();
        try {
            miClase.metodo();
        } catch (MiExcepcionPersonalizada e) {
            System.out.println("Se capturó una excepción personalizada: " + e.getMessage());
        }
    }
}
```
