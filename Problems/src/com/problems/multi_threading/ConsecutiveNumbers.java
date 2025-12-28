package com.problems.multi_threading;



public class ConsecutiveNumbers {
    public static void main(String[] args) {
        SharedObj shared = new SharedObj();

        for (int i = 0; i < 2; i++) {
            try{
                int finalI = i;
                new Thread(()->{
                    try {

                        shared.produce(finalI);
                    }catch (Exception e){
                        throw new RuntimeException(e);
                    }
                }, "T-"+i).start();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class SharedObj {
    int currentNum=0;
    int maxNum =20;
    private  volatile int turn =0;


    synchronized void produce(int i) throws InterruptedException {
        while(currentNum<maxNum) {


            while (turn != i) {
                wait();
            }
            if(currentNum>=maxNum){
                notifyAll();
                return;
            }
            currentNum++;
            System.out.println(currentNum +" "+turn + " " + Thread.currentThread().getName()) ;
            turn = (turn + 1) % 2;
            notifyAll();


        }
    }

}
