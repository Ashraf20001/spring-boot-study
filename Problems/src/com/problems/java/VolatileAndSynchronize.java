package com.problems.java;

public class VolatileAndSynchronize {

    private static int element = 0;

    public static void main(String[] args) {
            new VolatileReader().start();
            new VolatileWriter().start();
    }

    static class VolatileReader extends  Thread {

        int local = element;

        public void run(){
            while(local<5){
                    if(local!=element){
                        System.out.println("Element got changed");
                        local=element;
                    }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    static  class VolatileWriter extends  Thread {
        int local =element;

        public void run(){
            while(local<5){
                element=++local;

                System.out.println("Element incremented to "+element);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            }

        }
    }
}