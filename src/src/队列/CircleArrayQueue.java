package 队列;

import java.util.Scanner;

public class CircleArrayQueue {
    public static void main(String[] args) {
        CircleArray ca = new CircleArray(4);
        Scanner scanner = new Scanner(System.in);
        char key = ' ';
        boolean loop = true;
        while(loop){
            System.out.println("欢迎使用菜单栏");
            System.out.println("l: 遍历数组");
            System.out.println("a: 添加数据");
            System.out.println("g: 取出数据");
            System.out.println("h: 查看头条数据");
            System.out.println("e: 退出程序");
            key = scanner.next().charAt(0);
            switch (key){
                case 'a':
                    System.out.println("请输入你想输入的数");
                    int n = scanner.nextInt();
                    ca.addQueue(n);
                    break;
                case 'l':
                    ca.listAll();
                    break;
                case 'g':
                    try{
                        int res = ca.getQueue();
                        System.out.println("取出数据成功是"+res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try{
                        int res = ca.peek();
                        System.out.println(res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;

            }
        }
        System.out.println("program over");
    }
}

class CircleArray{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;
    //添加队列的构造函数进行初始化数据
    public CircleArray(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return front == rear;
    }

    //判断队列是否满
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }
    public void addQueue(int n){
        if(isFull()){
            throw new RuntimeException("队列已满");
        }
        arr[rear] = n;
        //环形添加数据
        rear = (rear + 1) % maxSize;
    }

    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，无法取出数据");
        }
        //将front对应的值临时保存以下
        int val = arr[front];
        //对front进行环形操作
        front = (front + 1) % maxSize;
        return val;
    }

    public void listAll(){
        if(isEmpty()) {
            System.out.println("队列为空，不能列举");
            return;
        }
        for(int i = front;i<front + (rear + maxSize - front) % maxSize ;i++){
            System.out.printf("arr[%d]=%d\n",i % maxSize,arr[i % maxSize]);
        }
    }
    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("没有头数据");
        }
        return arr[front];
    }
}
