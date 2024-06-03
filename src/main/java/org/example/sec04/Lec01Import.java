package org.example.sec04;

import org.example.models.common.Address;
import org.example.models.common.BodyStyle;
import org.example.models.common.Car;
import org.example.models.sec04.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec01Import {
    private static final Logger LOGGER = LoggerFactory.getLogger(Lec01Import.class);

    public static void main(String[] args) {
        var address = Address.newBuilder()
                .setStreet("st. 123")
                .setCity("Nehtaur")
                .setState("U.P")
                .build();
        var car = Car.newBuilder().setBodyStyle(BodyStyle.SEDAN).build();

        var person = Person.newBuilder()
                .setName("Mohan")
                .setAge(45)
                .setAddress(address)
                .setCar(car)
                .build();

        LOGGER.info("{}", person);
    }
}
