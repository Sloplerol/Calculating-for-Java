package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Bubble {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for(int i = 0;i < 80000;i++){
            arr[i] = (int)(Math.random() * 80000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");
        simpleDateFormat.format(date1);
        System.out.println(date1);
        BubbleSort(arr);

        Date date2 = new Date();
        simpleDateFormat.format(date2);
        System.out.println(date2);


    }

    public static int[] BubbleSort(int[] arr){
        int temp = 0;
        boolean flag = false;
        //第一次排序是将最大的数放到最右边
        for(int i = 0;i < arr.length - 1;i++){
            for(int j = 0;j < arr.length - i - 1;j++){
                if(arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if(!flag){
                break;
            }else {
                flag = false;
            }

        }
        return arr;
    }
}
