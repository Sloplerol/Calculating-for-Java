package 排序;

import java.util.Arrays;

public class 递归测试 {
    public static void main(String[] args) {
        Integer[] arr = {1,5,2,4,6};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(Comparable[] arr){
        int h = 1;
        while(arr.length / 2 > h){
            h = h * 2 + 1;
        }

        while(h >= 1){
            for(int i = h;i < arr.length;i += h){
                for(int j = i;j >= 0;j -= h){
                    if(great(arr[j-h],arr[j])){
                        swap(arr,j,j - h);
                    }else {
                        break;
                    }

                }
            }
            h /= 2;
        }
    }
    //判断两个数大小
    public static boolean great(Comparable a1,Comparable a2){
        return a1.compareTo(a2) > 0;
    }
    //用来进行交换的
    public static void swap(Comparable[] arr,int i,int j){
        Comparable temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
