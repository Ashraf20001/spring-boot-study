package com.problems.queues;

public class MaximumOfAllSubArray {
    public static void main(String[] args) {
        int [] arr ={12,10,9,15,20,10,8};
        int k=3;
        findMaximumElementsOfSubArray(arr,3);
    }

    private static void findMaximumElementsOfSubArray(int[] arr,int k) {
        Dequeue dequeue = new Dequeue();
        for (int i = 0; i < k; i++) {
            while (!dequeue.isEmpty() && arr[i]>=arr[dequeue.peekFirst()]){
                dequeue.pollFirst();
            }
            dequeue.offerLast(i);
        }

        for (int i = k; i < arr.length; i++) {
            System.out.println(arr[dequeue.peekFirst()]);

            while(!dequeue.isEmpty() && dequeue.peekFirst() <= i-k){  // i-k is similar to sliding window
                dequeue.pollFirst();                             // Remove the elements that are not needed to be included for next sub array
            }

            while (!dequeue.isEmpty() && arr[i]>=arr[dequeue.peekFirst()]){
                dequeue.pollFirst();
            }
            dequeue.offerLast(i);
        }

        System.out.println(arr[dequeue.peekFirst()]);
    }
}


