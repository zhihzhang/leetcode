package com.lee.tree;

public class InvertTree226 {

	public static void main(String[] args) {
		InvertTree226 obj = new InvertTree226();

	}
	
    public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode l = root.left;
		TreeNode r = root.right;
		root.left = invertTree(r);
		root.right = invertTree(l);
		return root;
    }

}
