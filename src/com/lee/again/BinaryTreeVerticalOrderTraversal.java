package com.lee.again;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import com.lee.common.TreeNode;

public class BinaryTreeVerticalOrderTraversal {

	public static void main(String[] args) {
		BinaryTreeVerticalOrderTraversal obj = new BinaryTreeVerticalOrderTraversal();

	}

	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		TreeMap<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
		Queue<List> queue = new LinkedList<>();

		List l = new ArrayList();
		l.add(root);
		l.add(0);
		queue.add(l);

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				List li = queue.poll();
				TreeNode node = (TreeNode) li.get(0);
				int v = (int) li.get(1);
				
				if(!map.containsKey(v)){
					map.put(v, new ArrayList<Integer>());
				}else{
					map.get(v).add(node.val);
				}
				

				if (node.left != null) {
					List lis = new ArrayList();
					lis.add(node.left);
					lis.add(v - 1);
					queue.add(lis);
				}
				if (node.right != null) {
					List lis = new ArrayList();
					lis.add(node.right);
					lis.add(v + 1);
					queue.add(lis);
				}
			}
		}
		result.addAll(map.values());

		return result;
	}

}
