package org.example.sec02;

import org.example.models.sec02.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProtoDemo2 {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProtoDemo2.class);

    public static void main(String[] args) {
        var person1 = createPerson();
        LOGGER.info("person1:{}", person1);

        var person2 = createPerson();
        LOGGER.info("person2:{}", person2);

        LOGGER.info("person1 equals person2:{}", person1.equals(person2));
        LOGGER.info("person1 == person2:{}", person1 == person2);

        var person3 = person1.toBuilder().setName("John Senior").build();

        LOGGER.info("person3:{}", person3);

        LOGGER.info("person1 equals person3:{}", person1.equals(person3));
        LOGGER.info("person1 == person3:{}", person1 == person3);

        var person4 = person1.toBuilder().clearName().build();
        LOGGER.info("person4:{}", person4);
    }

    private static Person createPerson() {
        return Person.newBuilder()
                .setAge(23)
                .setName("Alex Junior")
                .build();
    }
}
