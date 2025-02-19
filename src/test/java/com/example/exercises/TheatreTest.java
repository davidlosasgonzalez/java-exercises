// Indicamos el paquete.
package com.example.exercises;

// Importaciones para JUnit.
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Importaciones para simular la entrada y capturar la salida.
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

// Inicializamos la clase.
public class TheatreTest {
    @Test
    public void testBookingSeat() {
        // Guardamos la referencia original de System.out para restaurarla después.
        PrintStream originalOut = System.out;

        // Cadena que simula la entrada del usuario para reservar un asiento.
        // El usuario intenta reservar la fila 2, asiento 3.
        String simulatedInput = "2\n3\n";

        // Convertimos la cadena en un ByteArrayInputStream para asignarla a System.in.
        ByteArrayInputStream testInput = new ByteArrayInputStream(simulatedInput.getBytes());

        // Indicamos a System.in que use nuestra entrada simulada.
        System.setIn(testInput);

        // Creamos un ByteArrayOutputStream para almacenar la salida que se imprime en la consola.
        ByteArrayOutputStream testOutput = new ByteArrayOutputStream();

        // Redirigimos a System.out nuestro ByteArrayOutputStream.
        System.setOut(new PrintStream(testOutput));

        // Creamos una instancia de Scanner para la entrada simulada.
        Scanner scanner = new Scanner(System.in);

        // Creamos una instancia de Theatre con una matriz de 5x5 y el scanner simulado.
        Theatre theatre = new Theatre(5, 5, scanner);

        // Llamamos al método bookingSeat(), que usará la entrada simulada.
        theatre.bookingSeat();

        // Restauramos System.in y System.out a sus valores originales para no afectar otros tests.
        System.setIn(System.in);
        System.setOut(originalOut);

        // Convertimos la salida capturada a una cadena.
        String output = testOutput.toString();

        // Comprobamos que el mensaje de confirmación de la reserva aparece en la salida.
        assertTrue(output.contains("Asiento reservado: Fila 2, Asiento 3"),
                "El asiento debe ser reservado correctamente en la fila 2, asiento 3.");

        // Comprobamos que el estado de los asientos se ha actualizado correctamente.
        assertTrue(output.contains("OOOXO"),
                "El asiento 3 de la fila 2 debe estar marcado como 'X'.");
    }

    @Test
    public void testIsFullyBooked() {
        // Creamos un scanner ficticio (aunque no se usará en esta prueba).
        Scanner scanner = new Scanner(System.in);

        // Creamos una instancia de Theatre con una matriz de 3x3.
        Theatre theatre = new Theatre(3, 3, scanner);

        // Marcamos la totalidad de asientos como ocupados ('X').
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                theatre.seats[i][j] = 'X';
            }
        }

        // Comprobamos que el método isFullyBooked() devuelve true cuando la totalidad de asientos están ocupados.
        assertTrue(theatre.isFullyBooked(),
                "isFullyBooked() debe devolver true cuando todos los asientos están ocupados.");

        // Liberamos un asiento y comprobamos que ahora devuelve false.
        theatre.seats[1][1] = 'O';
        assertFalse(theatre.isFullyBooked(),
                "isFullyBooked() debe devolver false cuando al menos un asiento está libre.");
    }
}
