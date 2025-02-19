# Ejercicios Java

Este proyecto contiene una colección de ejercicios sencillos en **Java** que cubren diferentes conceptos básicos del lenguaje, como estructuras de control, arreglos y manipulación de datos por consola.

## Requisitos previos

Asegúrate de tener instalados:

- **Java 17 o superior**: [https://adoptium.net/](https://adoptium.net/)
- **Maven**: [https://maven.apache.org/](https://maven.apache.org/)

## Estructura del proyecto

El proyecto está organizado de la siguiente manera:

- **`src/`**: Contiene el código fuente de los ejercicios.
- **`README.md`**: Este archivo, que documenta el uso y propósito del proyecto.
- **`pom.xml`**: Archivo de configuración de Maven.

## Uso

### 1. Compilar el proyecto
Ejecuta el siguiente comando para compilar el proyecto con Maven:
```bash
mvn clean install
```

### 2. Ejecutar la aplicación
La clase principal `Main` contiene un `Scanner` y un `switch` que permite seleccionar el ejercicio a ejecutar. Para iniciar la aplicación, usa el siguiente comando:
```bash
mvn exec:java
```

Una vez ejecutado, el programa pedirá que ingreses el número del ejercicio que deseas correr.

## Ejercicios disponibles

### Ejercicio 1 - Precio Total
Permite ingresar el precio de varios productos hasta que el usuario decida finalizar. Luego, muestra el total de la compra.

### Ejercicio 2 - Temperatura Media
Calcula la temperatura promedio a partir de un array de 7 valores ingresados por el usuario.

### Ejercicio 3 - Reserva De Asientos
Simula un sistema de reservas de asientos en un teatro, permitiendo al usuario seleccionar asientos disponibles y mostrando un mapa actualizado.

Cada ejercicio se ejecuta de manera independiente a través de la clase `Main` y su respectiva selección en el `switch`.

