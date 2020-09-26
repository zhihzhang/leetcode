package com.lee.aathird;

import java.util.Stack;

import com.lee.common.TreeNode;

public class MaximumBinaryTree {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack.lastElement());
	}

	//3,2,1,6,0,5
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		Stack<TreeNode> stack = new Stack<>();
		for(int n: nums){
			TreeNode root = new TreeNode(n);
			TreeNode node = null;
			while(!stack.isEmpty() && stack.peek().val<n){
				node = stack.pop();
				root.left = node;
			}
			if(!stack.isEmpty()){
				stack.peek().right = root;
			}
			stack.push(root);
		}
		if(!stack.isEmpty()){
			return stack.firstElement();
		}
		return null;
	}



}
