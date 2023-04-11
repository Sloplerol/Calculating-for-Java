package 排序;

import java.util.Arrays;

public class Quick {
    private static void swap(Comparable[] arr,int i,int j){
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private static boolean less(Comparable a,Comparable b){
        return a.compareTo(b) < 0;
    }

    public static void sort(Comparable[] arr){
        int lo = 0;
        int hi = arr.length - 1;
        sort(arr,lo,hi);
    }

    private static void sort(Comparable[] arr,int lo,int hi){
        if(lo >= hi){
            return;
        }
        //返回的是分界值变化后的索引
        int partation = partation(arr,lo,hi);
        //将分界值的两别分别进行排序
        sort(arr,lo,partation - 1);
        sort(arr,partation + 1,hi);

    }

    private static int partation(Comparable[] arr,int lo,int hi){
        Comparable key = arr[lo];
        int left = lo;
        int right = hi + 1;
        while(true){
            while(less(key,arr[--right])){
                if(right == lo){
                    break;
                }

            }
            while(less(arr[++left],key)){
                if(left == hi){
                    break;
                }
            }

            if(left >= right){
                break;
            }else {
                swap(arr,left,right);
            }

        }
        swap(arr,lo,right);




        return right;
    }
}
