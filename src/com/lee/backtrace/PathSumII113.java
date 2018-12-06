package com.lee.backtrace;

import java.util.ArrayList;
import java.util.List;

import com.lee.common.TreeNode;

public class PathSumII113 {

	public static void main(String[] args) {
		PathSumII113 obj = new PathSumII113();
		TreeNode root = new TreeNode(-2);
		TreeNode right = new TreeNode(-3);
		root.right = right;
		List<List<Integer>> r = obj.pathSum(root, -5);
		System.out.println(r.size());
		
	}

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> r = new ArrayList<>();
		List<Integer> c = new ArrayList<>();
		backTrace(root, sum, r, c);
		return r;
	}

	public void backTrace(TreeNode root, int sum, List<List<Integer>> r, List<Integer> c) {
		if(root==null){
			return;
		}
		if (sum == root.val && root.left == null && root.right == null) {
			List<Integer> n = new ArrayList<>();
			n.addAll(c);
			n.add(root.val);
			r.add(n);
			return;
		}
		
		c.add(root.val);
		System.out.println(c.size() + "  " + root.val);
		backTrace(root.left, sum - root.val, r, c);
		System.out.println(c.size() + "  " + root.val);
		c.remove(c.size()-1);
		
		c.add(root.val);
		System.out.println(c.size() + "  " + root.val);
		backTrace(root.right, sum - root.val, r, c);
		System.out.println(c.size() + "  " + root.val);
		c.remove(c.size()-1);
	}

}
