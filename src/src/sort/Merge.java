package sort;

import java.util.Arrays;

public class Merge {
    public static void main(String[] args) {
        int[] arr = {3,6,1,0,8,2};
        int[] temp = new int[arr.length];
        divideSort(arr,0,arr.length - 1,temp);
        System.out.println(Arrays.toString(arr));
    }

    /**
     *
     * @param arr 原始数组
     * @param left 左边序列的初始索引
     * @param mid 右边序列的初始索引
     * @param right 右边的某个索引
     * @param temp 中转数组
     */
    public static void MergeSort(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;
        int j = mid + 1;
        int t = 0;
        while(i <= mid && j <= right){
            if(arr[i] <= arr[j]){
                temp[t] = arr[i];
                t++;
                i++;
            }else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }

        while(i <= mid){
            temp[t] = arr[i];
            t++;
            i++;
        }

        while(j <= right){
            temp[t] = arr[j];
            t++;
            j++;
        }
        //从头到尾将新数组拷贝到原数组中
        t = 0;
        int tempLeft = left;
        while(tempLeft <= right){
            arr[tempLeft] = temp[t];
            tempLeft++;
            t++;
        }

    }
    public static void divideSort(int[] arr,int left,int right,int[] temp){
        if(left < right){
            int mid = (left + right) / 2;
            //左递归
            divideSort(arr,left,mid,temp);
            //右递归
            divideSort(arr,mid + 1,right,temp);
            //合并
            MergeSort(arr,left,mid,right,temp);

        }
    }
}