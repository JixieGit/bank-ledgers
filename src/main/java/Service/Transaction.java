package Service;

import Data.Account;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public class Transaction {

    private Account sender;
    private Account receiver;
    private BigDecimal amount;
    private LocalDateTime timeStamp;
    private Status status;

    public Transaction(Account sender, Account receiver,
                       BigDecimal amount){//,// LocalDateTime timeStamp,
                       //Status status) {

        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
//        this.timeStamp = timeStamp;
//        this.status = status;
    }
    public Account getSenderAccount() {
        return this.sender;
    }
    public Account getReceiverAccount() {
        return this.receiver;
    }
    public BigDecimal getAmount() {
        return this.amount;
    }
    @Override
    public String toString() {


        return "Transaction: " + "\n" +  "Sender: " +  this.getSenderAccount() +
                "\n" + "Receiver: "  +  this.getReceiverAccount()+
                "\n" + "Amount: " + this.getAmount();
    }

}
