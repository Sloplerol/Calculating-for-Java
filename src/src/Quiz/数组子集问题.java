package Quiz;

import java.util.ArrayList;
import java.util.List;

public class 数组子集问题 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        //首先定义一个可初始化的二维数组 -> ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        //向这个二维数组中添加一个空的数组[]
        list.add(new ArrayList<>());
        //由于要都是要在别的数组的基础上添加1 2 3个元素
        for(int i = 0;i < nums.length;i++){
            int size = list.size();
            for(int j = 0;j < size;j++){
                //在list.get(j)的基础上添加元素
                List<Integer> temp = new ArrayList<>(list.get(j));
                temp.add(nums[i]);
                list.add(temp);
            }
        }
    }
}
