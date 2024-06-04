package org.example.sec06;

import org.example.common.AbstractChannelTest;
import org.example.common.GrpcServer;
import org.example.models.sec06.BankServiceGrpc;
import org.example.models.sec06.TransferServiceGrpc;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public abstract class AbstractTest extends AbstractChannelTest {
    private final GrpcServer grpcServer =
            GrpcServer.create(
                    new BankService(),
                    new TransferService()
            );
    protected BankServiceGrpc.BankServiceBlockingStub blockingStub;
    protected BankServiceGrpc.BankServiceStub bankServiceStub;
    protected TransferServiceGrpc.TransferServiceStub transferServiceStub;

    @BeforeAll
    public void setup(){
        grpcServer.start();
        blockingStub = BankServiceGrpc.newBlockingStub(channel);
        bankServiceStub = BankServiceGrpc.newStub(channel);
        transferServiceStub = TransferServiceGrpc.newStub(channel);
    }

    @AfterAll
    public void stop(){
        grpcServer.stop();
    }
}
