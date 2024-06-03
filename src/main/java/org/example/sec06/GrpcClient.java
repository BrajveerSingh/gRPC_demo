package org.example.sec06;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.example.models.sec06.AccountBalance;
import org.example.models.sec06.BalanceCheckRequest;
import org.example.models.sec06.BankServiceGrpc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class GrpcClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(GrpcClient.class);

    public static void main(String[] args) throws InterruptedException {
        var channel =
                ManagedChannelBuilder
                        .forAddress("localhost", 6565)
                        .usePlaintext()   // since we are not using secure connection
                        .build();

//        syncronousStubDemo(channel);

        asyncStubDemo(channel);     // supports all for communication patterns

        TimeUnit.SECONDS.sleep(2);

        LOGGER.info("Exiting main...");

    }

    private static void asyncStubDemo(final ManagedChannel channel) {
        var stub = BankServiceGrpc.newStub(channel);
        stub.getAccountBalance(BalanceCheckRequest.newBuilder().setAccountNumber(2).build(), new StreamObserver<AccountBalance>() {
            @Override
            public void onNext(final AccountBalance accountBalance) {
                LOGGER.info("balance:{}", accountBalance);
            }

            @Override
            public void onError(final Throwable throwable) {

            }

            @Override
            public void onCompleted() {
                LOGGER.info("completed");
            }
        });
    }

    private static void syncronousStubDemo(final ManagedChannel channel) {
        var stub = BankServiceGrpc.newBlockingStub(channel);

        final var balance = stub.getAccountBalance(BalanceCheckRequest.newBuilder().setAccountNumber(2).build());

        LOGGER.info("balance:{}", balance);
    }
}
