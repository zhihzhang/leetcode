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
		TreeNode root = obj.constructFromPrePost(new int[] { 1, 2, 4, 5, 3, 6, 7 }, new int[] { 4, 5, 2, 6, 7, 3, 1 });
		obj.print(root);
	}
	//
	// 2 4 5
	// 4 5 2

	public TreeNode constructFromPrePost(int[] pre, int[] post) {
		if (pre == null || pre.length == 0) {
			return null;
		}

		TreeNode root = new TreeNode(pre[0]);
		if (pre.length == 1) {
			return root;
		}
		int leftRoot = pre[1];
		int postIndex = -1;
		for (int i = 0; i < post.length; i++) {
			if (post[i] == leftRoot) {
				postIndex = i;
				break;
			}
		}

		root.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, postIndex + 2),
				Arrays.copyOfRange(post, 0, postIndex + 1));
		root.right = constructFromPrePost(Arrays.copyOfRange(pre, postIndex + 2, pre.length),
				Arrays.copyOfRange(post, postIndex + 1, pre.length - 1));

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
