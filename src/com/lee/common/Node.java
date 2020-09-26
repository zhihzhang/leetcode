package com.lee.common;

public class Node {
    public int val;
    public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	public Node left;
    public Node right;
    public Node(int x) { val = x; }
    public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public Node next;
}
