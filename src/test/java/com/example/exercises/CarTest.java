// Indicamos el paquete.
package com.example.exercises;

// Importaciones para JUnit.
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Importaciones para simular la salida de la consola.
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

// Importamos la clase LocalDate.
import java.time.LocalDate;

public class CarTest {
    @Test
    public void testCreateCombustionCar() {
        String brand = "Ford";
        String model = "Focus";
        int validYear = 2019;
        boolean maintenance = true;
        double fuelConsumption = 6.2;
        String engineType = "Diesel";

        CombustionCar combustionCar = new CombustionCar(brand, model, validYear, maintenance, fuelConsumption, engineType);

        assertAll("Validar la creación de un coche de combustión",
                () -> assertNotNull(combustionCar, "El coche de combustión no debería ser nulo."),
                () -> assertEquals(brand, combustionCar.brand, "La marca debería coincidir."),
                () -> assertEquals(model, combustionCar.model, "El modelo debería coincidir."),
                () -> assertEquals(validYear, combustionCar.year, "El año debería ser válido."),
                () -> assertEquals(maintenance, combustionCar.maintenance, "El estado de mantenimiento debería coincidir."),
                () -> assertEquals(fuelConsumption, combustionCar.getFuelConsumption(), "El consumo de combustible debería coincidir."),
                () -> assertEquals(engineType, combustionCar.getEngineType(), "El tipo de motor debería coincidir.")
        );
    }

    @Test
    public void testCreateElectricCar() {
        String brand = "Tesla";
        String model = "Model 3";
        int validYear = 2023;
        boolean maintenance = false;
        double batteryRange = 500;
        int batteryCapacity = 75;

        ElectricCar electricCar = new ElectricCar(brand, model, validYear, maintenance, batteryRange, batteryCapacity);

        assertAll("Validar la creación de un coche eléctrico",
                () -> assertNotNull(electricCar, "El coche eléctrico no debería ser nulo."),
                () -> assertEquals(brand, electricCar.brand, "La marca debería coincidir."),
                () -> assertEquals(model, electricCar.model, "El modelo debería coincidir."),
                () -> assertEquals(validYear, electricCar.year, "El año debería ser válido."),
                () -> assertEquals(maintenance, electricCar.maintenance, "El estado de mantenimiento debería coincidir."),
                () -> assertEquals(batteryRange, electricCar.getBatteryRange(), "La autonomía de la batería debería coincidir."),
                () -> assertEquals(batteryCapacity, electricCar.getBatteryCapacity(), "La capacidad de la batería debería coincidir.")
        );
    }

    @Test
    public void testInvalidCarYearThrowsException() {
        String brand = "Toyota";
        String model = "Corolla";
        int pastYear = 1960; // Año demasiado antiguo
        int futureYear = LocalDate.now().getYear() + 5; // Año en el futuro
        boolean maintenance = false;

        Exception pastException = assertThrows(IllegalArgumentException.class, () ->
                new Car(brand, model, pastYear, maintenance)
        );

        Exception futureException = assertThrows(IllegalArgumentException.class, () ->
                new Car(brand, model, futureYear, maintenance)
        );

       assertEquals("El año debe estar entre 1990 y el año actual.", pastException.getMessage(),
                        "El mensaje de excepción debe indicar que el año no es válido.");
    }

    @Test
    public void testIsValidYear() {
        int validYear = 2021;
        int invalidYear = 1960;
        int futureYear = LocalDate.now().getYear() + 1;
        int edgeCase1990 = 1990;
        int edgeCaseCurrentYear = LocalDate.now().getYear();

        assertAll("Validar años",
                () -> assertTrue(Car.isYearValid(validYear), "Debe ser válido."),
                () -> assertFalse(Car.isYearValid(invalidYear), "Debe ser inválido."),
                () -> assertFalse(Car.isYearValid(futureYear), "Debe ser inválido (el año aún no existe)."),
                () -> assertTrue(Car.isYearValid(edgeCase1990), "Debe ser válido (1990 es el año mínimo permitido)."),
                () -> assertTrue(Car.isYearValid(edgeCaseCurrentYear), "Debe ser válido (año actual permitido).")
        );
    }

    @Test
    public void testPerformInspection() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream testOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOutput));

        Car combustionCar = new CombustionCar("Ford", "Focus", 2019, true, 6.2, "Diesel");
        ((Maintenance) combustionCar).performInspection();

        Car electricCar = new ElectricCar("Tesla", "Model 3", 2023, true, 500, 75);
        ((Maintenance) electricCar).performInspection();

        System.setOut(originalOut);
        String output = testOutput.toString().trim();

        assertAll("Validar inspecciones",
                () -> assertTrue(output.contains("Inspección del motor de combustión en Ford Focus."), "La inspección del coche de combustión debe ejecutarse."),
                () -> assertTrue(output.contains("Inspección del sistema eléctrico en Tesla Model 3."), "La inspección del coche eléctrico debe ejecutarse.")
        );
    }

    @Test
    public void testToString() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream testOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOutput));

        Car combustionCar = new CombustionCar("Ford", "Focus", 2019, true, 6.2, "Diesel");
        Car electricCar = new ElectricCar("Tesla", "Model 3", 2023, false, 500, 75);

        System.out.println(combustionCar.toString().trim());
        System.out.println(electricCar.toString().trim());

        System.setOut(originalOut);
        String output = testOutput.toString().trim();

        System.out.println(output);

        assertAll("Validar salida toString()",
                () -> assertTrue(output.contains("\"fuelConsumption\": 6.20"), "Debe mostrar el consumo de combustible."),
                () -> assertTrue(output.contains("\"engineType\": \"Diesel\""), "Debe mostrar el tipo de motor."),
                () -> assertTrue(output.contains("\"batteryRange\": 500.00"), "Debe mostrar la autonomía de la batería."),
                () -> assertTrue(output.contains("\"batteryCapacity\": 75"), "Debe mostrar la capacidad de la batería.")
        );
    }
}
