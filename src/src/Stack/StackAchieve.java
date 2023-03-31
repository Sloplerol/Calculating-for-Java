package Stack;

public class StackAchieve {
    //设置stack最大容量
    private int stackStorage;
    //模拟栈数组
    private int[] stackArr;
    //设置栈顶为-1
    private int stackTop = -1;

    public StackAchieve(int stackStorage) {
        this.stackStorage = stackStorage;
        //初始化容器
        stackArr = new int[stackStorage];
    }

    //判断是否满栈
    public boolean isFull(){
        return this.stackStorage == this.stackTop;
    }

    //判断是否空栈
    public boolean isEmpty(){
        return this.stackTop == -1;
    }

    //压栈操作
    public void put(int val){
        if(isFull()){
            throw new RuntimeException("栈已满");
        }
        stackTop++;
        stackArr[stackTop] = val;
    }

    //弹栈操作
    public int pop(){
        if(isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        int value = stackArr[stackTop];
        stackTop--;
        return value;
    }

    public void list(){
        if(isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        for(int i = 0;i<stackArr.length;i++){
            System.out.printf("stackArr[%d] = %d\n",i,stackArr[i]);
        }
    }

    //表示栈中元素的个数
    public int length(){
        return this.stackTop + 1;
    }


    //判断运算符集
    public boolean isOper(char v){
        return v == '+' || v == '-' || v == '*' || v == '/';
    }
    //判断字符优先级
    public int properities(int v){
        if(v == '+' || v == '-'){
            return 0;
        }else if(v == '*' || v == '/') {
            return 1;
        }else {
            return -1;
        }
    }
    //获取栈顶的数据
    public int peek(){
        return this.stackArr[stackTop];
    }
    //获取栈的容量
    public int StackArrLength(){
        return stackArr.length;
    }

    //计算操作
    public int Calculate(int num1,int num2,int oper){
        int result = 0;
        switch (oper){
            case '+':
                result = num1 + num2;
                return result;
            case '-':
                result = num2 - num1;
                return result;
            case '*':
                result = num1 * num2;
                return result;
            case '/':
                result = num2 / num1;
                return result;
            default:
                break;
        }
        return result;
    }


}
