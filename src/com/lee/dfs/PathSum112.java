package com.lee.dfs;

import com.lee.common.TreeNode;

public class PathSum112 {

	public static void main(String[] args) {
		PathSum112 obj = new PathSum112();

	}
	
    public boolean hasPathSum(TreeNode root, int sum) {
        return sum(root, sum);
    }
    
	public boolean sum(TreeNode root, int target) {
		if (target < 0) {
			return false;
		}
		if (root == null) {
			return false;
		}
		if (root.val == target && root.left == null && root.right == null) {
			return true;
		}

		if (sum(root.left, target - root.val)) {
			return true;
		}
		if (sum(root.right, target - root.val)) {
			return true;
		}

		return false;
	}

}
