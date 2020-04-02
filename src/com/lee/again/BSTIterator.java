package com.lee.again;

import com.lee.common.TreeNode;

public class BSTIterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	TreeNode head = null;
	TreeNode tail = null;

	public BSTIterator(TreeNode root) {
		getList(root);
	}

	public void getList(TreeNode root) {
		if (root == null) {
			return;
		}
		
		getList(root.left);
		if (head == null) {
			head = root;
		} else {
			tail.right = root;
		}
		tail = root;
		
		getList(root.right);
	}

	/** @return the next smallest number */
	public int next() {
		int v = head.val;
		head = head.right;
		return v;
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		if (head == null) {
			return false;
		}
		return true;
	}

}
