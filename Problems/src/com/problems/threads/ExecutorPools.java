package com.problems.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorPools {
    public static void main(String[] args) {
        try {
            fixedThread();
            System.out.println("Reaching to cache pool");
            cachedThread();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private static void fixedThread() throws InterruptedException {
        int availableProcessorCount = Runtime.getRuntime().availableProcessors();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(availableProcessorCount);
        fixedThreadPool.submit(()-> {
            for(int i=0; i<5;i++){
                System.out.println("Hello "+ i);
            }
        });
        boolean b = fixedThreadPool.awaitTermination(3, TimeUnit.SECONDS);
        fixedThreadPool.shutdown();
        System.out.println("Fixed thread is killed");
    }

    private  static  void cachedThread() throws InterruptedException {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        cachedThreadPool.execute(()-> System.out.println("Cached pool"));
        cachedThreadPool.awaitTermination(4,TimeUnit.SECONDS);
        cachedThreadPool.shutdown();
        System.out.println("Cached thread is shut down");
    }

    private static void scheduledThreadPool(){
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        scheduledExecutorService.scheduleWithFixedDelay(() -> System.out.println("Scheduled pool"),10,15, TimeUnit.SECONDS);
    }

    private static void singleThreadPool(){
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        singleThreadExecutor.execute(()-> System.out.println("Single thread"));
    }

    String s = """
            There are four Abort Policies
            1. AbortPolicy -> Don't accept new task and throw RejectedExecutionHandler Exception
            2. DiscardPolicy -> Submitting new task will be discarded silently
            3. DiscardOldestPolicy -> Submitting new task will discard old tasks and new items will be added to queue
            4. CallerRunsPolicy -> Submitting new task will execute the task on the caller thread itself.This result in "Feedback loop"
            where the caller thread is busy executing the task and unable to submit the new task.
            """;
}
