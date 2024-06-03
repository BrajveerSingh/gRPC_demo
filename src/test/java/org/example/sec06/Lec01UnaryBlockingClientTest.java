package org.example.sec06;

import com.google.protobuf.Empty;
import org.example.models.sec06.BalanceCheckRequest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Lec01UnaryBlockingClientTest extends AbstractTest {
    private final static Logger LOGGER = LoggerFactory.getLogger(Lec01UnaryBlockingClientTest.class);

    @Test
    public void getBalanceTest() {
        var request = BalanceCheckRequest.newBuilder()
                .setAccountNumber(1)
                .build();
        var balance = this.blockingStub.getAccountBalance(request);

        LOGGER.info("balance:{}", balance);

        assertEquals(100, balance.getBalance());
    }

    @Test
    public void getAllAccountBalances(){
        var response = this.blockingStub.getAllAccounts(Empty.getDefaultInstance());
        LOGGER.info("All accounts balances:{}", response.getAccountBalanceList());

        assertEquals(10, response.getAccountBalanceCount());
    }

}
