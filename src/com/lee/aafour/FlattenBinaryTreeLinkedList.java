package com.lee.aafour;

import com.lee.common.TreeNode;

public class FlattenBinaryTreeLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void flatten(TreeNode root) {
		TreeNode t = flat(root);
		root = t;
	}

	public TreeNode flat(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode a = flat(root.left);
		TreeNode b = flat(root.right);
		if (a != null) {
			root.right = a;
			TreeNode t = a;
			while(t.right!=null){
				t = t.right;
			}
			t.right = b;
			a.left = null;
		} else {
			root.right = b;
		}
		if(b!=null){
			b.left = null;
		}
		root.left = null;
		return root;
	}

}
