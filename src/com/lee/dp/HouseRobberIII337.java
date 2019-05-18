package com.lee.dp;

import java.util.HashMap;
import java.util.Map;

import com.lee.common.TreeNode;

public class HouseRobberIII337 {

	public static void main(String[] args) {
		HouseRobberIII337 obj = new HouseRobberIII337();

	}
	
	Map<TreeNode, Integer> map = new HashMap<>();
	
    public int rob(TreeNode root) {
        return getSum(root);
    }
    
	public int getSum(TreeNode node) {
		if (node == null) {
			return 0;
		}
		if (map.containsKey(node)) {
			return map.get(node);
		}
		int sum1 = 0;
		int sum2 = 0;
		
		sum1 = node.val;
		if(node.left!=null){
			sum1 += getSum(node.left.left) + getSum(node.left.right);
		}
		if(node.right!=null){
			sum1 += getSum(node.right.left) + getSum(node.right.right);
		}
		sum2 = getSum(node.left) + getSum(node.right);
		int sum = Math.max(sum1, sum2);
		
		
		map.put(node, sum);
		return sum;
	}

}
