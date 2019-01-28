package ua.com.gfalcon.view;

import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import ua.com.gfalcon.domains.Client;
import ua.com.gfalcon.service.Service;
import ua.com.gfalcon.service.ServiceImpl;
import ua.com.gfalcon.service.TransactionProvider;

import java.util.ArrayList;
import java.util.List;



/**
 * Homepage
 */
public class HomePage extends WebPage {

    private static final long serialVersionUID = 1L;

    private static Service service = new ServiceImpl();


    /**
     * Constructor that is invoked when page is invoked without a session.
     *
     * @param parameters Page parameters
     */
    public HomePage(final PageParameters parameters) {
        add(getClientList("clientView"));

        add(getTransactionsTable("transactionTable", 10));
    }


    private ListView getClientList(String id) {
        return new ListView(id, service.getClients()) {
            @Override
            protected void populateItem(ListItem item) {
                Client client = (Client) item.getModelObject();
                item.add(new Label("firstName", client.getFirstName()));
                item.add(new Label("lastName", client.getLastName()));
                item.add(new Label("middleName", client.getMiddleName()));
                item.add(new Label("inn", client.getInn()));
            }
        };
    }


    private DefaultDataTable getTransactionsTable(String id, int rowsPerPage) {
        TransactionProvider provider = new TransactionProvider();
        List<IColumn> columns = new ArrayList<>();

        provider.setSort(new SortParam<>("amount", true));

        columns.add(new PropertyColumn(new Model<>("Place"), "place.name", "place.name"));
        columns.add(new PropertyColumn(new Model<>("Amount"), "amount", "amount"));
        columns.add(new PropertyColumn(new Model<>("Currency"), "currency.name", "currency.name"));
        columns.add(new PropertyColumn(new Model<>("Card"), "card.cardNumber", "card.cardNumber"));
        columns.add(new PropertyColumn(new Model<>("Client"), "card.client.lastName", "card.client.lastName"));
        return new DefaultDataTable(id, columns, provider, rowsPerPage);
    }

}
