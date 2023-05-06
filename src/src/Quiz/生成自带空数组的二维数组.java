package Quiz;

import java.util.ArrayList;
import java.util.List;

public class 生成自带空数组的二维数组 {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        //temp为为list.get(0)的一个兄弟
        List<Integer> temp = new ArrayList<>(list.get(0));
        temp.add(2);
        list.add(temp);
        System.out.println(list); //[[],[2]]
    }
}
