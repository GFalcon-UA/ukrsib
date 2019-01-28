package ua.com.gfalcon.domains;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;



/**
 * @author Oleksii Khalikov
 */
public class Client implements Serializable {

    private String firstName;

    private String lastName;

    private String middleName;

    private String inn;

    private Set<Card> cards;


    public Client() {
        this.cards = new HashSet<>();
    }


    public Client(String firstName, String lastName, String middleName, String inn) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.inn = inn;
    }


    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getMiddleName() {
        return middleName;
    }


    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }


    public String getInn() {
        return inn;
    }


    public void setInn(String inn) {
        this.inn = inn;
    }


    public Set<Card> getCards() {
        return cards;
    }


    public void addCard(Card card) {
        this.cards.add(card);
        card.setClient(this);
    }


    public void removeCard(Card card) {
        this.cards.remove(card);
        card.setClient(null);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(getFirstName(), client.getFirstName()) &&
                Objects.equals(getLastName(), client.getLastName()) &&
                Objects.equals(getMiddleName(), client.getMiddleName()) &&
                Objects.equals(getInn(), client.getInn());
    }


    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getMiddleName(), getInn());
    }

}
