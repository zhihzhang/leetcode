package com.lee.tree;

public class ValidateBinarySearchTree98 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isValidBST(TreeNode root) {
		return isValid(root, null, null);
	}
	
	public boolean isValid(TreeNode root, Integer min, Integer max) {
		if (root == null) {
			return true;
		}
		if (min != null) {
			if (root.val <= min) {
				return false;
			}
		}
		if (max != null) {
			if (root.val >= max) {
				return false;
			}
		}
		if (root.left != null && root.val < root.left.val) {
			return false;
		}
		if (root.right != null && root.val > root.right.val) {
			return false; 
		}
		return isValid(root.left,min,root.val) && isValid(root.right,root.val,max);
	}

}
