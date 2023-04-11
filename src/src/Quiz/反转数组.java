package Quiz;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 反转数组 {
    public static void main(String[] args) {
        String str = "I  have a apple";
        String[] str1 = str.split(" ");
        System.out.println(Arrays.toString(str1));
        System.out.println(str1[1]);
        System.out.println(str1[1].equals(" "));
    }

}
