package com.lee.aafour;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.lee.common.TreeNode;

public class LowestAncestor236 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	TreeNode an = null;

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		traverse(root, p.val, q.val);
		return an;
	}
	
	public Set<Integer> traverse(TreeNode root, int a, int b) {
		Set<Integer> set = new HashSet<>();
		if (root == null) {
			return set;
		}
		Set<Integer> left = traverse(root.left, a, b);
		if(an!=null){
			return set;
		}
		Set<Integer> right = traverse(root.right, a, b);
		if(an!=null){
			return set;
		}
		set.addAll(left);
		set.addAll(right);
		if(root.val==a || root.val==b){
            set.add(root.val);
        }
		if (an == null && set.size() == 2) {
			an = root;
			return set;
		}
		return set;
	}

//	public Set<Integer> traverse(TreeNode root, int a, int b) {
//		Set<Integer> set = new HashSet<>();
//		if (root == null) {
//			return set;
//		}
//		set.add(root.val);
//		Set<Integer> left = traverse(root.left, a, b);
//		if (an != null) {
//			return set;
//		}
//		set.addAll(left);
//		if (set.size() == 2) {
//			an = root;
//			return set;
//		}
//		Set<Integer> right = traverse(root.right, a, b);
//		if (an != null) {
//			return set;
//		}
//		set.addAll(right);
//		if (set.size() == 2) {
//			an = root;
//			return set;
//		}
//		return set;
//	}

}
