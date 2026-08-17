package Cards;

import java.time.LocalDate;

public class Card {

    private String cardNumber;
    private LocalDate expiryDate;
    private int cvvNumber;

    public Card(String cardNumber, LocalDate expiryDate, int cvvNumber) {

        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvvNumber = cvvNumber;
    }
    public String getCardNumber() {
        return this.cardNumber;
    }
    public LocalDate getExpiryDate() {
        return this.expiryDate;
    }
    public int getCvvNumber() {
        return this.cvvNumber;
    }
}

