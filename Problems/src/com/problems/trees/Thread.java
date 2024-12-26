package com.problems.trees;

import java.util.concurrent.CompletableFuture;

public class Thread {
    public static void main(String[] args) {
//        java.lang.Thread thread1 = new java.lang.Thread(()->{
//          try {
//              System.out.println("Thread 1 starts");
//              for(int i=0;i<5;i++){
//                  for(int j=0;j<5;j++){
//                      java.lang.Thread.sleep(1000);
//                      System.out.println(i+" "+j);
//                  }
//              }
//              System.out.println("Thread 1 ends");
//          }catch (Exception e){
//              e.printStackTrace();
//          }
//        });
//        java.lang.Thread thread2 = new java.lang.Thread(() -> {
//
//                System.out.println("Thread 2 starts");
//            for (int i = 0; i < 2; i++) {
//                System.out.println("thread 2"+" "+i);
//            }
//            try {
//                thread1.join();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//                System.out.println("Thread 2 ends");
//        });
//
//        thread1.start();
//        thread2.start();

//        completableFutureExample();

        synchronisationTest();
    }

    private static void synchronisationTest() {
        Sychronise sychronise = new Sychronise();
        java.lang.Thread thread1 = new java.lang.Thread(sychronise::addCount);
        java.lang.Thread thread2 = new java.lang.Thread(sychronise::addCount);
        thread1.start();
        thread2.start();

    }

    private static void completableFutureExample() {
        System.out.println("Starts");
        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> {
           try {
               for(int j=0;j<5;j++){
                   java.lang.Thread.sleep(1000);
                   System.out.println(" "+j);
               }
           }catch (Exception e){
               System.out.println(e.getMessage());
           }
            return 42;
        });

        Integer value = integerCompletableFuture.join();
        System.out.println(value);
    }
}

class Sychronise{

    private int count =0;

    public synchronized void addCount(){
        if(count==3){
            System.out.println("decrement" + " "+java.lang.Thread.currentThread().getName());
            decreasecount();
        }

        for (int i = 0; i <3; i++) {

            count++;
            try {
                java.lang.Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(count + " "+java.lang.Thread.currentThread().getName());
        }
    }

    private synchronized void decreasecount() {
        for(int i=3;i>0;i--){
            this.count --;
            try {
                java.lang.Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(count + " "+java.lang.Thread.currentThread().getName());
        }
    }
}
