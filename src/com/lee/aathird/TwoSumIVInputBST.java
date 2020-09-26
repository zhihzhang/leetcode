package com.lee.aathird;

import java.util.ArrayList;
import java.util.List;

import com.lee.common.TreeNode;

public class TwoSumIVInputBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean findTarget(TreeNode root, int k) {
		List<Integer> list = new ArrayList<>();
		traverse(root, list);
		int l = 0;
		int r = list.size() - 1;
		while (l < r) {
			int n = list.get(l) + list.get(r);
			if (n == k) {
				return true;
			} else if (n < k) {
				l++;
			} else {
				r--;
			}
		}
		return false;
	}

	public void traverse(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		traverse(root.left, list);
		list.add(root.val);
		traverse(root.right, list);
	}

}
