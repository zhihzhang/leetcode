package com.lee.againt;

public class DistributeCoinsinBinaryTree {

	public static void main(String[] args) {
		DistributeCoinsinBinaryTree obj = new DistributeCoinsinBinaryTree();
		TreeNode root = new TreeNode(3);
		TreeNode left = new TreeNode(0);
		TreeNode right = new TreeNode(0);
		root.left = left;
		root.right = right;
		int t = obj.distributeCoins(root);
		System.out.println(t);

	}
	
	int count = 0;

	public int distributeCoins(TreeNode root) {
		distribute(root);
		return count;
	}
	
	public int distribute(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int v = root.val;
		int l = distribute(root.left);
		int r = distribute(root.right);
		count += Math.abs(v + l + r - 1);
		return v + l + r - 1;
	}

}
