package com.lee.again;

import com.lee.common.TreeNode;

public class CountCompleteTreeNodes222 {
	public static void main(String[] args) {
		CountCompleteTreeNodes222 obj = new CountCompleteTreeNodes222();

	}

	public int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int lefta = getLeft(root.left);
		if (lefta == 0) {
			return 1;
		}
		int leftb = getLeft(root.right);
		if (lefta == leftb) {
			return countNodes(root.right) + (int) Math.pow(2, lefta);
		} else {
			return countNodes(root.left) + (int) Math.pow(2, lefta - 1);
		}
	}

	public int getLeft(TreeNode root) {
		TreeNode t = root;
		int count = 0;
		while (t != null) {
			count++;
			t = t.left;
		}
		return count;
	}

	public int getRight(TreeNode root) {
		TreeNode t = root;
		int count = 0;
		while (t != null) {
			count++;
			t = t.right;
		}
		return count;
	}
}
