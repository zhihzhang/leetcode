package com.lee.againt;

public class FlattenMultilevelDoublyLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Node flatten(Node head) {
		if (head == null) {
			return null;
		}

		return head;
	}

	class Node {
		public int val;
		public Node prev;
		public Node next;
		public Node child;
	};

}
