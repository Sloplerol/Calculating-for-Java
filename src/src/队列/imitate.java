package 队列;

import java.util.Scanner;

public class imitate {
    public static void main(String[] args) {
        ArrayQueue aq = new ArrayQueue(3);
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
                    aq.addQueue(n);
                    break;
                case 'l':
                    aq.listAll();
                    break;
                case 'g':
                    try{
                        int res = aq.getQueue();
                        System.out.println("取出数据成功是"+res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try{
                        int res = aq.peek();
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
//通过数组模拟数据
class ArrayQueue{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;
    //添加队列的构造函数进行初始化数据
    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return front == rear;
    }

    //判断队列是否满
    public boolean isFull(){
        return rear == maxSize - 1;
    }
    //添加数据到队列
    public void addQueue(int n){
        if(isFull()){
            throw new RuntimeException("队列已满");
        }
        arr[++rear] = n;
    }

    //获取出队列的那个数据 在这里有一个缺点：虽然拿到了前面的数据，但是这些数据还是占用位置
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，无法取出数据");
        }
        front++;
        return arr[front];
    }

    //遍历队列数组的操作
    public void listAll(){
        if(isEmpty()) {
            System.out.println("队列为空，不能列举");
            return;
        }
        for(int i = 0;i<arr.length;i++){
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    //列举队列头数据
    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("没有头数据");
        }
        return arr[front+1];
    }
}
