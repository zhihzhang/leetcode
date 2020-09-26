package com.lee.aathird;

import com.lee.common.ListNode;

public class RemoveLinkedListElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode removeElements(ListNode head, int val) {
		ListNode mock = new ListNode(-1);
		mock.next = head;
		ListNode node = mock;
		while (node != null) {
			if (node.next != null && node.next.val == val) {
				node.next = node.next.next;
			} else {
				node = node.next;
			}
		}
		return mock.next;
	}

}
