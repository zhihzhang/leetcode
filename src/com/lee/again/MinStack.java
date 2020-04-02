package com.lee.again;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

	LinkedList<Integer> list = new LinkedList<>();
	Queue<Integer> queue = new PriorityQueue<>();
	
	/** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        list.push(x);
        queue.add(x);
    }
    
    public int pop() {
		int i = list.pollFirst();
		queue.remove((Object) i);
		return i;
    }
    
    public int top() {
        return list.peekFirst();
    }
    
    public int getMin() {
        return queue.peek();
    }

}
