package com.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class AllOrder {
    public static ArrayList<Integer> myArr;

    public static void preOrder(MyTree myTree) {
        if (myTree == null) return;
        myArr.add(myTree.value);
        preOrder(myTree.left);
        preOrder(myTree.right);
    }

    public static void inOrder(MyTree myTree) {
        if (myTree == null) return;
        preOrder(myTree.left);
        myArr.add(myTree.value);
        preOrder(myTree.right);
    }

    public static void postOrder(MyTree myTree) {
        if (myTree == null) return;
        preOrder(myTree.left);
        preOrder(myTree.right);
        myArr.add(myTree.value);
    }

    public Stack<MyTree> myStack = new Stack<>();

    public void preStackOrder(MyTree myTree) {
        while (myTree != null || (!myStack.isEmpty())) {
            while (myTree != null) {
                System.out.println(myTree.value);
                myStack.push(myTree);
                myTree = myTree.left;
            }
            if (!myStack.isEmpty()) {
                myTree = myStack.pop().right;
            }
        }

    }

    public void inStackOrder(MyTree myTree) {
        while (myTree != null || (!myStack.isEmpty())) {
            while (myTree != null) {
                myStack.push(myTree);
                myTree = myTree.left;
            }
            if (!myStack.isEmpty()) {
                MyTree _myTree = myStack.pop();
                System.out.println(_myTree.value);
                myTree = _myTree.right;
            }
        }

    }

    public void postStackOrder(MyTree myTree) {
        while (myTree != null || (!myStack.isEmpty())) {
            while (myTree != null) {
                myStack.push(myTree);
                if (!myStack.isEmpty()) {
                    MyTree _myTree = myStack.pop();
                    System.out.println(_myTree.value);
                    myTree = _myTree.right;
                }
            }
        }
    }

    public void levelOrder(MyTree myTree) {
        Queue<MyTree> queue = new LinkedList<MyTree>();
        if (myTree == null) {
            return;
        }
        queue.offer(myTree);
        while (!queue.isEmpty()) {
            myTree = queue.poll();
            System.out.println(myTree.value);
            if (myTree.left != null) {
                queue.offer(myTree.left);
            }
            if (myTree.right != null) {
                queue.offer(myTree.right);
            }
        }
    }
}
