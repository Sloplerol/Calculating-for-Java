package Stack;

public class LinkedStackDemo {
    public static void main(String[] args) {
        LinkedStack ln = new LinkedStack();
        ln.push(3);
        ln.push(4);
        ln.push(5);
        ln.list();


    }
}

class LinkedStack{
    private LinkedNode head;
    private int top;
    public LinkedStack(){
        //设置value的值为0
        this.head = new LinkedNode(0);
        this.top = -1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        //链表不可能满
        return false;
    }

    public void list(){
        if(isEmpty()){
            System.out.println("链表为空");
            return;
        }
        LinkedNode cur = head.next;
        while(cur != null){
            System.out.printf("Stack[%d] = %d\n",top,cur.getValue());
            cur = cur.next;
            top--;
        }
    }

    public void push(int n){
        LinkedNode new_node = new LinkedNode(n);
        new_node.next = head;
        head = new_node;
        top++;
    }

    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("链表为空，无法抛出");
        }
        int val = head.getValue();
        head = head.next;
        top--;
        return val;

    }



}


class LinkedNode{

    private int value;


    LinkedNode next;

    public LinkedNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}




