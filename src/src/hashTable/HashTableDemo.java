package hashTable;

import java.math.BigInteger;
import java.util.*;

public class HashTableDemo {
    public static void main(String[] args) {
        Hashtable hashtable = new Hashtable(7);
        hashtable.list();
        hashtable.add(new Emp(1, "小明"));
        hashtable.add(new Emp(2, "小红"));
        hashtable.add(new Emp(3, "小蓝"));
        System.out.println("");
        hashtable.list();
        hashtable.add(new Emp(3, "小蓝"));
        hashtable.add(new Emp(4, "小蓝4"));
        hashtable.add(new Emp(5, "小蓝5"));
        hashtable.add(new Emp(6, "小蓝6"));
        hashtable.add(new Emp(7, "小蓝7"));
        hashtable.add(new Emp(8, "小蓝8"));
        hashtable.add(new Emp(9, "小蓝9"));
        System.out.println("");
        hashtable.list();

        hashtable.deleteById(3);
        hashtable.list();


    }

}

//定义存放多条链表的哈希表
class Hashtable{
    public int size;
    public EmpLinkedList[] empLinkedLists;

    public Hashtable(int size) {
        this.size = size;
        this.empLinkedLists = new EmpLinkedList[size];
        for(int i = 0;i < size;i++){
            empLinkedLists[i] = new EmpLinkedList();
        }
    }

    public void add(Emp emp){
        //通过员工的id来确定所在链表的位置
        int id = emp.id;
        int index = Hashfun(id);
        empLinkedLists[index].add(emp);
    }


    public void list(){
        for(int i = 0;i < size;i++){
            empLinkedLists[i].list();
        }
    }


    public Emp findById(int id) {
        // 先找到该 id 属于那一条链表
        int no = Hashfun(id);
        // 先判断边界
        if (no > size || no < 0) {
            System.out.printf("id = %d 异常，计算出目标链表为 %d \n", id, no);
            return null;
        }
        Emp emp = empLinkedLists[no].findById(id);
        if (emp == null) {
            System.out.printf("在第 %d 条链表中未找到 id = %d 的雇员 \n", no, id);
        } else {
            System.out.printf("在第 %d 条链表中找到 id = %d 的雇员, name = %s \n", no, id, emp.name);
        }
        return emp;
    }

    public Emp deleteById(int id) {
        // 先找到该 id 属于那一条链表
        int no = Hashfun(id);
        // 先判断边界
        if (no > size || no < 0) {
            System.out.printf("id = %d 异常，计算出目标链表为 %d \n", id, no);
            return null;
        }

        Emp emp = empLinkedLists[no].deleteById(id);
        if (emp == null) {
            System.out.printf("在第 %d 条链表中未找到 id = %d 的雇员，删除失败 \n", no, id);
        } else {
            System.out.printf("在第 %d 条链表中找到 id = %d 的雇员, name = %s ,删除成功\n", no, id, emp.name);
        }
        return emp;
    }

    public int Hashfun(int id){
        return id % size;
    }
}





//定义每一个员工
class Emp{
    public int id;
    public String name;

    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
//定义单条链表用来串联员工
class EmpLinkedList{
    private Emp head;

    public void add(Emp emp){
        if(head == null){
            head = emp;
            return;
        }
        Emp curEmp = head;
        while(true){
            if(curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;

        }
        curEmp.next = emp;

    }

    public void list(){
        if(head == null){
            System.out.println("空链表");
            return;
        }
        Emp curEmp = head;
        while(true){
            System.out.printf("id = %d name = %s\n",curEmp.id,curEmp.name);
            if(curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;
        }
    }

    public Emp findById(int id){

        if(head == null){
            return null;
        }

        Emp curEmp = head;
        while(true){
            if(curEmp.id == id){
                break;
            }

            if(curEmp.next == null){
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;


    }

    public Emp deleteById(int id){
        if(head == null){
            return null;
        }

        Emp cur = head;
        Emp pre = head;
        while(true){
            if(cur.next == null){
                cur = null;
                break;
            }
            if(cur.id == id){
                break;
            }
            //用pre记录cur变化后前一个节点
            pre = cur;
            cur = cur.next;

        }
        if(cur == null){
            return null;
        }

        pre.next = cur.next;
        return cur;

    }


}