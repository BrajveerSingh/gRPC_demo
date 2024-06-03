package org.example.sec03;

import org.example.models.sec03.Car;
import org.example.models.sec03.Dealer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec06MapDemo {
    private static final Logger LOGGER = LoggerFactory.getLogger(Lec06MapDemo.class);

    public static void main(String[] args) {
            var car1 = Car.newBuilder()
                    .setMake("honda")
                    .setModel("civic")
                    .setYear(2000)
                    .build();
        var car2 = Car.newBuilder()
                .setMake("honda")
                .setModel("accord")
                .setYear(2002)
                .build();
        var car3 = Car.newBuilder()
                .setMake("maruti")
                .setModel("swift")
                .setYear(2005)
                .build();
        var dealer = Dealer.newBuilder()
                .putCarByYear(car1.getYear(), car1)
                .putCarByYear(car2.getYear(), car2)
                .putCarByYear(car3.getYear(), car3)
                .putCarByYear(car1.getYear(), car1)
                .putCarByYear(car2.getYear(), car2)
                .putCarByModel(car1.getModel(), car1)
                .putCarByModel(car2.getModel(), car2)
                .putCarByModel(car3.getModel(), car3)
                .build();

        LOGGER.info("Dealer: {}", dealer);

        LOGGER.info("Cars by year:{}", dealer.getCarByYearMap());
        LOGGER.info("Cars by model:{}", dealer.getCarByModelMap());

        LOGGER.info("accord car details:{}", dealer.getCarByModelMap().get("accord"));
    }
}
