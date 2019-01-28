package ua.com.gfalcon.domains;

import java.io.Serializable;
import java.util.Objects;



/**
 * @author Oleksii Khalikov
 */
public class Card implements Serializable {

    private Client client;

    private String cardNumber;


    public Card() {
    }


    public Client getClient() {
        return client;
    }


    void setClient(Client client) {
        this.client = client;
    }


    public String getCardNumber() {
        return cardNumber;
    }


    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return getClient().equals(card.getClient()) &&
                getCardNumber().equals(card.getCardNumber());
    }


    @Override
    public int hashCode() {
        return Objects.hash(getClient(), getCardNumber());
    }


}
