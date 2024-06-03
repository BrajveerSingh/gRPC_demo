package org.example.sec03;

import org.example.models.sec03.Credentials;
import org.example.models.sec03.EmailCredentials;
import org.example.models.sec03.PhoneCredentials;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec07OneOfDemo {
    private static final Logger LOGGER = LoggerFactory.getLogger(Lec07OneOfDemo.class);

    public static void main(String[] args) {
        var emailCredentials = EmailCredentials.newBuilder()
                .setAddress("test@email.com")
                .setPassword("testPasword")
                .build();
        var phoneCredentials = PhoneCredentials.newBuilder()
                .setNumber(123445567)
                .setCode(1234)
                .build();

        Credentials credentials1 = Credentials.newBuilder()
                .setEmailCredentials(emailCredentials)
                .build();

        login(credentials1);

        Credentials credentials2 = Credentials.newBuilder()
                .setPhoneCredentials(phoneCredentials)
                .build();

        login(credentials2);

        Credentials credentials3 = Credentials.newBuilder()
                .setPhoneCredentials(phoneCredentials)
                .setEmailCredentials(emailCredentials)
                .build();

        login(credentials3);  // last one will win - it will set EmailCredentials
    }

    private static void login(Credentials credentials) {
        switch (credentials.getLoginCredentialsCase()) {
            case EMAILCREDENTIALS -> LOGGER.info("Email Credentials: {}", credentials.getEmailCredentials());
            case PHONECREDENTIALS -> LOGGER.info("Phone Credentials: {}", credentials.getPhoneCredentials());
        }
    }

}
