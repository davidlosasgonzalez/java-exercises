// Indicamos el paquete.
package com.example.exercises;

// Importaciones para JUnit.
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Importaciones para simular la entrada y capturar la salida.
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

// Importamos la clase LocalDate.
import java.time.LocalDate;

// Inicializamos la clase.
public class PersonTest {
    @Test
    public void testPersonCreation_ValidAge() {
        String name = "Dani";
        String birthDate = "1980-10-05";
        String address = "Calle Real, 2, A Coruña";
        String phone = "+34 609 456 543";

        Person person = new Person(name, birthDate, address, phone);

        // Verificar que la persona se crea correctamente
        assertNotNull(person);
        assertEquals(name, person.name);
        assertEquals(LocalDate.parse(birthDate), person.birthDate);
        assertEquals(address, person.address);
        assertEquals(phone, person.phone);
    }

    @Test
    public void testPersonCreation_InvalidAgeThrowsException() {
        String name = "Dani";
        String invalidBirthDate = "2024-02-10"; // Persona menor de 18 años
        String address = "Calle Real, 2, A Coruña";
        String phone = "+34 609 456 543";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Person(name, invalidBirthDate, address, phone));

        assertEquals("La edad debe estar entre 18 y 100 años.", exception.getMessage());
    }

    @Test
    public void testIsValidAge() {
        LocalDate validBirthDate = LocalDate.parse("1980-10-05");
        LocalDate invalidBirthDateYoung = LocalDate.parse("2024-02-10");
        LocalDate invalidBirthDateOld = LocalDate.parse("1900-01-01");
        LocalDate edgeCase18 = LocalDate.now().minusYears(18);
        LocalDate edgeCase100 = LocalDate.now().minusYears(100);

        assertAll("Validar edades",
                () -> assertTrue(Person.isValidAge(validBirthDate), "Debe ser válido (43 años)."),
                () -> assertFalse(Person.isValidAge(invalidBirthDateYoung), "Debe ser inválido (< 18 años)."),
                () -> assertFalse(Person.isValidAge(invalidBirthDateOld), "Debe ser inválido (> 100 años)."),
                () -> assertTrue(Person.isValidAge(edgeCase18), "Debe ser válido (justo 18 años)."),
                () -> assertTrue(Person.isValidAge(edgeCase100), "Debe ser válido (justo 100 años).")
        );
    }

    @Test
    public void getNameAndAgeTest () {
        // Guardamos la referencia original de System.out para restaurarla después.
        PrintStream originalOut = System.out;

        // Creamos un ByteArrayOutputStream para almacenar la salida que se imprime en la consola.
        ByteArrayOutputStream testOutput = new ByteArrayOutputStream();

        // Redirigimos a System.out nuestro ByteArrayOutputStream.
        System.setOut(new PrintStream(testOutput));

        String name = "Dani";
        String birthDate = "1980-10-05";
        String address = "Calle Real, 2, A Coruña";
        String phone = "+34 609 456 543";

        Person person = new Person(name, birthDate, address, phone);

        person.getNameAndAge();

        // Restauramos System.out a su valor original para no afectar otros tests.
        System.setOut(originalOut);

        // Convertimos la salida capturada a una cadena.
        String output = testOutput.toString();

        // Comprobamos que los datos se muestren correctamente.
        assertEquals(String.format(
                """
                {
                    "name": "Dani",
                    "age": %d
                }
                """, person.getAge()
                ), output
        );
    }

    @Test
    public void getFullInfoTest () {
        // Guardamos la referencia original de System.out para restaurarla después.
        PrintStream originalOut = System.out;

        // Creamos un ByteArrayOutputStream para almacenar la salida que se imprime en la consola.
        ByteArrayOutputStream testOutput = new ByteArrayOutputStream();

        // Redirigimos a System.out nuestro ByteArrayOutputStream.
        System.setOut(new PrintStream(testOutput));

        String name = "Dani";
        String birthDate = "1980-10-05";
        String address = "Calle Real, 2, A Coruña";
        String phone = "+34 609 456 543";

        Person person = new Person(name, birthDate, address, phone);

        person.getFullInfo();

        // Restauramos System.out a su valor original para no afectar otros tests.
        System.setOut(originalOut);

        // Convertimos la salida capturada a una cadena.
        String output = testOutput.toString();

        // Comprobamos que los datos se muestren correctamente.
        assertEquals(String.format(
            """
            {
                "id": "%s",
                "name": "Dani",
                "birthDate": "1980-10-05",
                "address": "Calle Real, 2, A Coruña",
                "phone": "+34 609 456 543"
            }
            """, person.id), output
        );
    }

}
