package Quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 在一个数组中查找另一个数组不存在的元素 {
    public static void main(String[] args) {
//        int[] s2 = {2,2,2,1,4,3,3,9,6,0,0};
//        int[] s1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] s1 = {1,2,3,4};
        int[] s2 = {2,3,4,5};
        int[] result = FindUnknown(s1,s2);
        System.out.println(Arrays.toString(result));


    }
    //寻找s1里s2不存在的元素
    public static int[] FindUnknown(int[] s1,int[] s2){
        List<Integer> list = new ArrayList<>();
        List<Integer> newList = new ArrayList<>();
        for(int data : s1){
            list.add(data);
        }
        for(int i : s2){
            if(!list.contains(i)){
                newList.add(i);
            }
        }
        int[] arr = new int[newList.size()];
        for(int i = 0;i < newList.size();i++){
            arr[i] = newList.get(i);
        }
        return arr;


    }
}
