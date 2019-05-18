package com.lee.again;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.lee.common.TreeNode;

public class BinaryTreeVerticalOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		Map<Integer, List<Integer>> map = new TreeMap<>();
		traverse(root, map, 0);
		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			result.add(entry.getValue());
		}
		return result;
	}

	public void traverse(TreeNode root, Map<Integer, List<Integer>> map, int key) {
		if (root == null) {
			return;
		}
		if (map.containsKey(key)) {
			map.get(key).add(root.val);
		} else {
			List<Integer> list = new ArrayList<>();
			list.add(root.val);
			map.put(key, list);
		}

		traverse(root.left, map, key - 1);
		traverse(root.right, map, key + 1);
	}

}
