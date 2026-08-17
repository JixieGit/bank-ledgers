import Data.Account;
import Data.User;
import Service.Transaction;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        LocalDate birthday = LocalDate.of(1996,01,01);
        User user = new User("Jack", "Jackson",
                birthday, "36708092232");
        User user2 = new User("Jenny", "Jackson",
                birthday, "46708092232");
        BigDecimal balance = new BigDecimal("100.0");
        BigDecimal balance2 = new BigDecimal("200.0");


        Account account = new Account(1, balance);
        Account account2 = new Account(2, balance2);
        user.addAccount(account);
        user2.addAccount(account2);



        System.out.println(account.getBalance());
        System.out.println(account2.getBalance());


    }
}
