package com.lee.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import com.lee.common.TreeNode;

public class MaximumWidthTree662 {

	public static void main(String[] args) {
		MaximumWidthTree662 obj = new MaximumWidthTree662();

	}
	
    public int widthOfBinaryTree(TreeNode root) {
   	if(root==null){
   		return 0;
   	}
       Queue<TreeNode> queue = new LinkedList<TreeNode>();
       queue.offer(root);
       
		Map<TreeNode, Integer> depMap = new HashMap<TreeNode, Integer>();
		Map<TreeNode, Integer> widMap = new HashMap<TreeNode, Integer>();

		depMap.put(root, 1);
		widMap.put(root, 1);
		int curDep = 0;
		int wid = -1;
		int max = 1;
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			int dep = depMap.get(node);

			if (dep > curDep) {
				wid = -1;
				curDep = dep;
			}

			int pWid = widMap.get(node);
			if (node.left != null) {
				depMap.put(node.left, dep + 1);
				if(wid<0){
					wid = pWid * 2 - 1;
				}
				widMap.put(node.left, pWid * 2 - 1);
				max = Math.max(max, pWid * 2 - 1 - wid + 1);
				queue.offer(node.left);

			}
			if (node.right != null) {
				depMap.put(node.right, dep + 1);
				if(wid<0){
					wid = pWid * 2;
				}
				widMap.put(node.right, pWid * 2);
				max = Math.max(max, pWid * 2 - wid + 1);
				queue.offer(node.right);
			}
		}
       return max;
   }

}