package Stack;

import java.util.Stack;

public class TestStack01 {
    public static void main(String[] args) {
        String str = "2+5*2+10";
        //定义数字栈
        StackAchieve StackNum = new StackAchieve(10);
        //定义符号栈
        StackAchieve StackSymbol = new StackAchieve(10);
        int tmp1 = 0;
        int tmp2 = 0;
        int symbolChar = 0;
        int result = 0;
        String values = "";
        for(int i = 0;i<str.length();i++){
            //拿出所有符号
            char c = str.charAt(i);
            //判断是否是运算符
            if(StackSymbol.isOper(c)){
                //如果符号栈的长度不为空的时候
                if(!StackSymbol.isEmpty()){
                    //判断栈顶和获取的符号优先级
                    if(StackSymbol.properities(c) <= StackSymbol.properities(StackSymbol.peek())){
                        //如果栈顶符号的优先级高
                        tmp1 = StackNum.pop();
                        tmp2 = StackNum.pop();
                        symbolChar = StackSymbol.pop();
                        result = StackNum.Calculate(tmp1,tmp2,symbolChar);
                        //上述都是通过栈顶符号进行计算的

                        //计算好的结果push到StackNum中进行下一步计算
                        StackNum.put(result);
                        //拿刚才的符号进行计算
                        StackSymbol.put(c);
                    }else {
                        //直接该符号压入符号栈
                        StackSymbol.put(c);
                    }
                }else {
                    //如果符号栈为空，直接压入
                    StackSymbol.put(c);
                }
            }else {
                //如果不是符号的话
                values += c;
                if(i == str.length() - 1){
                    StackNum.put(Integer.parseInt(values));

                }else {
                    char data = str.substring(i + 1,i + 2).charAt(0);
                    if(StackSymbol.isOper(data)){
                        StackNum.put(Integer.parseInt(values));
                        values = "";
                    }
                }

            }

        }
        while(true){
            if(StackSymbol.isEmpty()){
                break;
            }
            tmp1 = StackNum.pop();
            tmp2 = StackNum.pop();
            symbolChar = StackSymbol.pop();
            result = StackNum.Calculate(tmp1,tmp2,symbolChar);
            StackNum.put(result);
        }
        int res = StackNum.pop();
        System.out.println("最终打印的结果是"+res);
    }
}
