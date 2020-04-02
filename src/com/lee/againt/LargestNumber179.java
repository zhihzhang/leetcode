package com.lee.againt;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LargestNumber179 {

	public static void main(String[] args) {
		LargestNumber179 obj = new LargestNumber179();
		int[] nums = new int[]{3,30,34,9,5};
		System.out.println(obj.largestNumber(nums));
	}
	
	public String largestNumber(int[] nums) {
		Comparator c = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				String s1 = o1 + "" + o2;
				String s2 = o2 + "" + o1;
				int a = Integer.valueOf(s1);
				int b = Integer.valueOf(s2);
				if (a <= b) {
					return 1;
				}
				return -1;
			}
		};
		Queue<Integer> queue = new PriorityQueue<>(c);
		for (int n : nums) {
			queue.offer(n);
		}
		StringBuilder sb = new StringBuilder();
		while (!queue.isEmpty()) {
			int w = queue.poll();
			if(sb.length()==0 && w==0){
				continue;
			}
			sb.append(w);
		}
		if(sb.length()==0){
			return "0";
		}
		return sb.toString();
	}

}
