package com.lee.dp;

public class ReversePair493 {

	public static void main(String[] args) {
		ReversePair493 obj = new ReversePair493();
		int[] numbers1 = { 2, 4, 3, 5, 1 };
		int total = obj.reversePairs(numbers1);
		System.out.println(total);
		
		int[] numbers2 = { 1,3,2,3,1};
		total = obj.reversePairs(numbers2);
		System.out.println(total);
		
		int[] numbers3 = { -5, -5};
		total = obj.reversePairs(numbers3);
		System.out.println(total);
		
		int[] numbers4 = {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
		total = obj.reversePairs(numbers4);
		System.out.println(total);
	}

	public int reversePairs(int[] nums) {
		if (nums.length <= 1) {
			return 0;
		}
		long total = 0;
		Node head = new Node();
		head.value = nums[0];
		for (int i = 1; i < nums.length; i++) {
			long value = nums[i];
			addToTree(value, head);
			total = total + searchTree(value * 2, head);
			if (value < 0) {
				total = total - 1;
			}
		}
		return (int) total;
	}

	
	public long searchTree(long v, Node head) {
		if (head == null) {
			return 0;
		}
		if (v == head.value) {
			return searchTree(v, head.right);
		} else if (v > head.value) {
			return searchTree(v, head.right) ;
		} else {
			return head.count + searchTree(v, head.right) + searchTree(v, head.left);
		}
	}

	public void addToTree(long v, Node head) {
		if (v == head.value) {
			head.count++;
		} else if (v < head.value) {
			if (head.left == null) {
				Node node = new Node();
				node.value = v;
				head.left = node;
			} else {
				addToTree(v, head.left);
			}
		} else {
			if (head.right == null) {
				Node node = new Node();
				node.value = v;
				head.right = node;
			} else {
				addToTree(v, head.right);
			}
		}
	}

}

class Node {
	public Node left;
	public Node right;
	public long value;
	public long count = 1; // duplicate numbers
}
