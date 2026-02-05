package com.problems.multi_threading;

import java.util.concurrent.*;

public class ProducerConsumerUsingQueue {
    public static void main(String[] args) {
            final BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(5);
            ExecutorService executorService = Executors.newFixedThreadPool(2);

            executorService.execute(new ProducerQueue(queue));

            executorService.execute(new ConsumerQueue(queue));

            executorService.shutdown();
        try {

            if(!executorService.awaitTermination(3,TimeUnit.SECONDS)){
                executorService.shutdownNow();
            }


        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }

    }
}

class ProducerQueue implements Runnable{

    private final BlockingQueue<Integer> queue ;

    public ProducerQueue(BlockingQueue<Integer> queue){
        this.queue = queue;
    }

    @Override
    public void run() {

                try {
                    for (int i=1; i<=4 ; i++) {
                        queue.put(i);
                        System.out.println("Produced one input " + i);
                    }
                    queue.put(-1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


    }
}

class ConsumerQueue implements Runnable{

    private final BlockingQueue<Integer> queue ;

    public ConsumerQueue(BlockingQueue<Integer> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            try {
                Integer consumed = queue.take();

                if(consumed == -1){
                    System.out.println("Consumer ended ..");
                    break;
                }

                System.out.println("Consumed one input "+consumed);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
