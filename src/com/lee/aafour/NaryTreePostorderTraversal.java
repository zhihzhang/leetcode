package com.lee.aafour;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.lee.common.TreeNode;

public class NaryTreePostorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> postorder(Node root) {
		Stack<Node> stack = new Stack<>();
		List<Integer> list = new ArrayList<>();
		if (root != null) {
			stack.add(root);
		}
		while (!stack.isEmpty()) {
			Node node = stack.pop();
			if (node.children == null || node.children.size() == 0) {
				list.add(node.val);
				continue;
			}
			stack.push(node);
			int l = node.children.size() - 1;
			for (int i = l; i >= 0; i--) {
				Node n = node.children.get(i);
				stack.push(n);
			}
			node.children = null;
		}
		return list;
	}

	class Node {
		public int val;
		public List<Node> children;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	};

}
