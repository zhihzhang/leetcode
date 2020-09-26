package com.lee.aafour;

import com.lee.common.TreeNode;

public class CountCompleteTreeNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int count = 0;
		int left = getDepth(root.left);
		int right = getDepth(root.right);
		if(left==right){
			count = (int) (Math.pow(2, left) + countNodes(root.right));
		}else{
			count = (int) (Math.pow(2, right) + countNodes(root.left));
		}
		return count;

	}

	public int getDepth(TreeNode root) {
		int count = 0;
		while (root != null) {
			count++;
			root = root.left;
		}
		return count;
	}

}
