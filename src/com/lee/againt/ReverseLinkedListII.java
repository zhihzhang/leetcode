package com.lee.againt;

import com.lee.common.ListNode;

public class ReverseLinkedListII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Input: 1->2->3->4->5->NULL, m = 2, n = 4
	// Output: 1->4->3->2->5->NULL
	// Note: 1 ≤ m ≤ n ≤ length of list.
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode mock = new ListNode(0);
		ListNode r = mock;
		mock.next = head;
		for (int i = 1; i < m; i++) {
			mock = mock.next;
		}
		ListNode a = mock.next;
		ListNode b = a.next;
		ListNode first = a;
		ListNode t = null;
		for (int i = 0; i < n - m; i++) {
			t = b.next;
			b.next = a;
			a = b;
			b = t;
		}
		first.next = b;
		mock.next = a;
		return r.next;
	}

}
