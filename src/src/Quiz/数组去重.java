package Quiz;

import java.util.*;

public class 数组去重 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,1};
        for(int i : ArrayAlone(arr)){
            System.out.print(i + " ");
        }



    }

    public static int[] ArrayAlone(int[] arr){
        List<Integer> list = new ArrayList<>();
        for(int i : arr){
            if(!list.contains(i)){
                list.add(i);
            }
        }
        int[] newarr = new int[list.size()];
        int index = 0;
        for(int i : list){
            newarr[index++] = i;
        }
        return newarr;
    }




}
