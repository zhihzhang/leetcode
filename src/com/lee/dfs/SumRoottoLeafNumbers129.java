package com.lee.dfs;

import com.lee.common.TreeNode;

public class SumRoottoLeafNumbers129 {

	public static void main(String[] args) {
		SumRoottoLeafNumbers129 obj = new SumRoottoLeafNumbers129();

	}
	
	long total = 0;
	
    public int sumNumbers(TreeNode root) {
    	sumN(root, 0);
    	return (int)total;
    }
    
    public void sumN(TreeNode root, long sum){
		if (root == null) {
			return;
		}
		sum = sum * 10 + root.val;
		if (root.left == null && root.right == null) {
			total = total + sum;
		}
		sumN(root.left, sum);
		sumN(root.right, sum);
    }

}
