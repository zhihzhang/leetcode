package com.lee.again;

import com.lee.common.ListNode;

public class RemoveNth {

	public static void main(String[] args) {
		RemoveNth obj = new RemoveNth();

	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode fast = head;
		int count = n;
		while (count > 0) {
			if (fast == null) {
				return head;
			}
			fast = fast.next;
			count--;
		}
		if (fast == null) {
			return head.next;
		}
		fast = fast.next;
		ListNode slow = head;
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = slow.next.next;
		return head;
	}

}
