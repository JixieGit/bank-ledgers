package Service;


import Data.Account;

import java.math.BigDecimal;

public class Transferservice {


    public Transferservice() {

    }
    public Transaction createTransaction(Account sender, Account receiver, BigDecimal amount) {
        Transaction failedTransaction = new Transaction(sender,receiver,amount);
        if (sender.getBalance().compareTo(amount) >= 0) {
            sendAmount(sender, receiver, amount);
            Transaction succesfulTransaction = new Transaction(sender, receiver, amount);
            return succesfulTransaction;
        } else {
            System.out.println("Sender doesn't have enough balance to create a transaction");
        }
        return failedTransaction;

    }
        public void sendAmount(Account sender, Account receiver, BigDecimal amount) {
            sender.reduceBalance(amount);
            receiver.addBalance(amount);

            System.out.println("Send amount worked");
    }


}



