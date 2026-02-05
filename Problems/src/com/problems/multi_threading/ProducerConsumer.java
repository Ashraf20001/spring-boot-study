package com.problems.multi_threading;

public class ProducerConsumer {
    public static void main(String[] args) throws InterruptedException {
        Shared shared = new Shared();

        Thread producer1 = new Thread(new Producer(shared), "PR-1");
        Thread producer2 = new Thread(new Producer(shared), "PR-2");

        Thread consumer1 = new Thread(new Consumer(shared), "CNS-1");
        Thread consumer2 = new Thread(new Consumer(shared), "CNS-2");

        producer1.start();
//        producer1.join();
        producer2.start();
//        producer2.join();

        consumer1.start();
//        consumer1.join();
        consumer2.start();
//        consumer2.join();
    }
}

class Shared {
    int data;
    boolean hasData = false;


    synchronized void produce(int value) throws InterruptedException {
        while (hasData) {
            wait(); // wait if data already exists
        }
        data = value;
        System.out.println("Produced: " + data + " " +Thread.currentThread().getName());
        hasData = true;
        notifyAll(); // wake up consumer
    }

    synchronized void consume() throws InterruptedException {
        while (!hasData) {
            wait(); // wait if no data
        }
        System.out.println("Consumed: " + data + " "+ Thread.currentThread().getName());
        hasData = false;
        notifyAll(); // wake up producer
    }
}

class Producer implements Runnable {

    private Shared shared;

    Producer(Shared shared) {
        this.shared = shared;
    }

    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                shared.produce(i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable {

    private Shared shared;

    Consumer(Shared shared) {
        this.shared = shared;
    }

    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                shared.consume();
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}