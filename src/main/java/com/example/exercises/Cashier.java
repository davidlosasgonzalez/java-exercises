// Indicamos el paquete.
package com.example.exercises;

// Importar las clases para leer la entrada del usuario y para indicar el idioma.
import java.util.Scanner;
import java.util.Locale;

// Inicializamos la clase.
public class Cashier {
    // Método para calcular el total de la compra.
    public void calculateTotal() {
        // Scanner para leer la entrada del usuario. Usamos "Locale.US" para que el valor decimal se
        // escriba con un punto y no con una coma. Esto hace el programa más internacional.
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        double total = 0;
        double price;

        // Iniciamos el bucle.
        while (true) {
            System.out.print("Introduce el valor del producto (0 para finalizar): ");

            if (!scanner.hasNextDouble()) {
                System.out.println("El valor introducido no es válido.");

                // Descartar el valor no válido.
                scanner.next();

                continue;
            }

            // Leer el precio ingresado por el usuario.
            price = scanner.nextDouble();

            if (price < 0) {
                System.out.println("El precio no puede ser menor que 0.");
            } else if (price > 0) {
                total += price;
            } else {
                break;
            }
        }

        // Liberamos el Scanner.
        scanner.close();

        // Importante indicar "Locale.US" para que el valor decimal aparezca con punto.
        System.out.printf(Locale.US, "Total de la compra: %.2f€%n", total);
    }
}
