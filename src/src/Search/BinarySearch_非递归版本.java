package Search;

import java.math.BigInteger;
import java.util.*;

public class BinarySearch_非递归版本{
    public static void main(String[] args) {
        int[] arr = {2,3,5,6,7};
        int index = getIndex(arr,3);
        System.out.println(index);

    }

    //[left,right]
//    public static int getIndex(int[] arr,int value){
//        int left = 0;
//        int right = arr.length - 1;
//        while(left <= right){
//            int mid = (left + right) / 2;
//            if(arr[mid] > value){
//                right = mid - 1;
//            }else if(arr[mid] < value){
//                left = mid + 1;
//            }else {
//                return mid;
//            }
//
//        }
//        return -1;
//    }


    //    [left,right)
    public static int getIndex(int[] arr,int value){
        int left = 0;
        int right = arr.length - 1;
        //[left,right)
        while(left < right){
            int mid = (left + right) / 2;
            if(arr[mid] > value){
                right = mid;
            }else if(arr[mid] < value){
                left = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;

    }

}





