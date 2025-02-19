// Indicamos el paquete.
package com.example.exercises;

// Importar la clase Scanner para leer la entrada del usuario.
import java.util.Scanner;

// Importar la clase Arrays.
import java.util.Arrays;

// Clase principal.
public class Main {
    // Método principal.
    public static void main(String[] args) {
        // Scanner para leer la entrada del usuario.
        Scanner scanner = new Scanner(System.in);

        System.out.println(
                """
                    Seleccione un número de ejercicio a ejecutar:
                        1 -> Ejercicio cajero
                        2 -> Ejercicio temperaturas
                        0 -> Salir
                """
        );

        int option = scanner.nextInt();

        switch (option) {
            case 0:
                System.out.println("Saliendo...");
                break;
            case 1:
                Cashier cashier = new Cashier();
                cashier.calculateTotal();
                break;
            case 2:
                double[] temps = {10.7, 11.1, 13.5, 15.9, 15.3, 14.6, 13.9};
                System.out.println("Array de temperaturas: " + Arrays.toString(temps));
                WeatherStation weatherStation = new WeatherStation();
                weatherStation.calculateAvgTemp(temps);
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }

        scanner.close();
    }
}
