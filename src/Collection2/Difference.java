package Collection2;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class Difference {
    public static void main(String[] args) {
        Queue<Integer> q = new ArrayBlockingQueue<>(4); {
            q.add(1);
            q.add(2);
            q.add(3);
            q.add(4);
            System.out.println("offer Method output :");
           System.out.println(q.offer(5));
           System.out.println(q);
        }

    }
}
