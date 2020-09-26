package com.lee.aafour;

import java.util.ArrayList;
import java.util.List;

import com.lee.common.TreeNode;

public class UniqueBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	public List<TreeNode> generateTrees(int n) {
		List<TreeNode> list = getNode(1, n);
		return list;
	}

	public List<TreeNode> getNode(int l, int r) {
		List<TreeNode> list = new ArrayList<TreeNode>();
		for (int i = l; i <= r; i++) {

			List<TreeNode> leftList = getNode(l, i - 1);
			List<TreeNode> rightList = getNode(i + 1, r);
			if (leftList.size() == 0 && rightList.size() == 0) {
				TreeNode root = new TreeNode(i);
				list.add(root);
			} else if (leftList.size() == 0) {
				for (TreeNode node : rightList) {
					TreeNode root = new TreeNode(i);
					root.right = node;
					list.add(root);
				}

			} else if (rightList.size() == 0) {
				for (TreeNode node : leftList) {
					TreeNode root = new TreeNode(i);
					root.left = node;
					list.add(root);
				}
			} else {
				for (TreeNode right : rightList) {
					for (TreeNode left : leftList) {
						TreeNode root = new TreeNode(i);
						root.left = left;
						root.right = right;
						list.add(root);
					}
				}
			}
		}
		return list;
	}

}
