package CollectionDemo;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Demonstration {
    public static void main(String[] args) {
        Set set = new HashSet();
        set.add(1);
        set.add(200);
        set.add(5);
        set.add(40000);
        set.add(30000);
        Set set2 = new TreeSet();
        set2.add(1);
        set2.add(2);
        set2.add(5);
        set2.add(4);
        set2.add(3);
        System.out.println(set.toString());
        System.out.println(set2.toString());

    }
}
