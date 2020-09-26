package com.lee.aafour;

import java.util.LinkedList;

import com.lee.common.TreeNode;

public class AddOneRowTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        int level = 1;
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode mock = new TreeNode(-1);
        mock.left = root;
        queue.add(mock);
        while(!queue.isEmpty()){
        	if(level == d){
        		int l = queue.size();
        		for(int i=0;i<l;i++){
        			TreeNode node = queue.poll();
        			TreeNode a = new TreeNode(v);
        			TreeNode b = new TreeNode(v);
        			a.left = node.left;
        			b.right = node.right;
        			node.left = a;
        			node.right = b;
        		}
        		break;
        	} else {
        		int l = queue.size();
				for (int i = 0; i < l; i++) {
					TreeNode node = queue.poll();
					if (node.left != null) {
						queue.offer(node.left);
					}
					if (node.right != null) {
						queue.offer(node.right);
					}
				}
				level++;
        	}
        }
        return mock.left;
    }

}
