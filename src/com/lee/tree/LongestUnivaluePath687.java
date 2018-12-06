package com.lee.tree;

public class LongestUnivaluePath687 {

	public static void main(String[] args) {
		LongestUnivaluePath687 obj = new LongestUnivaluePath687();

	}

	private int max = 1;

	public int longestUnivaluePath(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int r = traverse(root, root.val);
		max = Math.max(r, max);
		return max - 1;
	}

	public int traverse(TreeNode node, int k) {
		if (node == null) {
			return 0;
		}
		if (node.val != k) {
			int l = traverse(node.left, node.val);
			int r = traverse(node.right, node.val);
			max = Math.max(l + r + 1, max);
			return 0;
		} else {
			int l = traverse(node.left, k);
			int r = traverse(node.right, k);
			max = Math.max(l + r + 1, max);
			return Math.max(l, r) + 1;
		}
	}

}
