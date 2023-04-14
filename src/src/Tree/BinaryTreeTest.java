package Tree;

public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree<Integer,String> tree = new BinaryTree<>();
        tree.put(1,"张三");
        tree.put(2,"里斯");
        tree.put(3,"王武");
        //获取二叉树的长度
        System.out.println(tree.size());
        //获取二叉树
        System.out.println(tree.get(2));
        //删除二叉树中的元素
        tree.delete(3);
        System.out.println(tree.size());
    }
}
