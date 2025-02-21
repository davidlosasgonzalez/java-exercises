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
    public void testPersonCreation() {
        String name = "Dani";
        String validBirthDate = "1980-10-05";
        String invalidBirthDate = "1900-01-01";
        String address = "Calle Real, 2, A Coruña";
        String phone = "+34 609 456 543";

        // Crear una persona con datos válidos
        Person person = new Person(name, validBirthDate, address, phone);

        // Intentar crear una persona con un año de nacimiento inválido
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Person(name, invalidBirthDate, address, phone)
        );

        // Agrupar todas las validaciones con assertAll
        assertAll("Validar la creación de la persona",
                () -> assertNotNull(person, "La persona no debería ser nula."),
                () -> assertEquals(name, person.name, "El nombre debería coincidir."),
                () -> assertEquals(LocalDate.parse(validBirthDate), person.birthDate, "La fecha de nacimiento debería coincidir."),
                () -> assertEquals(address, person.address, "La dirección debería coincidir."),
                () -> assertEquals(phone, person.phone, "El teléfono debería coincidir."),
                () -> assertEquals("La edad debe estar entre 18 y 100 años.", exception.getMessage(),
                        "El mensaje de excepción debería indicar el error correctamente.")
        );
    }

    @Test
    public void testIsValidAge() {
        LocalDate validBirthDate = LocalDate.parse("1980-10-05");
        LocalDate invalidBirthDateYoung = LocalDate.parse("2024-02-10");
        LocalDate invalidBirthDateOld = LocalDate.parse("1900-01-01");
        LocalDate edgeCase18 = LocalDate.now().minusYears(18);
        LocalDate edgeCase100 = LocalDate.now().minusYears(100);

        assertAll("Validar edades",
                () -> assertTrue(Person.isValidAge(validBirthDate), "Debe ser válido."),
                () -> assertFalse(Person.isValidAge(invalidBirthDateYoung), "Debe ser inválido."),
                () -> assertFalse(Person.isValidAge(invalidBirthDateOld), "Debe ser inválido."),
                () -> assertTrue(Person.isValidAge(edgeCase18), "Debe ser válido."),
                () -> assertTrue(Person.isValidAge(edgeCase100), "Debe ser válido.")
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
    public void toStringTest () {
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

        System.out.println(person.toString().trim());

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
