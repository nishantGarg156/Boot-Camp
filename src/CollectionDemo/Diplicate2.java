package CollectionDemo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Diplicate2 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("a");
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("d");
        Set set = new HashSet(list);
        set.addAll(list);
        System.out.println(set.toString());
    }
}
