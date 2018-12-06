package com.lee.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LowestAncestor236 {

	public static void main(String[] args) {
		LowestAncestor236 obj = new LowestAncestor236();
		
		List<Integer> t = new ArrayList<Integer>();
		t.add(5);
		t.add(6);
		t.add(7);
		t = t.subList(0, 2);
		System.out.println(t.size());

	}

	List<Integer> keys = new ArrayList<Integer>();
	Map<Integer, List<TreeNode>> map = new HashMap<Integer, List<TreeNode>>();

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		List<TreeNode> list = new ArrayList<TreeNode>();
		keys.add(p.val);
		keys.add(q.val);
		traverse(root, list);
		List<TreeNode> a = map.get(p.val);
		List<TreeNode> b = map.get(q.val);
		for (int i = b.size() - 1; i >= 0; i--) {
			TreeNode node = b.get(i);
			if (a.contains(node)) {
				return node;
			}
		}
		return root;
	}

	public void traverse(TreeNode root, List<TreeNode> list) {
		if (root == null) {
			return;
		}
		list.add(root);
		if (keys.contains(root.val)) {
			List<TreeNode> a = new ArrayList<TreeNode>();
			a.addAll(list);
			map.put(root.val, a);
			if (map.size() >= 2) {
				return;
			}
		}
		// List<TreeNode> left = new ArrayList<TreeNode>();
		// left.addAll(list);
		int s = list.size();
		traverse(root.left, list);
		list = list.subList(0, s);
		// List<TreeNode> right = new ArrayList<TreeNode>();
		// right.addAll(list);
		traverse(root.right, list);
		list = list.subList(0, s - 1);
	}

}
