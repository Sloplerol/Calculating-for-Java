package 排序;

import java.util.Arrays;

public class Bubble {


    public static void main(String[] args) {
        //由于Integer继承了Comparable接口
        Integer[] arr = {2,5,1,2,5,1};
        sort(arr);
        //将Integer数组转化为字符串
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(Comparable[] arr){
        for(int i = arr.length - 1;i > 0;i--){
            for(int j = 0;j < i;j++){
                //比较相邻两个数的大小
                if(greater(arr[j],arr[j + 1])){
                    //交换两个数的值将最大的放右边
                    swap(arr,j,j + 1);
                }
            }
        }
    }

    //用来比较大小
    private static boolean greater(Comparable c1,Comparable c2){
        return c1.compareTo(c2) > 0;
    }
    //交换元素
    private static void swap(Comparable[] arr,int i,int j){
        Comparable temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
