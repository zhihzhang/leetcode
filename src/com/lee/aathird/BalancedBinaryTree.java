package com.lee.aathird;

import java.util.concurrent.atomic.AtomicInteger;

import com.lee.common.TreeNode;

public class BalancedBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isBalanced(TreeNode root) {
		AtomicInteger length = new AtomicInteger();
		return check(root, length);
	}

	public boolean check(TreeNode root, AtomicInteger length) {
		if (root == null) {
			length.set(0);
			return true;
		}
		AtomicInteger l = new AtomicInteger();
		AtomicInteger r = new AtomicInteger();
		boolean a = check(root.left, length);
		boolean b = check(root.right, length);
		if (a && b) {
			if (Math.abs(l.get() - r.get()) > 1) {
				return false;
			}
			length.set(Math.max(l.get(), r.get()) + 1);
			return true;
		}
		return false;
	}

}
