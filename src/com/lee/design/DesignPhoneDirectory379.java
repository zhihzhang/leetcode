package com.lee.design;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class DesignPhoneDirectory379 {

	public static void main(String[] args) {
		DesignPhoneDirectory379 obj = new DesignPhoneDirectory379(123);
	}
	
	private Set<Integer> set;
	private Queue<Integer> queue;
	private int max;
	private int i;;

	/**
	 * Initialize your data structure here
	 * 
	 * @param maxNumbers
	 *            - The maximum numbers that can be stored in the phone
	 *            directory.
	 */
	public DesignPhoneDirectory379(int maxNumbers) {
		set = new HashSet<>(maxNumbers);
		queue = new LinkedList<>();
		max = maxNumbers;
		i = 0;
	}	

	/**
	 * Provide a number which is not assigned to anyone.
	 * 
	 * @return - Return an available number. Return -1 if none is available.
	 */
	public int get() {
		if(!queue.isEmpty()){
			int t = queue.poll();
			set.add(t);
			return t;
		}
		if(i>=max-1){
			return -1;
		}
		set.add(i);
		i++;
		return (i-1);
	}

	/** Check if a number is available or not. */
	public boolean check(int number) {
		return set.contains(number);
	}

	/** Recycle or release a number. */
	public void release(int number) {
		set.remove(number);
		queue.add(number);
	}

}
