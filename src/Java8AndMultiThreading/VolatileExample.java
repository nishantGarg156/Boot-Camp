package Java8AndMultiThreading;
public class VolatileExample extends Thread {
    private static volatile int count =0;

    public  void run() {
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }

    public static int getCount() {
        return count;
    }
    public static void main(String[] args) throws InterruptedException {
        VolatileExample[] threads = new VolatileExample[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new VolatileExample();
            threads[i].start();
        }
        for(VolatileExample thread : threads) {
            thread.join();
        }
        System.out.println("Final count value " + count);
    }

}
