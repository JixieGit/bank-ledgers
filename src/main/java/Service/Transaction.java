package Service;

import Data.Account;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static Service.Status.PENDING;
import static Service.Status.FAILED;
import static Service.Status.SUCCESS;


public class Transaction {

    private Account sender;
    private Account receiver;
    private BigDecimal amount;
    private LocalDateTime timeStamp;
    private Status status;

    public Transaction(Account sender, Account receiver,
                       BigDecimal amount, Status status){//,// LocalDateTime timeStamp,
                       //Status status) {

        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.timeStamp = LocalDateTime.now();
        this.status = status;
    }
    public Account getSenderAccount() {
        return this.sender;
    }
    public BigDecimal getSenderAccountBalance() { return this.sender.getBalance();}
    public Account getReceiverAccount() {
        return this.receiver;
    }
    public BigDecimal getAmount() {
        return this.amount;
    }
    public String getFormattedtimeStamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        return this.timeStamp.format(formatter);
    }
    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {

        return "Transaction: " +
                "\n" + "Date created: " +
                "\n"  + getFormattedtimeStamp() +
                "\n" + "Sender: " +  this.sender.getAccountNumber() +
                "\n" + "Receiver: "  +  this.receiver.getAccountNumber()+
                "\n" + "Amount: " + this.getAmount() +
                "\n" + "Status: " + this.status;


    }

}
