package Stack;

public class Test {
    public static void main(String[] args) {
        String str = "6 + 3 * 2";
        ArrayStacks charStacks = new ArrayStacks(10);
        ArrayStacks numsStacks = new ArrayStacks(10);
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int result = 0;
        char ch = ' ';
        int oper = 0;
        String keepChar = "";
        while(true){
            //遍历每一个元素
            ch = str.substring(index,index+1).charAt(0);
            if(charStacks.isOper(ch)){
                if(!charStacks.isEmpty()){
                    if(charStacks.priority(ch) <= charStacks.priority(charStacks.peek())){
                        num1 = numsStacks.pop();
                        num2 = numsStacks.pop();
                        oper = charStacks.pop();
                        result = numsStacks.cal(num1,num2,oper);
                        numsStacks.push(result);
                        charStacks.push(oper);
                    }else {
                        charStacks.push(ch);
                    }
                }else {
                    charStacks.push(ch);
                }

            }else {

                keepChar += ch;
                //如果index索引的是str最后一个元素的话
                if(index == str.length() - 1){
                    numsStacks.push(Integer.parseInt(keepChar));
                }else {
                    if(charStacks.isOper(str.substring(index + 1,index + 2).charAt(0))){
                        numsStacks.push(Integer.parseInt(keepChar));
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
            if(charStacks.isEmpty()){
                break;
            }
            num1 = numsStacks.pop();
            num2 = numsStacks.pop();
            oper = charStacks.pop();
            result = numsStacks.cal(num1,num2,oper);
            numsStacks.push(result);
        }

        System.out.printf("计算表达式[%s] = %d",str,numsStacks.pop());



    }
}


class ArrayStacks{
    private int maxSize;

    private int[] stack;
    private int top = -1;
    public ArrayStacks(int maxSize){
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isFulled(){
        return top == maxSize - 1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void list(){
        if(isEmpty()){
            System.out.println("栈为空，查看不了");
            return;
        }
        for(int i = top;i>=0;i--){
            System.out.println(stack[i]);
        }
    }

    public void push(int val){
        if(isFulled()){
            System.out.println("栈已满");
            return;
        }
        stack[++top] = val;
    }

    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈为空无法抛出");
        }
        return stack[top--];
    }

    public int peek(){
        return stack[top];
    }

    public boolean isOper(int ch){
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    public int priority(int ch){
        if(ch == '+' || ch == '-'){
            return 0;
        }else if(ch == '*' || ch == '/'){
            return 1;
        }else {
            return -1;
        }
    }

    public int cal(int num1,int num2,int oper){
        int res = 0;
        switch (oper){
            case '+':
                res = num1 + num2;
            case '-':
                res = num2 - num1;
            case '*':
                res = num1 * num2;
            case '/':
                res = num2 / num1;
            default:
                break;

        }
        return res;
    }



}


