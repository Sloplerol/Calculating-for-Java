package sort;

import java.util.Arrays;

public class Radix {
    public static void main(String[] args) {
        int[] arr = {53,3,542,748,14,214};
        RadixSort(arr);


    }

    public static void RadixSort(int[] arr){
        //寻找最大数
        int max = arr[0];
        for(int i = 1;i <arr.length;i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        int length = (max + "").length();

        //基数排序是通过空间换时间的排序方法
        int[][] bucket = new int[10][arr.length];

        int[] bucketElement = new int[10];


        for(int h = 0,n = 1;h < length;h++,n *= 10){
            for(int i = 0;i < arr.length;i++){
                int digitalEle = arr[i] / n % 10;
                bucket[digitalEle][bucketElement[digitalEle]] = arr[i];
                bucketElement[digitalEle]++;
            }

            int index = 0;
            for(int i = 0;i < 10;i++){
                if(bucketElement[i] != 0){
                    for(int l = 0;l < bucketElement[i];l++){
                        arr[index] = bucket[i][l];
                        index++;
                    }
                }
                bucketElement[i] = 0;
            }
            System.out.println(Arrays.toString(arr));
        }


//        System.out.println(Arrays.toString(arr));
//
//        for(int i = 0;i < arr.length;i++){
//            int digitalEle = arr[i] /10 % 10;
//            bucket[digitalEle][bucketElement[digitalEle]] = arr[i];
//            bucketElement[digitalEle]++;
//        }
//
//        index = 0;
//        for(int i = 0;i < 10;i++){
//            if(bucketElement[i] != 0){
//                for(int l = 0;l < bucketElement[i];l++){
//                    arr[index] = bucket[i][l];
//                    index++;
//                }
//            }
//            bucketElement[i] = 0;
//        }
//        System.out.println(Arrays.toString(arr));
//
//        for(int i = 0;i < arr.length;i++){
//            int digitalEle = arr[i] /100 % 10;
//            bucket[digitalEle][bucketElement[digitalEle]] = arr[i];
//            bucketElement[digitalEle]++;
//        }
//
//        index = 0;
//        for(int i = 0;i < 10;i++){
//            if(bucketElement[i] != 0){
//                for(int l = 0;l < bucketElement[i];l++){
//                    arr[index] = bucket[i][l];
//                    index++;
//                }
//            }
//            bucketElement[i] = 0;
//        }
//        System.out.println(Arrays.toString(arr));

    }
}
