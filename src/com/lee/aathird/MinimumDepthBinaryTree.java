package com.lee.aathird;

import com.lee.common.TreeNode;

public class MinimumDepthBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		} else if (root.left == null) {
			return minDepth(root.right) + 1;
		} else if (root.right == null) {
			return minDepth(root.left) + 1;
		} else {
			int l = minDepth(root.left);
			int r = minDepth(root.right);
			return Math.min(l, r) + 1;
		}
	}

}
