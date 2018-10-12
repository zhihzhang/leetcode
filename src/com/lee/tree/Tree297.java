package com.lee.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Tree297 {

	public static void main(String[] args) {
		Tree297 obj = new Tree297();

		String k = "[1,2,3,null,null,4,5]";
		TreeNode root = obj.deserialize(k);
		System.out.println(root.val);
		System.out.println(root.left.val);
		System.out.println(root.right.val);
		System.out.println(root.right.left.val);
		System.out.println(root.right.right.val);
		
		String t = obj.serialize(root);
		System.out.println(t);
		
	}

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null) {
			return "[null]";
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
//		StringBuilder sb = new StringBuilder("[");
		List<String> list = new ArrayList<String>();
		
        queue.add(root);
        
 
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node == null) {
				list.add("null");
			} else {
				list.add(node.val + "");
			}

			if (node != null) {
				queue.add(node.left);
				queue.add(node.right);
			}
		}
		
		for (int i = list.size() - 1; i >= 0; i--) {
			if (list.get(i).equals("null")) {
				list.remove(i);
			} else {
				break;
			}
		}
		return Arrays.toString(list.toArray());

	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if(data.equals("[]") || data.equals("[null]")){
			return null;
		}

		data = data.replace("[", "");
		data = data.replace("]", "");
		String[] array = data.split(",");
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode root = new TreeNode(Integer.valueOf(array[0]));
		
		queue.add(root);
		int i = 1;
		
		while (!queue.isEmpty()) {
			if (i == array.length) {
				break;
			}
			
			TreeNode node = queue.poll();
			
			String s = array[i++];
			if (!s.equals("null")) {
				TreeNode left = new TreeNode(Integer.valueOf(s));
				node.left = left;
				queue.add(left);
			}
			
			if (i == array.length) {
				break;
			}
			
			s = array[i++];
			if (!s.equals("null")) {
				TreeNode right = new TreeNode(Integer.valueOf(s));
				node.right = right;
				queue.add(right);
			}
		}
		
		
		return root;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
