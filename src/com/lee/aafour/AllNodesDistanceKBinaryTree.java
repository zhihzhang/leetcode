package com.lee.aafour;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.lee.common.TreeNode;

public class AllNodesDistanceKBinaryTree {

	public static void main(String[] args) {
		AllNodesDistanceKBinaryTree obj = new AllNodesDistanceKBinaryTree();
		

	}

	Set<Integer> set = new HashSet<>();

	public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
		traverse(root, target, K);
		List<Integer> list = new ArrayList<>();
		list.addAll(set);
		return list;
	}

	public int traverse(TreeNode root, TreeNode target, int K) {
		if (root == null) {
			return -1;
		}
		if (root.val == target.val) {
			if(K==0){
                set.add(root.val);
            }
			traverse(root.left, K - 1);
			traverse(root.right, K - 1);
			return 0;
		}
		int l = traverse(root.left, target, K);
		int r = traverse(root.right, target, K);
		int t = -1;
		if (l >= 0) {
			t = l+1;
			if (t == K) {
				set.add(root.val);
			} else if (t < K) {
				traverse(root.right, K - t -1);
			}
		} else if (r >= 0) {
			t = r+1;
			if (t == K) {
				set.add(root.val);
			} else if (t < K) {
				traverse(root.left, K - t -1);
			}
		} else {
			return -1;
		}

		return t;
	}

	public void traverse(TreeNode root, int K) {
		if (root == null) {
			return;
		}
		if (K == 0) {
			set.add(root.val);
			return;
		}
		traverse(root.left, K - 1);
		traverse(root.right, K - 1);
	}

}
