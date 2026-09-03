import Data.Account;
import Service.Recordservice;
import Service.Status;
import Service.Transaction;
import Service.Transferservice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;


@DisplayName("Transferservice tests")
class TestTransferService {

    private Transferservice transferservice;
    private Recordservice recordservice;
    private Transaction transaction;
    private Status status;


    @BeforeEach
    void setUp() {
        recordservice = new Recordservice();
        transferservice = new Transferservice(recordservice);




    }

    @Test
    @DisplayName("createTransaction negative or zero amount")
    void testNegativeOrZeroAmount() {

        // For testing 0 value
        assertThrows(RuntimeException.class,() -> transferservice.createTransaction(new Account(1, new BigDecimal(100)),
                        new Account(1, new BigDecimal(100)) , new BigDecimal(0)),
                "Runtime exception should run if the amount is 0 or below 0");
        // For testing negative value;
        assertThrows(RuntimeException.class,() -> transferservice.createTransaction(new Account(1, new BigDecimal(100)),
                        new Account(1, new BigDecimal(100)) , new BigDecimal(-1)),
                "Runtime exception should run if the amount is 0 or below 0");

    }
    @Test
    @DisplayName("createTransaction positive amount")
    void testPositiveAmountDoesNotThrow() {
        assertDoesNotThrow(() -> transferservice.createTransaction(
                new Account(1, new BigDecimal(100)),
                new Account(2, new BigDecimal(100)),
                new BigDecimal(1)));
    }
    @Test
    @DisplayName("checkTransaction status FAILED")
    void testSetStatusFailed() {
        transaction = new Transaction(new Account(1, new BigDecimal(40)),
                new Account(2, new BigDecimal(100)), new BigDecimal(50),Status.PENDING);

        transferservice.checkTransaction(transaction);
        assertSame(transaction.getStatus(), Status.FAILED, "Result should be the same");
    }
    @Test
    @DisplayName("checkTransaction status SUCCESS")
    void testSetStatusSuccess() {
            transaction = new Transaction(new Account(1, new BigDecimal(60)),
                    new Account(2, new BigDecimal(100)), new BigDecimal(50),Status.PENDING);

            transferservice.checkTransaction(transaction);
            assertSame(transaction.getStatus(), Status.SUCCESS, "Result should be the same");
        }
    }



