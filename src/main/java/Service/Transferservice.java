package Service;


import Data.Account;

import java.math.BigDecimal;


import static Service.Status.*;

public class Transferservice {

    private Recordservice recordservice;


    public Transferservice(Recordservice recordservice) {
        this.recordservice = recordservice;

    }
    //Transaction (sender,receiver, amount, timestamp, status)
    public Transaction createTransaction(Account sender, Account receiver, BigDecimal amount) {

        if (amount.signum() <= 0 ) {
            throw new RuntimeException("Amount is 0 or below 0");
        }


        Transaction transaction = new Transaction(sender,receiver,amount,PENDING);
        this.recordservice.addTransactionToRecord(sender,transaction);
        this.recordservice.addTransactionToRecord(receiver,transaction);

        return transaction;

    }
    //Transfer
        public void transfer(Account sender, Account receiver, BigDecimal amount) {
            sender.reduceBalance(amount);
            receiver.addBalance(amount);

            System.out.println("Transfer worked");
    }
        public void checkTransaction(Transaction transaction) {

        // Check if the sender has the amount to send to receiver
        if (transaction.getSenderAccountBalance().compareTo(transaction.getAmount()) >= 0) {
                // Calling the transfer method to reduce the balance of the send and add balance of the receiver
            transfer(transaction.getSenderAccount(), transaction.getReceiverAccount(),
                        transaction.getAmount());
                // Here should be a changeStatus method that will change the status to SUCCESS
                        transaction.setStatus(SUCCESS);
           } else {

            transaction.setStatus(FAILED);


            }
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



