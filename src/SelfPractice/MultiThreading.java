package SelfPractice;
// parallel processing
// life cycle of thread
// new , runnable,running-> waiting, time waiting, blocked, terminated.
//Thread method start() , run() , sleep(), join(), isAlive(), yeild()
// thread class, runnable interface, anonymous class
// Synchronized


public class MultiThreading {
    private  int  num = 0;

    public synchronized void  increment(){
        num++;
    }
    public static void main(String[] args) {
        MultiThreading mt = new MultiThreading();
        mt.doWork();



    }
    public void doWork(){
        Thread t1 = new Thread(new Runnable() {
            public void run() {
            for(int i=0;i<10000;i++){
                increment();
            }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                for(int i=0;i<10000; i++){
                    increment();
                }
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join(); // makes wait,  main thread before its child thread get executed
            t2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(num);
    }
}
