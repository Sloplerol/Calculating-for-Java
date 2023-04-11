package Stack;

public class Calculator {
    public static void main(String[] args) {
        String str = "40*2-3";
        //分别创建数字栈和符号栈
        ArrayForCalculate charStack = new ArrayForCalculate(10);
        ArrayForCalculate numStack = new ArrayForCalculate(10);
        //定义相关变量
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int result = 0;
        int oper = 0;
        char ch = ' ';
        String keepChar = "";
        while(true){
            //遍历str中的所有元素
            ch = str.substring(index,index+1).charAt(0);
            //如果遍历的ch是符号的话
            if(charStack.isOper(ch)){
                if(!charStack.isEmpty()){
                    //比较传进来符号和栈顶符号的优先级
                    if(charStack.priority(ch) <= charStack.priority(charStack.peek())){
                        //如果传进来的符号的优先级小于等于栈顶符号的优先级
                        num1 = numStack.pop();;
                        num2 = numStack.pop();
                        oper = charStack.pop();
                        result = numStack.calculate(num1,num2,oper);
                        numStack.push(result);
                        charStack.push(ch);
                    }else {
                        charStack.push(ch);
                    }
                }else {
                    charStack.push(ch);
                }
            }else {
                //读取到的数字字符 对应的ASCII值 '1' 对应的是49
//                numStack.push(ch - 48);
                keepChar += ch;
                //如果index索引的是str最后一个元素的话
                if(index == str.length() - 1){
                    numStack.push(Integer.parseInt(keepChar));
                }else {
                    if(charStack.isOper(str.substring(index + 1,index + 2).charAt(0))){
                        numStack.push(Integer.parseInt(keepChar));
                        keepChar = "";
                    }
                }
            }
            index++;
            if(index >= str.length()){
                break;
            }
        }
        while(true){
            if(charStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = charStack.pop();
            result = numStack.calculate(num1,num2,oper);
            numStack.push(result);
        }
        System.out.printf("表达式[%s] = %d",str,numStack.pop());


    }
}

class ArrayForCalculate{
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayForCalculate(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isFull(){
        return top == maxSize - 1;
    }
    public boolean isEmpty(){
        return top == -1;
    }

    public void push(int value){
        if(isFull()){
            System.out.println("栈满了");
            return;
        }
        stack[++top] = value;
    }
    //出栈将栈顶的数据放回
    public int pop(){
        if(isEmpty()) {
            throw new RuntimeException("栈为空，无法抛出任何数据");
        }
        return stack[top--];


    }

    //显示栈内的数据
    public void list(){
        if(isEmpty()){
            System.out.println("栈为空");
            return;
        }
        for(int i = top;i >= 0;i--){
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }

    public int priority(int character){
        if(character == '*' || character == '/'){
            return 1;
        }else if(character == '+' || character == '-' ){
            return 0;
        }else {
            return -1;
        }
    }

    public boolean isOper(int ch){
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    public int calculate(int num1,int num2,int ch){
        int res = 0;
        switch (ch){
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;

        }
        return res;
    }

    public int peek(){
        return stack[top];
    }
}


