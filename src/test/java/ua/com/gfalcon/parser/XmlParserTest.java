package ua.com.gfalcon.parser;

import org.junit.BeforeClass;
import org.junit.Test;
import ua.com.gfalcon.domains.*;
import ua.com.gfalcon.utils.ExampleResourceFile;

import java.io.BufferedReader;
import java.util.Set;

import static org.junit.Assert.assertEquals;



/**
 * @author Oleksii Khalikov
 */
public class XmlParserTest {

    private static DomainContainer container;


    @BeforeClass
    public static void setUp() throws Exception {
        ExampleResourceFile exampleResourceFile = new ExampleResourceFile("/test.xml");
        BufferedReader reader = exampleResourceFile.getFileReader();
        container = XmlParser.parse(reader);
    }


    @Test
    public void amountOfClients() {
        Set<Client> clients = container.getClients();
        assertEquals("Amount of clients", 3, clients.size());
    }


    @Test
    public void amountOfCurrencies() {
        Set<Currency> currencies = container.getCurrencies();
        assertEquals("Amount of currencies", 3, currencies.size());
    }


    @Test
    public void amountOfPlaces() {
        Set<Place> places = container.getPlaces();
        assertEquals("Amount of places", 4, places.size());
    }


    @Test
    public void amountOfCards() {
        Set<Card> cards = container.getCards();
        assertEquals("Amount of cards", 3, cards.size());
    }


    @Test
    public void amountOfTransactions() {
        Set<Transaction> transactions = container.getTransactions();
        assertEquals("Amount of transactions", 12, transactions.size());
    }


    @Test
    public void parsedContent() {
        Set<Transaction> transactions = container.getTransactions();
        long amount = transactions.stream()
                .filter(transaction -> {
                    Card card = transaction.getCard();
                    Client client = card.getClient();
                    return transaction.getPlace().getName().equals("A PLACE 4")
                            && transaction.getAmount().toString().equals("12.01")
                            && transaction.getCurrency().getName().equals("EUR")
                            && card.getCardNumber().equals("123456****1234")
                            && client.getFirstName().equals("Ivan")
                            && client.getLastName().equals("Ivanoff")
                            && client.getMiddleName().equals("Ivanoff")
                            && client.getInn().equals("1234567890");
                }).count();
        assertEquals("Transaction isn`t parsed or more than one", 1, amount);
    }

}