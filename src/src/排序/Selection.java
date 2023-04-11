package 排序;

import java.util.Arrays;

public class Selection {
    public static void main(String[] args) {
        Integer[] arr = {5,1,3,6,1,19};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(Comparable[] arr){
        for(int i = 0;i < arr.length - 1;i++){
            //保留最小数所对应的索引
            int minIndex = i;
            for(int j = i + 1;j < arr.length;j++){
                if(greater(arr[i],arr[j])){
                    minIndex = j;
                }
            }
            //将每一位都换成大于等于他里面最小的
            swap(arr,i,minIndex);
        }
    }
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
