package org.example.sec08;

import org.example.common.AbstractChannelTest;
import org.example.common.GrpcServer;
import org.example.common.ResponseObserver;
import org.example.models.sec08.GuessNumberGrpc;
import org.example.models.sec08.GuessResponse;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GuessANumberTest extends AbstractChannelTest {
    private final static Logger LOGGER = LoggerFactory.getLogger(GuessNumberService.class);

    private final GrpcServer server = GrpcServer.create(new GuessNumberService());
    private GuessNumberGrpc.GuessNumberStub guessNumberStub;

    @BeforeAll
    public void setup() {
        this.server.start();
        this.guessNumberStub = GuessNumberGrpc.newStub(channel);
    }

    @RepeatedTest(5)
//    @Test
    public void guess(){
        var responseObserver = new GuessResponseHandler();
        var requestObserver = this.guessNumberStub.makeGuess(responseObserver);
        responseObserver.setRequestObserver(requestObserver);
        responseObserver.start();
        responseObserver.await();
        LOGGER.info("Completed Test");
    }

    @AfterAll
    public void tearDown() {
        server.stop();
    }
}
