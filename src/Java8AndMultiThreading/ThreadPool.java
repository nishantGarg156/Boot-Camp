package Java8AndMultiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPool implements Runnable{
    private String testName;

    public ThreadPool(String testName) {
        this.testName = testName;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        try {
            Thread.sleep( 2000);  // Simulate test execution
            long duration = System.currentTimeMillis() - startTime;
            System.out.printf("%s completed in %d ms%n", testName, duration);
        } catch (InterruptedException e) {
            System.out.println(testName + " was interrupted");
        }
    }
}
 class SimpleThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);

        try {
            for (int i = 1; i <= 10; i++) {
                pool.submit(new TestCase("Test-" + i));
            }
        } finally {
            pool.shutdown();
            try {
                pool.awaitTermination(1, TimeUnit.MINUTES);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

