package com.lee.aafour;

import java.util.HashSet;
import java.util.Set;

import com.lee.common.TreeNode;

public class TwoSumIV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Set<Integer> set = new HashSet<>();

	public boolean findTarget(TreeNode root, int k) {
		if (root == null) {
			return false;
		}
		set.add(root.val);
		if (set.contains(k - root.val)) {
			return true;
		}
		boolean a = findTarget(root.left, k);
		if (a) {
			return a;
		}
		return findTarget(root.right, k);
	}

}
