package com.lee.aafour;

import com.lee.common.ListNode;

public class OddEvenLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode oddEvenList(ListNode head) {
		ListNode odd = new ListNode(-1);
		ListNode even = new ListNode(-1);
		ListNode mock = head;
		int count = 1;
		while (head != null) {
			if (count % 2 == 1) {
				odd.next = head;
				odd = head;
			} else {
				even.next = head;
				even = head;
			}
			System.out.println(head.val + "...." + odd.val + "..." + even.val);
			head = head.next;
			count++;
		}
		odd.next = even.next;
		return mock;
	}

}
