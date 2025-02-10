package CollectionDemo;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class SortingArray {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(3);
        list.add(5);
        list.add(1);
        SortingArray sortingArray = new SortingArray();
        System.out.println(sortingArray.sortAccending(list).toString());
        System.out.println(sortingArray.sortDecending(list).toString());
    }
    private List<Integer> sortDecending(List<Integer> list) {
        list.sort(Comparator.reverseOrder());
        return list;
    }
    private List<Integer> sortAccending(List<Integer> list) {
        list.sort(Comparator.naturalOrder());
        return list;
    }
}
