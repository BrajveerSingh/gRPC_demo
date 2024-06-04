package org.example.sec07;

import com.google.common.util.concurrent.Uninterruptibles;
import io.grpc.stub.StreamObserver;
import org.example.models.sec07.Output;
import org.example.models.sec07.RequestSize;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class ResponseHandler implements StreamObserver<Output> {
    private final static Logger LOGGER = LoggerFactory.getLogger(ResponseHandler.class);
    private int size;
    private CountDownLatch latch = new CountDownLatch(1);
    private StreamObserver<RequestSize> requestObserver;

    @Override
    public void onNext(final Output output) {
        size--;
        process(output);
        if(size == 0){
            LOGGER.info("Requesting next set of responses from server.");
            request(ThreadLocalRandom.current().nextInt(3, 10));
        }
    }

    @Override
    public void onError(final Throwable throwable) {
        LOGGER.info("Error:{}", throwable.getMessage());
        latch.countDown();
    }

    @Override
    public void onCompleted() {
        LOGGER.info("Got completed signal from server.");
        requestObserver.onCompleted();
        LOGGER.info("completed");
        latch.countDown();
    }

    public void setRequestObserver(final StreamObserver<RequestSize> requestObserver) {
        this.requestObserver = requestObserver;
    }

    private void request(final int size) {
        LOGGER.info("requesting size:{}", size);
        this.size = size;
        requestObserver.onNext(RequestSize.newBuilder().setSize(size).build());
    }

    private void process(final Output output) {
        LOGGER.info("Received:{}", output);
        Uninterruptibles.sleepUninterruptibly(
                ThreadLocalRandom.current().nextInt(50, 200),
                TimeUnit.MILLISECONDS
        );
    }

    public void await() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void start(){
        request(3);
    }
}
