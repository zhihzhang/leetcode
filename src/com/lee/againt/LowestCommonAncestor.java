package com.lee.againt;

public class LowestCommonAncestor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	

	TreeNode node = null;

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		traverse(root, p.val, q.val);
		return node;
	}

	public int traverse(TreeNode root, int l, int r) {
		if (root == null) {
			return 0;
		}
		if (node != null) {
			return 2;
		}
		int count = 0;
		if (root.val == l || root.val == r) {
			count++;
		}
		count = count + traverse(root.left, l, r) + traverse(root.right, l, r);
		if (count == 2 && node != null) {
			node = root;
		}
		return count;
	}

}
