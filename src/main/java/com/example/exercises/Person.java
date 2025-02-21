// Indicamos el paquete.
package com.example.exercises;

// Importamos las clases necesarias.
import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

// Inicializamos la clase.
public class Person {
    final UUID id = UUID.randomUUID();
    final String name;
    final LocalDate birthDate;
    final String address;
    final String phone;

    // Constructor.
    public Person(String name, String birthDate, String address, String phone) {
        LocalDate parsedBirthDate = LocalDate.parse(birthDate);

        if (!isValidAge(parsedBirthDate)) {
            throw new IllegalArgumentException("La edad debe estar entre 18 y 100 años.");
        }

        this.name = name;
        this.birthDate = parsedBirthDate;
        this.address = address;
        this.phone = phone;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getAge() {
        return Period.between(this.birthDate, LocalDate.now()).getYears();
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    // Método que comprueba si la edad es válida.
    public static boolean isValidAge(LocalDate birthDate) {
        int age = Period.between(birthDate, LocalDate.now()).getYears();
        return age >= 18 && age <= 100;
    }

    // Método que imprime el nombre y la edad de la persona en formato JSON.
    public void getNameAndAge() {
        System.out.printf(
                """
                {
                    "name": "%s",
                    "age": %d
                }
                """,
                this.name, this.getAge()
        );
    }

    // Sobrescribe el método toString para devolver los datos de la persona en formato JSON.
    @Override
    public String toString() {
        return String.format(
                """
                {
                    "id": "%s",
                    "name": "%s",
                    "birthDate": "%s",
                    "address": "%s",
                    "phone": "%s"
                }
                """,
                this.id, this.name, this.birthDate, this.address, this.phone
        );
    }
}
