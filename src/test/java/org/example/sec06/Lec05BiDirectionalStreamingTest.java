package org.example.sec06;

import com.google.common.util.concurrent.Uninterruptibles;
import io.grpc.stub.StreamObserver;
import org.example.common.ResponseObserver;
import org.example.models.sec06.AccountBalance;
import org.example.models.sec06.DepositAmount;
import org.example.models.sec06.DepositRequest;
import org.example.models.sec06.TransferRequest;
import org.example.models.sec06.TransferResponse;
import org.example.models.sec06.TransferStatus;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Lec05BiDirectionalStreamingTest extends AbstractTest {
    private final static Logger LOGGER = LoggerFactory.getLogger(Lec05BiDirectionalStreamingTest.class);

    @Test
    public void transfer() {
        var responseObserver = ResponseObserver.<TransferResponse>create();
        final var requestObserver = this.transferServiceStub.transfer(responseObserver);
        var requests = List.of(
                TransferRequest.newBuilder().setAmount(10).setFromAccount(6).setToAccount(6).build(),
                TransferRequest.newBuilder().setAmount(110).setFromAccount(6).setToAccount(7).build(),
                TransferRequest.newBuilder().setAmount(10).setFromAccount(6).setToAccount(7).build(),
                TransferRequest.newBuilder().setAmount(10).setFromAccount(7).setToAccount(6).build()
        );
        requests.forEach(requestObserver::onNext);
        requestObserver.onCompleted();
        responseObserver.await();

        assertEquals(4, responseObserver.getResponses().size());
        validate(responseObserver.getResponses().get(0), TransferStatus.REJECTED, 100, 100);
        validate(responseObserver.getResponses().get(1), TransferStatus.REJECTED, 100, 100);
        validate(responseObserver.getResponses().get(2), TransferStatus.COMPLETED, 90, 110);
        validate(responseObserver.getResponses().get(3), TransferStatus.COMPLETED, 100, 100);
    }

    private void validate(TransferResponse response, TransferStatus status, int fromAccountBalance, int toAccountBalance) {
        assertEquals(status, response.getStatus());
        assertEquals(fromAccountBalance, response.getFromAccount().getBalance());
        assertEquals(toAccountBalance, response.getToAccount().getBalance());
    }

}
