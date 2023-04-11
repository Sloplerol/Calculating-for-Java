package 排序;

import java.util.Arrays;

public class Merge {
    //定义辅助数组
    private static Comparable[] assist;

    public static void main(String[] args) {
        Integer[] arr = {6,2,4,7,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));


    }

    private static boolean less(Comparable s1,Comparable s2){
        return s1.compareTo(s2) < 0;
    }

    private static void swap(Comparable[] arr,int i,int j){
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    //用于对整个数组进行排序
    private static void sort(Comparable[] arr){
        assist = new Comparable[arr.length];
        int lo = 0;
        int hi = arr.length - 1;
        sort(arr,lo,hi);
    }

    private static void sort(Comparable[] arr,int lo,int hi){
        if(lo >= hi){
            return;
        }
        int mid = lo + (hi - lo) / 2;

        //对每一组数据进行排序
        sort(arr,lo,mid);
        sort(arr,mid + 1,hi);

        //开始合并两个组的数据
        merge(arr,lo,mid,hi);

    }

    private static void merge(Comparable[] arr,int lo,int mid,int hi){
        //定义三个指针
        int i = lo;
        int p1 = lo;
        int p2 = mid + 1;

        while(p1 <= mid && p2 <= hi){
            //如果p1里的元素比较小的话将其放入到辅助数组里
            if(less(arr[p1],arr[p2])){
                assist[i++] = arr[p1++];
            }else {
                assist[i++] = arr[p2++];
            }
        }

        //如果其中一个遍历完毕另一还没有遍历完的话
        while(p1 <= mid){
            assist[i++] = arr[p1++];
        }

        while(p2 <= hi){
            assist[i++] = arr[p2++];
        }
        //将辅助数组里面的数据拷贝到原数组中
        for(int index = lo;index <= hi;index++){
            arr[index] = assist[index];
        }


    }



}
