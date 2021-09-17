package com.test;

public class MyQueue {
    public int[] queue;
    public int front;
    public int rear;

    MyQueue(int capacity) {
        this.queue = new int[capacity];
    }

    public void inQueue(int element) throws Exception {
        if (((rear + 1) % queue.length) == front) {
            throw new ArrayIndexOutOfBoundsException("队列达到最大容量!");
        }
        queue[rear] = element;
        rear = (rear + 1) % queue.length;
    }

    public int deQueue() throws Exception{
        if(front == rear){
            throw new Exception("队列已空！");
        }
        int temp = queue[front];
        front = (front + 1) % queue.length;
        return temp;
    }
    public void outQueue(){
        for(int i = front; i != rear; i = (i + 1) % queue.length){
            System.out.println(queue[i]);
        }
    }
}
