package com.lee.againt;

import java.util.Arrays;

import com.lee.common.TreeNode;

public class ConstructBinaryTree {
	// 1
	// 2 3
	// 4 5 6 7

	// Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
	// Output: [1,2,3,4,5,6,7]

	public static void main(String[] args) {
		int[] nums = new int[] { 4, 5, 2, 6, 7, 3, 1 };
		System.out.println(Arrays.binarySearch(nums, 2));
		// int[] t = Arrays.copyOfRange(nums, 3, 6);
		// System.out.println(Arrays.toString(t));

		ConstructBinaryTree obj = new ConstructBinaryTree();
//		TreeNode root01 = obj.constructFromPrePost(new int[] { 1, 2, 4, 5, 3, 6, 7 }, new int[] { 4, 5, 2, 6, 7, 3, 1 });
//		TreeNode root02 = obj.constructFromPrePost(new int[] { 1, 2 }, new int[] { 2, 1 });
		TreeNode root02 = obj.constructFromPrePost(new int[] { 1,3,2,4 }, new int[] { 3,4,2,1 });
//		obj.print(root01);
		obj.print(root02);
	}
	//
	// 2 4 5
	// 4 5 2

	public TreeNode constructFromPrePost(int[] pre, int[] post) {
		if (pre == null || pre.length == 0) {
			return null;
		}
		int length = pre.length;
		return construct(pre, post, 0, 0, length);
	}

	//pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
	//pre = [1,2,4,3,6,7], post = [4,2,6,7,3,1]
	// [1,3,2,4] [3,4,2,1]
	public TreeNode construct(int[] pre, int[] post, int l0, int l1, int length) {
		if (length < 1) {
			return null;
		}
		TreeNode root = new TreeNode(pre[l0]);
		if (length == 1) {
			return root;
		}
		int v = pre[l0 + 1];
		int idx = 0;
		for (int i = l1; i < l1 + length; i++) {
			if (post[i] == v) {
				idx = i;
				break;
			}
		}
		int leftLength = idx - l1 + 1;
		root.left = construct(pre, post, l0 + 1, l1, leftLength);
		int rightLength = length - leftLength - 1;
		root.right = construct(pre, post, l0 + leftLength + 1, l1 + leftLength, rightLength);
		return root;
	}

	public void print(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val);
		print(root.left);
		print(root.right);

	}

}

// class TreeNode {
// int val;
// TreeNode left;
// TreeNode right;
//
// TreeNode(int x) {
// val = x;
// }
// }
