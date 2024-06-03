package org.example.sec03;

import org.example.models.sec03.Address;
import org.example.models.sec03.School;
import org.example.models.sec03.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec04Composition {
    private static final Logger LOGGER = LoggerFactory.getLogger(Lec04Composition.class);

    public static void main(String[] args) {
        var address = Address.newBuilder()
                .setStreet("Street 0123")
                .setCity("Bangalore")
                .setState("Karnataka")
                .build();
        var student = Student.newBuilder()
                .setName("Raj Kumar")
                .setAddress(address)
                .build();
        var school = School.newBuilder()
                .setId(01)
                .setAddress(address.toBuilder().setStreet("alpha street"))
                .setName("St. Thomas")
                .build();

        LOGGER.info("address:{}", address);
        LOGGER.info("student:{}", student);
        LOGGER.info("school:{}", school);

        LOGGER.info("student name:{}", student.getName());
    }
}
