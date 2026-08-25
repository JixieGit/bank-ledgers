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

        BigDecimal balance = new BigDecimal("40.0");
        BigDecimal balance2 = new BigDecimal("200.0");
        BigDecimal amount = new BigDecimal("50");


        Account account = new Account(1, balance);
        Account account2 = new Account(2, balance2);
        user.addAccount(account);
        user2.addAccount(account2);

        Recordservice recordservice = new Recordservice();
        Transferservice transferservice = new Transferservice(recordservice);

        transferservice.createTransaction(account,account2,amount);

        System.out.println("Printing recordservice:" + "\n" + "Account recordservice " + recordservice.printTransaction(account));
        System.out.println("Printing recordservice:" + "\n" + "Account2 recordservice " + recordservice.printTransaction(account2));




    }
}
