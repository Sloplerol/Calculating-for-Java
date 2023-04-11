package Quiz;

import java.util.*;

public class 查找两个数组各自独立的元素 {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {2,3,4,5,6};
        int length1 = arr1.length;
        int length2 = arr2.length;
        //扩容数组
        int[] newArr = Arrays.copyOf(arr1,length1 + length2);

        //填充多扩容出来多值
        for(int i = 0;i < length2;i++){
            newArr[i + length1] = arr2[i];
        }
        //通过哈希法进行map映射
        Map<Integer,Integer> map = new HashMap<>();

        for(int data : newArr){
            map.put(data,map.getOrDefault(data,0) + 1);
        }
        //获取到独立的元素
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue() == 1){
                list.add(entry.getKey());
            }
        }
        System.out.println(list);
    }

}
