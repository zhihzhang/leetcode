package com.lee.aathird;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.lee.common.TreeNode;

public class BinaryTreeLevelOrderTraversalII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> r = new ArrayList<>();
		if (root == null) {
			return r;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			List<Integer> list = new ArrayList<>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				list.add(node.val);
				r.add(list);
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
		}
		Collections.reverse(r);
		return r;
	}

}
