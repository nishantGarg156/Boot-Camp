package Java8AndMultiThreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestData {
    private int value =0;
    private final Lock externalLock = new ReentrantLock();
    // implicit lock
    public synchronized void increment() {
        int temp = value ;
        temp++;
        value = temp;
    }
    // explicit lock

    public void increment1(){
        externalLock.lock();
        try {
            int temp = value;
            temp++;
            value = temp;
        }finally {
            externalLock.unlock();
        }

    }
    public int getValue() {
        return value;
    }


}

class MyThread extends Thread {
    private final TestData testData;
    private final boolean unSynchronized;
    public MyThread(TestData testData, boolean unSynchronized) {
        this.testData = testData;
        this.unSynchronized = unSynchronized;

    }

    public void run() {
        if(unSynchronized) {
            for(int i=0;i<10;i++) {
                testData.increment();
            }
        }else{
            for(int i=0;i<10;i++) {
                testData.increment1();
            }
        }
    }


}
class TestDataUpdaterDemo {
    public static void main(String[] args) throws InterruptedException {
        TestData testData = new TestData();
        Thread[] synchronizedThreads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            synchronizedThreads[i] = new MyThread(testData, true);
        }
        Thread[] lockThreads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            lockThreads[i] = new MyThread(testData, false);
        }


        for (Thread t : synchronizedThreads) {
            t.start();
        }

        for (Thread t : lockThreads) {
            t.start();
        }

        for (Thread t : synchronizedThreads) {
            t.join();
        }

        for (Thread t : lockThreads) {
            t.join();
        }

        System.out.println("Final counter value: " + testData.getValue());
    }
}
