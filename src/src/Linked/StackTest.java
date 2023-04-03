package Linked;

import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        //入栈
        stack.add("a");
        stack.add("b");
        stack.add("c");

        //出栈
        while(stack.size() > 0){
            System.out.println(stack.pop());
        }
    }
}
