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
		List<Integer> del = new ArrayList<>();
		for (int n : to_delete) {
			del.add(n);
		}
		List<TreeNode> list = new ArrayList<>();
		getNodes(root, del, list, null);
		return list;

	}

	public TreeNode getNodes(TreeNode root, List<Integer> del, List<TreeNode> list, TreeNode parent) {
		if (root == null) {
			return null;
		}

		if (del.contains(root.val)) {
			getNodes(root.left, del, list, null);
			getNodes(root.right, del, list, null);
			return null;
		} else {
			if (parent == null) {
				list.add(root);
			}
			root.left = getNodes(root.left, del, list, root);
			root.right = getNodes(root.right, del, list, root);
			return root;
		}
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
