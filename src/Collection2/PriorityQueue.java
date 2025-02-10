package Collection2;

import java.util.Comparator;
import java.util.Queue;

public class PriorityQueue {
    public static void main(String[] args) {
        Queue<Character> pq = new java.util.PriorityQueue<>();
        pq.add('B');
        pq.add('C');
        pq.add('A');
        pq.add('B');
        pq.add('b');
        pq.add('a');
        pq.add('d');
        pq.add('c');
        System.out.println(  Comparator.reverseOrder());

    }
}
