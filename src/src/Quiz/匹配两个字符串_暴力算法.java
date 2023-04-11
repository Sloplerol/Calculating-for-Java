package Quiz;

public class 匹配两个字符串_暴力算法 {
    public static void main(String[] args) {
        String str1 = "HelloHello world";
        String str2 = "Hello world";

    }


    public static int violenceMatch(String str1,String str2){
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int i = 0,j = 0;
        while(i < chars1.length && j < chars2.length){
            if(chars1[i] == chars2[j]) {
                i++;
                j++;
            }else {
                i = i - j + 1;
                j = 0;
            }
        }
        if(j >= chars2.length){
            return i - j;
        }else {
            return -1;
        }
    }
}
