package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Shell {
    public static void main(String[] args) {
//        int[] arr = new int[80000];
//        for(int i = 0;i < 80000;i++){
//            arr[i] = (int)(Math.random() * 80000);
//        }
        int[] arr = {5,2,3,6,7};


        shellSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void shellSort(int[] arr){
        //交换法
//        for(int h = arr.length / 2;h > 0;h /= 2){
//            for(int i = h;i < arr.length;i++){
//                for(int j = i - h;j >= 0;j -= h){
//                    if(arr[j] > arr[j + h]){
//                        int temp = arr[j];
//                        arr[j] = arr[j + h];
//                        arr[j + h] = temp;
//                    }
//                }
//            }
//        }
        //移位法

        for(int gap = arr.length / 2;gap > 0;gap /= 2){
            for(int j = gap;j < arr.length;j++){
                int i = j;
                int temp = arr[i];
                if(arr[i] < arr[i - gap]){
                    while(i - gap >= 0 && temp < arr[i - gap]){
                        arr[i] = arr[i - gap];
                        i -= gap;
                    }
                    arr[i] = temp;
                }
            }
        }



    }
}
