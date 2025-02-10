package CollectionDemo;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SortingSet {
    public static void main(String[] args) {
        Set set = new HashSet();
        set.add(5);
        set.add(2);
        set.add(1);
        set.add(4);
        set.add(3);
        Set set2 = new TreeSet(set);
        System.out.println(set2);
    }
}
