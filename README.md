# Ejercicios Java

Este proyecto contiene una colección de ejercicios sencillos en **Java** que cubren diferentes conceptos básicos del lenguaje, como estructuras de control, arreglos y manipulación de datos por consola.

---

## Requisitos previos

Asegúrate de tener instalados:

- **Java 17 o superior**: [https://adoptium.net/](https://adoptium.net/)
- **Maven**: [https://maven.apache.org/](https://maven.apache.org/)

---

## Estructura del proyecto

El proyecto está organizado de la siguiente manera:

- `src/main/java/`: Contiene el código fuente de los ejercicios.
- `src/test/java/`: Contiene las pruebas unitarias de cada ejercicio.
- `README.md`: Este archivo, que documenta el uso y propósito del proyecto.
- `pom.xml`: Archivo de configuración de Maven.

---

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

---

## Pruebas

Cada ejercicio tiene una prueba unitaria correspondiente en el directorio `src/test/java/`, donde se validan los principales casos de uso.

### Ejecutar todos los tests

Para ejecutar todas las pruebas del proyecto, utiliza el siguiente comando:

```bash
mvn test
```

### Tests disponibles

- `CashierTest.java`: Valida el cálculo del total en el ejercicio del cajero.
- `WeatherStationTest.java`: Comprueba el cálculo de la temperatura media semanal.
- `TheatreTest.java`: Verifica la reserva de asientos y el estado del teatro.

---

## Ejercicios disponibles

### Ejercicio 1 - Precio Total

Permite ingresar el precio de varios productos hasta que el usuario decida finalizar. Luego, muestra el total de la compra.

---

### Ejercicio 2 - Temperatura Media

Una web de meteorología necesita de un programa que, al ingresar la temperatura media de cada día de la última semana, calcule la temperatura semanal promedio.

Para ello, deberá manejar un vector donde en cada posición represente la correspondiente temperatura media de cada día. El programa deberá calcular el promedio de las mismas recorriendo el vector y mostrando el resultado por pantalla.

---

### Ejercicio 3 - Reserva De Asientos

Estás trabajando en un sistema de reservas de asientos para un teatro. Crea un programa en Java que represente un mapa de asientos en una matriz de 5x5 y ten en cuenta lo siguiente:

- Los asientos pueden estar ocupados (representados por "X") o vacíos (representados por "O").
- Permite al usuario ingresar por teclado donde quiere sentarse, indicando su fila y número de asiento (por ejemplo, "Fila 3, Asiento 2"). El programa debe marcar como ocupado ese asiento solo en caso de que esté vacío.
- Si el asiento elegido por el usuario está ocupado, el sistema debe informar que elija otro diferente.
- A medida que los asientos se ocupen, el programa debe actualizar el mapa de asientos y mostrarlo por pantalla luego de cada reserva.
- El sistema deberá seguir corriendo hasta que el encargado de cargar las reservas de los asientos determine que ha finalizado.


