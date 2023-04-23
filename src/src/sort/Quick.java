package sort;

import java.util.Arrays;

public class Quick {
    public static void main(String[] args) {
        int[] arr = {2,3,-1,0,-9,3,2,6,5};
        QuickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void QuickSort(int[] arr,int left,int right){
        int l = left;
        int r = right;
        int temp = 0;
        int pivot = arr[(left + right) / 2];
        while(l < r){
            while(arr[l] < pivot){
                l++;
            }

            while(arr[r] > pivot){
                r--;
            }

            //如果l >= r说明此时就是正常顺序
            if(l >= r){
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            //两边的值交换完毕

            //如果发现交换后左边的值等于pivot
            if(arr[l] == pivot){
                r -= 1;
            }
            if(arr[r] == pivot){
                l += 1;
            }
        }
        //防止栈溢出
        if(l == r){
            l += 1;
            r -= 1;
        }
        if(left < r){
            QuickSort(arr,left,r);
        }
        if(right > l){
            QuickSort(arr,l,right);
        }

    }
}
