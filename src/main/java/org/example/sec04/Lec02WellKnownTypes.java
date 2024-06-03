package org.example.sec04;

import com.google.protobuf.Int32Value;
import com.google.protobuf.Timestamp;
import org.example.models.common.Address;
import org.example.models.common.BodyStyle;
import org.example.models.common.Car;
import org.example.models.sec04.Person;
import org.example.models.sec04.Sample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;

public class Lec02WellKnownTypes {
    private static final Logger LOGGER = LoggerFactory.getLogger(Lec02WellKnownTypes.class);

    public static void main(String[] args) {
        var sample = Sample.newBuilder()
                .setAge(Int32Value.of(20))
                .setLoginTime(
                        Timestamp.newBuilder()
                                .setSeconds(
                                        Instant.now().getEpochSecond()
                                )
                ).build();

        LOGGER.info("login time: {}", Instant.ofEpochSecond(sample.getLoginTime().getSeconds()));
    }
}
