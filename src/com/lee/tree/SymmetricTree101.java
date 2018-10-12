package com.lee.tree;

public class SymmetricTree101 {

	public static void main(String[] args) {
		SymmetricTree101 obj = new SymmetricTree101();

	}

	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isSymmetric(root.left, root.right);
	}
	
	public boolean isSymmetric(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}
		if ((left == null && right != null) || (left != null && right == null)) {
			return false;
		}
		if (left.val != right.val) {
			return false;
		}
		return isSymmetric(left.right, right.left) && isSymmetric(left.left, right.right);
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}