package sort;

import java.util.Arrays;
import java.util.Set;

public class Selection {
    public static void main(String[] args) {
        int[] arr = {10,1,3,5};
        System.out.println(Arrays.toString(SelectionSort(arr)));
    }

    public static int[] SelectionSort(int[] arr){
        for(int j = 0;j < arr.length - 1;j++){
            int min = arr[j];
            int minIndex = j;
            for(int i = j + 1;i < arr.length;i++){
                if(min > arr[i]){
                    min = arr[i];
                    minIndex = i;
                }
            }
            if(minIndex != j){
                arr[minIndex] = arr[j];
                arr[j] = min;
            }
        }


        return arr;

    }
}
