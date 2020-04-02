package com.lee.again;

public class InsertintoCyclicSortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Node insert(Node head, int insertVal) {

		if (head == null) {
			head = new Node(insertVal, null);
			return head;
		}
		Node node = head;
		int count = 0;
		while (node != null && node != head && count<2) {
			if (node.val <= insertVal && insertVal <= node.next.val) {
				Node t = new Node(insertVal, node.next);
				node.next = t;
				return head;
			}
			if (node.val < insertVal && node.val > node.next.val) {
				Node t = new Node(insertVal, node.next);
				node.next = t;
				return head;
			}

			node = node.next;
			if(node==head){
				count++;
			}
		}
		Node t = new Node(insertVal, head.next);
		head.next = t;
		return head;
	}

}

class Node {
	public int val;
	public Node next;

	public Node() {
	}

	public Node(int _val, Node _next) {
		val = _val;
		next = _next;
	}
};
