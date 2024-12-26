package com.problems.arrays;

import java.util.Arrays;
import java.util.List;

public class RotationOfEachOther {
    public static void main(String[] args) {
        int[] arr ={1,2,3,4,5} ; int[] arr2 = {3,4,5,1,2};

        System.out.println(isBothArrayRotationOfEachOther(arr,arr2));
    }

    private static boolean isBothArrayRotationOfEachOther(int[] arr, int[] arr2) {
        List<Integer> list1 = Arrays.stream(arr).boxed().toList();
        List<Integer> list2 =Arrays.stream(arr2).boxed().toList();
        System.out.println(list1.get(0));
        int i = list2.indexOf(list1.get(0));
        if(i<0) return  false;

        int count = 0;

        for(int index = i; index< list2.size(); index ++){

            if(index == count || list1.get(count) != list2.get(index)){
                return  false;
            }
            count++;
        }

        for(int index =0; index < i;index++){
            if(list1.get(count) != list2.get(index)){
                return false;
            }
        }

        return true;
    }
}
