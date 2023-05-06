package Tree.threadBinaryTree;

public class ThreadBinaryTree {
    public static void main(String[] args) {
        HeroNode root = new HeroNode(1,"tom");
        HeroNode node2 = new HeroNode(3,"a");
        HeroNode node3 = new HeroNode(6,"b");
        HeroNode node4 = new HeroNode(8,"c");
        HeroNode node5 = new HeroNode(10,"d");
        HeroNode node6 = new HeroNode(14,"e");

        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        ThreadTree t = new ThreadTree();
        t.setRoot(root);

        HeroNode leftNode = node5.getLeft();
        System.out.println();

    }
}


class ThreadTree{
    private HeroNode root;
    //pre总是指向当前节点的前一个节点
    private HeroNode pre = null;

    /**
     *
     * @param node 对当前节点进行线索化
     */
    public void threadedNodes(HeroNode node){
        //如果节点为空，无法进行线索化
        if(node == null) {
            return;
        }
        //线索化左子树
        threadedNodes(node.getLeft());
        //处理当前节点的前驱节点
        if(node.getLeft() == null){
            node.setLeft(pre);
            node.setLeftType(1);
        }

        if(pre != null && pre.getRight() == null){
            pre.setRight(node);
            pre.setRightType(1);
        }

        pre = node;

        threadedNodes(node.getRight());


    }

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void deleteNode(int no){
        if(root != null){
            if(root.getNo() == no){
                root = null;
            }else{
                root.deleteNode(no);
            }
        }
    }



    //前序遍历
    public void preOrder(){
        if(this.root != null){
            this.root.preOrder();
        }else {
            System.out.println("二叉树为空");
        }
    }

    //中序遍历
    public void midOrder(){
        if(this.root != null){
            this.root.midOrder();
        }else {
            System.out.println("二叉树为空");
        }
    }

    //后续遍历
    public void lastOrder(){
        if(this.root != null){
            this.root.lastOrder();
        }else {
            System.out.println("二叉树为空");
        }
    }

    //前序查找
    public HeroNode preOrderSearch(int no){
        if(root != null){
            return root.preOrderSearch(no);
        }else {
            return null;
        }
    }

    //中序查找
    public HeroNode midOrderSearch(int no){
        if(root != null){
            return root.midOrderSearch(no);
        }else {
            return null;
        }
    }

    //后续查找
    public HeroNode lastOrderSearch(int no){
        if(root != null){
            return root.lastOrderSearch(no);
        }else {
            return null;
        }
    }
}

class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }
    //leftType = 0 表示指向的是左子树，如果是1指向的是前驱节点
    //rightType = 0 表示指向的是右子树 如果1指向后继节点
    private int leftType;
    private int rightType;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }


    public void deleteNode(int no){
        if(this.left != null && this.left.no == no){
            this.left = null;
            return;
        }

        if(this.right != null && this.right.no == no){
            this.right = null;
            return;
        }

        //接着向左子树递归
        if(this.left != null){
            this.left.deleteNode(no);
        }
        //接着向右子树进行递归
        if(this.right != null){
            this.right.deleteNode(no);
        }
    }

    //非叶子节点的删除
    public void deleteNoLeft(int no){
        //当子节点只有一个的情况下
        if(this.left == null && this.right != null){
            this.no = this.right.no;
            this.right = null;
            return;
        }else if(this.left != null && this.right == null){
            this.no = this.left.no;
            this.left = null;
            return;
        }

        if(this.left != null && this.right != null){
            this.no = this.left.no;
            this.left = null;

        }


    }


    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if(this.left != null) {
            this.left.preOrder();
        }

        if(this.right != null){
            this.right.preOrder();
        }

    }
    //中序遍历
    public void midOrder(){
        if(this.left != null){
            this.left.midOrder();
        }
        System.out.println(this);
        if(this.right != null){
            this.right.midOrder();
        }
    }


    //后续遍历
    public void lastOrder(){
        if(this.left != null){
            this.left.lastOrder();
        }
        if(this.right != null){
            this.right.lastOrder();
        }
        System.out.println(this);
    }

    public HeroNode preOrderSearch(int no){
        //判断当前节点是否为空
        if(this.no == no){
            return this;
        }
        HeroNode resNode = null;
        if(this.left != null){
            resNode = this.left.preOrderSearch(no);
        }

        if(resNode != null){
            return resNode;
        }

        if(this.right != null){
            resNode = this.right.preOrderSearch(no);
        }

        if(resNode != null){
            return resNode;
        }

        return resNode;
    }

    public HeroNode midOrderSearch(int no){
        HeroNode resNode = null;
        if(this.left != null){
            resNode = this.left.midOrderSearch(no);
        }

        if(resNode != null){
            return resNode;
        }

        if(this.no == no){
            return this;
        }

        if(this.right != null){
            resNode = this.right.midOrderSearch(no);
        }

        if(resNode != null){
            return resNode;
        }
        return resNode;
    }

    public HeroNode lastOrderSearch(int no){
        HeroNode resNode = null;
        if(this.left != null){
            resNode = this.left.lastOrderSearch(no);
        }

        if(resNode != null){
            return resNode;
        }


        if(this.right != null){
            resNode = this.right.lastOrderSearch(no);
        }

        if(resNode != null){
            return resNode;
        }

        if(this.no == no){
            return this;
        }

        return resNode;
    }

}
