package com.lee.aathird;

import com.lee.common.ListNode;

public class RemoveDuplicatedFromList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Input: 1->1->2
	// Output: 1->2
	//
	// Input: 1->1->2->3->3
	// Output: 1->2->3

	public ListNode deleteDuplicates(ListNode head) {
		ListNode node = head;
		while (node != null) {
			if (node.next != null && node.val == node.next.val) {
				node.next = node.next.next;
			} else {
				node = node.next;
			}
		}
		return head;
	}

}
