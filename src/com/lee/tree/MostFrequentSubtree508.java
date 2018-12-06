package com.lee.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostFrequentSubtree508 {

	public static void main(String[] args) {
		MostFrequentSubtree508 obj = new MostFrequentSubtree508();

	}
	
	int max = 0;
	
    public int[] findFrequentTreeSum(TreeNode root) {
    	if(root == null){
    		return new int[]{};
    	}
    	
        List<Integer> list = new ArrayList<Integer>();
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        sumTree(map, root);
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
        	if(entry.getValue()==max){
        		list.add(entry.getKey());
        	}
        }
        
    	int[] array = new int[list.size()];
    	int count = 0;
    	for(int a : list){
    		array[count++] = a;
    	}
    	return array;
    }
    
	public int sumTree(Map<Integer,Integer> map, TreeNode node) {
		int sum = node.val;
		if (node.left != null) {
			sum = sum + sumTree(map, node.left);
		}
		if (node.right != null) {
			sum = sum + sumTree(map, node.right);
		}
		
		int count = map.getOrDefault(sum, 0);
		map.put(sum, count + 1);
		max = Math.max(count + 1, max);
		return sum;
	}

}
