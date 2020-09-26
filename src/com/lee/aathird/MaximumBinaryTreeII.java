package com.lee.aathird;

import com.lee.common.TreeNode;

public class MaximumBinaryTreeII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public TreeNode insertIntoMaxTree(TreeNode root, int val) {
		if (root == null || val > root.val) {
			TreeNode n = new TreeNode(val);
			n.left = root;
			return n;
		}
		root.right = insertIntoMaxTree(root.right, val);
		return root;
	}
    

}
