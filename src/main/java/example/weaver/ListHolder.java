package example.weaver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Holds a copy of a String array, returns a defensive copy.
 */
public class ListHolder {

    private final List<String> list;

    public ListHolder(String[] array) {
        this.list = new ArrayList<String>(Arrays.asList(array));
    }

    public List<String> getList() {
        return new ArrayList<String>(list);
    }

    public String toString() {
        return "ListHolder" + list.toString();
    }

}
