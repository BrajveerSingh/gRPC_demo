package org.example.sec06;

import com.google.common.util.concurrent.Uninterruptibles;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import org.example.models.sec06.AccountBalance;
import org.example.models.sec06.AllAccountResponse;
import org.example.models.sec06.BalanceCheckRequest;
import org.example.models.sec06.BankServiceGrpc;
import org.example.models.sec06.WithdrawRequest;
import org.example.models.sec06.WithdrawnAmount;
import org.example.sec06.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class BankService extends BankServiceGrpc.BankServiceImplBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(BankService.class);
    @Override
    public void getAccountBalance(final BalanceCheckRequest request, final StreamObserver<AccountBalance> responseObserver) {
        var accountNumber = request.getAccountNumber();
        var accountBalance = AccountBalance.newBuilder()
                .setAccountNumber(accountNumber)
                .setBalance(AccountRepository.getBalance(accountNumber))
                .build();
        responseObserver.onNext(accountBalance);
        responseObserver.onCompleted();
    }

    @Override
    public void getAllAccounts(final Empty request, final StreamObserver<AllAccountResponse> responseObserver) {
        final var accountBalances = AccountRepository.getAllAccounts()
                .entrySet()
                .stream()
                .map(e -> AccountBalance.newBuilder().setAccountNumber(e.getKey()).setBalance(e.getValue()).build())
                .toList();
        var response = AllAccountResponse.newBuilder().addAllAccountBalance(accountBalances).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void withdraw(final WithdrawRequest request, final StreamObserver<WithdrawnAmount> responseObserver) {
        var accountNumber = request.getAccountNumber();
        var requestedAmount = request.getAmount();
        var accountBalance = AccountRepository.getBalance(accountNumber);

        if (requestedAmount > accountBalance){
            responseObserver.onCompleted();
            return;
        }

        for (int i = 0; i < (requestedAmount / 10); i++){
            var withdrawnAmount = WithdrawnAmount.newBuilder().setAmount(10).build();
            responseObserver.onNext(withdrawnAmount);
            LOGGER.info("money sent:{}", withdrawnAmount);
            AccountRepository.debit(accountNumber,10);
            Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
        }

        responseObserver.onCompleted();
    }
}
