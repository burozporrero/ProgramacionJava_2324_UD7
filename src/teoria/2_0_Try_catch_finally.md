# EXCEPCIONES EN JAVA: Uso de try, catch y finally

Para ver esta información de forma más amena podéis acceder a [AULA EN LA NUBE](https://www.youtube.com/watch?v=1I5Wxy6ZFbw&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=134)

El manejo de excepciones se realiza mediante las cláusulas `try`, `catch` y `finally`. 

Estas cláusulas permiten estructurar el código de manera que las excepciones puedan ser manejadas de manera controlada, evitando que el programa se detenga abruptamente.

## try:
La cláusula `try` encierra un bloque de código donde se espera que ocurra una excepción.

Cuando se produce una excepción en el bloque try, el control del programa se transfiere al bloque catch correspondiente.

## catch:
La cláusula `catch` sigue al bloque try y se utiliza para capturar y manejar una excepción específica. 

El tipo de excepción que puede ser manejado se especifica entre paréntesis. Si se lanza una excepción dentro del bloque try que coincide con el tipo especificado, se ejecutará el bloque catch.

La JVM es la encargada de comprobar si la excepción se maneja o no. En caso de que no tengamos un catch apropiado 
para la excepción que se produce o, ni siquiera tengamos el código que la produce, dentro de un try catch, la JVM 
proporciona un manejador de excepciones predeterminado que realiza las siguientes tareas:
- Imprime la descripción de la excepción.
- Imprime el stackTrace(Jerarquía de métodos donde ocurrió la excepción).
- Hace que el programa finalice.

```java
try {
    // Código que podría lanzar una excepción
} catch (TipoDeExcepcion e) {
    // Manejo de la excepción
}
```

Si hay más de una excepción que puede ser lanzada por el bloque del try, se puede incluir mas de un bloque catch:

```java
try {
    // Código que podría lanzar una excepción
} catch (TipoDeExcepcion1 e1) {
    // Manejo de la excepción
} catch (TipoDeExcepcion2 e2) {
    // Manejo de la excepción
} catch (TipoDeExcepcion3 e3) {
    // Manejo de la excepción
}
```


## finally:
La cláusula `finally` se utiliza para especificar un bloque de código que se ejecutará siempre, independientemente de si se produce o no una excepción. Es útil para la limpieza de recursos.

```java
try {
    // Código que podría lanzar una excepción
} catch (TipoDeExcepcion e) {
    // Manejo de la excepción
} finally {
    // Código que se ejecuta siempre
}
```

## try-with-resources:

Característica introducida en Java 7 que simplifica el manejo de recursos.

La sintaxis básica del "try-with-resources" utiliza la palabra clave `try` seguida de paréntesis que contiene la declaración de uno o más recursos. Estos recursos deben implementar la interfaz `AutoCloseable` o `Closeable`, que define un método `close()` para liberar los recursos asociados.

```java
try (Recurso1 recurso1 = new Recurso1(); Recurso2 recurso2 = new Recurso2()) {
    // Código que utiliza los recursos
} catch (ExcepcionTipo e) {
    // Manejo de excepciones
}
```

A continuación, se explican las características clave del "try-with-resources":

1. **Auto Cierre de Recursos:**
    - Los recursos declarados en el bloque `try` se cierran automáticamente al final del bloque, ya sea que ocurra una excepción o no.
    - La clase del recurso debe implementar `AutoCloseable` o `Closeable`, que define el método `close()`.

2. **Declaración de Recursos:**
    - Los recursos se declaran dentro de los paréntesis del `try`.
    - Puedes declarar varios recursos separándolos con punto y coma.

3. **Orden de Cierre:**
    - Los recursos se cierran en el orden inverso de su declaración.
    - El último recurso declarado se cierra primero.

4. **Manejo de Excepciones:**
    - El bloque `catch` puede manejar excepciones que ocurran durante la ejecución del bloque `try`.
    - Después de manejar la excepción, los recursos se cierran automáticamente.

5. **Recursos Finalizados:**
    - Si un recurso implementa `AutoCloseable`, se cierra automáticamente cuando sale del ámbito del bloque `try`.
    - Si un recurso ya está cerrado cuando se intenta cerrar, su método `close()` no se llama nuevamente.

[Más información sobre try-with-resources en Oracle](https://docs.oracle.com/javase/7/docs/technotes/guides/language/try-with-resources.html)

---

## Ejemplos

Ejemplo de código donde no se producen errores

[Demo 1](DemoTryCatchFinally1.java)

Ejemplo de código donde se produce un error antes del try/catch. Como podemos ver, la excepción salta y rompe 
nuestro código, ya que, no la estamos controlando.

[Demo 2](DemoTryCatchFinally2.java)

Ejemplo de código donde se produce un error dentro del try/catch, como podemos ver, las siguientes 
líneas del bloque try, dejan de ejecutarse, para pasar a ejecutar el bloque catch. Probemos diferentes posiciones 
dentro del try.

[Demo 3](DemoTryCatchFinally3.java)

Ejemplo de código donde se produce un error dentro del try/catch, pero un error no contemplado por el catch. Como 
podemos ver, no se gestiona el error en el catch, sí se ejecuta el finally, pero no continúa la ejecución del 
programa, ya que no se ha realizado una gestión apropiada del error.

[Demo 4](DemoTryCatchFinally4.java)

Ejemplo de código donde se produce un error dentro del try/catch, contemplando los errores posibles con dos catch. 
Como podemos ver, acaba siendo capturada y gestionada.

[Demo 4](DemoTryCatchFinally4.java)

Ejemplo de código real con una excepción de tipo verificada, cuando se intenta acceder a un fichero que no se 
encuentra en el sistema. Revisar con especial atención el try/catch dentro del bloque finally
[Demo File](DemoFile.java)

---

## La variable `e`

La variable `e` dentro de un bloque `catch` en Java es la referencia a la excepción capturada. Esta variable te permite acceder a información sobre la excepción que se ha producido, como el tipo de excepción, el mensaje de error y la pila de llamadas.

Cuando una excepción es lanzada y capturada en un bloque `catch`, Java crea automáticamente una instancia de la clase de excepción correspondiente y la asigna a la variable `e`. La variable `e` tiene el tipo de la excepción capturada o de alguna de sus superclases. Esto significa que puedes acceder a métodos y propiedades específicos de la clase de excepción a través de esta variable.

Por ejemplo, si tienes un bloque `catch` como este:

```java
try {
    // Código que podría lanzar una excepción
} catch (ExcepcionTipo e) {
    // Manejo de la excepción
}
```

Aquí, `ExcepcionTipo` es el tipo de excepción que esperas capturar. La variable `e` es una referencia a la instancia de la excepción capturada. Puedes utilizar `e` para acceder a métodos como `getMessage()` para obtener el mensaje de la excepción, `printStackTrace()` para imprimir la traza de la pila, entre otros métodos definidos en la clase de excepción o en sus superclases.

### Ejemplo:

```java
try {
    int resultado = dividir(10, 0); // Lanzará una excepción ArithmeticException
} catch (ArithmeticException e) {
    System.err.println("Error: " + e.getMessage()); // Imprime el mensaje de la excepción
    e.printStackTrace(); // Imprime la traza de la pila
}
```
