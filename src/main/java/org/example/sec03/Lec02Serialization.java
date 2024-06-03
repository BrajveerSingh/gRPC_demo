package org.example.sec03;

import org.example.models.sec03.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Lec02Serialization {
    private final static Logger LOGGER = LoggerFactory.getLogger(Lec02Serialization.class);
    private static final Path PATH = Path.of("person.out");

    public static void main(String[] args) throws IOException {
        var person = Person.newBuilder()
                .setAge(30)
                .setLastName("Singh")
                .setEmail("test@email.com")
                .setBankAccountNumber(1112223333L)
                .setEmployed(true)
                .setSalary(540000)
                .setBalance(-100000)
                .build();

        LOGGER.info("{}", person);

        serialize(person);

        var person2 = deserailize();

        LOGGER.info("person equals person2:{}", person.equals(person2));
        LOGGER.info("person == person2:{}", person == person2);

        LOGGER.info("byte array length:{}", person.toByteArray().length);
    }

    private static void serialize(Person person) throws IOException {
        try(OutputStream outputStream = Files.newOutputStream(PATH)){
            person.writeTo(outputStream);
        }
    }

    private static Person deserailize() throws IOException {
        try(InputStream inputStream = Files.newInputStream(PATH)){
            return Person.parseFrom(inputStream);
        }
    }

}
