package com.problems.arrays.tp_approach;

import java.util.Arrays;

public class SortEvenAscendingOddDesc {
    public static void main(String[] args) {
        int[] ints = {3, 1, 4, 2, 5, 6,0};
        sortAscendDescend(ints);
    }

    private static void sortAscendDescend(int[] ints) {

        int[] temp = new int[ints.length];
        for(int i=0; i<ints.length;i++){
            if((i+1) % 2 != 0){
                temp[i] = -ints[i];
            }else{
                temp[i] = ints[i];
            }
        }

        Arrays.sort(temp);
        ints[0]=-temp[0];
        int i= 1;

        while (temp[i]<=0 && i*2 < ints.length){
            ints[i*2]=-temp[i];
            i++;
        }

        int evenIndex = 1;
        while(evenIndex < ints.length && i < temp.length){
            ints[evenIndex] = temp[i];
            i++;
            evenIndex = evenIndex+2;
        }

        for (int el: ints){
            System.out.print(el+ " ");
        }

    }
}
