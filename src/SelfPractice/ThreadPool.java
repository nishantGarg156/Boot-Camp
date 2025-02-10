package SelfPractice;
// execute // submit
// executorService is an interface
// execute is an interface
// AutoClosable is an interface


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class ThreadPool extends Thread {
    private int id =0;
    public ThreadPool(int id){
        this.id = id;
    }
    public void run(){
        System.out.println("Thread "+id+" started");
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Thread "+id+" finished");
    }
    public static void main(String[] args){
        ExecutorService pool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
               pool.execute(new ThreadPool(i));
        }
        pool.shutdown();
    }
}
