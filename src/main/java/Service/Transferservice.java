package Service;


import Data.Account;

import java.math.BigDecimal;

public class Transferservice {

    private Recordservice recordservice;

    public Transferservice(Recordservice recordservice) {
        this.recordservice = recordservice;
    }
    //Transaction (sender,receiever, amount, timestamp, status)
    public Transaction createTransaction(Account sender, Account receiver, BigDecimal amount) {


        Transaction failedTransaction = new Transaction(sender,receiver,amount);

        if (sender.getBalance().compareTo(amount) >= 0) {

            System.out.println("If check worked");
            transfer(sender, receiver, amount);
            Transaction succesfulTransaction = new Transaction(sender, receiver, amount);
            this.recordservice.addTransactionToRecord(sender,succesfulTransaction);
            this.recordservice.addTransactionToRecord(receiver,succesfulTransaction);

            return succesfulTransaction;
        } else {
            System.out.println("Sender doesn't have enough balance to create a transaction");
        }
        this.recordservice.addTransactionToRecord(sender,failedTransaction);
        this.recordservice.addTransactionToRecord(receiver,failedTransaction);
        return failedTransaction;

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
        }

    // Withdrawal
        public void withdrawal(Account withdrawalAccount, BigDecimal amount) {
                withdrawalAccount.reduceBalance(amount);
        }




}



