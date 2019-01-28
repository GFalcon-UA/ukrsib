package ua.com.gfalcon.domains;

import java.io.Serializable;
import java.util.Objects;



/**
 * @author Oleksii Khalikov
 */
public class Currency implements Serializable {

    private String name;


    public Currency() {
    }


    public Currency(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency currency = (Currency) o;
        return Objects.equals(getName(), currency.getName());
    }


    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

}
