package com.lee.aathird;

import java.util.ArrayList;
import java.util.List;

import com.lee.common.TreeNode;

public class BinaryTreePaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		if (root.left == null && root.right == null) {
			list.add(root.val + "");
			return list;
		}
		traverse(root.left, root.val + "", list);
		traverse(root.right, root.val + "", list);
		return list;
	}

	public void traverse(TreeNode root, String s, List<String> list) {
		if(root==null){
			return;
		}
		if (root.left == null && root.right == null) {
			list.add(s + "->" + root.val);
		}
		traverse(root.left, s + "->" + root.val, list);
		traverse(root.right, s + "->" + root.val, list);
	}

}
