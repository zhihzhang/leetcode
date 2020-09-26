package com.lee.againt;

public class MergeTwoSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode mock = new ListNode(-1);
		ListNode head = mock;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				mock.next = l1;
				l1 = l1.next;
			} else {
				mock.next = l2;
				l2 = l2.next;
			}
			mock = mock.next;
		}
		while (l1 != null) {
			mock.next = l1;
			l1 = l1.next;
			mock = mock.next;
		}
		while (l2 != null) {
			mock.next = l2;
			l2 = l2.next;
			mock = mock.next;
		}
		return head.next;
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
