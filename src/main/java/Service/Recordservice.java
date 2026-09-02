package Service;

import Data.Account;

import java.util.ArrayList;
import java.util.HashMap;

public class Recordservice {

    private HashMap<Account, ArrayList<Transaction>> transaction;

    public Recordservice(){

        this.transaction = new HashMap<>();

    }

    public void addTransactionToRecord(Account account, Transaction transaction) {
        // Check if the account has a list in the hashmap, if it doesn't add a list, if it does add to the list
        // Also need to check for duplicate transaction values inside the list.

        //First time this checked it's true: doesn't contain key
        if (!this.transaction.containsKey(account)) {
            ArrayList<Transaction> transactionArrayList = new ArrayList<>();
            transactionArrayList.add(transaction);
            this.transaction.put(account,transactionArrayList);

        } else {
            this.transaction.get(account).add(transaction);
        }
    }
    public ArrayList<Transaction> printTransaction(Account account) {

        return this.transaction.get(account);
    }


}
