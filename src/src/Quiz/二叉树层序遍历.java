package Quiz;

import com.sun.source.tree.Tree;

import java.util.*;

public class 二叉树层序遍历 {
    public static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.right = node3;
        node2.left = node4;
        List<List<Integer>> list = debugger(root);
        System.out.println(list);

    }

    public static List<List<Integer>> debugger(TreeNode root){
        Layout1(root,0);
        return result;
    }

    /**
     * 深度优先搜索
     * @param root root代表根节点
     * @param deep 代表层级
     * 二维数组中一维数组元素不够可以创建添加
     */
    public static void Layout1(TreeNode root,int deep){
        if(root == null) return;
        deep++;
        while(result.size() < deep){
            List<Integer> temp = new ArrayList<>();
            result.add(temp);
        }
        result.get(deep - 1).add(root.val);
        Layout1(root.left,deep);
        Layout1(root.right,deep);
    }


    /**
     * 广度优先搭配搜索队列
     * @param node 代表根结点
     */
    public static void Layout(TreeNode node){
        if(node == null) return;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(node);
        while(!que.isEmpty()){
            int len = que.size();
            List<Integer> list = new ArrayList<>();
            while(len > 0){

                TreeNode tmp = que.poll();
                list.add(tmp.val);
                if(tmp.left != null) que.offer(tmp.left);
                if(tmp.right != null) que.offer(tmp.right);
                len--;
            }
            result.add(list);

        }
    }
}



//定义树的每一个节点
class TreeNode{

    int val;
    TreeNode right;
    TreeNode left;

    public TreeNode(){}
    public TreeNode(int val){
        this.val = val;
    }

    public TreeNode(TreeNode left,TreeNode right,int val){
        this.left = left;
        this.right = right;
        this.val = val;
    }

}
