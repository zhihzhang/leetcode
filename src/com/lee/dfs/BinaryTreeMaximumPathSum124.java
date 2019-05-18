package com.lee.dfs;

import java.util.ArrayList;
import java.util.List;

import com.lee.common.TreeNode;

public class BinaryTreeMaximumPathSum124 {

	public static void main(String[] args) {
		BinaryTreeMaximumPathSum124 obj = new BinaryTreeMaximumPathSum124();

	}
	
	int max = Integer.MIN_VALUE;
	
    public int maxPathSum(TreeNode root) {
        sum(root);
        return max;
    }
    
    public int sum(TreeNode root) {
//    	List<Integer> list = new ArrayList<>();
    	if(root==null){
    		return 0;
//    		list.add(0);
//    		list.add(0);
//    		return list;
    	}
    	
    	
    	int left = sum(root.left);
    	int right = sum(root.right);
    	
    	int a = Math.max(left, right) + root.val;
    	a = Math.max(a, root.val);
    	int b = left + right + root.val;
    	
        max = Math.max(max, a);
        max = Math.max(max, b);
        
        return a;
        
    }

}
