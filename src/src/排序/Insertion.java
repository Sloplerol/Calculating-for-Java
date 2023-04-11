package 排序;

import java.util.Arrays;

public class Insertion {
    public static void main(String[] args) {
        Integer[] arr = {3,5,1,5,2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(Comparable[] arr){
        for(int i = 1;i < arr.length;i++){
            int tempIndex = i;
            for(int j = i;j > 0;j--){
                if(greater(arr[j - 1],arr[j])){
                    swap(arr,j,j-1);
                }else {
                    break;
                }
            }
        }
    }

    private static boolean greater(Comparable c1,Comparable c2){
        return c1.compareTo(c2) > 0;
    }

    private static void swap(Comparable[] arr,int i,int j){
        Comparable temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
