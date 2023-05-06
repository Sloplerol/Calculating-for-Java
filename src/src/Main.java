import java.util.*;
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

class Main {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node3.right = node5;
        connect(root);
    }
    public static Node connect(Node root) {
        Queue<Node> tmpQueue = new LinkedList<Node>();
        if (root != null) tmpQueue.add(root);

        while (tmpQueue.size() != 0){
            int size = tmpQueue.size();

            Node cur = tmpQueue.poll();
            if (cur.left != null) tmpQueue.add(cur.left);
            if (cur.right != null) tmpQueue.add(cur.right);

            for (int index = 1; index < size; index++){
                Node next = tmpQueue.poll();
                if (next.left != null) tmpQueue.add(next.left);
                if (next.right != null) tmpQueue.add(next.right);

                cur.next = next;
                cur = next;
            }
        }

        return root;
    }
}




