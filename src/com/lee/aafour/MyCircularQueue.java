package com.lee.aafour;

import java.util.LinkedList;

public class MyCircularQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	LinkedList<Integer> queue = new LinkedList<>();
	int k = 0;
	
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.k = k;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(queue.size()==k){
        	return false;
        }
        queue.offerLast(value);
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(queue.isEmpty()){
        	return false;
        }
        queue.poll();
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if(queue.isEmpty()){
        	return -1;
        }
        return queue.peekFirst();
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if(queue.isEmpty()){
        	return -1;
        }
        return queue.peekLast();
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return queue.isEmpty();
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return queue.size()==k;
    }

}
