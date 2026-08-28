package Data;

import java.time.LocalDate;
import java.util.ArrayList;

public class User {

    private String name;
    private String surname;
    private LocalDate birthDate;
    private String personalCode;
    private ArrayList<Account> account;

    public User(String name, String surname, LocalDate birthDate,
                String personalCode) {

        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.personalCode = personalCode;
        this.account = new ArrayList<>();

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
        this.account.add(account);
    }

    @Override

    public String toString() {

        return getName() + " " + getSurname() + " " + getBirthDate() + " " + getPersonalCode();

    }

}
