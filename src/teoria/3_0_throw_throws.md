# EXCEPCIONES EN JAVA: Uso de throw y throws

<!-- TOC -->
* [EXCEPCIONES EN JAVA: Uso de throw y throws](#excepciones-en-java-uso-de-throw-y-throws)
  * [Cláusula `throw`](#cláusula-throw)
    * [Ejemplo de Uso de `throw`](#ejemplo-de-uso-de-throw)
  * [Cláusula `throws`](#cláusula-throws)
    * [Ejemplo de Uso de `throws`](#ejemplo-de-uso-de-throws)
  * [Trabajar con excepciones en el catch](#trabajar-con-excepciones-en-el-catch)
    * [1. Imprimir o registrar un mensaje de error](#1-imprimir-o-registrar-un-mensaje-de-error)
    * [2. Propagar la Excepción](#2-propagar-la-excepción)
    * [3. Recuperación o Resolución del Error](#3-recuperación-o-resolución-del-error)
    * [4. Lanzar Otra Excepción](#4-lanzar-otra-excepción)
  * [Trabajar con excepciones en un constructor](#trabajar-con-excepciones-en-un-constructor)
<!-- TOC -->


Para ver esta información de forma más amena podéis acceder a [AULA EN LA NUBE](https://youtube.com/watch?v=XnQuyV86bOI&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=135)

## Cláusula `throw`

La cláusula `throw` se utiliza para lanzar manualmente una excepción en un programa. Esto significa que puedes crear
una instancia de una excepción y lanzarla explícitamente en cualquier punto dentro de tu código.

La sintaxis básica de la cláusula `throw` es la siguiente:

```java
throw new TipoDeExcepcion("Mensaje opcional");
```

Aquí, `TipoDeExcepcion` es el tipo de excepción que deseas lanzar, y `"Mensaje opcional"` es un mensaje descriptivo que puede proporcionar información adicional sobre la excepción.

### Ejemplo de Uso de `throw`

Imaginemos un método que realiza una verificación y lanza una excepción si la condición no se cumple:

```java
public void verificarEdad(int edad)  {
    try {
        if (edad < 18) {
            throw new IllegalArgumentException("La edad debe ser mayor o igual a 18");
        }
    } catch (IllegalArgumentException e){
        System.out.println(e.getMessage());
    }
}
```

En este ejemplo, si la edad proporcionada es menor que 18, se lanza una excepción `IllegalArgumentException` con un mensaje explicativo.
Esto permite generar un error y a la vez, nos da la oportunidad de manejar la excepción.

## Cláusula `throws`

La cláusula `throws` se utiliza en la firma de un método para indicar que el método puede lanzar una o más excepciones verificadas.
Esto significa que el método no maneja las excepciones por sí mismo, sino que las devuelve tal cual, al manejador que realizó la llamada a este método.

La sintaxis de la cláusula `throws` es la siguiente:

__Para una sola excepción__:
```java
public void miMetodo() throws MiExcepcion {
    // Código que podría lanzar una excepción
}
```

__Para más de una excepción__:
```java
public void miMetodo() throws TipoDeExcepcion1, TipoDeExcepcion2, ... {
    // Código que podría lanzar una excepción
}
```

Aquí, `TipoDeExcepcion1`, `TipoDeExcepcion2`, etc., son los tipos de excepciones que el método podría lanzar.

Para entrar en el detalle del lanzamiento de mas de una excepción, podéis
acceder a [AULA EN LA NUBE](https://www.youtube.com/watch?v=TjhbybnfCcs&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=136)

### Ejemplo de Uso de `throws`

Sobre el ejemplo anterior, podríamos elegir hacer lo siguiente:

```java
public void verificarEdad(int edad) throws IllegalArgumentException {
    if (edad < 18) {
        throw new IllegalArgumentException("La edad debe ser mayor o igual a 18");
    }
}
```

En un ejemplo diferente, supongamos que tenemos un método que lee datos de un archivo, pero no maneja las
excepciones de lectura de archivos. En su lugar, declara que podría lanzar una excepción `IOException`:

```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public void leerArchivo(String nombreArchivo) throws IOException {
    BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo));
    // Código para leer el archivo aquí
    lector.close();
}
```

## Trabajar con excepciones en el catch

Como hemos visto hasta ahora, cuando se lanza una excepción dentro del bloque `try`, el flujo de control se 
transfiere al bloque `catch` correspondiente, donde se maneja la excepción.

Dentro del bloque `catch`, podemos trabajar con la excepción capturada de varias maneras:

### 1. Imprimir o registrar un mensaje de error

```java
try {
    // Código que podría lanzar una excepción
} catch (ExcepcionTipo e) {
    System.err.println("Ocurrió un error: " + e.getMessage());
}
```

```java
try {
    // Código que podría lanzar una excepción
} catch (ExcepcionTipo e) {
    miLogger.registrarError(e);
}
```

### 2. Propagar la Excepción

Podemos propagar la excepción capturada para que sea manejada en un nivel superior de la jerarquía de llamadas de 
métodos.

```java
try {
    // Código que podría lanzar una excepción
} catch (ExcepcionTipo e) {
    throw e; // Propaga la excepción al código que llamó a este método
}
```

### 3. Recuperación o Resolución del Error

Podemos realizar acciones para recuperarnos del error o resolver la situación que causó la excepción.

```java
try {
    // Código que podría lanzar una excepción
} catch (ExcepcionTipo e) {
    // Realizar acciones para recuperarse del error
}
```

### 4. Lanzar Otra Excepción

Podemos lanzar otra excepción o una excepción personalizada en lugar de la original. Este es el caso que vamos a ver 
en el punto siguiente.
Cuidado con esta opción, porque en realidad, también podriamos estar camuflando la primera excepción.

```java
try {
    // Código que podría lanzar una excepción
} catch (ExcepcionTipo e) {
    throw new MiExcepcion("Se produjo un error al procesar los datos", e);
}
```

## Trabajar con excepciones en un constructor

Vamos a ver una buena solución para controlar los posibles valores de asignación en un constructor, con una 
excepción no verificada:

```java
// Constructor
public Cilindro(String nombre, double radio, double altura) throws IllegalArgumentException {
	super(nombre);
	this.base = new Circulo(radio);

    if (altura <= 0) {
      throw new IllegalArgumentException(
              String.format("Dimensiones no válidas: %f", altura));
    }
    this.altura = altura;
}
```

Interesante ver también el ejemplo siguiente, donde se muestra un ejemplo de clase, que controla una restricción de 
la clase, de forma completa, tanto al crear la instancia, como al intentar hacer un set de una instancia ya creada.

[Demo](demo_setters/Casa.java)
