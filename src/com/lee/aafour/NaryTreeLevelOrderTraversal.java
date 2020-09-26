package com.lee.aafour;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NaryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public List<List<Integer>> levelOrder(Node root) {
    	List<List<Integer>> list = new ArrayList<>();
    	LinkedList<Node> queue = new LinkedList<>();
    	if(root!=null){
    		queue.add(root);
    	}
    	while(!queue.isEmpty()){
    		int l = queue.size();
    		List<Integer> r = new ArrayList<>();
    		for(int i=0;i<l;i++){
    			Node node = queue.poll();
    			r.add(node.val);
    			if(node.children!=null){
    				for(Node n:node.children){
    					queue.offer(n);
    				}
    			}
    		}
    		list.add(r);
    	}
    	return list;
    }
    
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

}
