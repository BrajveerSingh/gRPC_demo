package org.example.sec03;

import org.example.models.sec03.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec01Scalar {
    private final static Logger LOGGER = LoggerFactory.getLogger(Lec01Scalar.class);

    public static void main(String[] args) {
        var person = Person.newBuilder()
                .setAge(30)
                .setLastName("Singh")
                .setEmail("test@email.com")
//                .setBankAccountNumber(1112223333L)
                .setEmployed(true)
                .setSalary(540000)
                .setBalance(-100000)
                .build();

        LOGGER.info("{}", person);
    }
}
