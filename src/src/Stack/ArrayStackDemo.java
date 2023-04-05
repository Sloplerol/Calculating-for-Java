package Stack;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack as = new ArrayStack(10);
        Scanner scanner = new Scanner(System.in);
        String key = "";
        boolean loop = true;
        while(loop){
            System.out.println("list:查看栈结构");
            System.out.println("push:添加数据");
            System.out.println("pop:弹出栈顶的数据");
            System.out.println("exit:退出操作页面");
            key = scanner.next();
            switch (key){
                case "list":
                    as.list();
                    break;
                case "push":
                    System.out.print("请输入你想要添加的数据");
                    as.push(scanner.nextInt());
                    break;

                case "pop":
                    try{
                        as.pop();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case "exit":
                    loop = false;
                    scanner.close();
                    break;
                default:
                    break;
            }
        }
        System.out.println("出栈成功~~~");
    }
}


class ArrayStack{
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack(int maxSize) {
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
}
