package Linked;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleNode d1 = new DoubleNode(1,"xsf","satr");
        DoubleNode d2 = new DoubleNode(2,"sdf","satrol");
        DoubleNode d3 = new DoubleNode(3,"dfg","satrol");
        DoubleNode d4 = new DoubleNode(4,"fgh","satrol");

        DoubleLinkedList dll = new DoubleLinkedList();
//        dll.add(d2);
//        dll.add(d1);
//        dll.add(d3);
//        dll.add(d4);

//        dll.list();
//
//        System.out.println("修改后的结果");
//        DoubleNode newNode = new DoubleNode(1,"dab","lhh");
//        dll.update(newNode);
//        dll.list();

        dll.addByOrder(d3);
        dll.addByOrder(d2);
        dll.addByOrder(d1);
        dll.addByOrder(d4);
        dll.list();

    }
}


class DoubleLinkedList{
    //初始化头节点
    private DoubleNode head = new DoubleNode(0,"","");

    public DoubleNode getHead() {
        return head;
    }

    public void list(){
        if(head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //通过辅助节点来实现遍历
        DoubleNode temp = head.next;
        while(true){
            if(temp == null){
                break;
            }
            //如果没有到最后一个节点那么就将信息打印
            System.out.println(temp);
            //每次打印完信息将节点后移
            temp = temp.next;
        }

    }

    public void add(DoubleNode doubleNode){
        //因为head节点的位置无法改变我们需要辅助节点来next
        DoubleNode temp = head;

        while(true){
            //说明找到链表的最后了
            if(temp.next == null){
                break;
            }
            //如果没有找到最后将链表后移
            temp = temp.next;
        }
        //当while循环结束相当于是到达了最后一个节点
        //并且需要将最后一个节点的指向为doubleNode
        temp.next = doubleNode;
        //并且将最后一个节点的前面指向temp
        doubleNode.pre = temp;


    }
    public void update(DoubleNode doubleNode){
        //判断链表是否为空
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }

        DoubleNode temp = head.next;
        boolean flag = false;
        //判断是否能够找到链表
        while(true){
            if(temp.next == null){
                //相当于遍历完链表的所有元素了
                break;
            }
            if(temp.no == doubleNode.no){
                //表示找到了将flag改为true
                flag = true;
                break;
            }
            //接着遍历链表
            temp = temp.next;
        }
        if(flag){
            temp.name = doubleNode.name;
            temp.nickname = doubleNode.nickname;
        }else {
            //表示没有找到该编号
            System.out.printf("没有找到%d编号的节点\n",doubleNode.no);
        }

    }

    public void delete(int no){
        //判断当前链表是否为空
        if(head.next == null){
            System.out.println("链表为空，无法删除");
            return;
        }

        DoubleNode temp = head;
        boolean flag = false;
        //用来标记被删除的元素是否存在
        while(true){
            if(temp.next == null){
                break;
            }
            //判断是否有相同的no 如果有说明找到了
            if(temp.next.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.pre.next = temp.next;
            //如果是最后一个节点不执行下面这句话
            temp.next.pre = temp.pre;

        }else {
            System.out.println("没有找到要删除的节点");
        }
    }
    public void addByOrder(DoubleNode doubleNode){
        DoubleNode temp = head;
        boolean flag = false; //代表添加的元素是否已经存在
        //因为是单向链表我们需要找到的位置是添加位置的前一个节点
        while(true){
            if(temp.next == null){
                //说明已经到链表的最后
                break;
            }
            //此时链表已经找到了 在temp和temp.next之间
            if(temp.next.no > doubleNode.no){
                break;
            }else if(temp.next.no == doubleNode.no){
                flag = true;
                break;
            }
            temp = temp.next; //后移接着遍历链表


        }
        if(flag){
            System.out.printf("添加%d编号已存在\n",hashCode());
        }else {
            //将这个节点next赋值成temp的next
            doubleNode.next = temp.next;
            doubleNode.pre = temp.pre;
            //让temp的下一位作为新的节点
            temp.next = doubleNode;
            temp.pre = doubleNode;
        }
    }
}




class DoubleNode{
    public int no;
    public String name;
    public String nickname;

    public DoubleNode next;
    public DoubleNode pre;

    public DoubleNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "DoubleNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}