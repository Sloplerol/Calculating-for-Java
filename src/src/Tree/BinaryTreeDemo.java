package Tree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        HeroNode root = new HeroNode(1,"a");
        HeroNode node2 = new HeroNode(2,"b");
        HeroNode node3 = new HeroNode(3,"c");
        HeroNode node4 = new HeroNode(4,"d");
        HeroNode node5 = new HeroNode(5,"e");
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);

//        binaryTree.preOrder();
//
//        binaryTree.midOrder();
//
//        binaryTree.lastOrder();
        HeroNode resNode = binaryTree.preOrderSearch(5);
        if(resNode != null){
            System.out.printf("找到了 编号:%d 名字:%s",resNode.getNo(),resNode.getName());
        }else {
            System.out.println("没有找到");
        }


    }
}

//定义二叉树
class BinaryTree{
    private HeroNode root;

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


//定义节点
class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

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
