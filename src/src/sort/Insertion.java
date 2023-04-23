package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Insertion {
    public static void main(String[] args) {
        int[] arr = new int[8];
        for(int i = 0;i < 8;i++){
            arr[i] = (int)(Math.random() * 80000);
        }
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] insertSort(int[] arr){

        for(int i = 1;i < arr.length;i++){
            int insertVal = arr[i];
            //代表的是插入元素的索引
            int insertIndex = i - 1;
            while(insertIndex >= 0 && insertVal < arr[insertIndex]){
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            //判断是否已经被插入到了合适的地方
            if(insertIndex + 1 != i){
                arr[insertIndex + 1] = insertVal;
            }
//            System.out.println(Arrays.toString(arr));
        }

        return arr;



    }
}
