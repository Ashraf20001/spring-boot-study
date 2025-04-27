package com.problems.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPool2 {
    public static void main(String[] args) {
      CustomRecursiveTask customTask = new CustomRecursiveTask(new int[] {13,14,15,16,17,18,19,20,21,22,25,30,36,38,40});
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        System.out.println(forkJoinPool.getActiveThreadCount()+ " Before invoking");
        Integer invokeResult = forkJoinPool.invoke(customTask);
        System.out.println(forkJoinPool.getActiveThreadCount()+ " After invoking");
        System.out.println(invokeResult);
    }
}

class CustomRecursiveTask extends RecursiveTask<Integer>{

    private int[] arr;
    private int threshholdLimit = 4;

    public CustomRecursiveTask(int[] arr){
        this.arr = arr;
    }
    /**
     * @return
     */
    @Override
    protected Integer compute() {
        if(arr.length>threshholdLimit){
           return ForkJoinTask.invokeAll(createSubTask())
                   .stream()
                   .mapToInt(ForkJoinTask::join)
                   .sum();
        }
        else{
           return doComputation();
        }
    }

    private Integer doComputation() {
       return Arrays.stream(arr)
                .sum();
    }

    private List<CustomRecursiveTask> createSubTask() {
      List<CustomRecursiveTask> customRecursiveTask = new ArrayList<>();
      customRecursiveTask.add(new CustomRecursiveTask(Arrays.copyOf(arr,arr.length/2)));
      customRecursiveTask.add(new CustomRecursiveTask(Arrays.copyOfRange(arr,arr.length/2,arr.length)));
      return customRecursiveTask;
    }
}
