package org.example.sec06.requesthandlers;

import io.grpc.stub.StreamObserver;
import org.example.models.sec06.AccountBalance;
import org.example.models.sec06.DepositRequest;
import org.example.sec06.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DepositRequestHandler implements StreamObserver<DepositRequest> {
    private final static Logger LOGGER = LoggerFactory.getLogger(DepositRequestHandler.class);
    private final StreamObserver<AccountBalance> responseObserver;
    private int accountNumber;

    public DepositRequestHandler(StreamObserver<AccountBalance> responseObserver) {
        this.responseObserver = responseObserver;
    }

    @Override
    public void onNext(final DepositRequest depositRequest) {
        switch (depositRequest.getRequestCase()){
            case ACCOUNT_NUMBER -> this.accountNumber = depositRequest.getAccountNumber();
            case DEPOSIT_AMOUNT -> AccountRepository.credit(this.accountNumber, depositRequest.getDepositAmount().getAmount());
        }
    }

    @Override
    public void onError(final Throwable throwable) {
        //rollback the transaction
        LOGGER.error("Client Error occurred:{}", throwable.getMessage());
    }

    @Override
    public void onCompleted() {
        var accountBalance = AccountBalance.newBuilder()
                .setAccountNumber(this.accountNumber)
                .setBalance(AccountRepository.getBalance(this.accountNumber))
                .build();
        this.responseObserver.onNext(accountBalance);
        this.responseObserver.onCompleted();
        //commit the transaction
    }
}
