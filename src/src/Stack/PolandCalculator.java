package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandCalculator {
    public static void main(String[] args) {
        String str = "2 4 + 5 * 6 -";
        List<String> s = getList(str);
        int result = Cal(s);
        System.out.println(result);
        String s1 = "2*(2+3)-5";
        List<String> list = CentertoList(s1);
        System.out.println(list);
    }



    public static List<String> getList(String str){
        //将逆波兰表达式的数字和字符都放入到ArrayList当中
        String[] suffixString = str.split(" ");
        List<String> list = new ArrayList<>();
        for(String ele : suffixString){
            list.add(ele);
        }
        return list;
    }
    //将中缀表达式转化成List
    public static List<String> CentertoList(String s){
        List<String> ls = new ArrayList<>();
        //充当指针用来遍历s
        int i = 0;
        String str = "";
        char c;
        do{
            //如果c是一个非数字的话
            if((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57 ){
                ls.add(""+c);
                i++;
            }else {
                str = "";
                //判断多位数的情况
                while(i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57){
                    str += c;
                    i++;
                }
                ls.add(str);
            }
        }while(i < s.length());
        return ls;

    }

    public static int Cal(List<String> ls){
        Stack<String> stack = new Stack<>();
        for(String item : ls){
            //如果item是一个多位数的话
            if(item.matches("\\d")){
                stack.push(item);
            }else {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res = 0;
                if(item.equals("+")){
                    res = num1 + num2;
                }else if(item.equals("-")){
                    res = num2 - num1;
                }else if(item.equals("*")){
                    res = num2 * num1;
                }else if(item.equals("/")){
                    res = num2 / num1;
                }else {
                    throw new RuntimeException("啥也不是");
                }
                stack.push(res + "");
            }

        }
        return Integer.parseInt(stack.pop());
    }
}
