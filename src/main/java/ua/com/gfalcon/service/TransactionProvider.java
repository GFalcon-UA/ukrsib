package ua.com.gfalcon.service;

import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import ua.com.gfalcon.domains.Transaction;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;



/**
 * @author Oleksii Khalikov
 */
public class TransactionProvider extends SortableDataProvider {

    private List<Transaction> list;

    private Comparator<Transaction> comparator;


    public TransactionProvider() {
        Service service = new ServiceImpl();
        list = service.getTransactions();
        comparator = new TransactionProviderComparator();
    }


    @Override
    public Iterator iterator(long first, long count) {
        List<Transaction> newList = new ArrayList<>(list);
        newList.sort(comparator);
        return newList.subList(Long.valueOf(first).intValue(), Long.valueOf(first + count).intValue()).iterator();
    }


    @Override
    public long size() {
        return list.size();
    }


    @Override
    public IModel<Transaction> model(Object object) {
        return (IModel<Transaction>) () -> (Transaction) object;
    }


    private class TransactionProviderComparator implements Comparator<Transaction>, Serializable {

        @Override
        public int compare(Transaction o1, Transaction o2) {
            PropertyModel<Comparable> model1 = new PropertyModel<>(o1, (String) getSort().getProperty());
            PropertyModel<Comparable> model2 = new PropertyModel<>(o2, (String) getSort().getProperty());

            int result = model1.getObject().compareTo(model2.getObject());

            if (!getSort().isAscending()) {
                result = -result;
            }

            return result;
        }

    }

}
