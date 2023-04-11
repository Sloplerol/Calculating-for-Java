package 排序;

import java.util.Arrays;

public class Shell {
    public static void main(String[] args) {
        Integer[] arr = {5,2,4,1,6};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(Comparable[] arr){
        int h = 1;
        while(arr.length / 2 > h){
            //用来获取h的初始值
            h = h * 2 + 1;
        }
        while(h >= 1){
            //获取需要插入排序的元素
            for(int i = h;i < arr.length;i++){
                for(int j = i;j >= h;j-=h){
                    if(greater(arr[j - h],arr[j])){
                        swap(arr,j-h,j);
                    }else {
                        break;
                    }
                }
            }


            h /= 2;
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
