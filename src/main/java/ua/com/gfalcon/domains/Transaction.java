package ua.com.gfalcon.domains;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;



/**
 * @author Oleksii Khalikov
 */
public class Transaction implements Serializable {

    private Place place;

    private BigDecimal amount;

    private Card card;

    private Currency currency;


    public Transaction() {
    }


    public Transaction(Card card, BigDecimal amount, Place place) {
        setCard(card);
        this.amount = amount;
        this.place = place;
    }


    public Place getPlace() {
        return place;
    }


    public void setPlace(Place place) {
        this.place = place;
    }


    public BigDecimal getAmount() {
        return amount;
    }


    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }


    public Card getCard() {
        return card;
    }


    public void setCard(Card card) {
        this.card = card;
    }


    public Currency getCurrency() {
        return currency;
    }


    public void setCurrency(Currency currency) {
        this.currency = currency;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return getPlace().equals(that.getPlace()) &&
                getAmount().equals(that.getAmount()) &&
                getCard().equals(that.getCard()) &&
                getCurrency().equals(that.getCurrency());
    }


    @Override
    public int hashCode() {
        return Objects.hash(getPlace(), getAmount(), getCard(), getCurrency());
    }

}
