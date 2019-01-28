package ua.com.gfalcon.service;

import ua.com.gfalcon.domains.Client;
import ua.com.gfalcon.domains.Transaction;

import java.util.List;



/**
 * @author Oleksii Khalikov
 */
public interface Service {

    List<Client> getClients();

    List<Transaction> getTransactions();

}
