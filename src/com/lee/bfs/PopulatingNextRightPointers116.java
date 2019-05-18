package com.lee.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointers116 {

	public static void main(String[] args) {
		PopulatingNextRightPointers116 obj = new PopulatingNextRightPointers116();

	}
	
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        int count = 1;
        int tc = 0;
        queue.add(root);
        while(!queue.isEmpty()){
        	Node node = queue.poll();
        	
        	count--;
            if(!queue.isEmpty() && count>0){
        		node.next = queue.peek();
        	}
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
			}
        }
        return root;
    }
    
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val,Node _left,Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

}
