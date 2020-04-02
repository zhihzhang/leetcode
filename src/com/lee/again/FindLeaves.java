package com.lee.again;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import com.lee.common.TreeNode;

public class FindLeaves {

	public static void main(String[] args) {
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		one.right = two;
//		one.right = three;
//		two.left = four;
//		two.right = five;
		FindLeaves obj = new FindLeaves();
		obj.findLeaves(one);
	}

	public List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}

		List<TreeNode> list = new ArrayList<>();
		list.add(root);
		int i = 0;
		while (i < list.size()) {
			TreeNode node = list.get(i);
			if (node.left != null) {
				list.add(node.left);
			}
			if (node.right != null) {
				list.add(node.right);
			}
			i++;
		}

		int height = 0;
		TreeNode node = root;
		while (node != null) {
			height++;
			node = node.left;
		}

		int t = (int) Math.pow(2, height);
		int treeSize = t - 1;
		int layerSize = t / 2;

		int d = treeSize - list.size();
		int size = layerSize - (d + 1) / 2;

		int fromIndex = list.size() - size;
		int toIndex = list.size();

		// 1
		// 2 7
		// xx ss
		while (height > 0) {
			List<Integer> tList = new ArrayList<>();
			int k = fromIndex;
			while(k<toIndex){
				tList.add(list.get(k).val);
				k++;
			}
			result.add(tList);
			height--;
			treeSize = treeSize - layerSize;
			layerSize = layerSize / 2;
			d = treeSize - fromIndex;
			size = layerSize - (d + 1) / 2;
			toIndex = fromIndex;
			fromIndex = fromIndex - size;
		}

		System.out.println(result.toString());
		return result;

	}

}
