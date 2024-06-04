package org.example.sec08;

import io.grpc.stub.StreamObserver;
import org.example.models.sec08.GuessNumberGrpc;
import org.example.models.sec08.GuessRequest;
import org.example.models.sec08.GuessResponse;
import org.example.models.sec08.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadLocalRandom;

public class GuessNumberService extends GuessNumberGrpc.GuessNumberImplBase {
    private final static Logger LOGGER = LoggerFactory.getLogger(GuessNumberService.class);

    @Override
    public StreamObserver<GuessRequest> makeGuess(final StreamObserver<GuessResponse> responseObserver) {
        return new GuessRequestHandler(responseObserver);
    }

    private class GuessRequestHandler implements StreamObserver<GuessRequest> {
        private final StreamObserver<GuessResponse> responseObserver;
        private final int secret;
        private int attempt;

        public GuessRequestHandler(final StreamObserver<GuessResponse> responseObserver) {
            this.responseObserver = responseObserver;
            this.secret = ThreadLocalRandom.current().nextInt(1,101);
            this.attempt = 0;
        }

        @Override
        public void onNext(final GuessRequest guessRequest) {
            if(guessRequest.getGuess() > secret){
                this.send(Result.TOO_HIGH);
            } else if (guessRequest.getGuess() < secret) {
                this.send(Result.TOO_LOW);
            } else {
                LOGGER.info("Client guess {} is correct.", guessRequest.getGuess());
                this.send(Result.CORRECT);
                responseObserver.onCompleted();
            }

        }

        private void send(final Result result) {
            attempt++;
            var response = GuessResponse.newBuilder()
                    .setAttempt(attempt)
                    .setResult(result)
                    .build();
            this.responseObserver.onNext(response);
        }

        @Override
        public void onError(final Throwable throwable) {

        }

        @Override
        public void onCompleted() {
            this.responseObserver.onCompleted();
        }
    }
}
