// Indicamos el paquete.
package com.example.exercises;

// Importaciones para JUnit.
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Importaciones para simular la entrada y capturar la salida.
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

// Inicializamos la clase.
public class CashierTest {
    @Test
    public void testCalculateTotal() {
        // Guardamos la referencia original de System.out para restaurarla después.
        PrintStream originalOut = System.out;

        // Cadena que simula los inserts del usuario, cada uno en una nueva línea.
        String simulatedInput = "10\n20.55\n0\n";

        // Convertimos la cadena en un ByteArrayInputStream para asignarla a System.in.
        ByteArrayInputStream testInput = new ByteArrayInputStream(simulatedInput.getBytes());

        // Indicamos a System.in que use nuestra entrada simulada.
        System.setIn(testInput);

        // Creamos un ByteArrayOutputStream para almacenar la salida que se imprime en la consola.
        ByteArrayOutputStream testOutput = new ByteArrayOutputStream();

        // Redirigimos a System.out nuestro ByteArrayOutputStream.
        System.setOut(new PrintStream(testOutput));

        // Creamos una instancia de Cashier y llamamos al método calculateTotal(), que usará la
        // entrada simulada.
        Cashier cashier = new Cashier();
        cashier.calculateTotal();

        // Restauramos System.in y System.out a sus valores originales para no afectar otros tests.
        System.setIn(System.in);
        System.setOut(originalOut);

        // Convertimos la salida capturada a una cadena.
        String output = testOutput.toString();

        // Como Cashier suma 10 y 20.55, comprobamos que el total sea "30.55".
        assertTrue(output.contains("30.55€"), "El total calculado debe ser 30.55€");
    }
}
