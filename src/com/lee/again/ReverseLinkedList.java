package com.lee.again;

import com.lee.common.ListNode;

public class ReverseLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode slow = head;
		ListNode fast = head.next;
		head.next = null;
		while (true) {
			ListNode t = fast.next;
			fast.next = slow;
			if (t == null) {
				return fast;
			}
			slow = fast;
			fast = t;
		}
	}

}
