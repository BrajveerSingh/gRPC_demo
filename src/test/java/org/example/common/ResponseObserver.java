package org.example.common;

import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ResponseObserver<T> implements StreamObserver<T> {
    private final static Logger LOGGER = LoggerFactory.getLogger(ResponseObserver.class);
    private final List<T> list = Collections.synchronizedList(new ArrayList<>());
    private Throwable throwable;
    private final CountDownLatch countDownLatch;

    private ResponseObserver(int countDown){
        countDownLatch = new CountDownLatch(countDown);
    }

    public static <T> ResponseObserver<T> create() {
        return create(1);
    }

    public static <T> ResponseObserver<T> create(int countDown) {
        return new ResponseObserver<>(countDown);
    }

    @Override
    public void onNext(final T response) {
        LOGGER.info("Received response: {}", response);
        list.add(response);
    }

    @Override
    public void onError(final Throwable throwable) {
        LOGGER.info("Received error:{}", throwable.getMessage());
        this.throwable = throwable;
        countDownLatch.countDown();
    }

    @Override
    public void onCompleted() {
        LOGGER.info("Completed");
        countDownLatch.countDown();
    }

    public void await() {
        try{
            this.countDownLatch.await(5, TimeUnit.SECONDS);
        } catch (InterruptedException e){
            throw  new RuntimeException(e);
        }
    }

    public List<T> getResponses(){
        return list;
    }

    public Throwable getThrowable(){
        return throwable;
    }
}
