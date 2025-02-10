package Java8AndMultiThreading;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class DeadLockExample {
    private static final Lock lock1 = new ReentrantLock();
    private static final Lock lock2 = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {

        // Deadlock Scenario (Thread 1 and Thread 2 trying to acquire locks in reverse order)
        Thread thread1 = new Thread(() -> {
            try {
                // Deadlock happens here (Thread 1 locks lock1 first, then tries to lock lock2)
                synchronized (lock1) {
                    System.out.println("Thread 1 acquired lock1");
                    try { Thread.sleep(100); } catch (InterruptedException e) {}
                    synchronized (lock2) {
                        System.out.println("Thread 1 acquired lock2");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                // Deadlock happens here (Thread 2 locks lock2 first, then tries to lock lock1)
                synchronized (lock2) {
                    System.out.println("Thread 2 acquired lock2");
                    try { Thread.sleep(100); } catch (InterruptedException e) {}
                    synchronized (lock1) {
                        System.out.println("Thread 2 acquired lock1");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();


        // Implementing Lock Ordering to Avoid Deadlock:

        System.out.println("\n==== Lock Ordering Strategy ====");

        thread1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread 1 acquired lock1");
                try { Thread.sleep(100); } catch (InterruptedException e) {}
                synchronized (lock2) {
                    System.out.println("Thread 1 acquired lock2");
                }
            }
        });

        thread2 = new Thread(() -> {
            synchronized (lock1) {  // Both threads now acquire lock1 first, then lock2
                System.out.println("Thread 2 acquired lock1");
                try { Thread.sleep(100); } catch (InterruptedException e) {}
                synchronized (lock2) {
                    System.out.println("Thread 2 acquired lock2");
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();


    }
}
