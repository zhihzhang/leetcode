package com.lee.again;

import com.lee.common.ListNode;

public class ReverseNodesKGroup {

	public static void main(String[] args) {

	}
	
//	1 2 3 4 5 6 7
//	3 2 1 6 5 4 7

	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || k <= 1) {
			return head;
		}
		ListNode t = head;
		int i = 1;
		for (i = 1; i <= k; i++) {
			if(head==null){
				return t;
			}
			head = head.next;
		}
		ListNode tail = reverseKGroup(head, k);
		for (i = 0; i < k; i++) {
			ListNode next = t.next;
			t.next = tail;
			tail = t;
			t = next;
		}
		return t;
	}

}
