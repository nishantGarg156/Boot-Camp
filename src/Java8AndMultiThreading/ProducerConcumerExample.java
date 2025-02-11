package Java8AndMultiThreading;
/*Remark: BlockingQueue helps us to maintain synchronization automatically as  designed to handle thread safe operation
// BlockingQueue is internally used in producer consumer problem
//  internal working of blockingQueue: blockingQueue excepts notNull arguments
//Thread 1 put the log and thread 2 consume the log
//LinkedBlockingQueue is optionally bounded queue if size is given it is bounded else it is unbounded
*/
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class SimpleTestLog {
    String message;

    public SimpleTestLog(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}

class Producer implements Runnable {
    private BlockingQueue<SimpleTestLog> queue;

    public Producer(BlockingQueue<SimpleTestLog> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                SimpleTestLog log = new SimpleTestLog("Test Log :" + i);
                queue.put(log);
                System.out.println("Produced: " + log);
                Thread.sleep(100);
            }
            queue.put(new SimpleTestLog("empty Test log"));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Consumer implements Runnable {
    private BlockingQueue<SimpleTestLog> queue;

    public Consumer(BlockingQueue<SimpleTestLog> queue) {
        this.queue = queue;
    }

    @Override
    public  void run() {
        try {
            while (true) {
                SimpleTestLog log = queue.take();
                if (log.message.equals("empty Test log")) break;

                System.out.println("Consumed: " + log);
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
public class ProducerConcumerExample {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<SimpleTestLog> queue = new LinkedBlockingQueue<>(10);

        Thread producerThread = new Thread(new Producer(queue));
        Thread consumerThread = new Thread(new Consumer(queue));

        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();
    }
}


