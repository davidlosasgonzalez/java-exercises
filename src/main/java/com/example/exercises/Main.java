// Indicamos el paquete.
package com.example.exercises;

// Importar la clase Scanner para leer la entrada del usuario.
import java.time.LocalDate;
import java.time.Period;
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
                        3 -> Ejercicio reserva de asientos
                        4 -> Ejercicio personas
                        0 -> Salir
                """
        );

        int option = scanner.nextInt();

        switch (option) {
            // Opción para cerrar el programa.
            case 0:
                System.out.println("Saliendo...");
                break;

            // Opción para visualizar el primer ejercicio.
            case 1:
                // Creamos una instancia y llamamos al método que calcula el total.
                Cashier cashier = new Cashier();
                cashier.calculateTotal();

                break;

            // Opción para visualizar el segundo ejercicio.
            case 2:
                // Array de temperaturas.
                double[] temps = {10.7, 11.1, 13.5, 15.9, 15.3, 14.6, 13.9};

                System.out.println("Array de temperaturas: " + Arrays.toString(temps));

                // Creamos una instancia y llamamos al método para calcular la media.
                WeatherStation weatherStation = new WeatherStation();
                weatherStation.calculateAvgTemp(temps);

                break;

            // Opción para visualizar el tercer ejercicio.
            case 3:
                // Creamos una instancia.
                Theatre theatre = new Theatre(5, 5, scanner);

                // Solicitamos reservas hasta que todos los asientos esten llenos,
                while (!theatre.isFullyBooked()) {
                    theatre.bookingSeat();
                }

                break;

            // Opción para visualizar el cuarto ejercicio.
            case 4:
                // Creamos un array de instancias.
                Person[] persons = new Person[5];

                // Datos para crear las instancias dentro del array.
                String[] names = {"Laura", "Pablo", "Sergio", "Sofía", "Ana"};
                String[] birthDates = {"1989-10-02", "1970-01-30", "1988-05-11", "2000-06-05", "2002-09-24"};
                String[] addresses = {
                        "Calle Gran Vía, 32, Madrid",
                        "Avenida Diagonal, 210, Barcelona",
                        "Calle Larios, 10, Málaga",
                        "Plaza Mayor, 5, Salamanca",
                        "Paseo de Gracia, 45, Barcelona"
                };
                String[] phones = {
                        "+34 612 345 678",
                        "+34 689 234 567",
                        "+34 675 890 123",
                        "+34 699 456 789",
                        "+34 622 678 901"
                };

                // Creamos las instancias.
                for (int i = 0; i < persons.length; i++) {
                    persons[i] = new Person(names[i], birthDates[i], addresses[i], phones[i]);
                }

                System.out.printf("%nNombre y edad de todas las personas:%n%n");

                // Mostramos el nombre y edad de cada persona.
                for (Person person : persons) {
                    person.getNameAndAge();
                }

                // Filtramos a las personas mayores de 30.
                Person[] personsOver30 = Arrays.stream(persons)
                        .filter(person -> person.getAge() > 30)
                        .toArray(Person[]::new);

                System.out.printf("%nPersonas mayores de 30:%n%n");

                // Mostramos toda la info de las personas filtradas.
                for (Person person : personsOver30) {
                    person.getFullInfo();
                }

                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }

        scanner.close();
    }
}
