package Tree;

import java.util.Queue;

public class BinaryTree<Key extends Comparable<Key>,Value> {
    private Node root;

    private int N;

    private class Node{
        //键
        public Key key;
        //值
        public Value value;
        //左节点
        public Node left;
        //右节点
        public Node right;

        public Node(Key key,Value value,Node left,Node right){
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }


    }

    //获取元素的个数
    public int size(){
        return N;
    }

    //向树中添加元素
    public void put(Key key,Value value){
        root = put(root,key,value);
    }

    public Node put(Node x,Key key,Value value){
        //当x子树为空的话
        if(x == null){
            N++;
            return new Node(key,value,null,null);
        }
        //如果子树不为空

        //判断传入的key值和x节点身上的键进行比较
        int res = key.compareTo(x.key);
        if(res > 0){
            x.right = put(x.right,key,value);
        }else if(res < 0){
            x.left = put(x.left,key,value);
        }else {
            x.value = value;
        }
        return x;

    }

    public Value get(Key key){
        return get(root,key);
    }

    public Value get(Node x,Key key){
        //如果子树为空的话
        if(x == null){
            return null;
        }

        int cmp = key.compareTo(x.key);
        //比较传入的key和从跟节点开始的key
        if(cmp > 0){
            return get(x.right,key);
        }else if(cmp < 0){
            return get(x.left,key);
        }else {
            return x.value;
        }
    }

    public void delete(Key key){
        delete(root,key);
    }

    public Node delete(Node x,Key key){
        if(x == null){
            return null;
        }

        int cmp = key.compareTo(x.key);
        if(cmp > 0){
            x.right = delete(x.right,key);
        }else if(cmp < 0){
            x.left = delete(x.left,key);
        }else {
            N--;
            if(x.left == null){
                return x.right;
            }

            if(x.right == null){
                return x.left;
            }

            Node minNode = x.right;
            while(minNode.left != null){
                minNode = minNode.left;
            }

            //用来查找右子树中最小的元素
            Node n = x.right;
            while(n.left != null){
                if(n.left.left == null){
                    n.left = null;
                }else {
                    n = n.left;
                }

            }
            //将最小元素替换删除的元素，也就是minNode的left和right和删除的元素一致
            minNode.left = x.left;
            minNode.right = x.right;
            //最后再将x节点的父节点指向为minNode
            x = minNode;


        }
        return x;
    }

    //查找整个树中最小的键
    public Key min(){
        return min(root).key;
    }

    private Node min(Node n){
        if(n.left != null){
            return min(n.left);
        }else {
            return n;
        }

    }
    //查找整个树中最大的键
    public Key max(){
        return max(root).key;
    }

    public Node max(Node x){
        if(x.right != null){
            return max(x.right);
        }else {
            return x;
        }
    }

    //前序遍历

    //获取整个树中的所有键
    public Queue<Key> preErgodic(){
//        Queue<Key> keys = new Queue<>();
//        preErgodic(root,keys);
//        return keys;
        return null;
    }

    //获取整个树中的指定键
    public void preErgodic(Node n,Queue<Key> keys){

    }

}
