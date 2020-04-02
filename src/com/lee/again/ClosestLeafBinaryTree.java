package com.lee.again;

import java.util.HashMap;
import java.util.Map;

import com.lee.common.TreeNode;

public class ClosestLeafBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int min = Integer.MAX_VALUE;
	Map<Integer, Integer> map = new HashMap<>();

//	public int findClosestLeaf(TreeNode root, int k) {
//		findClosest(root, k);
//		return min;
//	}
//
//	public int findClosest(TreeNode root, int k) {
//		if (root == null) {
//			return Integer.MAX_VALUE;
//		}
//		if (root.val == k) {
//			int v = findLeaf(root);
//			min = Math.min(min, v);
//			return 0;
//		}
//		int l = findClosest(root.left, k);
//		int r = findClosest(root.right, k);
//		if (l == Integer.MAX_VALUE && r == Integer.MAX_VALUE) {
//			return l;
//		}
//		if (l < Integer.MAX_VALUE) {
//			int x = findLeaf(root.right);
//			min = Math.min(min, l + x);
//			return l + 1;
//		} else {
//			int x = findLeaf(root.left);
//			min = Math.min(min, r + x);
//			return r + 1;
//		}
//	}
//
//	public int[] findLeaf(TreeNode root) {
//		if (root == null) {
//			return new int[]{Integer.MAX_VALUE,0}
//		}
//		if (root.left == null && root.right == null) {
//			return new int[]{0,root.val};
//		}
//		if (map.containsKey(root.val)) {
//			return map.get(root.val);
//		}
//		int x = 0;
//		if (root.left == null) {
//			x = findLeaf(root.right);
//		} else if (root.right == null) {
//			x = findLeaf(root.left);
//		} else {
//			x = Math.min(findLeaf(root.left), findLeaf(root.right));
//		}
//		map.put(root.val, x);
//		return x;
//	}

}
