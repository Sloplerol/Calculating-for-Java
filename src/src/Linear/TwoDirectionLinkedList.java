package Linear;

import java.util.Iterator;

public class TwoDirectionLinkedList<T> implements Iterable<T>{
    private Node head;
    private Node last;

    private int N;

    private class Node{

        public Node pre;
        public Node next;
        public T item;
        public Node(T item,Node pre,Node next){
            this.item = item;
            this.pre = pre;
            this.next = next;

        }


    }

    public TwoDirectionLinkedList() {
        this.head = new Node(null,null,null);
        this.last = null;
        this.N = 0;
    }

    public void clear(){
        this.head.next = null;
        this.last = null;
        this.N = 0;
    }

    public int length(){
        return N;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public T getFirst(){
        if(isEmpty()){
            return null;
        }
        return head.next.item;
    }

    public T getLast(){
        if(isEmpty()){
            return null;
        }
        return last.item;
    }

    //插入元素
    public void insert(T t){
        if(isEmpty()){
            //如果链表为空的话
            //将新链表的上一位设置为head，下一位为null
            Node newNode = new Node(t,head,null);
            //尾节点设置为新的节点
            last = newNode;
            //头节点的下一位也就是创建出来的尾节点
            head.next = last;

        }else {
            //用来代表之前的旧尾节点
            Node oldNode = last;
            //新创建的节点上一位设置为旧的节点，下一位设置为null
            Node newNode = new Node(t,oldNode,null);
            oldNode.next = newNode;
            last = newNode;
        }
    }

    public void insertIndex(int i,T t){
        //获取到索引到前一个节点
        Node pre = head;
        for(int j = 0;j <= i - 1;j++){
            pre = pre.next;
        }
        //找到当前节点
        Node current = pre.next;
        //创建新节点位于pre和current中
        Node newNode = new Node(t,pre,current);
        pre.next = newNode;
        current.pre = newNode;
        N++;
    }

    public T get(int i){
        Node pre = head.next;
        for(int j = 0;j <= i - 1;j++){
            pre = pre.next;
        }
        return pre.item;
    }


    public int indexOf(T t){
        Node n = head;
        for(int i = 0;head.next != null;i++){
            n = n.next;
            if(n.next.item.equals(t)){
                return i;
            }
        }
        return -1;
    }

    public T remove(int i){
        Node pre = head;
        for(int j = 0;j <= i - 1;j++){
            pre = pre.next;
        }
        Node cur = pre.next;
        Node curnext = cur.next;

        pre.next = curnext;
        curnext.pre = pre;
        N--;

        return cur.item;


    }


    @Override
    public Iterator<T> iterator() {
        return null;
    }

    private class HIterator implements Iterator{
        private Node n;
        public HIterator(){
            this.n = head;
        }
        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public Object next() {
            n = n.next;
            return n.item;
        }


    }
}
