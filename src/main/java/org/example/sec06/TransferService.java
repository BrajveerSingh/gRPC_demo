package org.example.sec06;

import com.google.common.util.concurrent.Uninterruptibles;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import org.example.models.sec06.AccountBalance;
import org.example.models.sec06.AllAccountResponse;
import org.example.models.sec06.BalanceCheckRequest;
import org.example.models.sec06.DepositRequest;
import org.example.models.sec06.TransferRequest;
import org.example.models.sec06.TransferResponse;
import org.example.models.sec06.TransferServiceGrpc;
import org.example.models.sec06.WithdrawRequest;
import org.example.models.sec06.WithdrawnAmount;
import org.example.sec06.repository.AccountRepository;
import org.example.sec06.requesthandlers.DepositRequestHandler;
import org.example.sec06.requesthandlers.TransferRequestHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class TransferService extends TransferServiceGrpc.TransferServiceImplBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(TransferService.class);

    @Override
    public StreamObserver<TransferRequest> transfer(final StreamObserver<TransferResponse> responseObserver) {
        return new TransferRequestHandler(responseObserver);
    }
}
