package com.lee.aafour;

import java.util.LinkedList;

import com.lee.common.TreeNode;

public class SumLeftLeaves {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
    	if(root==null){
    		return 0;
    	}
    	explore(root, false);
        return sum;
    }
    
    public void explore(TreeNode node, boolean isLeft){
    	if(node==null){
    		return;
    	}
    	if(isLeft && node.left==null && node.right==null){
    		sum += node.val;
    	}
    	explore(node.left, true);
    	explore(node.right, false);
    }

}
