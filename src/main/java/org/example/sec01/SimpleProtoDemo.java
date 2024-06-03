package org.example.sec01;

import org.example.models.sec01.PersonOuterClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleProtoDemo {
    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleProtoDemo.class);

    public static void main(String[] args) {
        var person = PersonOuterClass.Person
                .newBuilder()
                .setAge(25)
                .setName("Ramesh Kumar")
                .build();
        LOGGER.info("{}", person);
    }
}
