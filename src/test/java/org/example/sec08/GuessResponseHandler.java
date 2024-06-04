package org.example.sec08;

import io.grpc.stub.StreamObserver;
import org.example.models.sec08.GuessRequest;
import org.example.models.sec08.GuessResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

public class GuessResponseHandler implements StreamObserver<GuessResponse> {
    private static final Logger LOGGER = LoggerFactory.getLogger(GuessNumberService.class);
    private final CountDownLatch latch = new CountDownLatch(1);
    private StreamObserver<GuessRequest> requestObserver;

    private int lb;
    private int mid;
    private int ub;
    @Override
    public void onNext(final GuessResponse guessResponse) {
        LOGGER.info("attempt:{}, result:{}", guessResponse.getAttempt(), guessResponse.getResult());
        switch (guessResponse.getResult()){
            case TOO_LOW -> this.send(this.mid, this.ub);
            case TOO_HIGH -> this.send(this.lb, this.mid);
        }

    }

    @Override
    public void onError(final Throwable throwable) {
        LOGGER.info("Error:{}", throwable.getMessage());
        latch.countDown();
    }

    @Override
    public void onCompleted() {
        requestObserver.onCompleted();
        latch.countDown();
    }

    public void setRequestObserver(final StreamObserver<GuessRequest> requestObserver) {
        this.requestObserver = requestObserver;
    }

    public void start() {
        this.send(0,100);
    }

    private void send(final int low, final int high){
        this.lb = low;
        this.ub = high;
        this.mid = low + (high - low) / 2;
        LOGGER.info("Client guess:{}", this.mid);
        requestObserver.onNext(GuessRequest.newBuilder().setGuess(mid).build());
    }

    public void await() {
        try{
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
