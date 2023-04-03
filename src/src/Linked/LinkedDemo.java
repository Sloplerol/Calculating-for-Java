package Linked;

import org.w3c.dom.Node;

import java.util.Stack;

public class LinkedDemo {
    public static void main(String[] args) {
        //创建节点
        SingleNode s1 = new SingleNode(1,"zjj","satrol");
        SingleNode s2 = new SingleNode(3,"sdf","hesdf");
        SingleNode s3 = new SingleNode(2,"fdg","dfgdf");
        SingleNode s4 = new SingleNode(4,"hfg","swerwer");
        //创建列表
        SingleLinkedList sll = new SingleLinkedList();
//        sll.add(s1);
//        sll.add(s2);
//        sll.add(s3);
//        sll.add(s4);

        //按照编号的大小进行排序
        sll.addByOrder(s1);
        sll.addByOrder(s2);
        sll.addByOrder(s3);
        sll.addByOrder(s4);
        System.out.println("修改前的数据");
        sll.list();

        //对于指定编号的节点信息进行修改
        SingleNode newNode = new SingleNode(1,"ljm","dsb");
        sll.update(newNode);


        System.out.println("修改后的数据");
        sll.list();
        System.out.println("删除后的结果");
        sll.delete(1);
        sll.list();

        System.out.println(NodeLength(sll.getHead()));

        //测试获取倒数的元素
//        SingleNode singleNode = searchIndexNode(sll.getHead(),1);
//        System.out.println(singleNode);

        System.out.println("反转之前的链表");
        sll.list();

        System.out.println("反转之后的链表");
//        reverseLinked(sll.getHead());
//        sll.list();
        System.out.println("逆序打印");
        reversePrint(sll.getHead());


    }
    //计算节点的长度
    public static int NodeLength(SingleNode head){
        if(head.next == null){
            return 0;
        }
        //从头节点的下一个开始 计算节点时不包含头节点
        SingleNode temp = head.next;
        int length = 0;
        while(temp != null){
            length++;
            temp = temp.next;
        }
        return length;
    }

    //查找倒数第k个节点
    //这里index代表的是倒数第几个节点
    public static SingleNode searchIndexNode(SingleNode head,int index){
        if(head.next == null){
            //链表为空
            return null;
        }
        //获取节点的长度
        int size = NodeLength(head);
        //先对index进行校验
        if(index <= 0 || index > size){
            return null;
        }
        SingleNode temp = head.next;
        //通过size - index来判断temp移动的次数 来索引倒数第几项
        for(int i = 0;i<size - index;i++){
            temp = temp.next;
        }
        return temp;


    }

    public static void reversePrint(SingleNode head){
        if(head.next == null){
            return;
        }
        Stack<SingleNode> stack = new Stack<SingleNode>();
        SingleNode cur = head.next;
        while(cur != null){
            stack.push(cur);
            cur = cur.next;
        }

        while(stack.size() > 0) {
            System.out.println(stack.pop());
        }

    }

    public static void mergeLinked(SingleNode s1,SingleNode s2){
        SingleNode singleNode = new SingleNode(0,"","");
        while(s1.next != null && s2.next != null) {
            if(s1.no < s2.no){
                singleNode.next = s1.next;
                s1 = s1.next;
            }else {
                singleNode.next = s2.next;
                s2 = s2.next;
            }
            singleNode = singleNode.next;
        }

    }

    public static void reverseLinked(SingleNode head){
        //如果当前链表为空或者仅仅只有一个元素的时候不需要反转链表
        if(head.next == null || head.next.next == null) {
            return ;
        }
        //定义一个辅助节点用来遍历链表
        SingleNode cur = head.next;
        //定义下一个节点
        SingleNode next = null;
        SingleNode reverselink = new SingleNode(0,"","");
        while(cur != null){
            //展示保存cur的下一个节点
            next = cur.next;
            //让cur的下一个节点放入反转链表中
            cur.next = reverselink.next;

            reverselink.next = cur;
            //让cur进行后移
            cur = next;
        }
        head.next = reverselink.next;

    }



}

//创建单链表用来管理节点
class SingleLinkedList {
    //首先创建一个头节点
    private SingleNode head = new SingleNode(0,"","");

    public SingleNode getHead() {
        return head;
    }

    public void add(SingleNode singleNode){
        //因为head节点的位置无法改变我们需要辅助节点来next
        SingleNode temp = head;

        while(true){
            //说明找到链表的最后了
            if(temp.next == null){
                break;
            }
            //如果没有找到最后将链表后移
            temp = temp.next;
        }
        //当while循环结束相当于是到达了最后一个节点
        //并且需要将最后一个节点的指向为singleNode
        temp.next = singleNode;

    }

    //显示节点
    public void list(){
        if(head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //通过辅助节点来实现遍历
        SingleNode temp = head.next;
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

    //按照编号添加
    public void addByOrder(SingleNode singleNode){
        SingleNode temp = head;
        boolean flag = false; //代表添加的元素是否已经存在
        //因为是单向链表我们需要找到的位置是添加位置的前一个节点
        while(true){
            if(temp.next == null){
                //说明已经到链表的最后
                break;
            }
            //此时链表已经找到了 在temp和temp.next之间
            if(temp.next.no > singleNode.no){
                break;
            }else if(temp.next.no == singleNode.no){
                flag = true;
                break;
            }
            temp = temp.next; //后移接着遍历链表


        }
        if(flag){
            System.out.printf("添加%d编号已存在\n",hashCode());
        }else {
            //将这个节点next赋值成temp的next
            singleNode.next = temp.next;
            //让temp的下一位作为新的节点
            temp.next = singleNode;
        }
    }

    //更新链表信息
    public void update(SingleNode singleNode){
        //判断链表是否为空
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }

        SingleNode temp = head.next;
        boolean flag = false; //判断是否能够找到链表
        while(true){
            if(temp.next == null){
                //相当于遍历完链表的所有元素了
                break;
            }
            if(temp.no == singleNode.no){
                //表示找到了将flag改为true
                flag = true;
                break;
            }
            //接着遍历链表
            temp = temp.next;
        }
        if(flag){
            temp.name = singleNode.name;
            temp.nickname = singleNode.nickname;
        }else {
            //表示没有找到该编号
            System.out.printf("没有找到%d编号的节点\n",singleNode.no);
        }




    }


    public void delete(int no){
        SingleNode temp = head;
        boolean flag = false; //用来标记被删除的元素是否存在
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
            temp.next = temp.next.next;

        }else {
            System.out.println("没有找到要删除的节点");
        }
    }

}





class SingleNode{
    public int no;
    public String name;
    public String nickname;

    public SingleNode next;

    public SingleNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "SingleNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}

