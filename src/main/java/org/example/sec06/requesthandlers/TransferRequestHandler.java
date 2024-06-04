package org.example.sec06.requesthandlers;

import io.grpc.stub.StreamObserver;
import org.example.models.sec06.AccountBalance;
import org.example.models.sec06.DepositRequest;
import org.example.models.sec06.TransferRequest;
import org.example.models.sec06.TransferResponse;
import org.example.models.sec06.TransferStatus;
import org.example.sec06.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TransferRequestHandler implements StreamObserver<TransferRequest> {
    private final static Logger LOGGER = LoggerFactory.getLogger(TransferRequestHandler.class);
    private final StreamObserver<TransferResponse> responseStreamObserver;

    public TransferRequestHandler(StreamObserver<TransferResponse> responseStreamObserver) {
        this.responseStreamObserver = responseStreamObserver;
    }

    @Override
    public void onNext(final TransferRequest transferRequest) {
        var transferStatus = transfer(transferRequest);
        var response = TransferResponse.newBuilder()
                .setFromAccount(toAccountBalance(transferRequest.getFromAccount()))
                .setToAccount(toAccountBalance(transferRequest.getToAccount()))
                .setStatus(transferStatus)
                .build();
        responseStreamObserver.onNext(response);
    }

    @Override
    public void onError(final Throwable throwable) {
        LOGGER.info("Transfer request error:{}", throwable.getMessage());
    }

    @Override
    public void onCompleted() {
        LOGGER.info("Transfer request stream completed.");
        responseStreamObserver.onCompleted();
    }

    private TransferStatus transfer(final TransferRequest transferRequest) {
        var amount = transferRequest.getAmount();
        var fromAccount = transferRequest.getFromAccount();
        var toAccount = transferRequest.getToAccount();
        if(AccountRepository.getBalance(fromAccount) >= amount && (toAccount != fromAccount)){
            AccountRepository.debit(fromAccount, amount);
            AccountRepository.credit(toAccount, amount);
            return TransferStatus.COMPLETED;
        }
        return TransferStatus.REJECTED;
    }

    private AccountBalance toAccountBalance(final int accountNumber) {
        return AccountBalance.newBuilder()
                .setAccountNumber(accountNumber)
                .setBalance(AccountRepository.getBalance(accountNumber))
                .build();
    }
}
