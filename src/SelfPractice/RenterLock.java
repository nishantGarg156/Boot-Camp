package SelfPractice;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RenterLock {
    private int count =0 ;
    private Lock lock = new ReentrantLock();

    public void increment() {
        for(int i = 0; i< 100000; i++) {
            count++;
        }
    }
    public static void main(String[] args) {


    }
}
