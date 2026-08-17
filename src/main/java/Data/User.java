package Data;

import java.time.LocalDate;
import java.util.ArrayList;

public class User {

    private int id;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private String personalCode;
    private ArrayList<Account> accountNumber;

    public User(String name, String surname, LocalDate birthDate,
                String personalCode) {

        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.personalCode = personalCode;
        this.accountNumber = new ArrayList<>();

    }
    public String getName() {
        return this.name;
    }
    public String getSurname() {
        return this.surname;
    }
    public LocalDate getBirthDate() {
        return this.birthDate;
    }
    public String getPersonalCode() {
        return this.personalCode;
    }
    public void addAccount(Account account) {
        this.accountNumber.add(account);
    }

    @Override

    public String toString() {

        return getName() + " " + getSurname() + " " + getBirthDate() + " " + getPersonalCode();

    }

}
