package Service;

import Data.Account;

public class Transferservice {

    private Transaction transaction;
    private Account sender;
    private Account receiver;


    public Transferservice(Transaction transaction, Account sender,
                           Account receiver) {
        this.sender = sender;
        this.receiver = receiver;
        this.transaction = transaction;
    }





    public void createTransaction() {

    }


    public void sendAmount(double amount) {

        this.sender.reduceBalance(amount);

        this.receiver.addBalance(amount);

    }

}
