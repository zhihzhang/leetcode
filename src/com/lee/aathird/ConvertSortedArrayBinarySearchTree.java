package com.lee.aathird;

import com.lee.common.TreeNode;

public class ConvertSortedArrayBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
//	-10,-3,0,5,9
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		int l = 0;
		int r = nums.length - 1;
		return convert(nums, l, r);
	}

	public TreeNode convert(int[] nums, int l, int r) {
		if (l > r) {
			return null;
		}
		int m = l + (r - l) / 2;
		TreeNode root = new TreeNode(nums[m]);
		root.left = convert(nums, l, m - 1);
		root.right = convert(nums, m + 1, r);
		return root;
	}

}
