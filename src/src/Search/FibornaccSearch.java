package Search;

import java.util.Arrays;
import java.util.Scanner;


//根据F[k] = F[k - 1] + F[k - 2];
//F[k] - 1 = (F[k - 1] - 1) + (F[k - 2] - 1) + 1;
//mid = low + F[k - 1] - 1;
public class FibornaccSearch {
    public static int maxSize = 20;
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        System.out.println(fibSearch(arr,5));
    }

    public static int[] fib(){
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for(int i = 2;i < maxSize;i++){
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    //通过mid = low + F(k - 1) - 1来获取到下标
    public static int fibSearch(int[] arr,int key){
        int low = 0;
        int high = arr.length - 1;
        int k = 0; //用来斐波那契分割数值的下标
        int mid = 0;
        int[] f = fib(); //获取斐波那契数列
        while(high > f[k] - 1){
            k++;

        }
        int[] temp = Arrays.copyOf(arr,f[k]);
        for(int i = high + 1;i < temp.length;i++){
            temp[i] = arr[high];
        }

        while(low <= high){
            mid = low + f[k - 1] - 1;
            if(key < temp[mid]){
                high = mid - 1;
                k--;
            }else if(key > temp[mid]){
                low = low + 1;
                k -= 2;
            }else {
                if(mid <= high){
                    return mid;
                }else {
                    return high;
                }
            }
        }
        return -1;


    }
}
