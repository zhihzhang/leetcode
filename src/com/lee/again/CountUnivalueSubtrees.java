package com.lee.again;

import com.lee.common.TreeNode;

public class CountUnivalueSubtrees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int count = 0;

	public int countUnivalSubtrees(TreeNode root) {
		get(root);
		return count;
	}

	public Integer get(TreeNode root) {
		if (root == null) {
			return null;
		}
		Integer l = get(root.left);
		Integer r = get(root.right);

		return null;
	}

}
