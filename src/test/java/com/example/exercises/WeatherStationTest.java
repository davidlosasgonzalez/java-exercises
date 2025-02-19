// Indicamos el paquete.
package com.example.exercises;

// Importaciones para JUnit.
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Importaciones para capturar la salida de consola.
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

// Inicializamos la clase de pruebas.
public class WeatherStationTest {
    @Test
    public void testCalculateAvgTemp() {
        // Creamos un array de temperaturas simuladas.
        double[] testTemperatures = {10.7, 11.1, 13.5, 15.9, 15.3, 14.6, 13.9};

        // Guardamos la referencia original de System.out para restaurarla después.
        PrintStream originalOut = System.out;

        // Creamos un ByteArrayOutputStream para capturar la salida de consola.
        ByteArrayOutputStream testOutput = new ByteArrayOutputStream();

        // Redirigimos System.out para capturar la salida del método.
        System.setOut(new PrintStream(testOutput));

        // Creamos una instancia de WeatherStation y llamamos al método calculateAvgTemp().
        WeatherStation weatherStation = new WeatherStation();
        weatherStation.calculateAvgTemp(testTemperatures);

        // Restauramos System.out a su valor original para no afectar otros tests.
        System.setOut(originalOut);

        // Convertimos la salida capturada a una cadena.
        String output = testOutput.toString().trim();

        // Verificamos que la salida contiene el valor esperado de la media.
        assertTrue(output.contains("13.6ºC"), "La temperatura semanal media debe ser 13.6ºC");
    }
}
