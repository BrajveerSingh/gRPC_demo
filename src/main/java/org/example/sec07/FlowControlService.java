package org.example.sec07;

import io.grpc.stub.StreamObserver;
import org.example.models.sec07.FlowControlServiceGrpc;
import org.example.models.sec07.Output;
import org.example.models.sec07.RequestSize;
import org.example.sec06.TransferService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.IntStream;

public class FlowControlService extends FlowControlServiceGrpc.FlowControlServiceImplBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(TransferService.class);

    @Override
    public StreamObserver<RequestSize> getMessages(final StreamObserver<Output> responseObserver) {
        return new RequestHandler(responseObserver);
    }

    private static class RequestHandler implements StreamObserver<RequestSize> {
        private final StreamObserver<Output> outputStreamObserver;
        private int numberOfMessagesEmitted;

        private RequestHandler(StreamObserver<Output> outputStreamObserver) {
            this.outputStreamObserver = outputStreamObserver;
            this.numberOfMessagesEmitted = 0;
        }

        @Override
        public void onNext(final RequestSize requestSize) {
            IntStream.rangeClosed(numberOfMessagesEmitted + 1, 100)
                    .limit(requestSize.getSize())
                    .forEach(
                            i -> {
                                LOGGER.info("Emitting {}", i);
                                outputStreamObserver.onNext(Output.newBuilder().setValue(i).build());
                            });
            numberOfMessagesEmitted += requestSize.getSize();
            if(numberOfMessagesEmitted >= 100){
                outputStreamObserver.onCompleted();
            }
        }

        @Override
        public void onError(final Throwable throwable) {

        }

        @Override
        public void onCompleted() {
            outputStreamObserver.onCompleted();
        }
    }
}
