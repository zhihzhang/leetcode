package com.lee.aathird;

import java.util.LinkedList;
import java.util.Queue;

import com.lee.common.TreeNode;

public class FindBottomLeftTreeValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findBottomLeftValue(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int n = 0;
		while (!queue.isEmpty()) {
			int s = queue.size();
			n = queue.peek().val;
			for (int i = 0; i < s; i++) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
		}
		return n;
	}

}
