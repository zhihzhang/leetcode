package com.lee.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class KEmptySlots {

	public static void main(String[] args) {
		KEmptySlots obj = new KEmptySlots();
		int r = obj.kEmptySlots(new int[] {10,1,9,3,5,7,6,4,8,2}, 8);
		System.out.println(r);
	}

	// public int kEmptySlots(int[] flowers, int k) {
	// if (flowers == null || flowers.length == 0 || k > flowers.length - 2) {
	// return -1;
	// }
	// List<Integer> list = new LinkedList<Integer>();
	// // int[] slots = new int[flowers.length];
	// for (int i = 0; i < flowers.length; i++) {
	// int p = flowers[i];
	// list.add(p);
	// Collections.sort(list);
	// int j = list.indexOf(p);
	// if (j -1 >= 0) {
	// if (p - list.get(j - 1) == k + 1) {
	// return i + 1;
	// }
	// }
	// if (j + 1 < list.size()) {
	// if (list.get(j + 1) - p == k + 1) {
	// return i + 1;
	// }
	// }
	// }
	//
	// return -1;
	// }
	
	boolean ifFound = false;

	public int kEmptySlots(int[] flowers, int k) {
		if (flowers == null || flowers.length == 0 || k > flowers.length - 2) {
			return -1;
		}
		Node head = null;
		for (int i = 0; i < flowers.length; i++) {
			
			int p = flowers[i];
			if (head == null) {
				head = new Node(p);
				continue;
			}
			
			head = insert(head, new Node(p), k, i+1);

			if (ifFound) {
				return i + 1;
			}
		}

		return -1;
	}

	public Node insert(Node head, Node node, int k, int right) {
		if (head == null) {
			node.next = head;
			head = node;
			return head;
		} else if (head.val >= node.val) {
			node.next = head;
			head = node;
			if (head.next.val - head.val == k + 1) {
				ifFound = true;
			}
			return head;
		} else {
			Node current = head;
			while (current.next != null && current.next.val < node.val) {
				current = current.next;
			}
			
			//start
//			Node current = head;
//			Node temp = head;
//			int i = right / 2;
//			int left = 0;
//			while (true) {
//				int s = 0;
//				while (s < i) {
//					current = current.next;
//				}
//
//				if (current.val < node.val && current.next != null && current.next.val < node.val) {
//					break;
//				} else if (current.val < node.val && current.next == null) {
//					break;
//				} else if (current.val < node.val) {
//					i = i + (l-i)/2;
//					temp = current;
//				} else if (current.val > node.val) {
//					current = temp;
//					i = i / 2;
//				}
//			}

			node.next = current.next;
			current.next = node;

			if (node.val - current.val == k + 1) {
				ifFound = true;
			}
			if (node.next != null && node.next.val - node.val == k + 1) {
				ifFound = true;
			}
			return head;
		}
	}

	class Node {
		int val;
		Node next;

		Node(int d) {
			val = d;
			next = null;
		}
	}

}


//public class Solution {
//    /**
//     * @param flowers: the place where the flower will open in that day
//     * @param k:  an integer
//     * @return: in which day meet the requirements
//     */
//	boolean ifFound = false;
//
//	public int kEmptySlots(int[] flowers, int k) {
//		if (flowers == null || flowers.length == 0 || k > flowers.length - 2) {
//			return -1;
//		}
//		Node head = null;
//		for (int i = 0; i < flowers.length; i++) {
//			
//			int p = flowers[i];
//			if (head == null) {
//				head = new Node(p);
//				continue;
//			}
//			
//			head = insert(head, new Node(p), k);
//
//			if (ifFound) {
//				return i + 1;
//			}
//		}
//
//		return -1;
//	}
//
//	public Node insert(Node head, Node node, int k) {
//		if (head == null) {
//			node.next = head;
//			head = node;
//			return head;
//		} else if (head.val >= node.val) {
//			node.next = head;
//			head = node;
//			if (head.next.val - head.val == k + 1) {
//				ifFound = true;
//			}
//			return head;
//		} else {
//			Node current = head;
//			while (current.next != null && current.next.val < node.val) {
//				current = current.next;
//			}
//
//			node.next = current.next;
//			current.next = node;
//
//			if (node.val - current.val == k + 1) {
//				ifFound = true;
//			}
////			System.out.println(node.val + "  " + (node.next.val - node.val));
//			if (node.next != null && node.next.val - node.val == k + 1) {
//				ifFound = true;
//			}
//			return head;
//		}
//	}
//
//	class Node {
//		int val;
//		Node next;
//
//		Node(int d) {
//			val = d;
//			next = null;
//		}
//	}
//}
