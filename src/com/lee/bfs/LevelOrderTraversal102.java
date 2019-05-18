package com.lee.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.lee.common.TreeNode;

public class LevelOrderTraversal102 {

	public static void main(String[] args) {
		LevelOrderTraversal102 obj = new LevelOrderTraversal102();
	}
	
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	
    	int count = 1;
    	int nextCount = 0;
    	queue.add(root);
    	List<Integer> temp = null;
    	while(!queue.isEmpty()){
			if (temp == null) {
				temp = new ArrayList<>();
			}
    		TreeNode node = queue.poll();
    		temp.add(node.val);
			if (node.left != null) {
				queue.add(node.left);
				nextCount++;
			}
			if (node.right != null) {
				queue.add(node.right);
				nextCount++;
			}
			count--;
			if(count==0){
				ans.add(temp);
				temp=null;
				count = nextCount;
				nextCount=0;
			}
    	}
    	return ans;
    }

}
