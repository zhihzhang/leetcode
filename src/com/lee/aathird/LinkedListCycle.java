package com.lee.aathird;

import com.lee.common.ListNode;

public class LinkedListCycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean hasCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null) {
			if (fast.next == null || fast.next.next == null) {
				return false;
			}
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}

}
