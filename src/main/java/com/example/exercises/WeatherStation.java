// Indicamos el paquete.
package com.example.exercises;

// Importamos la clase para indicar el idioma.
import java.util.Locale;

// Inicializamos la clase.
public class WeatherStation {
    // Método que muestra por consola la media de temperaturas.
    public void calculateAvgTemp(double[] tempArr) {
        double total = 0;

        for (double temp: tempArr) {
            total += temp;
        }

        System.out.printf(Locale.US,"Temperatura semanal media: %.1fºC", total / tempArr.length);
    }
}
