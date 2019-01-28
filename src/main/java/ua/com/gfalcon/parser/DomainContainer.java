package ua.com.gfalcon.parser;

import ua.com.gfalcon.domains.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;



/**
 * @author Oleksii Khalikov
 */
public class DomainContainer {

    private Set<Card> cards = new HashSet<>();

    private Set<Client> clients = new HashSet<>();

    private Set<Currency> currencies = new HashSet<>();

    private Set<Place> places = new HashSet<>();

    private Set<Transaction> transactions = new HashSet<>();

    private String placeName;

    private BigDecimal currentAmount;

    private String currencyName;

    private String cardNumber;

    private String firstName;

    private String lastName;

    private String middleName;

    private String inn;


    private Place getPlace(String name) {
        Optional<Place> optional = places.stream()
                .filter(place -> place.getName().equals(name))
                .findFirst();
        if (optional.isPresent()) {
            return optional.get();
        } else {
            Place place = new Place(name);
            places.add(place);
            return place;
        }
    }


    private Currency getCurrency(String name) {
        Optional<Currency> optional = currencies.stream()
                .filter(currency -> currency.getName().equals(name))
                .findFirst();
        if (optional.isPresent()) {
            return optional.get();
        } else {
            Currency currency = new Currency(name);
            currencies.add(currency);
            return currency;
        }
    }


    private Client getClient(String firstName, String lastName, String middleName, String inn) {
        Client newClient = new Client(firstName, lastName, middleName, inn);
        Optional<Client> optional = clients.stream().filter(client -> client.equals(newClient)).findFirst();
        if (optional.isPresent()) {
            return optional.get();
        } else {
            clients.add(newClient);
            return newClient;
        }
    }


    private Card getCard(String cardNumber, Client client) {
        Optional<Card> optional = cards.stream()
                .filter(card -> card.getCardNumber().equals(cardNumber) && card.getClient().equals(client))
                .findFirst();
        if (optional.isPresent()) {
            return optional.get();
        } else {
            Card card = new Card();
            card.setCardNumber(cardNumber);
            client.addCard(card);
            cards.add(card);
            return card;
        }
    }


    void setAmount(String value) {
        currentAmount = BigDecimal.valueOf(Double.valueOf(value));
    }


    void putTransaction() {
        Currency currency = getCurrency(currencyName);
        Place place = getPlace(placeName);
        Client client = getClient(firstName, lastName, middleName, inn);
        Card card = getCard(cardNumber, client);

        Transaction transaction = new Transaction();
        transaction.setPlace(place);
        transaction.setAmount(currentAmount);
        transaction.setCurrency(currency);
        transaction.setCard(card);
        transactions.add(transaction);
    }


    public void clear() {
        placeName = "";
        currentAmount = null;
        currencyName = "";
        cardNumber = "";
        firstName = "";
        lastName = "";
        middleName = "";
        inn = "";
    }


    public Set<Card> getCards() {
        return cards;
    }


    public Set<Client> getClients() {
        return clients;
    }


    public Set<Currency> getCurrencies() {
        return currencies;
    }


    public Set<Place> getPlaces() {
        return places;
    }


    public Set<Transaction> getTransactions() {
        return transactions;
    }


    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }


    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }


    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }


    public void setInn(String inn) {
        this.inn = inn;
    }

}
