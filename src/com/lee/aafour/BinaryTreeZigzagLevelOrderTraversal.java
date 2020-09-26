package com.lee.aafour;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.lee.common.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> r = new ArrayList<>();
		if(root==null){
			return r;
		}
		LinkedList<TreeNode> queue = new LinkedList<>();
		boolean f = true;
		queue.add(root);
		while(!queue.isEmpty()){
			int l = queue.size();
			List<Integer> list = new ArrayList<>();
			for(int i=0;i<l;i++){
				TreeNode node = queue.pollFirst();
				list.add(node.val);
				if(node.left!=null){
					queue.offer(node.left);
				}
				if(node.right!=null){
					queue.offer(node.right);
				}
			}
			
			if(f){
				f = false;
			} else {
				Collections.reverse(list);
				f = true;
			}
			r.add(list);
		}
		return r;
    }

}
