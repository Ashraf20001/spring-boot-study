package com.problems.multi_threading;

public class DeadlockProblem {
    public static void main(String[] args) {
        Pen pen = new Pen();
        Paper paper = new Paper();
        A a = new A(pen, paper);
        B b = new B(pen, paper);
        a.start();
        b.start();
    }
}


class A extends Thread {
    private final Pen pen;
    private final Paper paper;

    public A(Pen pen , Paper paper){
        this.pen = pen;
        this.paper = paper;
    }

    public void run(){
        synchronized (pen){
            System.out.println("A acquired lock of pen");
            pen.write();

            synchronized (paper){
                System.out.println("A acquired lock of paper");
                paper.write();
            }
            System.out.println("A released lock of paper");
        }
        System.out.println("A released lock of pen");
    }
}

class B extends Thread{
    private final Pen pen;
    private final Paper paper;

    public B(Pen pen , Paper paper){
        this.pen = pen;
        this.paper = paper;
    }

    public void run(){
        synchronized (paper){
            System.out.println("B acquired lock of paper");
            paper.write();

            synchronized (pen){
                System.out.println("B acquired lock of pen");
                pen.write();
            }
            System.out.println("B released lock of pen");
        }
        System.out.println("B released lock of paper");
    }
}

class Pen{
    public Pen(){
    }

    public void write(){
        System.out.println("Write using Pen ..");
    }
}

class Paper{
    public Paper(){

    }
    public void write(){
        System.out.println("Write on Paper ..");
    }
}
