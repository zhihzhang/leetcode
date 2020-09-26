package com.lee.aafour;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.lee.common.TreeNode;

public class BinaryTreeInorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> inorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> list = new ArrayList<>();
		if (root != null) {
			stack.push(root);
		}
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node);
				stack.push(node.left);
				node.left = null;
				node.right = null;
			} else {
				list.add(node.val);
			}
		}
		return list;
	}

}
