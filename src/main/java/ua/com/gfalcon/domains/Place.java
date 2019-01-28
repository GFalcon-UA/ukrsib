package ua.com.gfalcon.domains;

import java.io.Serializable;
import java.util.Objects;



/**
 * @author Oleksii Khalikov
 */
public class Place implements Serializable {

    private String name;


    public Place() {
    }


    public Place(String name) {
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
        Place place = (Place) o;
        return Objects.equals(getName(), place.getName());
    }


    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

}
