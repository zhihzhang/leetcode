package com.lee.tree;

public class InvertTree226 {

	public static void main(String[] args) {
		InvertTree226 obj = new InvertTree226();

	}

	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode left = root.left;
		root.left = invertTree(root.right);
		
		root.right = invertTree(left);
		return root;
	}

}
