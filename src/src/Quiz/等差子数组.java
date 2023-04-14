package Quiz;
import java.util.*;

public class 等差子数组 {
    public static void main(String[] args) {
        int[] nums = {4,6,5,9,3,7};
        int[] l = {0,0,2};
        int[] r = {2,3,5};
        boolean[] result = checkArithmeticSubarrays(nums,l,r);
        for (boolean res : result) {
            System.out.println(res);
        }
    }
    public static boolean[] checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {

        boolean[] result = new boolean[l.length];
        int index = 0;
        while(index < l.length){
            int l1 = l[index];
            int r1 = r[index];
            int[] newArr = new int[r1 - l1 + 1];
            int newIndex = 0;
            for(int i = l1;i <= r1;i++){
                newArr[newIndex++] = nums[i];
            }
            System.out.println(Arrays.toString(newArr));
            result[index] = EqualDifference(newArr);
            index++;

        }
        return result;

    }
    //用来判断等差数列的方法
    public static boolean EqualDifference(int[] arr){
        Arrays.sort(arr);
        int res = arr[1] - arr[0];
        for(int i = 2;i < arr.length;i++){
            if(arr[i] - arr[i - 1] != res){
                return false;
            }
        }
        return true;
    }


}
