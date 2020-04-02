package com.lee.againt;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodesAndReturnForest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		List<TreeNode> list = new ArrayList<>();
		list.add(root);
		if (root == null || to_delete == null || to_delete.length == 0) {
			return list;
		}
		Set<Integer> vals = new HashSet<>();
		for (int i : to_delete) {
			vals.add(i);
		}
		getNode(root, vals, list);
		return list;
	}

	public TreeNode getNode(TreeNode root, Set<Integer> vals, List<TreeNode> list) {
		if (root == null) {
			return null;
		}
		if (vals.contains(root.val)) {
			list.add(getNode(root.left, vals, list));
			list.add(getNode(root.right, vals, list));
			return null;
		}
		root.left = getNode(root.left, vals, list);
		root.right = getNode(root.right, vals, list);
		return root;
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
