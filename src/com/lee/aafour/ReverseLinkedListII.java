package com.lee.aafour;

import com.lee.common.ListNode;

public class ReverseLinkedListII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
		if(head == null || head.next == null || m==n){
			return head;
		}
		ListNode firstTail = new ListNode(-1);
		ListNode firstHead = firstTail;
		firstTail.next = head;
		for (int i = 1; i < m; i++) {
			firstTail = firstTail.next;
		}
		head = firstTail.next;
		ListNode secondHead = head;

		ListNode pre = null;
		for (int i = 0; i < n - m; i++) {
			ListNode next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		firstTail.next = pre;
		secondHead.next = head;
		return firstHead.next;
	}

}
