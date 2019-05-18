package com.lee.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class NestedList364 {

	public static void main(String[] args) {
		NestedList364 obj = new NestedList364();

	}

	public int depthSumInverse(List<NestedInteger> nestedList) {
		if (nestedList == null){
			return 0;
		}
		Queue<NestedInteger> queue = new LinkedList<NestedInteger>();
		for (NestedInteger next : nestedList) {
			queue.offer(next);
		}

		Stack<Integer> stack = new Stack<>();

		while (!queue.isEmpty()) {
			int size = queue.size();
			int levelSum = 0;
			for (int i = 0; i < size; i++) {
				NestedInteger current = queue.poll();
				if (current.isInteger()) {
					levelSum += current.getInteger();
				}
				List<NestedInteger> nextList = current.getList();
				if (nextList != null) {
					for (NestedInteger next : nextList) {
						queue.offer(next);
					}
				}
			}
			stack.add(levelSum);
			// prev += levelSum;
			// total += prev;
		}
		int sum = 0;
		int l = 1;
		while (!stack.isEmpty()) {
			int t = stack.pop();
			sum = sum + l * t;
			l++;
		}
		return sum;
	}

	// int sum = 0;
	//
	// public int depthSumInverse(List<NestedInteger> nestedList) {
	// Queue<NestedInteger> queue = new LinkedList<>();
	// int sum = 0;
	// Map<NestedInteger, Integer> map = new HashMap<>();
	// for(NestedInteger ni : nestedList){
	// queue.offer(ni);
	// map.put(ni, 1);
	// }
	// while(!queue.isEmpty()){
	// NestedInteger ni = queue.poll();
	// if(!ni.isInteger()){
	// for(NestedInteger child : ni.getList()){
	// queue.offer(child);
	// }
	// }
	// }
	// }
	//
	// public int depthSumInverse(List<NestedInteger> nestedList) {
	// int max = 1;
	// for (NestedInteger ni : nestedList) {
	// if (!ni.isInteger()) {
	// int d = depthSumInverse(ni.getList());
	// max = Math.max(d + 1, max);
	// }
	// }
	// for (NestedInteger ni : nestedList) {
	// if (ni.isInteger()) {
	// sum = sum + ni.getInteger() * max;
	// }
	// }
	// return max;
	// }

	// public int calc(NestedInteger ni) {
	// int max = 1;
	// if (!ni.isInteger()) {
	// for (NestedInteger n : ni.getList()) {
	// int d = calc(n);
	// max = Math.max(max, d + 1);
	// }
	// return sum;
	// }
	// for (int i : list) {
	// sum = sum + i * max;
	// }
	// return max;
	//
	// }

}
