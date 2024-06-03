package org.example.sec06;

import org.example.common.ResponseObserver;
import org.example.models.sec06.AccountBalance;
import org.example.models.sec06.WithdrawRequest;
import org.example.models.sec06.WithdrawnAmount;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Lec03ServerStreamingClientTest extends AbstractTest {
    private final static Logger LOGGER = LoggerFactory.getLogger(Lec03ServerStreamingClientTest.class);

    @Test
    public void blockingClientWithdraw() {
        var request = WithdrawRequest.newBuilder()
                .setAccountNumber(1)
                .setAmount(50)
                .build();
        final var withdrawnAmountIterator = this.blockingStub.withdraw(request);
        int count = 0;
        while (withdrawnAmountIterator.hasNext()) {
            final WithdrawnAmount amount = withdrawnAmountIterator.next();
            LOGGER.info("Received money:{}", amount);
            assertEquals(10, amount.getAmount());
            count++;
        }
        assertEquals(5, count);
    }

    @Test
    public void asyncClientWithdraw() {
        var request = WithdrawRequest.newBuilder()
                .setAccountNumber(1)
                .setAmount(50)
                .build();
        var observer = ResponseObserver.<WithdrawnAmount>create();
        this.asyncStub.withdraw(request, observer);
        observer.await();
        assertEquals(5, observer.getResponses().size());
        assertEquals(10, observer.getResponses().get(0).getAmount());
        assertNull(observer.getThrowable());

    }

}
