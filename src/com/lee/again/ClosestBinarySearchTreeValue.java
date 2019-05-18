package com.lee.again;

import com.lee.common.TreeNode;

public class ClosestBinarySearchTreeValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int closestValue(TreeNode root, double target) {
		int v = Integer.MAX_VALUE;
		double diff = Long.MAX_VALUE;
		while (root != null) {
			double d = Math.abs(target - root.val);
			if (d < diff) {
				diff = d;
				v = root.val;
			}

			if (root.val > target) {
				root = root.left;
			} else {
				root = root.right;
			}
		}
		return v;
	}

}
