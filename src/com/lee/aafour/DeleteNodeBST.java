package com.lee.aafour;

import com.lee.common.TreeNode;

public class DeleteNodeBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode deleteNode(TreeNode root, int key) {
		TreeNode mock = new TreeNode(-1);
		mock.left = root;
		deleteNode(root, key, mock, true);
		return mock.left;
	}

	public void deleteNode(TreeNode root, int key, TreeNode pre, boolean isLeft) {
		if(root==null){
			return;
		}
		if (key == root.val) {
			if (root.right == null) {
				if (isLeft) {
					pre.left = root.left;
				} else {
					pre.right = root.left;
				}
			} else {
				TreeNode node = root.right;
				while (node.left != null) {
					node = node.left;
				}
				node.left = root.left;
				if (isLeft) {
					pre.left = root.right;
				} else {
					pre.right = root.right;
				}
			}
		} else if (key < root.val) {
			deleteNode(root.left, key, root, true);
		} else {
			deleteNode(root.right, key, root, false);
		}
	}

}
