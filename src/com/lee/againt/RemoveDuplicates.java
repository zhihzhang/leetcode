package com.lee.againt;

import com.lee.common.ListNode;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Example 1:
	//
	// Input: 1->2->3->3->4->4->5
	// Output: 1->2->5
	// Example 2:
	//
	// Input: 1->1->1->2->3
	// Output: 2->3

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode mock = new ListNode(-1);
		mock.next = head;
		ListNode l = mock;
		ListNode r = head;
		while (r != null) {
			if (r.next != null && r.val == r.next.val) {
				int t = r.val;
				while (r != null && r.val == t) {
					r = r.next;
				}
				l.next = r;
			} else {
				l = r;
				r = r.next;
			}
		}
		return mock.next;
	}

}
