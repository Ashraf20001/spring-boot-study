package com.problems.function;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ForkJoinExample {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        System.out.println(forkJoinPool.getActiveThreadCount()+ " Before invoking");
        InvokingTask invokingTask = new InvokingTask(10000);
        forkJoinPool.invoke(invokingTask);
        System.out.println(forkJoinPool.getActiveThreadCount()+" After invoking");

    }
}

class InvokingTask extends RecursiveAction {

    int range;

    public InvokingTask(int range){
        this.range = range;
    }

    /**
     * The main computation performed by this task.
     */
    @Override
    protected void compute() {
        List<InvokingTask> invokingTaskArrayList = new ArrayList<InvokingTask>(getSubTask());
        for (int i=0 ; i<invokingTaskArrayList.size(); i ++){
            invokingTaskArrayList.get(i).fork();
        }
    }

    private Collection<? extends InvokingTask> getSubTask() {
        List<InvokingTask> invokingTaskArrayList = new ArrayList<InvokingTask>();

        invokingTaskArrayList.add(new InvokingTask(this.range/5));
        invokingTaskArrayList.add(new InvokingTask(this.range/5));
        invokingTaskArrayList.add(new InvokingTask(this.range/5));
        invokingTaskArrayList.add(new InvokingTask(this.range/5));
        invokingTaskArrayList.add(new InvokingTask(this.range/5));

        return invokingTaskArrayList;
    }
}
