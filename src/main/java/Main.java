import Data.Account;
import Data.User;
import Service.Recordservice;
import Service.Transaction;
import Service.Transferservice;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        LocalDate birthday = LocalDate.of(1996,1,1);
        User user = new User("Jack", "Jackson",
                birthday, "36708092232");
        User user2 = new User("Jenny", "Jackson",
                birthday, "46708092232");
        User user3 = new User("Jimmi", "Jackson",
                birthday, "56708092232");

        BigDecimal balance = new BigDecimal("40.0");
        BigDecimal balance2 = new BigDecimal("200.0");
        BigDecimal balance3 = new BigDecimal("100");

        BigDecimal amount = new BigDecimal("50");
        BigDecimal amount2 = new BigDecimal("30");
        BigDecimal amount3 = new BigDecimal("60");





        Account account = new Account(1, balance);
        Account account2 = new Account(2, balance2);
        Account account3 = new Account(3, balance3);
        user.addAccount(account);
        user2.addAccount(account2);
        user3.addAccount(account3);

        System.out.println("Account balance before sent: " + account);
        System.out.println("Account2 balance before sent: " + account2);

        Recordservice recordservice = new Recordservice();
        Transferservice transferservice = new Transferservice(recordservice);

        transferservice.createTransaction(account,account2,amount);
        //This transaction should fail and only add the failed transaction to the record
        System.out.println("First transaction between 2 accounts current balance:" + account);
        System.out.println("First transaction between 2 accounts current balance:" + account2);

        transferservice.createTransaction(account2, account, amount2);
        //This transaction should succeed
        System.out.println("Second transaction between 2 accounts current balance:" + account);
        System.out.println("Second transaction between 2 accounts current balance:" + account2);

        transferservice.createTransaction(account2, account3,amount3);
        System.out.println("Third transaction between 2 accounts current balance:" + account2);
        System.out.println("Third transaction between 2 accounts current balance:" + account3);

        System.out.println("Amount to be sent: " + amount + "\n" +
                 recordservice.printTransaction(account));
        System.out.println("******************");
        System.out.println("Amount to be sent: " + amount2 + "\n" +
                 recordservice.printTransaction(account2));
        System.out.println("******************");
        System.out.println("Amount to be sent: " + amount3 + "\n" +
                recordservice.printTransaction(account3));




    }
}
