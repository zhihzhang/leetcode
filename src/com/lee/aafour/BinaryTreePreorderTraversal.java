package com.lee.aafour;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.lee.common.TreeNode;

public class BinaryTreePreorderTraversal {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> preorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> list = new ArrayList<>();
		if (root != null) {
			stack.add(root);
		}
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			list.add(node.val);
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
		}
		return list;
	}
}
