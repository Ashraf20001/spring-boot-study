package com.problems.arrays.tp_approach;

public class RotationOfEachOther {
    public static void main(String[] args) {
        int[] arr ={1,2,3,4,5} ; int[] arr2 = {3,4,5,1,2};
        System.out.println(isBothArrayRotationOfEachOther(arr,arr2));
    }

    private static boolean isBothArrayRotationOfEachOther(int[] arr, int[] arr2) {
        StringBuilder array1 = new StringBuilder();
        StringBuilder array2 = new StringBuilder();
        for (int arr1: arr){
            array1.append(arr1);
        }

        for(int ar2 : arr2){
            array2.append(ar2);
        }

        String arr2String = new String(array2);
        String joinedString = new String(array1.append(array1));

        return  joinedString.contains(arr2String);

    }
}
