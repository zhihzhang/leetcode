package com.lee.aafour;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.lee.common.TreeNode;

public class HouseRobberIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int rob(TreeNode root) {
		if (root == null) {
			return 0;
		}
		List<Integer> dp = new ArrayList<>();
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (queue.isEmpty()) {
			int l = queue.size();
			int sum = 0;
			for (int i = 0; i < l; i++) {
				TreeNode node = queue.poll();
				sum += node.val;
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			if (dp.size() == 0) {
				dp.add(sum);
			} else if (dp.size() == 1) {
				int v = Math.max(dp.get(0), sum);
				dp.add(v);
			} else {
				int v0 = dp.get(dp.size() - 2);
				int v1 = dp.get(dp.size() - 1);
				int v = Math.max(v0, v1);
				dp.add(v);
			}
		}
		return dp.get(dp.size() - 1);
	}

}
