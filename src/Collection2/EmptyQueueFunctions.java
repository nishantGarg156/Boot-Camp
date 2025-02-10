package Collection2;

import java.util.LinkedList;
import java.util.Queue;

public class EmptyQueueFunctions {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.element());
    }
}
