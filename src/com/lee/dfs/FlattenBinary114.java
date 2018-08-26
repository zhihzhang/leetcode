package com.lee.dfs;

import com.lee.common.TreeNode;

public class FlattenBinary114 {

	public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
          
        morrisTraversal(root);

	}
	
	public static void morrisTraversal(TreeNode root) {
		TreeNode temp = null;
		TreeNode current = root;
		while (current != null) {
			if (current.left != null) {
				// connect threading for root
				temp = current.left;
				while (temp.right != null && temp.right != current) {
					temp = temp.right;
				}
				// the threading already exists
				if (temp.right == null) {
					// construct the threading
					temp.right = current;
					current = current.left;
				} else {
					temp.right = null;
					System.out.println(current.val);
					current = current.right;
				}
			} else {
				System.out.println(current.val);
				current = current.right;
			}
		}
	}

}
