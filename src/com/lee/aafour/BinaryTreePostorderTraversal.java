package com.lee.aafour;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.lee.common.TreeNode;

public class BinaryTreePostorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> postorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> list = new ArrayList<>();
		if (root != null) {
			stack.add(root);
		}
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if (node.left == null && node.right == null) {
				list.add(node.val);
			} else {
				stack.push(node);
			}
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
			node.left = null;
			node.right = null;
		}
		return list;
	}

}
