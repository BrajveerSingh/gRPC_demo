package org.example.sec03;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.InvalidProtocolBufferException;
import org.example.models.sec03.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Lec03PerformanceTest {
    private final static Logger LOGGER = LoggerFactory.getLogger(Lec03PerformanceTest.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        var protoPerson = Person.newBuilder()
                .setAge(30)
                .setLastName("Singh")
                .setEmail("test@email.com")
                .setBankAccountNumber(1112223333L)
                .setEmployed(true)
                .setSalary(540000)
                .setBalance(-100000)
                .build();

        LOGGER.info("protoPerson:{}", protoPerson);

        var jsonPerson = new JsonPerson(
                "Singh",
                30,
                "test@email.com",
                true,
                540000,
                1112223333L,
                -100000);

        LOGGER.info("jsonPerson:{}", jsonPerson);

        json(jsonPerson);
        proto(protoPerson);
//        for(int i = 0; i < 5; i++) {
//            test("json", () -> json(jsonPerson));
//            test("proto", () -> proto(protoPerson));
//        }

    }

    private static void proto(Person person) {
        final var bytes = person.toByteArray();
        LOGGER.info("total bytes:{}", bytes.length);
        try {
            Person.parseFrom(bytes);
        } catch (InvalidProtocolBufferException e) {
            throw new RuntimeException(e);
        }
    }

    private static void json(JsonPerson person) {
        final byte[] bytes;
        try {
            bytes = objectMapper.writeValueAsBytes(person);
            LOGGER.info("total bytes:{}", bytes.length);
            objectMapper.readValue(bytes, JsonPerson.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void test(String testName, Runnable runnable){
        var start = System.currentTimeMillis();
        for(int i = 0; i < 5_000_000; i++){
            runnable.run();
        }
        var end = System.currentTimeMillis();
        LOGGER.info("Time taken for {} - {} ms.", testName, (end-start));
    }

}
