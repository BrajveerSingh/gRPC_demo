package org.example.sec06;

import com.google.common.util.concurrent.Uninterruptibles;
import org.example.common.ResponseObserver;
import org.example.models.sec06.AccountBalance;
import org.example.models.sec06.DepositAmount;
import org.example.models.sec06.DepositRequest;
import org.example.models.sec06.WithdrawRequest;
import org.example.models.sec06.WithdrawnAmount;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Lec04ClientStreamingTest extends AbstractTest {
    private final static Logger LOGGER = LoggerFactory.getLogger(Lec04ClientStreamingTest.class);

    @Test
    public void deposit() {
        var responseObserver = ResponseObserver.<AccountBalance>create();
        var requestObserver = this.asyncStub.deposit(responseObserver);
        requestObserver.onNext(DepositRequest.newBuilder().setAccountNumber(5).build());
        IntStream.rangeClosed(1, 10)
                .mapToObj(i -> DepositAmount.newBuilder().setAmount(10).build())
                .map(depositAmount -> DepositRequest.newBuilder().setDepositAmount(depositAmount).build())
                .forEach(requestObserver::onNext);

        requestObserver.onCompleted();

        responseObserver.await();

        assertEquals(1, responseObserver.getResponses().size());
        assertEquals(200, responseObserver.getResponses().get(0).getBalance());
        assertNull(responseObserver.getThrowable());

    }

    @Test
    public void depositRequestCancellation() {
        var responseObserver = ResponseObserver.<AccountBalance>create();
        var requestObserver = this.asyncStub.deposit(responseObserver);
        requestObserver.onNext(DepositRequest.newBuilder().setAccountNumber(5).build());
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
        requestObserver.onError(new RuntimeException());
        responseObserver.await();

        assertNotNull(responseObserver.getThrowable());

    }

}
