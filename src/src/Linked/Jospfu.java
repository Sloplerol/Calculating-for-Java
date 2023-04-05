package Linked;

public class Jospfu {
    public static void main(String[] args) {
        CircleSingleLinked clsl = new CircleSingleLinked();
        clsl.add(5);
        clsl.list();

        clsl.countKid(1,2,5);

    }



}


class CircleSingleLinked{
    private Kid first = new Kid(-1); //创建一个头节点

    /**
     * 出圈顺序的代码实现
     * @params startNo 开始的编号
     * @params countNum 代表数了多少下
     * @params KidSum 代表总共多少个人
     */
    public void countKid(int startNo,int countNum,int KidSum){
        //1
        if(startNo < 1 || first == null || startNo > KidSum){
            System.out.println("输入格式不合法");
            return;
        }
        //2
        Kid curkid = first;
        while(true){
            if(curkid.getNext() == first){
                break;
            }
            curkid = curkid.getNext();
        }

        //3
        for(int i = 0;i<startNo - 1;i++){
            first = first.getNext();
            curkid = curkid.getNext();
        }
        //4
        while(true){
             if(curkid == first){
                 break;
             }

             for(int j = 0;j < countNum - 1;j++){
                 first = first.getNext();
                 curkid = curkid.getNext();
             }
             System.out.println("出圈小孩的编号是"+first.getNo());
             first = first.getNext();
             curkid.setNext(first);
        }
        System.out.println("残留小孩编号的认识" + first.getNo());

    }













//    public void countKid(int startNo,int countNum,int KidSum){
//        if(first == null || startNo > KidSum || startNo < 1){
//            System.out.println("输入格式有无");
//            return;
//        }
//        Kid curkid = first;
//        //构建环形链表
//        while(true){
//            //当绕回来的时候进行break
//            if(curkid.getNext() == first){
//                break;
//            }
//            //后移
//            curkid = curkid.getNext();
//        }
//        //现将位置移动到startNo
//        for(int i = 0;i < startNo - 1;i++){
//            first = first.getNext();
//            curkid = curkid.getNext();
//
//        }
//
//        //出圈操作
//        while(true){
//            if(curkid == first){
//                break;
//            }
//
//            //让first和curkid移动countNum - 1步
//            for(int j = 0;j<countNum - 1;j++){
//                curkid = curkid.getNext();
//                first = first.getNext();
//            }
//            System.out.println("出圈小孩的编号是"+ first.getNo());
//            //将first指向下一个节点
//            first = first.getNext();
//            //将curkid的下一个指向first就可以将first圈出
//            curkid.setNext(first);
//        }
//        System.out.println("最后留在圈中小孩的编号是" + first.getNo());
//
//
//
//    }
//
    public void add(int nums){
        if(nums < 1){
            System.out.println("人数不合法");
            return;
        }
        //创建一个辅助指针
        Kid curkid = null;
        for(int i = 1;i <= nums;i++){
            Kid kid = new Kid(i);
            if(i == 1){
                //first作为新创建出来的第一个小孩
                first = kid;
                //自己指向自己的过程
                first.setNext(first);
                //curkid辅助指针后移
                curkid = first;
            }
            //将当前所处的节点next设置为新创建出来的kid
            curkid.setNext(kid);
            //创建回路
            kid.setNext(first);
            //curkid后移
            curkid = kid;
        }
    }


    public void list(){
        if(first == null){
            System.out.println("环形链表为空");
            return;
        }
        Kid curkid = first;
        while(true){
            System.out.println("小孩的编号是" + curkid.getNo());
            if(curkid.getNext() == first){
                break;
            }
            curkid = curkid.getNext();
        }
    }

}


class Kid{
    private int no;
    private Kid next;

    public Kid(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Kid getNext() {
        return next;
    }

    public void setNext(Kid next) {
        this.next = next;
    }

}
