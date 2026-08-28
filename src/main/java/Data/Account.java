package Data;

import java.math.BigDecimal;

public class Account {

    private int accountNumber;
    private BigDecimal balance;


    public Account(int accountNumber, BigDecimal balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public BigDecimal getBalance() {

        return this.balance;

    }
    public void addBalance(BigDecimal amount) {

        this.balance = this.balance.add(amount);

    }


    public void reduceBalance(BigDecimal amount) {

        this.balance = this.balance.subtract(amount);
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    @Override

    public String toString() {
        return  getBalance() + "";
    }
}
