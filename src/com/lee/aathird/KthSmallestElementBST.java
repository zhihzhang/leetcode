package com.lee.aathird;

import java.util.ArrayList;
import java.util.List;

import com.lee.common.TreeNode;

public class KthSmallestElementBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
//    5
//   / \
//  3   6
// / \
//2   4
///
//1

	int k = 0;
	int count = 0;
	int n = -1;

	public int kthSmallest(TreeNode root, int k) {
		this.k = k;
		traverse(root);
		return n;
	}

	public void traverse(TreeNode root) {
		if (root == null) {
			return;
		}
		traverse(root.left);
		if (count == k) {
			return;
		}
		count++;
		if (count == k) {
			n = root.val;
			return;
		}
		traverse(root.right);
	}

}
