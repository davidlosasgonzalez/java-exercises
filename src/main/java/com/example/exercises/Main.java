// Indicamos el paquete.
package com.example.exercises;

// Importamos las clases necesarias.
import java.util.Scanner;
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
                        5 -> Ejercicio fábrica automóviles
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

                // Solicitamos reservas hasta que el total de los asientos esten llenos.
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
                    System.out.println(person);
                }

                break;

            // Opción para visualizar el quinto ejercicio.
            case 5:
                // Array para almacenar los coches.
                Car[] cars = new Car[5];

                // Array de valores para generar los coches (2 diésel, 1 gasolina, 2 eléctricos).
                String[] brands = {"Opel", "Ford", "Toyota", "Tesla", "Nissan"};
                String[] models = {"Astra", "Focus", "Corolla", "Model 3", "Leaf"};
                int[] years = {2021, 2019, 2020, 2023, 2022};
                boolean[] maintenances = {false, true, false, false, true };

                // Solo para vehículos de combustión.
                double[] fuelConsumptions = {5.6, 6.2, 7.5};
                String[] engineTypes = {"Diesel", "Diesel", "Gasoline"};

                // Solo para vehículos eléctricos.
                double[] batteryRanges = {500, 400};
                int[] batteryCapacities = {75, 60};

                // Creamos las instancias y las almacenamos en el array.
                for (int i = 0; i < cars.length; i++) {
                    // Los tres primeros vehículos son de combustión.
                    if (i < 3) {
                        cars[i] = new CombustionCar(brands[i], models[i], years[i], maintenances[i], fuelConsumptions[i], engineTypes[i]);
                    } else { // Los dos últimos son eléctricos
                        cars[i] = new ElectricCar(brands[i], models[i], years[i], maintenances[i], batteryRanges[i - 3], batteryCapacities[i - 3]);
                    }
                }

                // Mostramos info de cada coche.
                for (Car car : cars) {
                    System.out.println(car.toString());
                }

                // Realizamos la inspección a los vehículos que lo necesiten.
                for (Car car : cars) {
                    if (car.maintenance && car instanceof Maintenance maintenanceCar) {
                        maintenanceCar.performInspection();
                    }
                }

                break;

            default:
                System.out.println("Opción no válida.");
                break;
        }

        scanner.close();
    }
}
