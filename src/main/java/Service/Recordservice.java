package Service;

import Data.Account;

import java.util.ArrayList;
import java.util.HashMap;

public class Recordservice {

    private HashMap<Account, Transaction> transaction;

    public Recordservice(){

        this.transaction = new HashMap<>();

    }

    public void addTransactionToRecord(Account account, Transaction transaction) {

        this.transaction.put(account, transaction);
    }
    public Transaction printTransaction(Account account) {

        return this.transaction.get(account);
    }


}
