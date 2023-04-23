package sort;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr = {4,2,3,1,6};
        int[] temp = new int[arr.length];
        divideOperate(arr,0,arr.length - 1,temp);
        System.out.println(Arrays.toString(arr));


    }


    public static void divideOperate(int[] arr,int left,int right,int[] temp){
        if(left < right){
            int m = (left + right) / 2;
            divideOperate(arr,left,m,temp);
            divideOperate(arr,m + 1,right,temp);
            mergeOperate(arr,left,m,right,temp);
        }
    }

    public static void mergeOperate(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;
        int j = mid + 1;
        int t = 0;
        while(i <= mid && j <= right){
            if(arr[i] < arr[j]){
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

        t = 0;
        int tempLeft = left;
        while(tempLeft <= right){
            arr[tempLeft] = temp[t];
            tempLeft++;
            t++;
        }
    }




}