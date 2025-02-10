package CollectionDemo;
import java.util.HashSet;
import java.util.Set;
public class Intersection {
    public static void main(String[] args) {
        Set set = new HashSet();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        Set set2 = new HashSet();
        set2.add(5);
        set2.add(2);
        set2.add(3);
        set2.add(4);
        set2.add(9);
        Intersection intersection = new Intersection();
        intersection.findIntersection(set,set2);
    }
    private void findIntersection(Set set, Set set2) {
        Set intersection = new HashSet();
         for(Object o : set) {
             if(set2.contains(o))
                 intersection.add(o);
        }
         System.out.println(intersection);
    }
}
