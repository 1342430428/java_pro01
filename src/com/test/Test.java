package com.test;

public class Test {
    public static void main(String[] args) throws Exception {
        MyTree myTree1 = new MyTree();
        myTree1.value = 3;
        MyTree myTree2 = new MyTree();
        myTree2.value = 1;
        MyTree myTree3 = new MyTree();
        myTree3.value = 4;
        MyTree myTree4 = new MyTree();
        myTree4.value = 6;
        MyTree myTree5 = new MyTree();
        myTree5.value = 8;
        myTree1.left = myTree2;
        myTree1.right = myTree3;
        myTree2.left = myTree4;
        myTree4.right = myTree5;
        AllOrder allOrder = new AllOrder();
        //allOrder.preStackOrder(myTree1);
        //allOrder.inStackOrder(myTree1);
        allOrder.levelOrder(myTree1);
    }
}
