package com.lee.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.lee.common.TreeNode;

public class LargestValueRow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null){
        	return result;
        }
        
        Map<TreeNode, Integer> heightMap = new HashMap<TreeNode, Integer>();
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        heightMap.put(root, 1);
        
        int currentHeight = 1;
        int max = Integer.MIN_VALUE;
        while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			int height = heightMap.get(node);
			
			if (height > currentHeight) {
				currentHeight++;
				result.add(max);
				max = Integer.MIN_VALUE;
			}
			
			if (node.left != null) {
				queue.offer(node.left);
				heightMap.put(node.left, height + 1);
			}
			if (node.right != null) {
				queue.offer(node.right);
				heightMap.put(node.right, height + 1);
			}
        	max = Math.max(node.val, max);
        }
        
        result.add(max);
        return result;
    }

}
