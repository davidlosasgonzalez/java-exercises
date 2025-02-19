// Indicamos el paquete.
package com.example.exercises;

// Importamos la clase Arrays.
import java.util.Arrays;

// Importamos la clase Scanner.
import java.util.Scanner;

// Inicializamos la clase.
public class Theatre {
    final char[][] seats;
    final Scanner scanner;

    // Constructor.
    public Theatre(int rows, int columns, Scanner scanner) {
        this.seats = new char[rows][columns];
        this.scanner = scanner;

        // Inicializamos los asientos a un carácter 'O'.
        for (char[] row : seats) {
            Arrays.fill(row, 'O');
        }
    }

    // Método para imprimir los asientos.
    public void printSeats() {
        System.out.printf("Estado actual de los asientos:%n");

        for (char[] row : seats) {
            System.out.println(new String(row)); // Convierte cada fila en una cadena
        }

        System.out.println(); // Salto de línea adicional para mejor separación en la consola
    }

    // Método para verificar si todos los asientos están ocupados.
    public boolean isFullyBooked() {
        for (char[] row : this.seats) {
            for (char seat : row) {
                if (seat == 'O') {
                    return false;
                }
            }
        }
        return true;
    }

    // Método para reservar un asiento.
    public void bookingSeat() {
        while (true) {
            System.out.println("Indique la fila y el asiento a reservar.");
            System.out.printf("Fila (0-%d): ", seats.length - 1);

            // Si el valor introducido no es válido volvemos a empezar.
            if (!scanner.hasNextInt()) {
                scanner.next();
                System.out.println("Error: La fila ingresada no es válida. Inténtelo de nuevo.");
                continue;
            }

            // Almacenamos la fila.
            int row = scanner.nextInt();

            System.out.printf("Asiento (0-%d): ", seats[0].length - 1);

            // Si el valor introducido no es válido volvemos a empezar.
            if (!scanner.hasNextInt()) {
                scanner.next();
                System.out.println("Error: El asiento ingresado no es válido. Inténtelo de nuevo.");
                continue;
            }

            // Almacenamos el asiento.
            int seat = scanner.nextInt();

            // Verificar si la fila y el asiento están dentro del rango permitido.
            if (row < 0 || row >= seats.length || seat < 0 || seat >= seats[0].length) {
                System.out.printf("Error: La butaca %d de la fila %d no existe. Inténtelo de nuevo.%n", seat, row);
                continue;
            }

            // Si el asiento está vacío lo reservamos, de lo contrario volvemos a empezar.
            if (this.seats[row][seat] == 'O') {
                this.seats[row][seat] = 'X';
                System.out.printf("Asiento reservado: Fila %d, Asiento %d%n", row, seat);
                printSeats();
                break;
            } else {
                System.out.printf("Error: La butaca %d de la fila %d no está disponible. Inténtelo de nuevo.%n", seat, row);
            }
        }
    }
}
