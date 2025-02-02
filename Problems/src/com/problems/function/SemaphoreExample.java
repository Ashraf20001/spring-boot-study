package com.problems.function;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(1);
        Thread1 a = new Thread1(semaphore, "A");
        Thread1 b = new Thread1(semaphore, "B");

        a.start();
        b.start();

        a.join();
        b.join();
    }
}

class Thread1 extends Thread{
    
    Semaphore sem;
    String threadName;
    
    public Thread1(Semaphore sem, String threadName){
        super(threadName);
        this.sem = sem;
        this.threadName = threadName;
    }
    
    @Override
    public void run() {
        if(threadName.equals("A")){
            System.out.println("Providing permit for thread A");

            try {
                sem.acquire();
                for (int i = 0; i < 4; i++) {
                    Shared.count++;
                    System.out.println("Thread name "+threadName +" "+Shared.count);
                    Thread.sleep(1000);

                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            sem.release();
        }else{
            System.out.println("Providing permit for thread B");
                try {
                    sem.acquire();
                    for (int i = 0; i < 4; i++) {
                        Shared.count --;
                        System.out.println("Thread Name "+ threadName + " "+ Shared.count);
                        Thread.sleep(1000);

                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

           sem.release();
        }
    }
}

class Shared{
    public static int count = 0;
}