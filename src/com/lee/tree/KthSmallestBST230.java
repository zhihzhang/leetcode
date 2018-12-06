package com.lee.tree;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestBST230 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	List<Integer> list = new ArrayList<Integer>();

	public int kthSmallest(TreeNode root, int k) {
		traverse(root, k);
		return list.get(k-1);
	}

	public void traverse(TreeNode root, int k) {
		if (root == null) {
			return;
		}
		traverse(root.left, k);
		if (list.size() >= k) {
			return;
		}
		list.add(root.val);
		if (list.size() >= k) {
			return;
		}
		traverse(root.right, k);
	}

}
