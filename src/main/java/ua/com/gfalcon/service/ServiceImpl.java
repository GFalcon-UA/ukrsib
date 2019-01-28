package ua.com.gfalcon.service;

import ua.com.gfalcon.domains.Client;
import ua.com.gfalcon.domains.Transaction;
import ua.com.gfalcon.parser.DomainContainer;
import ua.com.gfalcon.parser.XmlParser;
import ua.com.gfalcon.util.ResourceFile;

import javax.xml.stream.XMLStreamException;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



/**
 * @author Oleksii Khalikov
 */
public class ServiceImpl implements Service {

    private static DomainContainer container;


    static {
        ResourceFile resourceFile = new ResourceFile("/transactions.xml");
        BufferedReader reader = resourceFile.getFileReader();
        try {
            container = XmlParser.parse(reader);
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Client> getClients() {
        Set<Client> clients = container.getClients();
        return new ArrayList<>(clients);
    }


    @Override
    public List<Transaction> getTransactions() {
        Set<Transaction> transactions = container.getTransactions();
        return new ArrayList<>(transactions);
    }

}
