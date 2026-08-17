package Service;

import Data.Account;

import java.time.LocalDateTime;


public class Transaction {

    private Account sender;
    private Account receiver;
    private double amount;
    private LocalDateTime timeStamp;
    private Status status;

    public Transaction(Account sender, Account receiver,
                       double amount, LocalDateTime timeStamp, Status status) {

        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.timeStamp = timeStamp;
        this.status = status;
    }


}
