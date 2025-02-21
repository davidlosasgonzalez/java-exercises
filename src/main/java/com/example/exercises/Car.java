// Indicamos el paquete.
package com.example.exercises;

// Importamos la clase UUID.
import java.util.Locale;
import java.util.UUID;

// Interfaz para vehículos que requieren mantenimiento.
interface Maintenance {
    void performInspection();
}

// Clase principal.
public class Car {
    final UUID id = UUID.randomUUID();
    final String brand;
    final String model;
    final int year;
    final boolean maintenance;

    // Constructor.
    public Car(String brand, String model, int year, boolean maintenance) {
        if (!isYearValid(year)) {
            throw new IllegalArgumentException("El año debe estar entre 1990 y el año actual.");
        }

        this.brand = brand;
        this.model = model;
        this.year = year;
        this.maintenance = maintenance;
    }

    // Método que comprueba si el año es válido.
    public static boolean isYearValid(int year) {
        int currentYear = java.time.LocalDate.now().getYear();
        return year >= 1990 && year <= currentYear;
    }

    // Método toString para imprimir información del coche.
    @Override
    public String toString() {
        return String.format(
                """
                {
                    "id": "%s",
                    "brand": "%s",
                    "model": "%s",
                    "year": %d,
                    "maintenance": %b
                }""", this.id, this.brand, this.model, this.year, this.maintenance
        );
    }
}

// Subclase para coches de combustión.
class CombustionCar extends Car implements Maintenance {
    // Consumo de combustible en L/100km.
    private final double fuelConsumption;

    // Tipo de motor (ej. "Gasolina", "Diesel").
    private final String engineType;

    // Constructor.
    public CombustionCar(String brand, String model, int year, boolean maintenance, double fuelConsumption, String engineType) {
        super(brand, model, year, maintenance);
        this.fuelConsumption = fuelConsumption;
        this.engineType = engineType;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public String getEngineType() {
        return engineType;
    }

    // Método que se encarga de realizar la inspección del vehículo.
    @Override
    public void performInspection() {
        System.out.printf("%nInspección del motor de combustión en %s %s.%n", brand, model);
    }

    // Sobrescribimos toString() para incluir información adicional.
    @Override
    public String toString() {
        return String.format(Locale.US,
                """
                {
                    "id": "%s",
                    "brand": "%s",
                    "model": "%s",
                    "year": %d,
                    "maintenance": %b,
                    "fuelConsumption": %.2f L/100km,
                    "engineType": "%s"
                }""", this.id, this.brand, this.model, this.year, this.maintenance, this.fuelConsumption, this.engineType
        );
    }
}

// Subclase para coches eléctricos.
class ElectricCar extends Car implements Maintenance {
    // Autonomía en km.
    private final double batteryRange;

    // Capacidad en kWh.
    private final int batteryCapacity;

    // Constructor.
    public ElectricCar(String brand, String model, int year, boolean maintenance, double batteryRange, int batteryCapacity) {
        super(brand, model, year, maintenance);
        this.batteryRange = batteryRange;
        this.batteryCapacity = batteryCapacity;
    }

    public double getBatteryRange() {
        return batteryRange;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    // Método que se encarga de realizar la inspección del vehículo.
    @Override
    public void performInspection() {
        System.out.printf("%nInspección del sistema eléctrico en %s %s.%n", brand, model);
    }

    // Sobrescribimos toString() para incluir información adicional.
    @Override
    public String toString() {
        return String.format(Locale.US,
                """
                {
                    "id": "%s",
                    "brand": "%s",
                    "model": "%s",
                    "year": %d,
                    "maintenance": %b,
                    "batteryRange": %.2f km,
                    "batteryCapacity": %d kWh
                }""", this.id, this.brand, this.model, this.year, this.maintenance, this.batteryRange, this.batteryCapacity
        );
    }
}
