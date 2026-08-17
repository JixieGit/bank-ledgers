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
    public void addBalance(double amount) {

        this.balance = this.balance.add(new BigDecimal(amount));

    }
    public void checkBalance() {

    }
    public void reduceBalance(double amount) {

        this.balance = this.balance.subtract(new BigDecimal(amount));
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    @Override

    public String toString() {
        return getAccountNumber() + " " + getBalance() + "€";
    }
}
