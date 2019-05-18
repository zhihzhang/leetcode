package com.lee.again;

import com.lee.common.ListNode;

public class AddTwoNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode a = l1;
		ListNode b = l2;
		int t = 0;
		ListNode dummy = new ListNode(-1);
		ListNode head = dummy;
		while (a != null && b != null) {
			int w = a.val + b.val + t;
			if (w > 9) {
				t = 1;
				w = w % 10;
			} else {
				t = 0;
			}
			dummy.next = new ListNode(w);
			dummy = dummy.next;
			a = a.next;
			b = b.next;
		}
		ListNode tail = null;
		if (a != null) {
			tail = a;
		} else if (b != null) {
			tail = b;
		}
		while (tail != null) {
			int w = tail.val + t;
			if (w > 9) {
				t = 1;
				w = w % 10;
			} else {
				t = 0;
			}
			tail = tail.next;
		}
		if(t==1){
			dummy.next = new ListNode(1);
		}

		return head.next;
	}

}
