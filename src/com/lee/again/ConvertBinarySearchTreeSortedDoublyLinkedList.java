package com.lee.again;

public class ConvertBinarySearchTreeSortedDoublyLinkedList {

	public static void main(String[] args) {
		ConvertBinarySearchTreeSortedDoublyLinkedList obj = new ConvertBinarySearchTreeSortedDoublyLinkedList();
		Node one = new Node();
		one.val = 1;
		Node two = new Node();
		two.val = 2;
		Node three = new Node();
		three.val = 3;
		Node four = new Node();
		four.val = 4;
		Node five = new Node();
		five.val = 5;
		four.right = five;
		four.left = two;
		two.left = one;
		two.right = three;
		
		Node head = obj.treeToDoublyList(four);
		int count = 0;
		while(count<5){
			System.out.print(head.val + "->");
			head = head.right;
			count++;
		}
		System.out.println("null");
	}
	
	

	Node head = null;
	Node tail = null;

	public Node treeToDoublyList(Node root) {
		if (root == null) {
			return null;
		}
		getList(root);
	    tail.right = head;
	    head.left = tail;
		return head;
	}

	public void getList(Node root) {
		if (root == null) {
			return;
		}
		getList(root.left);
		if (head == null) {
			head = root;
		} else {
			tail.right = root;
			root.left = tail;
		}
		tail = root;
		getList(root.right);
	
	}

	static class Node {
		public int val;
		public Node left;
		public Node right;

		public Node() {
		}

		public Node(int _val, Node _left, Node _right) {
			val = _val;
			left = _left;
			right = _right;
		}
	};

}
