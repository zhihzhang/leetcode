package com.lee.again;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaxStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	LinkedList<Integer> list = new LinkedList<>();
	Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
	
	/** initialize your data structure here. */
    public MaxStack() {
        
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
    
    public int peekMax() {
        return queue.peek();
    }
    
    public int popMax() {
        int max = queue.poll();
        list.remove((Object)max);
        return max;
    }

}
