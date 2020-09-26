package com.lee.aafour;

import com.lee.common.ListNode;

public class ReverseNodesGroup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Given this linked list: 1->2->3->4->5
	// For k = 2, you should return: 2->1->4->3->5
	// For k = 3, you should return: 3->2->1->4->5
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || head.next == null) {
			return head;
		}

		int count = 0;
		ListNode fast = head;
		while (fast != null && count < k) {
			fast = fast.next;
			count++;
		}
		if (count < k) {
			return head;
		}
		ListNode pre = reverseKGroup(fast, k);
		for (int i = 0; i < k; i++) {
			ListNode next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}

}
