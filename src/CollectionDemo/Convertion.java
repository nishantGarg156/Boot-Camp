package CollectionDemo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Convertion {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        List<String> linkList = new LinkedList<>(list);
        //Above line will initialize a linked list containing all elements of arrayList
        System.out.println("converted arrayList into LinkedList " );
        System.out.println(linkList.toString());
        List<Integer> list1= new LinkedList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        List<Integer> arrayList = new LinkedList<>(list1);
        System.out.println("Converted linkedlist into arraylidt " );
        System.out.println(arrayList.toString());
    }
}
