package com.lee.aafour;

import java.util.LinkedList;
import java.util.Queue;

import com.lee.common.Node;

public class PopulatingNextightPointersEachNodeII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public Node connect(Node root) {
    	if(root == null){
    		return root;
    	}
    	Queue<Node> queue = new LinkedList<>();
    	queue.add(root);
    	while(!queue.isEmpty()){
    		int k = queue.size();
    		for(int i=0;i<k;i++){
    			Node node = queue.poll();
    			if(!queue.isEmpty()){
    				node.next = queue.peek();
    			}
    			if(node.left!=null){
    				queue.offer(node.left);
    			}
    			if(node.right!=null){
    				queue.offer(node.right);
    			}
    		}
    	}
    	return root;
    }

}
