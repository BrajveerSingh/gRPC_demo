package org.example.sec02;

import org.example.models.sec02.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProtoDemo {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProtoDemo.class);

    public static void main(String[] args) {
        var person = Person.newBuilder()
                .setAge(23)
                .setName("Alex Junior")
                .build();
        LOGGER.info("{}", person);
    }
}
