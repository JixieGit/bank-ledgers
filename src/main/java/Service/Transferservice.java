package Service;


import Data.Account;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static Service.Status.FAILED;
import static Service.Status.SUCCESS;

public class Transferservice {

    private Recordservice recordservice;


    public Transferservice(Recordservice recordservice) {
        this.recordservice = recordservice;

    }
    //Transaction (sender,receiver, amount, timestamp, status)
    public void createTransaction(Account sender, Account receiver, BigDecimal amount) {

        if (sender.getBalance().compareTo(amount) >= 0) {
            transfer(sender, receiver, amount);
            Transaction succesfulTransaction = new Transaction(sender, receiver, amount, SUCCESS);

            this.recordservice.addTransactionToRecord(sender,succesfulTransaction);
            this.recordservice.addTransactionToRecord(receiver,succesfulTransaction);
        } else {
            Transaction failedTransaction = new Transaction(sender,receiver,amount, FAILED);
            this.recordservice.addTransactionToRecord(sender,failedTransaction);
            this.recordservice.addTransactionToRecord(receiver,failedTransaction);
            System.out.println("FAILED TRANSFER BELOW");
        }
    }
    //Transfer
        public void transfer(Account sender, Account receiver, BigDecimal amount) {
            sender.reduceBalance(amount);
            receiver.addBalance(amount);

            System.out.println("Transfer worked");
    }

    // Deposits
        public void deposit(Account depositAccount, BigDecimal amount) {
                depositAccount.addBalance(amount);

            System.out.println("Deposit worked");
        }

    // Withdrawal
        public void withdrawal(Account withdrawalAccount, BigDecimal amount) {
                withdrawalAccount.reduceBalance(amount);

            System.out.println("Withdrawal worked");

        }




}



