package Collection2;

import java.util.PriorityQueue;

public class PriorityQueueInsertionWorking {
    public static void main(String[] args) {
        PriorityQueue<Character> pq = new PriorityQueue<>();
        pq.add('B');
        pq.add('C');
        pq.add('A');
        pq.add('B');
        pq.add('b');
        pq.add('a');
        pq.add('d');
        pq.add('c');
        System.out.println(pq);

    }
}
