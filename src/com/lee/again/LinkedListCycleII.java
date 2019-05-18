package com.lee.again;

import com.lee.common.ListNode;

public class LinkedListCycleII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode detectCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		ListNode last = head;
		while (fast != null && fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				while (true) {
					if (last == slow) {
						return slow;
					}
					last = last.next;
					slow = slow.next;
				}
			}
		}
		return null;
	}

	// 1 2 3 4 5 6 7
	// c = circle length
	//
	// 2 * (m + n) = m + n + x*c;
	// m+n = x*w;
}
