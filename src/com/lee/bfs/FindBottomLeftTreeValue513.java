package com.lee.bfs;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import com.lee.common.TreeNode;

public class FindBottomLeftTreeValue513 {

	public static void main(String[] args) {
		FindBottomLeftTreeValue513 obj = new FindBottomLeftTreeValue513();

	}
	
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int count = 1;
        int tc = 0;
        queue.add(root);
        int t = root.val;
        while(!queue.isEmpty()){
        	TreeNode node = queue.poll();
        	count--;
			if (node.left != null) {
				queue.add(node.left);
				tc++;
			}
			if (node.right != null) {
				queue.add(node.right);
				tc++;
			}
			
			if (count == 0) {
				count = tc;
				tc = 0;
				if(!queue.isEmpty()){
					t = queue.peek().val;
				}
			}
        }
        return t;
    }

}
