package Quiz;

import java.util.Scanner;

public class 统计字符 {
    public static void main(String[] args) {
        //统计的分别是大写字符，小写字符，数字字符，其他字符
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int upper = 0;
        int low = 0;
        int num = 0;
        int other = 0;
        for(int i = 0;i < str.length();i++){
            char c = str.charAt(i);
            if(Character.isUpperCase(c)){
                upper++;
            }else if(Character.isLowerCase(c)){
                low++;
            }else if(Character.isDigit(c)){
                num++;
            }else {
                other++;
            }
        }
        System.out.printf("%d %d %d %d\n",upper,low,num,other);

    }
}
