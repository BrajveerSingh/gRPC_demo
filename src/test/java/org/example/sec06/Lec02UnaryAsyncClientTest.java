package org.example.sec06;

import com.google.protobuf.Empty;
import org.example.common.ResponseObserver;
import org.example.models.sec06.AccountBalance;
import org.example.models.sec06.AllAccountResponse;
import org.example.models.sec06.BalanceCheckRequest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Lec02UnaryAsyncClientTest extends AbstractTest {
    private final static Logger LOGGER = LoggerFactory.getLogger(Lec02UnaryAsyncClientTest.class);

    @Test
    public void getBalanceTest() throws InterruptedException {
        var request = BalanceCheckRequest.newBuilder()
                .setAccountNumber(1)
                .build();
        var observer = ResponseObserver.<AccountBalance>create();
        this.bankServiceStub.getAccountBalance(request, observer);
        observer.await();
        assertEquals(1, observer.getResponses().size());
        assertEquals(100, observer.getResponses().get(0).getBalance());
        assertNull(observer.getThrowable());
    }

    @Test
    public void getAllAccountBalances(){
        var observer = ResponseObserver.<AllAccountResponse>create();
        this.bankServiceStub.getAllAccounts(Empty.getDefaultInstance(), observer);
        observer.await();
        assertEquals(1, observer.getResponses().size());
        assertEquals(10, observer.getResponses().get(0).getAccountBalanceCount());
        assertNull(observer.getThrowable());
    }

}
