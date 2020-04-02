package com.lee.again;

import java.util.LinkedList;
import java.util.Queue;

public class Vector2D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	Queue<Integer> queue = new LinkedList<>();
	
    public Vector2D(int[][] v) {
        for(int[] a :v){
        	for(int i:a){
        		queue.offer(i);
        	}
        }
    }
    
    public int next() {
        return queue.poll();
    }
    
    public boolean hasNext() {
        return !queue.isEmpty();
    }

}
