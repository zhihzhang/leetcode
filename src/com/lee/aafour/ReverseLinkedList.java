package com.lee.aafour;

import com.lee.common.ListNode;

public class ReverseLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode reverseList123(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode slow = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = slow;
			slow = head;
			head = next;
		}
		return slow;
	}
	
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode next = head.next;
		ListNode newHead = reverseList(next);
		next.next = head;
		head.next = null;
		return newHead;
	}

}
