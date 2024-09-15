package com.problems.matrices;

public class MedianElementSearchInMatrix {
    public static void main(String[] args) {
        int[][] arr={
                {5,11,20,35,45},
                {1,2,3,4,6},
                {13,15,16,19,21}
        };
        int medianPosition = (arr.length * arr[0].length)/2 +1; // +1 is added to check less than or equal to condition

        int[] minMax={Integer.MAX_VALUE,Integer.MIN_VALUE};
        findMinAndMaxInMatrix(minMax,arr);
        System.out.println(findMedianOfMatrix(minMax[0],minMax[1],medianPosition,arr));
    }

    private static void findMinAndMaxInMatrix(int[] minMax, int[][] arr) {
        int i=0;int j=0;
        while(i<arr.length){
            if(arr[i][j]<minMax[0]){
                minMax[0]=arr[i][j];
            }
            i++;
        }
        i=0;j=arr[0].length-1;
        while(i<arr.length){
            if(arr[i][j]>minMax[1]){
                minMax[1]=arr[i][j];
            }
            i++;
        }

    }

    private static int findMedianOfMatrix(int min, int max, int medianPosition, int[][] arr) {
        while(min<max){
            int mid=(min+max)/2;
            int count=0;
            for(int i=0;i<arr.length;i++){
                int foundedCount=findCount(mid,arr[i]);
                while( foundedCount<arr[i].length && arr[i][foundedCount]==mid){
                    foundedCount++;
                }
                count+=foundedCount;
            }
            if(count<medianPosition){
                min=mid+1;
            }else{
                max=mid;
            }
        }
        return min;
    }

    private static int findCount(int mid, int[] colArr) {
        int l=0; int h=colArr.length-1;
        int mid1=0;
        while(l<=h){
            mid1=(l+h)/2;
            if(colArr[mid1]==mid){
                return mid1;
            }
            else if(colArr[mid1]<mid){
                l=mid1+1;
            } else{
                h=mid1-1;
            }

        }
        return l;
    }
}
