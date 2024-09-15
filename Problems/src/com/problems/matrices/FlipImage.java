package com.problems.matrices;

public class FlipImage {
    public static void main(String[] args) {
        int[][] image={
                {1,1,0},
                {1,0,1},
                {0,0,0}
        };
        int[][] flippedAndInvertImage = flipAndInvertImage(image);
        for(int i=0;i<flippedAndInvertImage.length;i++) {
            for (int j = 0; j < flippedAndInvertImage[0].length; j++) {
                System.out.print(flippedAndInvertImage[i][j] + " ");
            }
            System.out.println();
        }
    }

//    public static  int[][] flipAndInvertImage(int[][] image) {
//        for(int i=0;i<image.length;i++){
//            int l=0; int h=image[0].length-1;
//            while(l<h){
//                if(image[i][l]!=image[i][h]){
//                    int temp=image[i][l];
//                    image[i][l]=image[i][h];
//                    image[i][h]=temp;
//                }
//            }
//        }
//
//        for(int i=0;i<image.length;i++) {
//            for (int j = 0; j < image[0].length; j++) {
//                if(image[i][j]==0){
//                    image[i][j]=1;
//                }else{
//                    image[i][j]=0;
//                }
//            }
//        }
//
//        return image;
//    }

    public static  int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            int l = 0;
            int h = image[0].length - 1;
            while (l <= h) {
                if (image[i][l] != image[i][h]) {
                    int temp = image[i][l];
                    image[i][l] = image[i][h];
                    image[i][h] = temp;
                    invertImage(l, h, image, i);
                } else {
                    invertImage(l, h, image, i);

                }
                l++;
                h--;
            }

        }
        return image;
    }

    public static void invertImage(int l,int h,int[][] image,int i){
        if(l!=h){
            image[i][l]=image[i][l]==0?1:0;
            image[i][h]=image[i][h]==0?1:0;
        }else{
            image[i][l]=image[i][l]==0?1:0;
        }
    }

}
