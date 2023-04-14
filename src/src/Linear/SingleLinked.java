package Linear;

import java.util.Iterator;

public class SingleLinked<T> implements Iterable<T>{
    //记录头节点
    private Node head;
    //链表的长度
    private int N;

    private class Node{
        //用来存储数据
        T item;
        //下一个节点
        Node next;
        public Node(T item,Node next){
            this.item = item;
            this.next = next;
        }

    }

    //初始化头节点和链表个数
    public SingleLinked(){
        this.head = new Node(null,null);
        this.N = 0;
    }

    //清空链表
    public void clear(){
        head.next = null;
        this.N = 0;
    }

    public boolean isEmpty(){
        return this.N == 0;
    }

    //获取指定位置的节点
    public T get(int i){
        //从第一个元素开始for循环
        Node n = head.next;
        for(int j = 0;j < i;j++){
            n = n.next;
        }
        //获取此索引下的数据
        return n.item;
    }

    //插入节点
    public void insert(T t){
        Node node = head;
        while(node.next != null){
            node = node.next;
        }
        //创建一个新的节点
        Node n = new Node(t,null);
        //将node的下一个节点窒息那个为创建出来的新节点
        node.next = n;
        //让节点的数量++
        N++;
    }

    //插入指定位置的节点
    public void insetInIndex(int i,T t){
        //找到i位置的前一个节点
        Node pre = head;
        //i - 1;
        for(int j = 0;j <= i -1;j++){
            pre = pre.next;
        }
        //找到i位置的节点
        Node current = pre.next;
        //创建新节点并且指向current节点
        Node newNode = new Node(t,current);
        //前一个节点接着指向新节点
        pre.next = newNode;
        //再让节点数++
        N++;

    }

    public T remove(int i){
        Node pre = head;
        for(int j = 0;j <= i - 1;j++){
            pre = pre.next;
        }
        Node current = pre.next;
        pre.next = current.next;
        N--;
        return current.item;


    }

    public int indexOf(T t){
        Node n = head;
        for(int i = 0;n.next != null;i++){
            n = n.next;
            if(n.next.item.equals(t)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new LIterator();
    }
    //通过重写Iterator来实现遍历的目的
    private class LIterator implements Iterator{
        //定义一个头节点 方便进行遍历
        private Node n;
        public LIterator(){
            this.n = head;
        }

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public T next() {
            n = n.next;
            return n.item;
        }
    }

    public void reverse(){
        if(isEmpty()){
            return;
        }

        reverse(head.next);
    }

    public Node reverse(Node current){
        //说明遍历到最后最后一个节点
        if(current.next == null){
            //将头节点.next = current节点
            head.next = current;
            return current;
        }
        //原链表前移
        Node pre = reverse(current.next);
        //将这个链表的next 指向为current
        pre.next = current;
        current.next = null;

        return null;
    }

}
