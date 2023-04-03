package Linked;

public class LinkedForDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1,"No1","啥地方");
        HeroNode hero2 = new HeroNode(2,"No1","啥地方");
        HeroNode hero3 = new HeroNode(3,"No1","啥地方");
        HeroNode hero4 = new HeroNode(4,"No1","啥地方");

        LinkedListForSingle linkedListForSingle = new LinkedListForSingle();
        linkedListForSingle.addByOrder(hero2);
        linkedListForSingle.addByOrder(hero3);
        linkedListForSingle.addByOrder(hero4);
        linkedListForSingle.addByOrder(hero1);

        HeroNode newHero = new HeroNode(1,"sfd","dsfsdf");
        linkedListForSingle.update(newHero);
        linkedListForSingle.list();

        linkedListForSingle.delete(hero1);
        linkedListForSingle.list();
    }



}


class LinkedListForSingle{
    //初始化头节点
    private HeroNode head = new HeroNode(0,"","");



    public void add(HeroNode heroNode){
        //通过辅助指针进行遍历节点
        HeroNode cur = head;
        while(true){
            //相当于遍历到了最后一个节点
            if(cur.next == null){
                break;
            }
            cur = cur.next;
        }
        //在最后添加上新的节点
        cur.next = heroNode;
        heroNode.pre = cur;
    }

    public void list(){

        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode cur = head.next;
        while(true){
            if(cur == null){
                break;
            }
            System.out.println(cur);
            cur = cur.next;
        }


    }

    public void update(HeroNode heroNode){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode cur = head;
        boolean flag = false;
        while(true){
            if(cur.next == null){
                break;
            }
            if(cur.no == heroNode.no){
                flag = true;
                break;
            }
            cur = cur.next;
        }
        //一种是找到了还有一种是没有
        if(flag){
            cur.name = heroNode.name;
            cur.nickname = heroNode.nickname;
        }else {
            System.out.println("没有找到结果");
        }

    }

    public void delete(HeroNode heroNode){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode cur = head.next;
        boolean flag = false;
        while(true){
            //因为现在不需要通过前一个节点来删除对应的节点
            if(cur == null){
                break;
            }
            if(cur.no == heroNode.no){
                flag = true;
                break;
            }
            cur = cur.next;
        }
        if(flag){
            cur.pre.next = cur.next;
            if(cur.next != null){
                cur.next.pre = cur.pre;
            }

        }else {
            System.out.println("没有该编号的节点");
        }

    }



    public void addByOrder(HeroNode heroNode){
        HeroNode cur = head;
        //判断编号是否已经存在
        boolean flag = false;
        while(true){
            if(cur.next == null){
                break;
            }
            //位置找到了在cur的后面
            if(cur.next.no > heroNode.no){
                break;
            }
            //出现重复
            if(cur.next.no == heroNode.no){
                flag = true;
                break;
            }

            cur = cur.next;
        }

        if(flag){
            System.out.println("编号出现重复");
        }else {
            heroNode.next = cur.next;
            cur.next = heroNode;
        }




    }

}



class HeroNode{
    public int no;
    public String name;
    public String nickname;

    public HeroNode next;

    public HeroNode pre;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}