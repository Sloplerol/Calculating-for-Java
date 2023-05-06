package Search;

import java.util.ArrayList;
import java.util.List;

public class TwoDivideSearch {
    public static void main(String[] args) {
        int[] arr = {2,3,4,6,7,7};
//        System.out.println(BinarySearch(arr,0,arr.length - 1,1000));
        List<Integer> list = BinarySearch2(arr,0,arr.length - 1,7);
        System.out.println(list);
    }
//    public static int BinarySearch(int[] arr, int value){
//        int left = 0;
//        int right = arr.length - 1;
//        //[left,right]
//        while(left <= right){
//            int mid = (left + right) / 2;
//            if(arr[mid] < value){
//                left++;
//            }else if(arr[mid] > value){
//                right--;
//            }else {
//                return mid;
//            }
//        }
//        return -1;
//    }

    public static int BinarySearch(int[] arr,int left,int right,int value){
        //递归的终止条件
        if(left > right) return -1;
        int mid = (left + right) / 2;
        int midValue = arr[mid];
        if(midValue < value) {
            return BinarySearch(arr,mid + 1,right,value);
        }else if(midValue > value) {
            return BinarySearch(arr,left,mid - 1,value);
        }else {
            return mid;

        }
    }
    //这个二分查找方法将会考虑查找重复元素的情况
    public static List<Integer> BinarySearch2(int[] arr,int left,int right,int value){
        //递归的终止条件
        if(left > right) return new ArrayList<>();
        int mid = (left + right) / 2;
        int midValue = arr[mid];
        if(midValue < value) {
            return BinarySearch2(arr,mid + 1,right,value);
        }else if(midValue > value) {
            return BinarySearch2(arr,left,mid - 1,value);
        }else {
            List<Integer> list = new ArrayList<>();
            int temp = mid - 1;
            while(true){
                if(temp < 0 || arr[temp] != value){
                    break;
                }
                list.add(temp);
                temp -= 1;
            }
            list.add(mid);

            temp = mid + 1;
            while(true){
                if(temp >= arr.length || arr[temp] != value){
                    break;
                }
                list.add(temp);
                temp += 1;
            }
            return list;

        }
    }
}
